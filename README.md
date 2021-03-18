# Implicit vs Explicit Bean Wiring For Spring

There was a discussion regarding explicit wiring and if it would make refactoring harder, so I simulated a couple of
different situations that might arise. I have created a mockup of a framework where there are several types of tasks that can be executed depending on config.
These tasks are often very similar to each other and rely on the same/similar dependencies.
In this example we have some common functionality such as ftp, xml etc which
can be enabled using feature flag to tell Spring whatever to instantiate the objects or not. 
Similar effects can be achieved by using @Lazy annotation.

## Managing Dependencies

I have also considered the case where several features depend on a complex object with many sub-dependencies 
that can change. I thought about how refactoring and changing objects would propagate changes in many places and if it is an issue.
I can't see why or how explicit wiring makes maintenance or refactoring harder. If we have a class that performs X and depends on Y and Z, we can change Y and Z
with any other implementation that fulfills the interface without having to make changes to any features. This is the basics of the Strategy pattern
which in combination with Dependency Inversion enables us to write testable and modular code ( Enables Hexagonal Architecture ). 
If X is an implementation of an interface Y, we can replace X with any other implementation of the same interface Y without breaking any other 
class that depends on X.

Consider the example where we decide to change class X by changing its public API. Since it no longer adheres to the interface, we have
performed a breaking change and thus need to refactor several features ( Or create a new class X2 which implements the new behaviour ).
This is a not an issue with explicit wiring and is not solved by implicit wiring.

## Issues with Implicit Wiring and Why @Lazy is not the solution.

Implicit wiring with the combination of @Lazy annotation can certainly prevent crashes that would normally happen when people don't know
what they are doing when creating components. Lazy loaded beans can also be completely miss-configured, but It won't be detected at startup,
rather at some arbitrarily long time later depending on when the dependency first is called. Another issue is if someone creates a new
implementation of an interface, Spring can no longer decide what bean to wire and this breaks initialization without anyone detecting the issue until
the application is deployed unless you write specific context loading tests for each functionality.
As a system gets bigger with more lazy components and implicit beans that depend on each other, It gets more costly to use implicit wiring since
it's harder to narrow the scope of possible beans that can be loaded. 

Further more, it's arguable easier to make changes to an application when all dependencies and configuration is declared in one place.
Consider an application where each class has a bunch of interfaces that are implicitly managed. What bean gets wired depends on several
factors such as, how many implementations the interface has, is there a @Primary annotation and no explicit bean, are we using named annotations
and where do we specify what qualifier is used. The coupling we create towards Spring by including framework specific annotation to our
code is a minor issue but ultimately avoidable.

Consider also the case where we have a service X which implements an interface Y, which is used in many classes and features. Consider that
we want to create another implementation of Y, now we have to make sure to qualify every place where we use Y cause X is no longer
the sole implementation. By adding a @Qualifier to our @Autowired dependencies we have solved the problem by shooting ourselves in the foot. 
If class A depends on the interface Y we can no longer choose what implementation we want to use since we have effectively hardcoded A to depend
on one implementation of Y, and we can't have 2 instances of A with different dependencies on Y either. A no longer depends on the abstraction
Y but on a specific implementation. 

## Suggested alternative

I would instead suggest that we can leave all framework and common code that all features rely on as annotated Spring managed components.
These are classes that will rarely change and if they change they will change in a way where every functionality must change in the same way.
Optional features such as XML parsers, SFTP client and similar should be explicitly enabled through config and disabled by default.
This will prevent errors from misconfiguration components and enabling beans which where not intended to use.
If a specific functionality has some different requirements, it can just overwrite whatever dependencies it needs from the common/optional dependencies.
Feature specific beans should be located in their packages and be enabled by component scanning on that specific package.


### Example Feature 1

* crypto.enabled=true
* ftp.enabled=true
* xml.enabled=true

In this example the feature depends on Xml, Encryptor and the DoesEverything classes.
Since crypto, ftp and xml is enabled the DoesEverything bean is instantiated.
Normally it would get the default implementation of DoesEverything declared in com.example.demo.common.config.DoesEverythingConfig but we can override individual dependencies or sub-dependencies.
Thus, each functionality can use common code but still change individual sub-dependencies.

Changes made to DoesEverything class does not have any effect on Feature 1 functionality as long as the
public interface stays the same. Even if we change how the default bean is implemented, as long as the dependencies
or sub-dependencies don't change the interface, we don't have to change Feature1. 

### Example Feature 2

* crypto.enabled=true

In this example we have a functionality that depends on crypto dependencies but can be optionally ran with a custom
ftp or using the default ftp if enabled. 

### Example Feature 3

* crypto.enabled=true
* ftp.enabled=true
* xml.enabled=true

In this example we are not customizing anything special, we are using the
default features provided by enabling various feature flags. As long as the interface of the
dependencies are not broken, this class does not require changing if we make changes in other places.

### Example Feature 4

In this example the functionality is implicitly loading some common framework class called FrameWorkTaskRunner. While the FrameWorkTaskRunner bean is implicit,
we can override the sub-dependency without any issues.

### Example Feature 5

In this example the functionality is implicitly configured, relying only on "framework" code that should be instantiated by Spring no matter
what functionality we are running.
[ ! -f target/app.jar ] && mvn clean install

echo "\n\n## Running with functionality  1"
feature=feature1 java -jar target/app.jar
echo "\n\n## Running with functionality  2"
feature=feature2 java -jar target/app.jar
echo "\n\n## Running with functionality  3"
feature=feature3 java -jar target/app.jar
echo "\n\n## Running with functionality  4"
feature=feature4 java -jar target/app.jar
echo "\n\n## Running with functionality  5"
feature=feature5 java -jar target/app.jar
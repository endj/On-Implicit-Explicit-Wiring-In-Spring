package com.example.demo.features.feature5;

import com.example.demo.features.Functionality;
import com.example.demo.framework.Task;
import lombok.Value;
import org.springframework.stereotype.Component;

@Value
@Component
public class Feature5 implements Functionality {
  Task task;
}

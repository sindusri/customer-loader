package com.example.demo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@ComponentScan("com.exmaple.demo")
@Import(PersistenceConfiguaration.class)
public class ApplicationConfiguration {

}

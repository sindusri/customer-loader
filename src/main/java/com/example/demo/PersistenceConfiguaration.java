package com.example.demo;

import org.springframework.context.annotation.PropertySource;

@PropertySource(ignoreResourceNotFound=true,value="classpath:persistence-${spring.profiles.active}.properties")
public class PersistenceConfiguaration {

}

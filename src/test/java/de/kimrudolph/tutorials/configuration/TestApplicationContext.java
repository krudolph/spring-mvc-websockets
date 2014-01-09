package de.kimrudolph.tutorials.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "de.kimrudolph.tutorials" })
public class TestApplicationContext {

}
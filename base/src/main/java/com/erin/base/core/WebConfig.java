package com.erin.base.core;

import config.WebMvcConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
@ComponentScan("com.erin.base.controller")
public class WebConfig extends WebMvcConfig {

}

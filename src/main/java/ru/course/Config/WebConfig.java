package ru.course.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
}

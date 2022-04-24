package com.greedy.dduckleaf.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.greedy.dduckleaf")
public class BeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {

        return new CustomModelMapper();
    }
}

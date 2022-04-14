package com.greedy.dduckleaf.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.greedy.dduckleaf")
@EnableJpaRepositories(basePackages = "com.greedy.dduckleaf")
public class JPAConfiguration {
}

package com.pizzaria.java.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configurations {
    @Bean
    public ModelMapper criandoModelMapper(){
        return new ModelMapper();
    }
}

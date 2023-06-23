package com.fiap.techchallenge.pessoa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.validation.Validation;
import javax.validation.Validator;

@Configuration
public class ValidatorBean {
    @Bean
    public Validator validator()
    {         return Validation.buildDefaultValidatorFactory().getValidator();     }
}

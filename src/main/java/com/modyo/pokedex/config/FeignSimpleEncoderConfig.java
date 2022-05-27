package com.modyo.pokedex.config;

import feign.form.FormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;

public class FeignSimpleEncoderConfig {
    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConvertersObjectFactory;

    @Bean
    public FormEncoder encoder(){return new FormEncoder(new SpringEncoder(this.messageConvertersObjectFactory));
    }
}
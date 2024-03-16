package com.microservices1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microservices1.exception.decoder.CustomDecoder;

import feign.codec.ErrorDecoder;

@Configuration
public class Decoderonfig {

	@Bean
	public ErrorDecoder createConfig(){
		return new CustomDecoder();
	}
}

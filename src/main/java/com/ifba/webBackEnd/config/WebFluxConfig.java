/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ifba.webBackEnd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *
 * @author lara
 */
@Configuration
public class WebFluxConfig {
    
    @Bean
    public WebClient webClient(WebClient.Builder builder){
        return builder.baseUrl("https://openlibrary.org").build();
    }
}

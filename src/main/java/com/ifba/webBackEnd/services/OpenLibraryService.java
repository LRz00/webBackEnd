/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ifba.webBackEnd.services;

import com.ifba.webBackEnd.DTOs.BookResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 *
 * @author lara
 */
@Service
public class OpenLibraryService {
    @Autowired
    private  WebClient webClient;  
    
    public Mono<BookResponseDTO> getBooksByStephenKing(){
        return webClient.get().uri("/search.json?q=stephen+king&fields=title,author_name,first_publish_year&limit=10")
                .retrieve().bodyToMono(BookResponseDTO.class);
    }
    
    
}

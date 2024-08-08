/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ifba.webBackEnd.controllers;

import com.ifba.webBackEnd.DTOs.BookResponseDTO;
import com.ifba.webBackEnd.services.OpenLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 *
 * @author lara
 */
@RestController
@RequestMapping("/books")
public class OpenLibraryController {
    @Autowired
    private OpenLibraryService service;
    
    @GetMapping("/stephen-king")
    public Mono<BookResponseDTO> getBooksByStephenKing(){
        return service.getBooksByStephenKing();
    }
}

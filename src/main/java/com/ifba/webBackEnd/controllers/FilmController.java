/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ifba.webBackEnd.controllers;

import com.ifba.webBackEnd.models.Film;
import com.ifba.webBackEnd.services.FilmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lara
 */
@RestController
@RequestMapping("/films")
public class FilmController {
    @Autowired
    FilmService service;
    
    @GetMapping
    public ResponseEntity<List<Film>> findAll(){
        
        return ResponseEntity.ok(service.findAll());
    }
    
    @PostMapping
    public ResponseEntity<Film> save(@RequestBody Film film){
        return ResponseEntity.ok(service.saveFilm(film));
    }
}

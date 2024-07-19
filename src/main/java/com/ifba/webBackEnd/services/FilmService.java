/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ifba.webBackEnd.services;

import com.ifba.webBackEnd.models.Film;
import com.ifba.webBackEnd.repositories.FilmRepository;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lara
 */
@Service
public class FilmService {
    
    @Autowired
    FilmRepository repository;
    Logger logger = Logger.getLogger(FilmService.class.getName());
    
    public Film saveFilm(Film film){
        if(film == null){
            throw new RuntimeException("film cannot be null");
        }
        logger.info("Saving new film");
        var savedFilm = repository.save(film);
        
        return savedFilm;
    }
    
    public List<Film> findAll(){
        logger.info("Finding all films");
        var allFilms = repository.findAll();
        
        return allFilms;
    }
    
}

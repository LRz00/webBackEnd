/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ifba.webBackEnd.controllers;

import com.ifba.webBackEnd.DTOs.CreateFilmDTO;
import com.ifba.webBackEnd.DTOs.FilmViewDTO;
import com.ifba.webBackEnd.DTOs.UpdateFilmDTO;
import com.ifba.webBackEnd.services.FilmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    
        
    @PostMapping
    public ResponseEntity<FilmViewDTO> save(@RequestBody CreateFilmDTO film){
        return ResponseEntity.ok(service.saveFilm(film));
    }
    
    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<FilmViewDTO>>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
             @RequestParam(value = "direction", defaultValue = "asc") String direction){
        
         var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;
        
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "title"));
        
        
        return ResponseEntity.ok(service.findAll(pageable));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<FilmViewDTO> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.findById(id));
    }
    
    @PutMapping
     public ResponseEntity<FilmViewDTO> update(@RequestBody UpdateFilmDTO film){
        return ResponseEntity.ok(service.update(film));
    }
     
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

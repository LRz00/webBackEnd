/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ifba.webBackEnd.services;

import com.ifba.webBackEnd.models.Film;
import com.ifba.webBackEnd.repositories.FilmRepository;
import com.ifba.webBackEnd.DTOs.CreateFilmDTO;
import com.ifba.webBackEnd.DTOs.FilmViewDTO;
import com.ifba.webBackEnd.DTOs.UpdateFilmDTO;
import com.ifba.webBackEnd.exceptions.ObjectIsNullException;
import com.ifba.webBackEnd.exceptions.ObjectNotFoundException;
import com.ifba.webBackEnd.mapper.FilmMapper;
import com.ifba.webBackEnd.controllers.FilmController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;

/**
 *
 * @author lara
 */
@Service
public class FilmService {
    
    @Autowired
    FilmRepository repository;
    static final Logger logger = Logger.getLogger(FilmService.class.getName());
    private final FilmMapper mapper = FilmMapper.INSTANCE; 
    @Autowired
    private PagedResourcesAssembler<FilmViewDTO> pagedResourcesAssembler;
    
    public FilmViewDTO saveFilm(CreateFilmDTO film){
        if(film == null){
            throw new ObjectIsNullException("film cannot be null");
        }
        Film entity = mapper.toEntity(film);
        
        logger.info("Saving new film");
        repository.save(entity);
        
        var savedFilm = mapper.toViewDTO(entity);
        
        savedFilm.add(linkTo(methodOn(FilmController.class).findById(savedFilm.getId())).withSelfRel());
        
        return savedFilm;
    }
    
       public PagedModel<EntityModel<FilmViewDTO>> findAll(Pageable pageable) {
        logger.info("Finding all films");
        Page<Film> entities = repository.findAll(pageable);
        
        Page<FilmViewDTO> filmDtoPage = entities.map(film -> {
            FilmViewDTO dto = mapper.toViewDTO(film);
            dto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(FilmController.class).findById(film.getId())).withSelfRel());
            return dto;
        });

        return pagedResourcesAssembler.toModel(filmDtoPage);
    }
       public FilmViewDTO findById(Long id){
        logger.info("finding film by id");
        var entity = repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("No records found for this ID"));
        var film = mapper.toViewDTO(entity);
        film.add(linkTo(methodOn(FilmController.class).findById(id)).withSelfRel());
        return film;
    }
    
    public FilmViewDTO update(UpdateFilmDTO film){
        logger.info("looking for film to update");
         Film entity = repository.findById(film.getId())
                .orElseThrow(() -> new ObjectNotFoundException("No records found for this ID"));
         entity.setReleaseYear(film.getReleaseYear());
         entity.setRunTime(film.getRunTime());
         entity.setTitle(film.getTitle());
         
         Film updatedEntity = repository.save(entity);
         logger.info("film updated");
         
         var updatedFilm = mapper.toViewDTO(updatedEntity);
         
         updatedFilm.add(linkTo(methodOn(FilmController.class).findById(updatedFilm.getId())).withSelfRel());
         
         return updatedFilm;
        }
    
    public void delete(Long id){
         logger.log(Level.INFO, "Deleting book of id:{0}", id.toString());
        Film entity = repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ifba.webBackEnd.mapper;
import com.ifba.webBackEnd.DTOs.CreateFilmDTO;
import com.ifba.webBackEnd.DTOs.FilmViewDTO;
import com.ifba.webBackEnd.DTOs.UpdateFilmDTO;
import com.ifba.webBackEnd.models.Film;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
/**
 *
 * @author lara
 */
@Mapper
public interface FilmMapper {
    FilmMapper INSTANCE = Mappers.getMapper(FilmMapper.class);
    
    Film toEntity(CreateFilmDTO createFilmDTO);
    Film toEntity(UpdateFilmDTO createFilmDTO);
    List<FilmViewDTO> toViewDTO(List<Film> films);
    FilmViewDTO toViewDTO(Film film);
}

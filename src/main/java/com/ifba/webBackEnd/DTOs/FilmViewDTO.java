/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ifba.webBackEnd.DTOs;

import org.springframework.hateoas.RepresentationModel;
/**
 *
 * @author lara
 */
public class FilmViewDTO extends RepresentationModel<FilmViewDTO>{
    private Long id;
    private String title;
    private Long releaseYear;
    private Long runTime;

    public FilmViewDTO() {
    }

    public FilmViewDTO(Long id, String title, Long releaseYear, Long runTime) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.runTime = runTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Long releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Long getRunTime() {
        return runTime;
    }

    public void setRunTime(Long runTime) {
        this.runTime = runTime;
    }
    
    
}

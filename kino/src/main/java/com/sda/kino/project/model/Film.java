package com.sda.kino.project.model;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Film {

    private String title;
    private FilmGenre filmGenre;
    private String filmDescription;
    private String yearOfFilmProduction;
    private String interval;
    private List<Actor> listOfActors;

}

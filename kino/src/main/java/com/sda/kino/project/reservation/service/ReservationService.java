package com.sda.kino.project.reservation.service;

import com.sda.kino.project.dto.UserDto;
import com.sda.kino.project.model.Movie;
import com.sda.kino.project.model.Seance;
import com.sda.kino.project.model.User;
import com.sda.kino.project.reservation.dto.MovieDto;
import com.sda.kino.project.reservation.dto.ReservationDto;
import com.sda.kino.project.reservation.dto.SeanceDto;
import com.sda.kino.project.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository repository;

    public ReservationDto getReservationDtoBySeanceId(int seanceId, int userId, List<MovieDto> listOfMovies) {
        User userByUserId = repository.getUserByUserId(userId);
        Seance seanceById = repository.getSeanceById(seanceId);

        return createReservationDtoFromUserAndSeance(userByUserId, seanceById, listOfMovies);

    }

    private ReservationDto createReservationDtoFromUserAndSeance(User user, Seance seance, List<MovieDto> listOfMovies) {

        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setSeanceId(seance.getId());
        reservationDto.setSeanceDataStart(seance.getDataStart());
        reservationDto.setSeanceDataStartTime(seance.getDataStartTime());
        reservationDto.setSeancePrice(seance.getPrice());
        reservationDto.setMovieId(seance.getMovieId());
        reservationDto.setUserId(user.getId());
        reservationDto.setUserFirstName(user.getFirstName());
        reservationDto.setUserLastName(user.getLastName());
        reservationDto.setUserLogin(user.getLogin());
        reservationDto.setUserEmail(user.getEmail());

        MovieDto movieDto = listOfMovies.stream().filter(movie -> movie.getId() == seance.getMovieId()).findFirst().get();
        reservationDto.setMovieTitle(movieDto.getTitle());
        reservationDto.setMovieDescription(movieDto.getMovieDescription());
        reservationDto.setYearOfMovieProduction(movieDto.getYearOfMovieProduction());

        return reservationDto;

    }
}

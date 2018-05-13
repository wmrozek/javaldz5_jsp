package com.sda.kino.project.reservation.service;

import com.sda.kino.project.reservation.dto.MovieDto;
import com.sda.kino.project.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository repository;

    public List<MovieDto> getSeances(String date){

        repository.getMoviesByDate(date);



//        User user = repository.getUser(login, password);
//        UserDto userDto = mapUser(user);
//        return userDto;
        return null;
    }

//    private UserDto mapUser(User user) {
//        if (user == null){
//            return null;
//        }
//        UserDto userDto = new UserDto();
//        userDto.setFirstName(user.getFirstName());
//        userDto.setLastName(user.getLastName());
//        userDto.setLogin(user.getLogin());
//        return userDto;
//    }
}

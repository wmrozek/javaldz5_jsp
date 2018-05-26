package com.sda.kino.project.reservation.controller;


import com.sda.kino.project.dto.MovieDto;
import com.sda.kino.project.dto.UserDto;
import com.sda.kino.project.reservation.dto.ReservationDto;
import com.sda.kino.project.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping(path = "/reservation")
    public ModelAndView reservatinPage(
            @RequestParam(name = "seanceId", required = true) int seanceId,
            @RequestParam(name = "message", required = false) String message,
            HttpServletRequest request
    ) {

        HttpSession session = request.getSession();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("reservation");

        if (message != null) {
            modelAndView.addObject("message", message);
        }
        if (seanceId > 0) {
            modelAndView.addObject("seanceId", seanceId);
        }

        if (checkIfUserIsLogged(session)) {
//            UserDto userDto = reservationService.getUserByUserId((int) session.getAttribute("userId"));
//            modelAndView.addObject("userDto", userDto);
//
//        reservationService.getSeanceDtoBySeanceId(seanceId);

            ReservationDto reservationDtoBySeanceId = reservationService.getReservationDtoBySeanceId(seanceId, (int) session.getAttribute("userId"),
                    (List<MovieDto>) session.getAttribute("listOfMovies"));
            modelAndView.addObject("Reservation", reservationDtoBySeanceId);
        }

        return modelAndView;
    }

    public boolean checkIfUserIsLogged(HttpSession session) {
        return (session.getAttribute("userId") != null);
    }

}

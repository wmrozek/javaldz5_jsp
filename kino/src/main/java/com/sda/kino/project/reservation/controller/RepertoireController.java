package com.sda.kino.project.reservation.controller;

import com.sda.kino.project.model.User;
import com.sda.kino.project.reservation.dto.MovieDto;
import com.sda.kino.project.reservation.service.RepertoireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class RepertoireController {

    @Autowired
    private RepertoireService repertoireService;

    @GetMapping(path = "/repertoire")
    public ModelAndView repertoirePage(@RequestParam(name = "date", required = false) String date,
                                       HttpServletRequest request,
                                       HttpServletResponse response) {
        HttpSession session = request.getSession();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("USERNAME", session.getAttribute("userFirstName") + " " + session.getAttribute("userLastName"));
        modelAndView.setViewName("repertoire");

        if (date != null) {
            modelAndView.addObject("datePicked", date);
            List<MovieDto> moviesDtosForDate = repertoireService.getMoviesDtosForDate(date.replace("/", "-"));
            modelAndView.addObject("listOfMovies", moviesDtosForDate);
            session.setAttribute("listOfMovies", moviesDtosForDate);
        }
        return modelAndView;
    }



}
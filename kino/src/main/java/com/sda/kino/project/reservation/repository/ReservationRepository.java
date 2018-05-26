package com.sda.kino.project.reservation.repository;

import com.sda.kino.project.model.Movie;
import com.sda.kino.project.model.MovieGenre;
import com.sda.kino.project.model.Seance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ReservationRepository {
    private static final String GET_MOVIES_BY_DATE =
            "SELECT m.*, array_agg(s.id) FROM movies m JOIN seances s ON s.id_movie = m.id WHERE s.data_start = ? " +
                    "GROUP BY m.id, m.title, m.category, m.time_duration, m.description, m.movie_cast, m.date_production";

    private static final String GET_SEANCES_BY_DATE = "SELECT * FROM seances WHERE data_start = ?;";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Movie> getMoviesByDate(String date) {
        System.out.println(date);
        List<Movie> movies = jdbcTemplate.query(GET_MOVIES_BY_DATE, new String[]{date}, new RowMapper<Movie>() {
            @Override
            public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
                Movie movie = new Movie();
                movie.setId(rs.getInt("id"));
                movie.setTitle(rs.getString("title"));
                movie.setMovieGenre(MovieGenre.valueOf(rs.getString("category").toUpperCase()));
                movie.setMovieDescription(rs.getString("description"));
                movie.setActors(rs.getString("movie_cast"));
                movie.setYearOfMovieProduction(Integer.toString(rs.getInt("date_production")));
                return movie;
            }
        });
        return movies;
    }


    public List<Seance> getSeancesByDate(String date) {

        System.out.println(date);
        return jdbcTemplate.query(GET_SEANCES_BY_DATE, new String[]{date}, new RowMapper<Seance>() {
            @Override
            public Seance mapRow(ResultSet rs, int rowNum) throws SQLException {

                Seance seance = new Seance();
                seance.setId(rs.getInt("id"));
                seance.setMovieId(rs.getInt("id_movie"));
                seance.setDataStart(rs.getString("data_start"));
                seance.setDataStartTime(rs.getString("data_start_time"));
                seance.setPrice(rs.getDouble("price"));
                return seance;
            }
        });
    }


    public static void main(String[] args) {
        ReservationRepository rr = new ReservationRepository();
        List<Movie> moviesByDate = rr.getMoviesByDate("05-13-2018");
    }

}

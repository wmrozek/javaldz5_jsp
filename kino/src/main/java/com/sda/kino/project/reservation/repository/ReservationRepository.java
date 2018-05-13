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
            "select m.*, array_agg(s.id) from movies m \n" +
                    "join seances s on s.id_movie = m.id\n" +
                    "where s.data_start = ?\n" +
                    "group by m.id, m.title, m.category, m.time_duration, m.description, m.movie_cast, m.date_production";

    private static final String GET_SEANCES_BY_DATE =
            "select * from seances where data_start = ?";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Movie> getMoviesByDate(String date) {
        List<Seance> seanceList = getSeancesByDate(date);
        Map<Integer, List<Seance>> mapMoviesSeances = createMapMovieSeances(seanceList);

        List<Movie> movies = jdbcTemplate.query(GET_MOVIES_BY_DATE, new String[]{date}, new RowMapper<Movie>() {
            @Override
            public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
                Movie movie = new Movie();
                movie.setId(rs.getInt("id"));
                movie.setTitle(rs.getString("title"));
                movie.setMovieGenre(MovieGenre.valueOf(rs.getString("category").toUpperCase()));
                movie.setMovieDescription(rs.getString("description"));
                movie.setListOfActors(rs.getString("movie_cast"));
                movie.setYearOfMovieProduction(Integer.toString(rs.getInt("date_production")));
                movie.setListOfSeance(mapMoviesSeances.get(rs.getInt("id")));

                return movie;
            }
        });
        return movies;


    }


    private List<Seance> getSeancesByDate(String date) {
        List<Seance> seanceList = jdbcTemplate.query(GET_SEANCES_BY_DATE, new String[] {date}, new RowMapper<Seance>() {
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
        return null;
    }

    public Map<Integer, List<Seance>> createMapMovieSeances(List<Seance> seances){
        Map<Integer, List<Seance>> mapMovieSeances = new HashMap<>();
        for (Seance seance : seances){
            if (mapMovieSeances.containsKey(seance.getMovieId())){
                mapMovieSeances.get(seance.getMovieId()).add(seance);
                mapMovieSeances.put(seance.getMovieId(), mapMovieSeances.get(seance.getMovieId()));
            } else {
                List<Seance> seanceList = new ArrayList<>();
                seanceList.add(seance);
                mapMovieSeances.put(seance.getMovieId(), seanceList);

            }
        }
        return mapMovieSeances;
    }
}

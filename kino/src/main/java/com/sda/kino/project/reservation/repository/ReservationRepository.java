package com.sda.kino.project.reservation.repository;

import com.sda.kino.project.model.Movie;
import com.sda.kino.project.model.MovieGenre;
import com.sda.kino.project.model.Seance;
import com.sda.kino.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ReservationRepository {

    private static final String GET_USER_BY_USERID =
            "SELECT * FROM users WHERE id=:userId";

    private static final String GET_SEANCE_BY_ID =
            "SELECT * FROM seances WHERE id=:id";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public User getUserByUserId(int userId) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("userId", userId);
        return namedParameterJdbcTemplate.query(GET_USER_BY_USERID, parameters, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setLogin(rs.getString("login"));
                user.setEmail(rs.getString("email"));
                return user;
            }
        }).get(0);
    }

    public Seance getSeanceById(int seanceId) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("id", seanceId);
        return namedParameterJdbcTemplate.query(GET_SEANCE_BY_ID, parameters, new RowMapper<Seance>() {
            @Override
            public Seance mapRow(ResultSet rs, int rowNum) throws SQLException {
                Seance seance = new Seance();
                seance.setId(rs.getInt("id"));
                seance.setDataStart(rs.getString("data_start"));
                seance.setDataStartTime(rs.getString("data_start_time"));
                seance.setPrice(rs.getDouble("price"));
                return seance;
            }
        }).get(0);


    }
}

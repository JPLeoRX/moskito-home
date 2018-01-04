package org.moskito.moskito_home.dao;

import org.moskito.moskito_home.model.Login;
import org.moskito.moskito_home.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void register(User user) {
        // Form sql string
        String sql = "INSERT INTO users VALUES (?, ?, ?)";

        // Update
        jdbcTemplate.update(sql, new Object[]{user.getUsername(), user.getPassword(), user.getAppUrl()});

    }

    public User validateUser(Login login) {
        // Form sql string
        String sql = "SELECT * FROM users WHERE username='" + login.getUsername() +"' AND password='" + login.getPassword() + "'";

        // Query the users
        List<User> users = jdbcTemplate.query(sql, new UserMapper());

        // Return user if successful or null
        return users.size() > 0 ? users.get(0) : null;
    }

    public User validateUser(String username) {
        // Form sql string
        String sql = "SELECT * FROM users WHERE username='" + username + "'";

        // Query the users
        List<User> users = jdbcTemplate.query(sql, new UserMapper());

        // Return user if successful or null
        return users.size() > 0 ? users.get(0) : null;
    }

    private static class UserMapper implements RowMapper<User> {
        public User mapRow(ResultSet rs, int i) throws SQLException {
            return new User(rs.getString("username"), rs.getString("password"), rs.getString("app_url"));
        }
    }
}

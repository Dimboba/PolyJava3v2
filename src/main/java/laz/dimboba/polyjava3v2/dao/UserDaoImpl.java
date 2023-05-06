package laz.dimboba.polyjava3v2.dao;

import laz.dimboba.polyjava3v2.entity.User;
import laz.dimboba.polyjava3v2.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{

    @Override
    public User findById(int id) {
        try {
            Connection connection = new ConnectionFactory().getNewConnection();
            Statement statement = connection.createStatement();
            String query = "Select * FROM users WHERE id = " + id;
            ResultSet res = statement.executeQuery(query);
            System.out.println(res.next());

            String nickname = res.getString("nickname");
            String password = res.getString("password");
            int score = res.getInt("score");
            System.out.println(score);

            return new User(id, nickname, password, score);

        } catch (SQLException e){
            System.err.println(e.getMessage());
        }

        return new User();
    }

    public void save(User user) {

    }

    public void update(User user) {

    }

    public void delete(User user) {

    }

    public List<User> findAllUsers() {
        return new ArrayList<User>();
    }
}

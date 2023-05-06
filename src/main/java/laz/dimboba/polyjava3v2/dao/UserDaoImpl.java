package laz.dimboba.polyjava3v2.dao;

import laz.dimboba.polyjava3v2.entity.User;
import laz.dimboba.polyjava3v2.utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{

    @Override
    public User findById(int id) {
        System.out.println(id + "!");
        try {
            Connection connection = new ConnectionFactory().getNewConnection();
            Statement statement = connection.createStatement();
            System.out.println("here");
            String query = "Select * FROM users where id = " + id;

            ResultSet res = statement.executeQuery(query);
            res.next();
            System.out.println(id + "!!!");

            String nickname = res.getString("nickname");
            String password = res.getString("password");
            int score = res.getInt("score");

            connection.close();
            return new User(id, nickname, password, score);

        } catch (SQLException e){
            System.err.println("FindById Error");
            System.err.println(e.getMessage());
        }

        return new User();
    }

    public void save(String nickname, String passwd) {
        try {
            Connection connection = new ConnectionFactory().getNewConnection();
            Statement statement = connection.createStatement();
            String query = "INSERT INTO " +
                    "users(nickname, password) " +
                    "VALUES (?, ?)";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);
            preparedStatement.setString(1, nickname);
            preparedStatement.setString(2, passwd);
            ResultSet res = preparedStatement.executeQuery();
            connection.close();
        } catch (SQLException e){

            System.err.println("Save Error");
            System.err.println(e.getMessage());
            //TODO: что за ошибка??? При этом работает верно
        }
    }

    public void update(User user) {

    }

    public void delete(User user) {

    }

    public List<User> findAllUsers() {
        return new ArrayList<User>();
    }
}

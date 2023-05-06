package laz.dimboba.polyjava3v2.dao;

import laz.dimboba.polyjava3v2.entity.User;
import laz.dimboba.polyjava3v2.utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{

    @Override
    public User findById(int id) {
        try {
            Connection connection = new ConnectionFactory().getNewConnection();
            Statement statement = connection.createStatement();
            String query = "Select * FROM users where id = " + id;

            ResultSet res = statement.executeQuery(query);
            res.next();

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
        try {
            Connection connection = new ConnectionFactory().getNewConnection();
            String query = "UPDATE users " +
                    "Set (nickname," +
                    "password," +
                    "score) =" +
                    "(?,?,?)" +
                    "where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, user.getNickname());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getScore());
            preparedStatement.setInt(4, user.getId());

            ResultSet res = preparedStatement.executeQuery();


            connection.close();
        } catch (SQLException e) {
            System.err.println("Update Error");
            System.err.println(e.getMessage());
            //TODO: что за ошибка??? При этом работает верно
        }
    }

    public void delete(User user) {
        try {
            Connection connection = new ConnectionFactory().getNewConnection();
            Statement statement = connection.createStatement();
            String query = "Delete FROM users Where id = " + user.getId();
            ResultSet res = statement.executeQuery(query);
            connection.close();
        } catch (SQLException e){
            System.err.println("Delete Error");
            System.err.println(e.getMessage());
            //TODO: что за ошибка??? При этом работает верно
        }
    }

    public List<User> findAllUsers() {
        try {
            Connection connection = new ConnectionFactory().getNewConnection();
            Statement statement = connection.createStatement();
            String query = "Select * FROM users order by score desc ";

            ResultSet res = statement.executeQuery(query);
            List<User> ans = new ArrayList<>();
            while(res.next()) {
                ans.add(new User(
                   res.getInt("id"),
                   res.getString("nickname"),
                   res.getString("password"),
                   res.getInt("score")
                ));
            }
            connection.close();
            return ans;
        } catch(SQLException e) {
            System.err.println("FindAll Error");
            System.err.println((e.getMessage()));
        }
        return null;
    }
}

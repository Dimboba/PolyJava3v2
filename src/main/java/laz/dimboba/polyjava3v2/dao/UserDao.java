package laz.dimboba.polyjava3v2.dao;

import laz.dimboba.polyjava3v2.entity.User;

import java.util.List;

public interface UserDao {
    public User findById(int id);
    public void save(String nickname, String password);
    public void update(User user);
    public void delete(User user);
    public List<User> findAllUsers();
}

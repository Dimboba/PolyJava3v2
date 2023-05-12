package laz.dimboba.polyjava3v2.model.scoreboard.userservice;

import laz.dimboba.polyjava3v2.model.scoreboard.dao.UserDao;
import laz.dimboba.polyjava3v2.model.scoreboard.dao.UserDaoImpl;
import laz.dimboba.polyjava3v2.model.scoreboard.entity.User;

import java.util.List;

public class UserService {
    private UserDao userDao = new UserDaoImpl();

    public UserService() {}

    public User findUser(int id) {
        return userDao.findById(id);
    }

    public void saveUser(String nickname, String password) {
        userDao.save(nickname, password);
    }

    public void deleteUser(User user) {
        userDao.delete(user);
    }

    public void updateUser(User user) {
        userDao.update(user);
    }

    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }
}

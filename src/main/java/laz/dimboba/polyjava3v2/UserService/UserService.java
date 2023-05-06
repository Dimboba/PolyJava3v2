package laz.dimboba.polyjava3v2.UserService;

import laz.dimboba.polyjava3v2.dao.UserDao;
import laz.dimboba.polyjava3v2.dao.UserDaoImpl;
import laz.dimboba.polyjava3v2.entity.User;

import java.util.List;

public class UserService {
    private UserDao userDao = new UserDaoImpl();

    public UserService() {}

    public User findUser(int id) {
        return userDao.findById(id);
    }

    public void saveUser(User user) {
        userDao.save(user);
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

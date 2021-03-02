package servlet0302.service;

import servlet0302.dao.UserDao;
import servlet0302.dao.UserDaoImpl;
import servlet0302.entity.User;

import java.util.List;

public class UserService {
    UserDao userDao = new UserDaoImpl();
    // 查询所有用户
    public List<User> getAllUsers() {
        return userDao.getAllUser();
    }
}
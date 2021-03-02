package servlet0302.dao;

import servlet0302.entity.User;

import java.util.List;

public interface UserDao {
    // 查询所有用户
    List<User> getAllUser();
}
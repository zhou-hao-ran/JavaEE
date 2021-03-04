package servlet0303.dao;

import servlet0303.model.Userinfos;

import java.util.List;

public interface UserDao {
    // 新增用户
    int addUser(Userinfos userinfos);

    // 删除用户
    int delUserById(String id);

    //修改数据
    int upUserById(Userinfos userinfos);

    //模糊查询
    List<Userinfos> findUserByNickname(String keyword);
}
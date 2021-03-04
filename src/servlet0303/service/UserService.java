package servlet0303.service;

import servlet0303.dao.UserDao;
import servlet0303.dao.UserDaoImpl;
import servlet0303.model.RespBean;
import servlet0303.model.Userinfos;

import java.util.List;

public class UserService {
    UserDao userDao = new UserDaoImpl();
    public RespBean addUser(Userinfos userinfos) {
        int count = userDao.addUser(userinfos);
        if (count == 0) {
            return RespBean.error(500, "新增失败");
        }else{
            return RespBean.success(200, "新增成功");
        }
    }

    public RespBean delUser(String id) {
        int count = userDao.delUserById(id);
        if (count == 0) {
            return RespBean.error(500, "删除失败");
        }else{
            return RespBean.success(200, "删除成功");
        }
    }

    public RespBean upUser(Userinfos userinfos) {
        int count = userDao.upUserById(userinfos);
        if (count == 0) {
            return RespBean.error(500, "修改失败");
        }else{
            return RespBean.success(200, "修改成功");
        }
    }

    public List<Userinfos> findUser(String keyword) {
        return userDao.findUserByNickname(keyword);
    }
}
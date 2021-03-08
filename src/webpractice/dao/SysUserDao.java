package webpractice.dao;

import webpractice.bean.SysUser;

public interface SysUserDao {
    SysUser findUserByNameAndPass(String username, String password);
}
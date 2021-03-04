package servlet0303.dao;

import servlet0303.model.Userinfos;
import servlet0303.utils.DBUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao{
    @Override
    public int addUser(Userinfos userinfos) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtils.getInstance().getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into userinfos values(default,?,?,?,default,default)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,userinfos.getUsername());
            ps.setString(2,userinfos.getPassword());
            ps.setString(3,userinfos.getNickname());
            count = ps.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBUtils.getInstance().close(ps);
            DBUtils.getInstance().close(conn);
        }
        return count;
    }

    @Override
    public int delUserById(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtils.getInstance().getConnection();
            conn.setAutoCommit(false);
            String sql = "delete from userinfos where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1,Long.parseLong(id));
            count = ps.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBUtils.getInstance().close(ps);
            DBUtils.getInstance().close(conn);
        }
        return count;
    }

    @Override
    public int upUserById(Userinfos userinfos) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtils.getInstance().getConnection();
            conn.setAutoCommit(false);
            String sql = "update userinfos set password=?,gender=?,birthday=? where id= ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1,userinfos.getPassword());
            ps.setBoolean(2,userinfos.getGender());
            ps.setString(3, userinfos.getBirthday());
            ps.setLong(4,userinfos.getId());
            count = ps.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBUtils.getInstance().close(ps);
            DBUtils.getInstance().close(conn);
        }
        return count;
    }
}
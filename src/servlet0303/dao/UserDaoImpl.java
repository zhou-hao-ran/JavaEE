package servlet0303.dao;

import servlet0303.model.Userinfos;
import servlet0303.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
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
            ps.setString(1, userinfos.getUsername());
            ps.setString(2, userinfos.getPassword());
            ps.setString(3, userinfos.getNickname());
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
            ps.setLong(1, Long.parseLong(id));
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
            ps.setString(1, userinfos.getPassword());
            ps.setBoolean(2, userinfos.getGender());
            ps.setTimestamp(3, new Timestamp(userinfos.getBirthday().getTime()));
            ps.setLong(4, userinfos.getId());
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
    public List<Userinfos> findUserByNickname(String keyword) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Userinfos> list = new ArrayList<>();
        try {
            conn = DBUtils.getInstance().getConnection();
            ps = conn.prepareStatement("select * from userinfos where nickname like concat('%',?,'%')");
            ps.setString(1, keyword);
            rs = ps.executeQuery();
            while (rs.next()) {
                Userinfos userinfos = new Userinfos();
                userinfos.setId(rs.getLong("id"));
                userinfos.setUsername(rs.getString("username"));
                userinfos.setPassword(rs.getString("password"));
                userinfos.setNickname(rs.getString("nickname"));
                userinfos.setGender(rs.getBoolean("gender"));
                userinfos.setBirthday(rs.getDate("birthday"));
                list.add(userinfos);
            }
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBUtils.getInstance().close(rs);
            DBUtils.getInstance().close(ps);
            DBUtils.getInstance().close(conn);
        }

        return list;
    }
}
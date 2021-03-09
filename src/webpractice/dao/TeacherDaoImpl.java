package webpractice.dao;

import servlet0303.utils.DBUtils;
import webpractice.bean.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {
    @Override
    public long getTotal(String idOrName) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int count=0;
        try {
            conn=DBUtils.getInstance().getConnection();
            ps=conn.prepareStatement("select count(id) as total from teacher where id = ? or tname like concat('%',?,'%')");
            ps.setString(1,idOrName);
            ps.setString(2,idOrName);
            rs=ps.executeQuery();
            count=rs.getInt("total");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.getInstance().close(rs);
            DBUtils.getInstance().close(ps);
            DBUtils.getInstance().close(conn);
        }
        return count;
    }

    @Override
    public List<Teacher> findTeacher(String idOrName, long pageNum, String pageSize) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Teacher> list = new ArrayList<>();
        try{
            conn= DBUtils.getInstance().getConnection();
            ps=conn.prepareStatement("select * from teacher where id = ? or tname like concat('%',?,'%') limit ?,?");
            ps.setString(1,idOrName);
            ps.setString(2,idOrName);
            ps.setLong(3,pageNum);
            ps.setLong(4,Long.valueOf(pageSize));
            rs=ps.executeQuery();
            while (rs.next()){
                Teacher teacher = new Teacher();
                teacher.setId(rs.getLong("id"));
                teacher.setTname(rs.getString("tname"));
                teacher.setNation(rs.getString("nation"));
                teacher.setGender(rs.getBoolean("gender"));
                teacher.setBirthday(rs.getDate("birthday"));
                teacher.setMobile(rs.getString("mobile"));
                teacher.setEducate(rs.getString("educate"));
                teacher.setSchool(rs.getString("school"));
                teacher.setJoinTime(rs.getTimestamp("joinTime"));
                teacher.setLeaveTime(rs.getTimestamp("leaveTime"));
                teacher.setStatus(rs.getBoolean("status"));
                list.add(teacher);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.getInstance().close(rs);
            DBUtils.getInstance().close(ps);
            DBUtils.getInstance().close(conn);
        }
        return list;
    }
}

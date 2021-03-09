package webpractice.dao;

import webpractice.bean.Teacher;

import java.util.List;

public interface TeacherDao {
    long getTotal(String idOrName);

    List<Teacher> findTeacher(String idOrName, long pageNum, String pageSize);
}

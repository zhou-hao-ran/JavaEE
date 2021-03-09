package webpractice.service;

import webpractice.bean.PageInfos;
import webpractice.bean.Teacher;
import webpractice.dao.TeacherDao;
import webpractice.dao.TeacherDaoImpl;

import java.util.List;

public class TeacherService {
    TeacherDao dao=new TeacherDaoImpl();
    public PageInfos searchTeachers(String idOrName, String pageNum, String pageSize) {
        List<Teacher> list=dao.findTeacher(idOrName == null?"":idOrName,(Long.valueOf(pageNum)-1)*Long.valueOf(pageSize),pageSize);
        long counts=dao.getTotal(idOrName);
        PageInfos infos = new PageInfos();
        infos.setTotal(counts);
        infos.setData(list);
        return infos;
    }
}

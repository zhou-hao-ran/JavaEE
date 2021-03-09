package webpractice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import webpractice.bean.PageInfos;
import webpractice.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/searchTeacher")
public class SearchTeacherServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idOrName = request.getParameter("idOrName");
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        TeacherService service = new TeacherService();
        PageInfos pageInfos=service.searchTeachers(idOrName,pageNum,pageSize);
        response.getWriter().println(new ObjectMapper().writeValueAsString(pageInfos));
    }
}

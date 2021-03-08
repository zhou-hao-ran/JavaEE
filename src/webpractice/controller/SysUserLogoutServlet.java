package webpractice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import webpractice.bean.RespBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/logout")
public class SysUserLogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        RespBean respBean = RespBean.success(200, "退出成功");
        response.getWriter().println(new ObjectMapper().writeValueAsString(respBean));
    }
}
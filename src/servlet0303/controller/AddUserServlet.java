package servlet0303.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import servlet0303.model.RespBean;
import servlet0303.model.Userinfos;
import servlet0303.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(value = "/addUser")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String nickname = request.getParameter("nickname");
        // 封装数据
        Userinfos userinfos = new Userinfos();
        userinfos.setUsername(username);
        userinfos.setPassword(password);
        userinfos.setNickname(nickname);
        // 调Service
        UserService userService = new UserService();
        RespBean respBean = userService.addUser(userinfos);
        response.getWriter().println(new ObjectMapper().writeValueAsString(respBean));
    }
}
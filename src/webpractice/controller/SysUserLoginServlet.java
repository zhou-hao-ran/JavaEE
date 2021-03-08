package webpractice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import webpractice.bean.RespBean;
import webpractice.servlet.SysUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/doLogin")
public class SysUserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取登录的用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 调用Service 登录业务
        SysUserService service = new SysUserService();
        RespBean respBean = service.doLogin(username,password);
        // 判断是否有登录信息，有的话将登陆者信息存入session
        if (respBean.getData() != null) {
            request.getSession().setAttribute("loginUser",respBean.getData());
        }
        // 响应
        response.getWriter().println(new ObjectMapper().writeValueAsString(respBean));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}
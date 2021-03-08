package servlet0226;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(value = "/login3")
public class LoginServlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求参数 username tom password 123
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        // 设置响应类型
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        PrintWriter writer = resp.getWriter();
        if (username.equals("tom") && password.equals("123")) {
            writer.println("<h3>登录成功</h3>");
        } else {
            writer.println("登录失败");
        }
    }
}
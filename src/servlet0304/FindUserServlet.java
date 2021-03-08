package servlet0304;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(value = "/FindUser4")
public class FindUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser == null) {
            System.out.println("未登录");
        } else {
            System.out.println("登录成功");
        }
    }
}

package servlet0226;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/login4")
public class LoginServlet4 extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求参数
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        // 设置响应类型
        resp.setContentType("application/json;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        PrintWriter writer = resp.getWriter();
        RespBean respBean = new RespBean();
        if (username.equals("tom") && password.equals("123")) {
            User user = new User();
            user.setId(101);
            user.setUsername("tom");
            respBean.setStatus(200);
            respBean.setMsg("登录成功");
            respBean.setObj(user);
        } else {
            respBean.setStatus(500);
            respBean.setMsg("用户名或密码无效");
        }
        // respBean 写成 JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String strJson = objectMapper.writeValueAsString(respBean);
        writer.println(strJson);
    }
}
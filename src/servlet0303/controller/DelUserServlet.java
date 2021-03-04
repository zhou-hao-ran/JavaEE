package servlet0303.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import servlet0303.model.RespBean;
import servlet0303.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/delById")
public class DelUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 保证接受及响应时不乱码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String id = request.getParameter("id");
        UserService service = new UserService();
        RespBean respBean = service.delUser(id);
        writer.println(new ObjectMapper().writeValueAsString(respBean));
    }
}

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

@WebServlet(value = "/delById")
public class DelUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        UserService service = new UserService();
        RespBean respBean = service.delUser(id);
        response.getWriter().println(new ObjectMapper().writeValueAsString(respBean));
    }
}

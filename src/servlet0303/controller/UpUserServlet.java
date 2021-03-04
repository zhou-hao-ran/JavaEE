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
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(value = "/upById")
public class UpUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 保证接受及响应时不乱码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        // 获取请求参数
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        // 封装数据
        Userinfos userinfos = new Userinfos();
        userinfos.setId(Long.valueOf(id));
        userinfos.setPassword(password);
        userinfos.setGender(Boolean.valueOf(gender));
            try {
                if (birthday != null) {
                userinfos.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        // 调Service
        UserService userService = new UserService();
        RespBean respBean = userService.upUser(userinfos);
        //在postman中打印json数据
        writer.println(new ObjectMapper().writeValueAsString(respBean));
    }
}
package servlet0303.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(value = {"/addUser","/delById","/findUser","/upById"})
@WebFilter(value = "/*")
public class Filter0303 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 保证接受及响应时不乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
    }
}

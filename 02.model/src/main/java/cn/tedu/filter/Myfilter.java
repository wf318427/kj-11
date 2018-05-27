package cn.tedu.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Administrator on 17.12.23.
 */
public class Myfilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}

package br.com.gd.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aninha S.A
 */
//@WebFilter(urlPatterns = "/*")
public class LoginRedirectFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("a culpa é sua.");
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();
        String url = ((HttpServletRequest) request).getRequestURI();
        System.out.println("url: " + url);
        String login = session.getAttribute("login") != null ? (String) session.getAttribute("login") : "";
        System.out.println("login filter: " + login);
        if (url.contains("Login")||login == null) {
            request.getRequestDispatcher("telaLogin.xhtml").forward(request, response);
        }else{
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}

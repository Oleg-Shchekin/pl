package com.os.filter;

import com.os.command.Error403Command;
import com.os.entity.Administrator;
import com.os.entity.Reader;
import com.os.enums.Role;
import com.os.security.SecurityUtils;
import com.os.util.UrlPath;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String path = request.getPathInfo();
        Reader signedInReader = (Reader) request.getSession().getAttribute("readerSession");
        Administrator administrator = (Administrator) request.getSession().getAttribute("adminSession");

        if(UrlPath.SIGN_IN.equals(path) && signedInReader != null){
            response.sendRedirect("/library" + UrlPath.READER_PROFILE);
            return;
        }
        if (UrlPath.ADMIN.equals(path) && signedInReader != null){
            response.sendRedirect("/library" + UrlPath.ADMIN_SHOW_ALL_BOOKS);
            return;
        }

        if(SecurityUtils.isSecurityPage(request)){
            if((signedInReader != null && SecurityUtils.hasPermission(request, Role.READER)) ||
                    (administrator != null && SecurityUtils.hasPermission(request, Role.ADMINISTRATOR))){
                filterChain.doFilter(request, response);
            }
            else {
                new Error403Command().execute(request, response);
            }
        }
        else {
            filterChain.doFilter(request, response);
        }

    }


    @Override
    public void destroy() {

    }
}

package com.os.command.admin;

import com.os.command.Command;
import com.os.entity.Administrator;
import com.os.service.impl.AdministratorServiceImpl;
import com.os.util.Routes;
import com.os.util.UrlPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminCommand implements Command {

    private AdministratorServiceImpl administratorServiceImpl;

    public AdminCommand(AdministratorServiceImpl administratorServiceImpl) {
        this.administratorServiceImpl = administratorServiceImpl;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Administrator administrator = (Administrator) request.getAttribute("adminSession");

        if(administrator != null){
            response.sendRedirect("/library" + UrlPath.ADMIN_SHOW_ALL_BOOKS);
        }
        else {
            if(administratorServiceImpl.isExist(login, password)){
                administrator = administratorServiceImpl.getAdministratorByLoginAndPassword(login, password);
                request.getSession().setAttribute("adminSession", administrator);
                response.sendRedirect("/library" + UrlPath.ADMIN_SHOW_ALL_BOOKS);
            }
            else{
                String message = "Wrong email or password";
                request.setAttribute("SignInFailedMessage", message);
                request.getRequestDispatcher(Routes.ADMIN_SIGN_IN).forward(request, response);
            }
        }
    }
}

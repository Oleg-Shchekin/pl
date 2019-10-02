package com.os.command;

import com.os.entity.Reader;
import com.os.service.impl.ReaderServiceImpl;
import com.os.util.Routes;
import com.os.util.UrlPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpCommand implements Command {

    private ReaderServiceImpl readerServiceImpl;

    public SignUpCommand(ReaderServiceImpl readerServiceImpl) {
        this.readerServiceImpl = readerServiceImpl;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Reader reader = (Reader) request.getSession().getAttribute("readerSession");


        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String telephoneNumber = request.getParameter("telephone_number");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if(reader != null){
            response.sendRedirect("/library" + UrlPath.READER_PROFILE);
        }
        else {
            if (readerServiceImpl.isEmailExist(email)) {
                String message = "Email is already exist!";
                request.setAttribute("SignUpFailedMessage", message);
                request.getRequestDispatcher(Routes.SIGN_UP).forward(request, response);
            } else {
                reader = new Reader.ReaderBuilder()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setTelephoneNumber(telephoneNumber)
                        .setEmail(email)
                        .setPassword(password)
                        .build();
                readerServiceImpl.create(reader);
                request.getRequestDispatcher(Routes.SUCCESSFUL_REGISTRATION).forward(request, response);
            }
        }
    }
}

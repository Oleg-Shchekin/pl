package com.os.command;

import com.os.entity.Reader;
import com.os.service.impl.ReaderServiceImpl;
import com.os.util.Routes;
import com.os.util.UrlPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInCommand implements Command {

    private ReaderServiceImpl readerServiceImpl;

    public SignInCommand(ReaderServiceImpl readerServiceImpl) {
        this.readerServiceImpl = readerServiceImpl;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Reader reader = (Reader) request.getSession().getAttribute("readerSession");

        if(reader != null){
            response.sendRedirect("/library" + UrlPath.READER_PROFILE);
        }
        else {
            reader = readerServiceImpl.getReaderByEmailAndPassword(email, password);
            if(readerServiceImpl.isReaderExist(reader)){
                request.getSession().setAttribute("readerSession", reader);
                response.sendRedirect("/library" + UrlPath.READER_PROFILE);
            }
            else{
                String message = "Wrong email or password";
                request.setAttribute("SignInFailedMessage", message);
                request.getRequestDispatcher(Routes.SIGN_IN).forward(request, response);
            }
        }
    }
}

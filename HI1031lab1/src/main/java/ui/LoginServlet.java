package ui;

import bo.UserHandler;
import bo.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet("/user-login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserHandler userHandler = new UserHandler();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()) {
            String username = request.getParameter("login-username");
            String password = request.getParameter("login-password");

            UserInfo user = userHandler.verify(username, password);

            if (user != null) {

                request.getSession().setAttribute("loggedInUser", user);
                System.out.print("user logged in");
                response.sendRedirect("index.jsp");
            } else {
                System.out.print("!!!!!not logged in");
                request.setAttribute("errorMessage", "Invalid username or password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }
}



import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
   
 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter out = response.getWriter();
       
       String username = request.getParameter("username");
       String password = request.getParameter("password");
       String mobile = request.getParameter("mobile");
       
       User user = new User(username, password, mobile);
       boolean status = UserDAO.registerUser(user);
       if(status){
         response.sendRedirect("login.html");
       }
       else
         response.sendRedirect("register.html");
    }

}

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PrintWriter out = response.getWriter();
         String username = request.getParameter("username");
         String password = request.getParameter("password");
         User user = new User();
         user.setUsername(username);
         user.setPassword(password);
         boolean status = UserDAO.authenticateUser(user);
         if(status){
           HttpSession session = request.getSession();
           session.setAttribute("username", username);
           response.sendRedirect("./ProductDashboard");
         }
         else{
           response.sendRedirect("login.html");
         }
         
    }


}

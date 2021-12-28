
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProductDashboard extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
       Object username =  session.getAttribute("username");
       if(username!=null){
         out.print("<html>");
         out.print("<body>");
         out.print("<h3>Welcome "+username+"</h3>");
         out.print("<a href='./AddProductServlet'>Add-Product</a><br>");
         out.print("<a href='./ProductListServlet'>Product List</a><br>");
         out.print("<a href='./LogoutServlet'>Logout</a>");
         out.print("</body>");
         out.print("</html>");
       }
       else
           response.sendRedirect("login.html");
    }

}

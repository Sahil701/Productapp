import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class ProductListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        Object username = session.getAttribute("username");
        if(username!=null){
            ArrayList<Product>al = ProductDAO.getProductList();
            out.print("<html>");
            out.print("<body>");
            out.print("<table width='100%' border='1'>");
            
            out.print("<tr>");
            out.print("<td>S.no</td>");
            out.print("<td>Name</td>");
            out.print("<td>Price</td>");
            out.print("<td>Description</td>");
            out.print("<td>Edit</td>");
            out.print("<td>Delete</td>");
            out.print("</tr>");
            
            for(int i=0; i<al.size(); i++){
             Product p = al.get(i);
             out.print("<tr>");
             out.print("<td>"+(i+1)+"</td>");
             out.print("<td>"+p.getName()+"</td>");
             out.print("<td>"+p.getPrice()+"</td>");
             out.print("<td>"+p.getDescription()+"</td>");
             out.print("<td><button>Edit</button></td>");
             out.print("<td><button>Delete</button></td>");
             out.print("</tr>");
            
            }
            
            out.print("</table>");
            out.print("</body>");
            out.print("</html>");
        }
        else
            response.sendRedirect("login.html");
    }

}

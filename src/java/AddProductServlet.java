import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        Object username = session.getAttribute("username");
        if(username!=null){
            String message = request.getParameter("message");
            
            out.print("<html>");
            out.print("<body>");
            if(message!=null){
              if(message.equals("true"))
                  out.print("<h3>Product Saved</h3>");
              else if(message.equals("false"))
                    out.print("<h3>Product Not Saved</h3>");
            }
            out.print("<a href='./ProductListServlet'>ProductList</a>");
            out.print("<form method='post' action='./AddProductServlet'>");
            out.print("<div>");
            out.print("<label>Product Name</label><br>");
            out.print("<input type='text' name='product_name'/>");
            out.print("</div>");
            
            out.print("<div>");
            out.print("<label>Price</label><br>");
            out.print("<input type='text' name='product_price'/>");
            out.print("</div>");
            
            out.print("<div>");
            out.print("<label>Description</label><br>");
            out.print("<input type='text' name='product_desc'/>");
            out.print("</div>");
            
            out.print("<div>");
            out.print("<button type='submit'>Add-product</button>");
            out.print("</div>");
            out.print("</form>");
            
            out.print("</body>");
            out.print("</html>");
        }
        else
            response.sendRedirect("login.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          String name = request.getParameter("product_name");
          String price = request.getParameter("product_price");
          String desc = request.getParameter("product_desc");
          
          Product p = new Product(name, Float.parseFloat(price), desc);
          
          boolean status = ProductDAO.save(p);
          if(status){
              response.sendRedirect("./AddProductServlet?message=true");
          }
          else
            response.sendRedirect("./AddProductServlet?message=false");  
    }


}

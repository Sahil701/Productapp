
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class UpdateProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        Object username = session.getAttribute("username");
        if(username!=null){
            String message = request.getParameter("message");
            String id = request.getParameter("id");
            Product p = ProductDAO.getProductById(Integer.parseInt(id));
            out.print("<html>");
            out.print("<body>");
            if(message!=null){
              if(message.equals("true"))
                  out.print("<h3>Product Saved</h3>");
              else if(message.equals("false"))
                    out.print("<h3>Product Not Saved</h3>");
            }
            out.print("<a href='./ProductListServlet'>ProductList</a>");
            out.print("<form method='post' action='./UpdateProductServlet'>");
            out.print("<input type='hidden' name='id' value='"+p.getId()+"'>");
            out.print("<div>");
            out.print("<label>Product Name</label><br>");
            out.print("<input type='text' name='product_name' value='"+p.getName()+"'/>");
            out.print("</div>");
            
            out.print("<div>");
            out.print("<label>Price</label><br>");
            out.print("<input type='text' name='product_price' value='"+p.getPrice()+"'/>");
            out.print("</div>");
            
            out.print("<div>");
            out.print("<label>Description</label><br>");
            out.print("<input type='text' name='product_desc' value='"+p.getDescription()+"'/>");
            out.print("</div>");
            
            out.print("<div>");
            out.print("<button type='submit'>Update</button>");
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
        String id = request.getParameter("id");
        String name = request.getParameter("product_name");
        String price = request.getParameter("product_price");
        String desc = request.getParameter("product_desc");
        
        boolean status = ProductDAO.update(new Product(Integer.parseInt(id), name, Float.parseFloat(price), desc));
        if(status)
            response.sendRedirect("./ProductListServlet");
    }

}

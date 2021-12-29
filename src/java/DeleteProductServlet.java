import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DeleteProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String id = request.getParameter("id");
       boolean status = ProductDAO.delete(Integer.parseInt(id));
       if(status)
           response.sendRedirect("./ProductListServlet");
    }
}

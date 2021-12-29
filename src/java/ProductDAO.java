
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDAO {
  public static Product getProductById(int id){
   Product p = null;
   Connection con = null;
   try{
       con = GetConnection.getConnection();
       String sql = "select * from product where id = ?";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setInt(1, id);
       ResultSet rs = ps.executeQuery();
       if(rs.next()){
           //int pid = rs.getInt(1);
           String name = rs.getString(2);
           float price = rs.getFloat(3);
           String desc =rs.getString(4);
           p = new Product(id, name, price, desc);
       }
   }
   catch(Exception e){
       e.printStackTrace();
   }
   finally{
       try{
           con.close();
       }
       catch(Exception e){
           e.printStackTrace();
       }
   }
   return p;
  }
  public static boolean save(Product p){
    boolean status = false;
    Connection con = null;
    try{
      con = GetConnection.getConnection();
      String sql = "insert into product(name,price,description) values(?,?,?)";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, p.getName());
      ps.setFloat(2, p.getPrice());
      ps.setString(3, p.getDescription());
      if(ps.executeUpdate()!=0)
          status = true;
    }   
    catch(Exception e){
        e.printStackTrace();
    }
    finally{
        try{
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    return status;
  }
  public static boolean delete(int id){
    boolean status = false;
    Connection con = null;
    try{
       con = GetConnection.getConnection();
       String sql = "delete from product where id = ?";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setInt(1, id);
       if(ps.executeUpdate()!=0)
           status = true;
    }   
    catch(Exception e){
        e.printStackTrace();
    }
    finally{
        try{
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    return status;
  }
  public static boolean update(Product p){
   boolean status = false;
   Connection con = null;
    try{
        con = GetConnection.getConnection();
        String sql = "update product set name=?,price=?,description=? where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, p.getName());
        ps.setFloat(2, p.getPrice());
        ps.setString(3,p.getDescription());
        ps.setInt(4, p.getId());
        if(ps.executeUpdate()!=0)
            status = true;
    }   
    catch(Exception e){
        e.printStackTrace();
    }
    finally{
        try{
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    return status;
  }
  public static ArrayList<Product> getProductList(){
    Connection con = null;
    ArrayList<Product>al = new ArrayList<>();
    try{
        con = GetConnection.getConnection();
        String sql = "select * from product";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            float price = rs.getFloat(3);
            String desc = rs.getString(4);
            Product p = new Product(id, name, price, desc);
            al.add(p);
        }
    }   
    catch(Exception e){
        e.printStackTrace();
    }
    finally{
        try{
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    return al;
  }
  
}

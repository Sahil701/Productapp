
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
  public static boolean authenticateUser(User user){
      boolean status = false;
      Connection con = null;
      try{
          con = GetConnection.getConnection();
          String sql = "select * from user where username = ? and password=?";
          PreparedStatement ps = con.prepareStatement(sql);
          ps.setString(1, user.getUsername());
          ps.setString(2, user.getPassword());
          ResultSet rs = ps.executeQuery();
          if(rs.next())
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
  public static boolean registerUser(User user){
      boolean status= false;
      Connection con = null;
      try{
          con = GetConnection.getConnection();
          String sql = "insert into user(username,password,mobile) values(?,?,?)";
          PreparedStatement ps = con.prepareStatement(sql);
          ps.setString(1, user.getUsername());
          ps.setString(2, user.getPassword());
          ps.setString(3, user.getMobile());
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
}


import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDAO {
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

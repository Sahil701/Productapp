public class User {
  private int id;
  private String username;
  private String password;
  private String mobile;

    public User(int id, String username, String password, String mobile) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.mobile = mobile;
    }

    public User(String username, String password, String mobile) {
        this.username = username;
        this.password = password;
        this.mobile = mobile;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
  
}

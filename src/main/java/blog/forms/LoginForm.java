package blog.forms;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginForm {

    /**
     * login user name
     */
    @Size(min=2, max=30, message = "The username size should be in the range (2..30)")
    private String username;

    /**
     * the password for login user
     */
    @NotNull
    @Size(min=1, max =50)
    private String password_hash;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password_hash;
    }

    public void setPassword(String password) {
        this.password_hash = password;
    }
}

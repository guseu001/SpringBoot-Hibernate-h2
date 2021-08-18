package de.Standard.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Login implements Serializable
{
    @Id
    @Column
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int log_id;
    @Column
    private boolean isLogging = false;
    @Column
    private String email;
    @Column
    private String password;
    @OneToOne
    private Users users;

    public Login(String emailAdresse,
                 String password){
        this.email = emailAdresse;
        this.password = password;
    }

    public Login(){}

    public int getLog_id() {
        return log_id;
    }

    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsLogging() {
        return isLogging;
    }

    public void setIsLogging(boolean logger) {
        this.isLogging = logger;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Users getKunde() {
        return users;
    }

    public void setKunde(Users users) {
        this.users = users;
    }
}

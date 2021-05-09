package de.Standard.Model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
public class Login
{

    @Id
    @Column
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int log_id;
    @Column
    private String emailAdresse;
    @Column
    private String passwort;

    public Login(String emailAdresse, String passwort){
        this.emailAdresse = emailAdresse;
        this.passwort = passwort;
    }

    public int getLog_id() {
        return log_id;
    }

    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }

    public String getEmailAdresse() {
        return emailAdresse;
    }

    public void setEmailAdresse(String emailAdresse) {
        this.emailAdresse = emailAdresse;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }
}

package de.Standard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailsendTest
{
    @Autowired
    JavaMailSender javaMailSender;

    @Test
    public void sendsimpleMail(){
        try{
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setSubject("Dies ist der Betreff der Test-E-Mail"); // E-Mail Betreff

            msg.setTo("hello@yahoo.fr"); // Es können mehrere Empfänger vorhanden sein

            msg.setText("Dies ist der Inhalt der Testnachricht"); // Nachrichtentext

            javaMailSender.send(msg);


        }
        catch (Exception e){
            System.out.println("done send");
        }

    }
}

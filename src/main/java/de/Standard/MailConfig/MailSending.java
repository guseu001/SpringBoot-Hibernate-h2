package de.Standard.MailConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;

@Async
public class MailSending implements MailService {

    @Autowired
    JavaMailSender mailSender;
    String empfaenger, betreff, nachricht;

    @Override
    public void sendmail(String empfaenger, String betreff, String nachricht) {
        SimpleMailMessage mailSending = new SimpleMailMessage();

        this.empfaenger = empfaenger;
        this.betreff = betreff;
        this.nachricht = nachricht;

        mailSending.setTo(empfaenger);
        mailSending.setSubject(betreff);
        mailSending.setText(nachricht);

        mailSender.send(mailSending);
        System.out.println("Mail ist Sending !");
    }


}

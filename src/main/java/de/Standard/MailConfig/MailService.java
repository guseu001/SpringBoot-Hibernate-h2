package de.Standard.MailConfig;

import org.springframework.scheduling.annotation.Async;

@Async
public interface MailService
{
    void sendmail(String empfaenger , String betreff, String nachricht);
}

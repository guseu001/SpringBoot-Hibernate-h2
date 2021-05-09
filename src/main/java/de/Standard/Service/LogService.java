package de.Standard.Service;

import de.Standard.Model.Kunde;
import de.Standard.Model.Login;
import de.Standard.Repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService
{
    @Autowired
    LogRepository logRepository;

    public boolean islog(){
        return true;
    }

    public void newlog(Login login){
        logRepository.save(login);
    }
}

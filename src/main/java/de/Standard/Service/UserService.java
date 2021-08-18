package de.Standard.Service;

import de.Standard.Model.Adresse;
import de.Standard.Model.Users;
import de.Standard.Model.Login;
import de.Standard.Repository.AdresseRepository;
import de.Standard.Repository.UserRepository;
import de.Standard.Repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class UserService
{
    private AdresseRepository adresseRepository;
    private UserRepository userRepository;
    private LogRepository logRepository;

//    @Autowired
//    SessionFactory sessionFactory;

    //  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    //  String passwortCodieren = passwordEncoder.encode(kunde.getPasswort());
    //  kunde.setPasswort(passwortCodieren);

    @Autowired
    public UserService(UserRepository userRepository,
                       AdresseRepository adresseRepository,
                       LogRepository logRepository)
    {
        this.userRepository = userRepository;
        this.adresseRepository = adresseRepository;
        this.logRepository = logRepository;
    }

    public void saveUser(Users users, Adresse adress){
        /*  Adresse daten  */
        adresseRepository.save(adress);

         /* Logging Daten  */
        Login log = new Login(users.getEmail(), users.getPassword());
        logRepository.save(log);
        log.setKunde(users);

        /* Save Person in der Database */
        userRepository.save(users);
        users.setAdress(adress);
    }

    public void updateUser(int id, Users altUsers, Users users) throws NullPointerException
    {
        try {
            if (users != null)
            {
                altUsers.setNachname(users.getNachname());
                altUsers.setVorname(users.getVorname());
                altUsers.setAnrede(users.getAnrede());
                altUsers.setGeburtsdatum(users.getGeburtsdatum());
                altUsers.setTelefonnummer(users.getTelefonnummer());

                userRepository.save(altUsers);
            }
        }
        catch (NullPointerException ex){
            new NullPointerException();
        }

    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }

    public Users getUser(String email, String password)
    {
        return userRepository.getUserBeiEmailAndPasswort(email, password);
    }

    public List<Users> getAllUser()
    {
        List<Users> userlist = new ArrayList<Users>();
        userRepository.findAll().forEach(user -> userlist.add(user));

        return userlist;
    }
}
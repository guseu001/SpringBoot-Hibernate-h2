package de.Standard.Service;

import de.Standard.Model.Adresse;
import de.Standard.Model.Kunde;
import de.Standard.Model.Login;
import de.Standard.Repository.AdresseRepository;
import de.Standard.Repository.KundeRepository;
import de.Standard.Repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class KundeService
{
    private AdresseRepository adresseRepository;
    private KundeRepository kundeRepository;
    private LogRepository logRepository;

//    @Autowired
//    SessionFactory sessionFactory;

    //  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    //  String passwortCodieren = passwordEncoder.encode(kunde.getPasswort());
    //  kunde.setPasswort(passwortCodieren);

    @Autowired
    public KundeService(KundeRepository kundeRepository,
                        AdresseRepository adresseRepository,
                        LogRepository logRepository)
    {
        this.kundeRepository = kundeRepository;
        this.adresseRepository = adresseRepository;
        this.logRepository = logRepository;
    }

    public void saveKunde(Kunde kunde, Adresse adress){
        /*  Adresse daten  */
        adresseRepository.save(adress);

         /* Logging Daten  */
        Login log = new Login(kunde.getEmail(), kunde.getPassword());
        logRepository.save(log);
        log.setKunde(kunde);

        /* Save Person in der Database */
        kundeRepository.save(kunde);
        kunde.setAdress(adress);
    }

    public void updateKunden(int id, Kunde altKunde, Kunde kunde) throws NullPointerException
    {
        try {
            if (kunde != null)
            {
                altKunde.setNachname((kunde.getNachname().isEmpty() ? altKunde.getNachname() : kunde.getNachname()));
                altKunde.setVorname(kunde.getVorname());
                altKunde.setAnrede(kunde.getAnrede());
                altKunde.setGeburtsdatum(kunde.getGeburtsdatum());
                altKunde.setGeburtstag(kunde.getGeburtstag());
                altKunde.setGeburtsmonat(kunde.getGeburtsmonat());
                altKunde.setTelefonnummer(kunde.getTelefonnummer());

                kundeRepository.save(altKunde);
            }
        }
        catch (NullPointerException ex){
            new NullPointerException();
        }

    }

    public void delete(int id){
        kundeRepository.deleteById(id);
    }

    public Kunde getKunde(String email, String password) {
    /*
            Session session = sessionFactory.openSession();
            Transaction transaction;
            Kunde kunde;

            try{
                transaction = session.beginTransaction();
    //            String SQLQuary = "Select * from kunde where kunde_id = " + id + ";";
                kunde = kundeRepository.findById(id).get();
                transaction.commit();
            }

            catch (HibernateException ex){
                ex.printStackTrace();
            }
    */
//        return kundeRepository.findById(id).get();
        return kundeRepository.getKundenBeiEmailAndPasswort(email, password);
    }

    public List<Kunde> getAllKunde() {
        List<Kunde> kundelist = new ArrayList<Kunde>();
        kundeRepository.findAll().forEach(kunde -> kundelist.add(kunde));

        return kundelist;
    }
}
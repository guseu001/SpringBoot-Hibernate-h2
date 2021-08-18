package de.Standard.Service;

import de.Standard.Repository.UserRepository;
import de.Standard.Repository.LogRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService
{
    @Autowired
    LogRepository logRepository;
    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    UserRepository kundeRepo;

    public boolean islog(){
        return true;
    }

    // TODO
//    public Users getKunde(String email, String password){
//
//        try {
//            Users einkunde;
//            Session session = sessionFactory.getCurrentSession();
//
//            Query query = session.createQuery("from Users where emailAdresse=:email and passwort=:password");
//            query.setParameter("emailId", email);
//            query.setParameter("password", password);
//            List<Users> list = query.getResultList();
//
//            return list.get(0);
//        }
//        catch (Exception ex){
//            System.out.println("Kunden existiert nicht!");
//        }
//        return null;//kundeRepo.findById(id).get();
//    }
}

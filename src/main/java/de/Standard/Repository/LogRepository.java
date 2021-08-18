package de.Standard.Repository;

import de.Standard.Model.Login;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends CrudRepository<Login, Integer>
{
//    @Query("select u from Login u where u.email = ?1 and u.password = ?1")
//    Login FindbyEmail(String email, String passwort);

}

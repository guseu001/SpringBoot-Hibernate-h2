package de.Standard.Repository;

import de.Standard.Model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Integer>
{
    @Query("select k from Users k where k.email = ?1 and k.password = ?2")
    Users getUserBeiEmailAndPasswort(String email, String password);

}

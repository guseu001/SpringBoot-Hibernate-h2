package de.Standard.Repository;

import de.Standard.Model.Login;
import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends CrudRepository<Login, Integer>
{

}

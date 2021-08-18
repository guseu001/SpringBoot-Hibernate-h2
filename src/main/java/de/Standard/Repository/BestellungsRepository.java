package de.Standard.Repository;

import de.Standard.Model.Bestellung;
import org.springframework.data.repository.CrudRepository;

public interface BestellungsRepository extends CrudRepository<Bestellung, Long>
{

}

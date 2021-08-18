package de.Standard.Repository;

import de.Standard.Model.Items;
import org.springframework.data.repository.CrudRepository;

public interface ItemsRepository extends CrudRepository<Items, Long>
{

}

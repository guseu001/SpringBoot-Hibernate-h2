package de.Standard.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import de.Standard.Model.Kunde;

public interface KundeRepository extends JpaRepository<Kunde, Integer>
{

}

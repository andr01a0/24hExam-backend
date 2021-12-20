package kea.exam.repositories;

import kea.exam.entities.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepo extends JpaRepository<Party, Long> {

}

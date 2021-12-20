package kea.exam.repositories;

import kea.exam.entities.Candidate;
import kea.exam.entities.Party;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepo extends JpaRepository<Candidate, Long> {

  List<Candidate> findByParty(Party party);

}

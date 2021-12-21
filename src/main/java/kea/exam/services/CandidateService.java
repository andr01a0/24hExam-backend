package kea.exam.services;

import kea.exam.dtos.CandidateDTO;
import kea.exam.entities.Candidate;
import kea.exam.entities.Party;
import kea.exam.exceptions.ResourceNotFoundException;
import kea.exam.repositories.CandidateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

  @Autowired
  CandidateRepo candidateRepo;

  public ResponseEntity<List<CandidateDTO>> getAllCandidates() {
    List<Candidate> candidateList = candidateRepo.findAll();
    if(candidateList.isEmpty())
      throw new ResourceNotFoundException("NO CONTENT");
    else
      return new ResponseEntity<>(CandidateDTO.entityToDTO(candidateList), HttpStatus.OK);
  }

  // for internal use
  public List<Candidate> findByParty(Party party) {
    return candidateRepo.findByParty(party);
  }

  public Candidate create(Candidate candidate) {
    return candidateRepo.save(candidate);
  }

  public void delete(Candidate candidate) {
    candidateRepo.delete(candidate);
  }

  public Candidate findById(long id) {
    return candidateRepo.findById(id).orElse(null);
  }

  public Candidate edit(Candidate candidate) {
    return candidateRepo.save(candidate);
  }

}

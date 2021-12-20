package kea.exam.controllers;

import kea.exam.dtos.CandidateDTO;
import kea.exam.dtos.CreateCandidateDTO;
import kea.exam.dtos.PartyDTO;
import kea.exam.entities.Candidate;
import kea.exam.services.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/party")
public class PartyController {

  @Autowired
  PartyService partyService;

  @GetMapping("/{id}")
  public ResponseEntity<PartyDTO> getPartyById(@PathVariable("id") long id) {
    return partyService.getPartyById(id);
  }

  @GetMapping("/{id}/candidate")
  public ResponseEntity<List<CandidateDTO>> getAllCandidates(@PathVariable("id") long id) {
    return partyService.getCandidates(id);
  }

  @PostMapping("/{id}/candidate")
  public ResponseEntity<CandidateDTO> addCandidate(@PathVariable("id") long id, @RequestBody CreateCandidateDTO createCandidateDTO) {
    return partyService.addCandidate(id, createCandidateDTO);
  }

  @DeleteMapping("/{partyId}/candidate/{candidateId}")
  public ResponseEntity<Long> removeCandidate(@PathVariable("partyId") long partyId, @PathVariable("candidateId") long candidateId) {
    return partyService.removeCandidate(partyId, candidateId);
  }

  @PutMapping("/{id}/candidate")
  public ResponseEntity<CandidateDTO> editCandidate(@PathVariable("id") long id, @RequestBody CandidateDTO candidateDTO) {
    return partyService.editCandidate(id, candidateDTO);
  }

}

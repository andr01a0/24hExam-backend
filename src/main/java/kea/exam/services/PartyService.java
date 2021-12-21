package kea.exam.services;

import kea.exam.dtos.CandidateDTO;
import kea.exam.dtos.CreateCandidateDTO;
import kea.exam.dtos.PartyDTO;
import kea.exam.entities.Candidate;
import kea.exam.entities.Party;
import kea.exam.exceptions.ResourceNotCreatedException;
import kea.exam.exceptions.ResourceNotFoundException;
import kea.exam.repositories.PartyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartyService {

  @Autowired
  PartyRepo partyRepo;
  @Autowired
  CandidateService candidateService;

  private String errorMessageIDNotFound(long id) {
    return "ID NOT FOUND: "+id;
  }

  public ResponseEntity<List<PartyDTO>> getAllParties() {
    List<Party> partyList = partyRepo.findAll();
    return new ResponseEntity<>(PartyDTO.entityToDTO(partyList), HttpStatus.OK);
  }

  public ResponseEntity<PartyDTO> getPartyById(long id) {
    Party party = partyRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(errorMessageIDNotFound(id)));
    return new ResponseEntity<>(PartyDTO.entityToDTO(party), HttpStatus.OK);
  }

  public ResponseEntity<List<CandidateDTO>> getCandidates(long id) {
    Party party = partyRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(errorMessageIDNotFound(id)));
    List<Candidate> candidateList = candidateService.findByParty(party);
    if(candidateList.isEmpty())
      throw new ResourceNotFoundException("NO CONTENT");
    else
      return new ResponseEntity<>(CandidateDTO.entityToDTO(candidateList), HttpStatus.OK);
  }

  public ResponseEntity<CandidateDTO> addCandidate(long partyId, CreateCandidateDTO createCandidateDTO) {
    partyRepo.findById(partyId).orElseThrow(() -> new ResourceNotFoundException(errorMessageIDNotFound(partyId)));
    createCandidateDTO.setPartyId(partyId);
    Candidate candidate = candidateService.create(CreateCandidateDTO.DTOtoEntity(createCandidateDTO));
    if(candidate != null)
      return new ResponseEntity<>(CandidateDTO.entityToDTO(candidate), HttpStatus.OK);
    else
      throw new ResourceNotCreatedException("ENTITY NOT CREATED: "+createCandidateDTO);
  }

  public ResponseEntity<Long> removeCandidate(long partyId, long candidateId) {
    Party party = partyRepo.findById(partyId).orElseThrow(() -> new ResourceNotFoundException(errorMessageIDNotFound(partyId)));
    Candidate candidate = candidateService.findById(candidateId);
    if(candidate == null)
      throw new ResourceNotCreatedException(errorMessageIDNotFound(candidateId));
    if(!party.getPartyId().equals(candidate.getParty().getPartyId()))
      throw new ResourceNotCreatedException(errorMessageIDNotFound(partyId));
    candidateService.delete(candidate);
    if(candidateService.findById(candidateId) == null)
      return new ResponseEntity<>(candidateId, HttpStatus.OK);
    else
      throw new ResourceNotCreatedException(errorMessageIDNotFound(candidateId));

  }

  public ResponseEntity<CandidateDTO> editCandidate(long id, CandidateDTO candidateDTO) {
    partyRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(errorMessageIDNotFound(id)));
    candidateDTO.setPartyId(id);
    if(candidateService.findById(candidateDTO.getCandidateId()) == null)
      throw new ResourceNotCreatedException(errorMessageIDNotFound(candidateDTO.getCandidateId()));
    Candidate candidate = candidateService.edit(CandidateDTO.DTOtoEntity(candidateDTO));
    if(candidateDTO.equals(candidate))
      return new ResponseEntity<>(CandidateDTO.entityToDTO(candidate), HttpStatus.OK);
    else
      throw new ResourceNotCreatedException("ENTITY NOT SAVED: "+candidateDTO);
  }

}

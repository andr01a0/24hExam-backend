package kea.exam.dtos;

import kea.exam.entities.Candidate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
public class CandidateDTO {

  private long candidateId;
  private String firstName;
  private String lastName;
  private int votes;
  private Long partyId;
  private String partyName;

  public CandidateDTO(Candidate candidate) {
    this.candidateId = candidate.getCandidateId();
    this.firstName = candidate.getFirstName();
    this.lastName = candidate.getLastName();
    this.votes = candidate.getVotes();
    this.partyId = candidate.getParty().getPartyId();
    this.partyName = candidate.getParty().getName();
  }

  private static ModelMapper modelMapper = new ModelMapper();

  public static CandidateDTO entityToDTO(Candidate candidate) {
    CandidateDTO candidateDTO = modelMapper.map(candidate, CandidateDTO.class);
    return candidateDTO;
  }

  public static List<CandidateDTO> entityToDTO(List<Candidate> candidates) {
    return candidates.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
  }

  public static Candidate DTOtoEntity(CandidateDTO candidateDTO) {
    Candidate candidate = modelMapper.map(candidateDTO, Candidate.class);
    return candidate;
  }

  public static List<Candidate> DTOtoEntity(List<CandidateDTO> candidateDTOS) {
    return candidateDTOS.stream().map(x -> DTOtoEntity(x)).collect(Collectors.toList());
  }

  @Override
  public String toString() {
    return this.getFirstName()+" "+this.getLastName();
  }

  @Override
  public boolean equals(Object o) {
    Candidate candidate = (Candidate) o;
    return this.firstName.equals(candidate.getFirstName()) && this.lastName.equals(candidate.getLastName()) && candidate.getParty().getPartyId().equals(this.partyId);
  }

}

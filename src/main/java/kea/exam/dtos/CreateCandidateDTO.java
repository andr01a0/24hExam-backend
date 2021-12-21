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
public class CreateCandidateDTO {

  private String firstName;
  private String lastName;
  private Long partyId;

  public CreateCandidateDTO(Candidate candidate) {
    this.firstName = candidate.getFirstName();
    this.lastName = candidate.getLastName();
    this.partyId = candidate.getParty().getPartyId();
  }

  private static ModelMapper modelMapper = new ModelMapper();

  public static CreateCandidateDTO entityToDTO(Candidate candidate) {
    CreateCandidateDTO createCandidateDTO = modelMapper.map(candidate, CreateCandidateDTO.class);
    return createCandidateDTO;
  }

  public static List<CreateCandidateDTO> entityToDTO(List<Candidate> candidates) {
    return candidates.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
  }

  public static Candidate DTOtoEntity(CreateCandidateDTO createCandidateDTO) {
    Candidate candidate = modelMapper.map(createCandidateDTO, Candidate.class);
    candidate.setCandidateId(null);
    candidate.setVotes(0);
    return candidate;
  }

  public static List<Candidate> DTOtoEntity(List<CreateCandidateDTO> candidateDTOS) {
    return candidateDTOS.stream().map(x -> DTOtoEntity(x)).collect(Collectors.toList());
  }

  @Override
  public String toString() {
    return this.getFirstName()+" "+this.getLastName();
  }

}

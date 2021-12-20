package kea.exam.dtos;

import kea.exam.entities.Party;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
public class PartyDTO {

  private String name;
  private String municipality;

  public PartyDTO(Party party) {
    this.name = party.getName();
    this.municipality = party.getMunicipality();
  }

  private static ModelMapper modelMapper = new ModelMapper();

  public static PartyDTO entityToDTO(Party party) {
    PartyDTO partyDTO = modelMapper.map(party, PartyDTO.class);
    return partyDTO;
  }

  public static List<PartyDTO> entityToDTO(List<Party> parties) {
    return parties.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
  }

  public static Party DTOtoEntity(PartyDTO partyDTO) {
    Party party = modelMapper.map(partyDTO, Party.class);
    return party;
  }

  public static List<Party> DTOtoEntity(List<PartyDTO> partyDTOS) {
    return partyDTOS.stream().map(x -> DTOtoEntity(x)).collect(Collectors.toList());
  }

}

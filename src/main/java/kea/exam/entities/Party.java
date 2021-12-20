package kea.exam.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "parties")
public class Party {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "party_id")
  private Long partyId;

  @Column(name = "name")
  private String name;

  @Column(name = "municipality")
  private String municipality;

  @JsonIgnore
  @OneToMany(mappedBy = "party", cascade = CascadeType.REMOVE)
  private Set<Candidate> candidates = new HashSet<>();

}

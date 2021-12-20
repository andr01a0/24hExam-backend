package kea.exam.controllers;

import kea.exam.dtos.CandidateDTO;
import kea.exam.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

  @Autowired
  CandidateService candidateService;

  @GetMapping
  public ResponseEntity<List<CandidateDTO>> getAllCandidates(){
    return candidateService.getAllCandidates();
  }

}

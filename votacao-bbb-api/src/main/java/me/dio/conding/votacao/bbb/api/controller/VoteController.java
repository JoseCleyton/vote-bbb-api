package me.dio.conding.votacao.bbb.api.controller;

import lombok.AllArgsConstructor;
import me.dio.conding.votacao.bbb.api.model.ParticipantModel;
import me.dio.conding.votacao.bbb.api.service.VoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vote")
@AllArgsConstructor
public class VoteController {

    private final VoteService voteService;

    @PostMapping
    public ResponseEntity<String> vote(@RequestBody ParticipantModel participantModel) {
        this.voteService.addEvent(participantModel);
        return ResponseEntity.ok("Voto computado com sucesso!");
    }
}

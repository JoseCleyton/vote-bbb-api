package me.dio.conding.votacao.bbb.api.controller;

import lombok.AllArgsConstructor;
import me.dio.conding.votacao.bbb.api.model.ParticipantModel;
import me.dio.conding.votacao.bbb.api.repository.ParticipantRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/participants")
@AllArgsConstructor
public class ParticipantController {

    private final ParticipantRepository participantRepository;

    @PostMapping
    public ResponseEntity<ParticipantModel> save(@RequestBody ParticipantModel participantModel) {
        return ResponseEntity.ok(this.participantRepository.save(participantModel));
    }

    @GetMapping
    public ResponseEntity<ParticipantModel> findByKey(@RequestParam String id) {
        Optional<ParticipantModel> participantModelOptional = this.participantRepository.findById(id);
        if (participantModelOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(participantModelOptional.get());
    }
}

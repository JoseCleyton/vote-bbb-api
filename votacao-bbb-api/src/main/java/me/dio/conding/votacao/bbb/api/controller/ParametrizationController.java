package me.dio.conding.votacao.bbb.api.controller;

import me.dio.conding.votacao.bbb.api.model.ParametrizationModel;
import me.dio.conding.votacao.bbb.api.repository.ParametrizationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/parametrizations")
public class ParametrizationController {

    private final ParametrizationRepository parametrizationRepository;

    public ParametrizationController(ParametrizationRepository parametrizationRepository) {
        this.parametrizationRepository = parametrizationRepository;
    }

    @PostMapping
    public ResponseEntity<ParametrizationModel> save(@RequestBody ParametrizationModel parametrizationModel) {
        return ResponseEntity.ok(this.parametrizationRepository.save(parametrizationModel));
    }

    @GetMapping
    public ResponseEntity<ParametrizationModel> findByKey(@RequestParam String key) {
        Optional<ParametrizationModel> parametrizationOptional = this.parametrizationRepository.findById(key);
        if (parametrizationOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(parametrizationOptional.get());
    }
}

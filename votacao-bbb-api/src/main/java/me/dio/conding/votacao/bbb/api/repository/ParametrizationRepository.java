package me.dio.conding.votacao.bbb.api.repository;

import me.dio.conding.votacao.bbb.api.model.ParametrizationModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParametrizationRepository extends MongoRepository<ParametrizationModel, String> {
}

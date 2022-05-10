package me.dio.conding.votacao.bbb.api.repository;

import me.dio.conding.votacao.bbb.api.model.ParticipantModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParticipantRepository extends MongoRepository<ParticipantModel, String> {
}

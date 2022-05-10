package me.dio.coding.votacao.bbb.ms.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.dio.coding.votacao.bbb.ms.model.ParticipantModel;
import me.dio.coding.votacao.bbb.ms.model.VoteModel;
import me.dio.coding.votacao.bbb.ms.repository.VoteRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
@AllArgsConstructor
public class VoteService {
    private final VoteRepository voteRepository;

    private static final String TOPIC_VOTE = "vote";
    private static final String GROUP_VOTE = "VoteMicroService";

    @KafkaListener(topics = TOPIC_VOTE, groupId = GROUP_VOTE)
    private void execute(ConsumerRecord<String, String> register) {

        String participantStr = register.value();
        log.info("Voto recebido = {}", participantStr);

        ObjectMapper objectMapper = new ObjectMapper();
        ParticipantModel participant = null;

        try {
            participant = objectMapper.readValue(participantStr, ParticipantModel.class);
        } catch (JsonProcessingException e) {
            log.info("Erro na desserialização", participantStr);
            return;
        }


        VoteModel voteModel = new VoteModel(null, participant, new Date());
        VoteModel voteModelSaved = this.voteRepository.save(voteModel);

        log.info("Voto registrado com sucesso: [id={}], data e hora={}", voteModelSaved.getId(), voteModelSaved.getDate());
    }
}

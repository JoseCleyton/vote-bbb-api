package me.dio.conding.votacao.bbb.api.service;

import lombok.AllArgsConstructor;
import me.dio.conding.votacao.bbb.api.model.ParticipantModel;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VoteService {
    private static final String TOPIC_VOTE = "vote";
    private final KafkaTemplate<Object, Object> template;


    public void addEvent(ParticipantModel participantModel) {
        this.template.send(TOPIC_VOTE, participantModel);
    }
}

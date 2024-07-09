package com.arthur.planner.participant;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ParticipantService {

    private final ParticipantRepository participantRepository;

    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public Participant getParticipant(UUID id) {
        return participantRepository.findById(id).orElseThrow(() -> new RuntimeException("Participant not found"));
    }

    public void registerParticipants(List<ParticipantRequestDto> participants) {
        for (ParticipantRequestDto participant : participants) {
            participantRepository.save(participant.toEntity());
        }
    }

    public void confirmParticipant(ParticipantConfirmDto participantDto) {
        Participant participant = getParticipant(participantDto.id());
        participant.setConfirmed(true);
        participant.setName(participantDto.name());
        participantRepository.save(participant);
    }
}

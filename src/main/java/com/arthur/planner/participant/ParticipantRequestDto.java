package com.arthur.planner.participant;

public record ParticipantRequestDto(String email) {
    public Participant toEntity() {
        var participant = new Participant();
        participant.setEmail(email);
        return participant;
    }
}

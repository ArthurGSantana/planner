package com.arthur.planner.trip;

import com.arthur.planner.participant.ParticipantRequestDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public record TripRequestDto(
        String destination,
        LocalDateTime startsAt,
        LocalDateTime endsAt,
        String ownerName,
        String ownerEmail,
        List<ParticipantRequestDto> participants
) {

    public Trip toEntity() {
        return new Trip(
                destination,
                LocalDateTime.parse(startsAt.toString(), DateTimeFormatter.ISO_DATE_TIME),
                LocalDateTime.parse(endsAt.toString(), DateTimeFormatter.ISO_DATE_TIME),
                ownerName,
                ownerEmail
        );
    }
}

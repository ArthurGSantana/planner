package com.arthur.planner.trip;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record TripRequestDto(
        String destination,
        LocalDateTime startsAt,
        LocalDateTime endsAt,
        String ownerName,
        String ownerEmail
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

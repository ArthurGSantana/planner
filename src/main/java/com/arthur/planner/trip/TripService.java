package com.arthur.planner.trip;

import com.arthur.planner.participant.ParticipantService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TripService {
    private final TripRepository tripRepository;
    private final ParticipantService participantService;

    public TripService(TripRepository tripRepository, ParticipantService participantService) {
        this.tripRepository = tripRepository;
        this.participantService = participantService;
    }

    public Trip getTrip(UUID id) {
        return tripRepository.findById(id).orElseThrow(() -> new RuntimeException("Trip not found"));
    }

    @Transactional
    public Trip createTrip(TripRequestDto tripRequestDto) {
        Trip trip = tripRequestDto.toEntity();
        participantService.registerParticipants(tripRequestDto.participants());

        return tripRepository.save(trip);
    }

    public Trip updateTrip(UUID id, TripRequestDto tripRequestDto) {
        Trip trip = getTrip(id);

        trip.setDestination(tripRequestDto.destination());
        trip.setStartsAt(tripRequestDto.startsAt());
        trip.setEndsAt(tripRequestDto.endsAt());

        return tripRepository.save(trip);
    }

    public void confirmTrip(UUID id) {
        Trip trip = getTrip(id);
        trip.setConfirmed(true);
        tripRepository.save(trip);
    }
}

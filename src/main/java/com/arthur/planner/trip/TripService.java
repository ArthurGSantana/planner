package com.arthur.planner.trip;

import org.springframework.stereotype.Service;

@Service
public class TripService {
    private final TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Trip createTrip(TripRequestDto tripRequestDto) {
        Trip trip = tripRequestDto.toEntity();
        return tripRepository.save(trip);
    }
}

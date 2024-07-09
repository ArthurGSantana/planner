package com.arthur.planner.trip;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/trip")
public class TripController {
    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trip> getTrip(@PathVariable UUID id) {
        var trip = tripService.getTrip(id);
        return ResponseEntity.ok(trip);
    }

    @PostMapping
    public ResponseEntity<TripCreateResponseDto> createTrip(@RequestBody TripRequestDto tripRequestDto) {
        var trip = tripService.createTrip(tripRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(new TripCreateResponseDto(trip.getId()));
    }

}

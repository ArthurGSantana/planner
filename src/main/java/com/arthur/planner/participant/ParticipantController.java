package com.arthur.planner.participant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/participant")
public class ParticipantController {
    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Participant> getParticipant(@PathVariable UUID id) {
        var participant = participantService.getParticipant(id);
        return ResponseEntity.ok(participant);
    }

    @PutMapping("/confirm")
    public ResponseEntity<Void> confirmParticipant(@RequestBody ParticipantConfirmDto participantDto) {
        participantService.confirmParticipant(participantDto);
        return ResponseEntity.noContent().build();
    }
}

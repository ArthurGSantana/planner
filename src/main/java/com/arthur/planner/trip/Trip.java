package com.arthur.planner.trip;

import com.arthur.planner.participant.Participant;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "destination", nullable = false)
    private String destination;

    @Column(name = "starts_at", nullable = false)
    private LocalDateTime startsAt;

    @Column(name = "ends_at", nullable = false)
    private LocalDateTime endsAt;

    @Column(name = "is_confirmed", nullable = false)
    private Boolean isConfirmed;

    @Column(name = "owner_name", nullable = false)
    private String ownerName;

    @Column(name = "owner_email", nullable = false)
    private String ownerEmail;

    @OneToMany(mappedBy = "trip")
    private List<Participant> participants;

    public Trip() {
    }
    public Trip(String destination, LocalDateTime startsAt, LocalDateTime endsAt, String ownerName, String ownerEmail) {
        this.destination = destination;
        this.startsAt = startsAt;
        this.endsAt = endsAt;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
    }

    public Trip(UUID id, String destination, LocalDateTime startsAt, LocalDateTime endsAt, Boolean isConfirmed, String ownerName, String ownerEmail, List<Participant> participants) {
        this.id = id;
        this.destination = destination;
        this.startsAt = startsAt;
        this.endsAt = endsAt;
        this.isConfirmed = isConfirmed;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.participants = participants;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(LocalDateTime startsAt) {
        this.startsAt = startsAt;
    }

    public LocalDateTime getEndsAt() {
        return endsAt;
    }

    public void setEndsAt(LocalDateTime endsAt) {
        this.endsAt = endsAt;
    }

    public Boolean getConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        isConfirmed = confirmed;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }
}

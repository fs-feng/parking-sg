package me.frankfeng.parking.backend.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class CarPark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String phId;
    private String name;

    @OneToMany
    private Set<CarParkState> carParkStates;

    @OneToOne
    @JoinColumn("location_id")
    private Location location;

    public CarPark() {}

    public CarPark(String phId, String name) {
        this.phId = phId;
        this.name = name;
    }
}

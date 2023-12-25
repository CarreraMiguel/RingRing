package com.example.RingRing.models;

import jakarta.persistence.*;

@Entity
@Table(name = "COMENTARIES")
public class Comentaries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    String body;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}

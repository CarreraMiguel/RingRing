package com.example.RingRing.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "COMENTARIES")
public class Commentary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (columnDefinition = "TEXT")
    private String body;
    @Column (name = "created_date")
    private LocalDateTime createdDate;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}

package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "Guest")
public class GuestEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

}

package com.example.med_cards.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "disease")
public class Disease {
    @Id
    private String id;
    @Column(length=1000)
    private String name;
}

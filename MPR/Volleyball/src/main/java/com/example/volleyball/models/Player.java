package com.example.volleyball.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Player {
    @Id
    @UuidGenerator
    @NonNull
    private UUID id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    private int age;
    private int height;
    private String role;
    @ManyToOne
    private Team team;
}


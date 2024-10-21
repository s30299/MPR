package com.example.volleyball.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class PlayerRequest {
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    private int age;
    private int height;
    private String role;
}

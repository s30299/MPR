package com.example.volleyball.models;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Player {
    @NonNull
    private int id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    private int age;
    private int height;
    private String role;
}


package com.example.volleyball.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class CarResponse {
    @NonNull
    private String firstName;
    private int age;
    private int height;
    private String role;
}


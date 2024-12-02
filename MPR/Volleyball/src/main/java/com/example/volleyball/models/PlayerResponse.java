package com.example.volleyball.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class PlayerResponse {
    @NonNull
    private String firstName;
    private int age;
    private int height;
    private String role;
}


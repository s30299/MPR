package com.example.volleyball.models;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class CarRequest {
    @NonNull
    private String name;
    @NonNull
    private String lastName;
    private int age;
    private int height;
    private String role;
}

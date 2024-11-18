package com.example.volleyball.models;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Team {

    @Id
    @UuidGenerator
    @NonNull
    private UUID id;
    @NonNull
    private String name;
    private String description;
    @OneToMany(fetch = FetchType.LAZY) //n+1 problem team[1] + players[n] // nie dawać Eager
    private List<Car> cars;

//    private String imageUrl;
    
//    Optional<String> image = Optional.ofNullable(imageUrl).map(url -> url.substring(url.lastIndexOf("/") + 1));


}

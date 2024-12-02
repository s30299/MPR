package com.example.volleyball.controller;


import com.example.volleyball.models.CarFilter;
import com.example.volleyball.models.CarRequest;
import com.example.volleyball.models.CarResponse;
import com.example.volleyball.services.CarService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CarController {
    @NonNull
    private final CarService service;

    @GetMapping("/getAllPlayersByAge/{age}")
    public List<CarResponse> getPlayer(@PathVariable int age) {
        return service.getAllPlayerAge(age);
    }
    @GetMapping("/getAllPlayersBySurname/{surname}")
    public List<String> getAllPlayersBySurname(@PathVariable String surname) {

        return service.getAllPlayersBySurname(surname);
    }
    @GetMapping("/getAllSpecificPlayers/{firstName}/{lastName}/{age}")
    public List<Integer> getAllSpecificPlayers(@PathVariable String firstName,@PathVariable String lastName,@PathVariable int age) {
        return service.getAllPlayersByData(firstName, lastName, age);
    }
    @GetMapping("/getAllSpecificPlayersByClass")
    public List<Integer> getAllSpecificPlayersByClass(@RequestBody CarFilter filter) {
        return service.getAllPlayersByData(filter);
    }

    @GetMapping("/getAllPlayers")
    public List<CarResponse> getAllPlayers() {
        return service.getAllPlayers();
    }

    @PostMapping("/addPlayer")
    public CarResponse addPlayer(@RequestBody CarRequest player){
        return service.addPlayer(player);
    }

    @PutMapping("/editPlayer/{id}")
    public CarResponse updatePlayer(@PathVariable UUID id, @RequestBody CarRequest player){
        return service.updatePlayerID(id, player);
    }

    @DeleteMapping("deletePlayer/{id}")
    public String deletePlayer(@PathVariable UUID id) {
        return service.deletePlayerID(id);
    }
}

package com.example.volleyball.controller;


import com.example.volleyball.models.Player;
import com.example.volleyball.models.PlayerFilter;
import com.example.volleyball.models.PlayerRequest;
import com.example.volleyball.services.PlayerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService service;

    @GetMapping("/getAllPlayersByAge/{age}")
    public List<Player> getPlayer(@PathVariable int age) {

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
    public List<Integer> getAllSpecificPlayersByClass(@RequestBody PlayerFilter filter) {
        return service.getAllPlayersByData(filter);
    }

    @GetMapping("/getAllPlayers")
    public List<Player> getAllPlayers() {
        return service.getAllPlayers();
    }

    @PostMapping("/addPlayer")
    public Player addPlayer(@RequestBody PlayerRequest player){
        return service.addPlayer(player);
    }

    @PutMapping("/editPlayer/{id}")
    public Player updatePlayer(@PathVariable UUID id, @RequestBody Player player){
        return service.updatePlayerID(id, player);
    }

    @DeleteMapping("deletePlayer/{id}")
    public String deletePlayer(@PathVariable UUID id) {
        return service.deletePlayerID(id);
    }
}

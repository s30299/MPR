package com.example.volleyball.controller;


import com.example.volleyball.models.Player;
import com.example.volleyball.models.PlayerFilter;
import com.example.volleyball.models.PlayerRequest;
import com.example.volleyball.models.PlayerResponse;
import com.example.volleyball.services.PlayerService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PlayerController {
    @NonNull
    private final PlayerService service;

    @GetMapping("/awards/{id}")
    public List<String> GetAwards(@PathVariable UUID id) {
        return List.of("test","test1","Volleyball");
    }




    @GetMapping("/getAllPlayersByAge/{age}")
    public List<PlayerResponse> getPlayer(@PathVariable int age) {
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
    public ResponseEntity<List<PlayerResponse>> getAllPlayers() {
        throw new NullPointerException();
//        return ResponseEntity.ok(service.getAllPlayers());
    }

    @PostMapping("/addPlayer")
    public PlayerResponse addPlayer(@RequestBody PlayerRequest player){
        return service.addPlayer(player);
    }

    @PutMapping("/editPlayer/{id}")
    public PlayerResponse updatePlayer(@PathVariable UUID id, @RequestBody PlayerRequest player){
        return service.updatePlayerID(id, player);
    }

    @DeleteMapping("deletePlayer/{id}")
    public String deletePlayer(@PathVariable UUID id) {
        return service.deletePlayerID(id);
    }
}

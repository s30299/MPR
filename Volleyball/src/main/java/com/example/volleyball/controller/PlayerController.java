package com.example.volleyball.controller;


import com.example.volleyball.models.Player;
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

    @GetMapping("/getAllPlayers/{id}")
    public List<Player> getPlayer(@PathVariable UUID id) {

        return List.of(service.getPlayerID(id));
    }

    @GetMapping("/getAllPlayers")
    public List<Player> getAllPlayers() {
        return service.getAllPlayers();
    }

    @PostMapping("/addPlayer")
    public Player addPlayer(@RequestBody Player player){
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

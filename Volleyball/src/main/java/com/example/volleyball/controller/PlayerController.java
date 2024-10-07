package com.example.volleyball.controller;


import com.example.volleyball.models.Player;
import com.example.volleyball.services.PlayerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService service;

    @GetMapping("/getAllPlayers/{id}")
    public List<Player> getAllPlayers(@PathVariable int id) {

        return List.of(service.getPlayerID(id));
    }

    @PostMapping("/addPlayer")
    public Player addPlayer(@RequestBody Player player){
        return service.addPlayer(player);
    }

    @PutMapping("/editPlayer/{id}")
    public String updatePlayer(@PathVariable int id){
        return service.updatePlayerID(id);
    }

    @DeleteMapping("deletePlayer/{id}")
    public String deletePlayer(@PathVariable int id) {
        return service.deletePlayerID(id);
    }
}

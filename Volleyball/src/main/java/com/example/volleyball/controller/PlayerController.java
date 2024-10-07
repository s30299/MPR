package com.example.volleyball.controller;


import com.example.volleyball.models.Player;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

    @GetMapping("/getAllPlayer")
    public List<Player> getAllPlayers(){
        return List.of(new Player());
    }
}

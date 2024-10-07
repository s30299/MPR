package com.example.volleyball.services;

import com.example.volleyball.models.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerService {
    public Player getPlayerID(int id){
        return new Player(id, "Jan", "Nowak");
    }
    public Player addPlayer(Player player){
        return player;
    }
    public String deletePlayerID(int id){
        return "Player "+id+" deleted";
    }
    public String updatePlayerID(int id){
        return "Player "+id+" updated";
    }
}

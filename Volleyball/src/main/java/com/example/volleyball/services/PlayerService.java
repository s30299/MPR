package com.example.volleyball.services;

import com.example.volleyball.models.Player;
import com.example.volleyball.repositories.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;

    public Player getPlayerID(UUID id){
        return playerRepository.getReferenceById(id);
    }
    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }
    public Player addPlayer(Player player){
        playerRepository.save(player);
        return player;
    }
    public String deletePlayerID(UUID id){
        playerRepository.deleteById(id);
        return "Player "+id+" deleted";
    }
    public Player updatePlayerID(UUID id, Player playerFromRequest){
        Player ActualPlayer = playerRepository.getReferenceById(id);
        ActualPlayer.setAge(playerFromRequest.getAge());
        ActualPlayer.setRole(playerFromRequest.getRole());
        ActualPlayer.setHeight(playerFromRequest.getHeight());
        ActualPlayer.setLastName(playerFromRequest.getLastName());
        ActualPlayer.setFirstName(playerFromRequest.getFirstName());

        return playerRepository.save(ActualPlayer);
    }
}

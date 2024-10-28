package com.example.volleyball.services;

import com.example.volleyball.models.Player;
import com.example.volleyball.models.PlayerFilter;
import com.example.volleyball.models.PlayerRequest;
import com.example.volleyball.models.PlayerResponse;
import com.example.volleyball.repositories.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;

    private PlayerResponse PlayerToResponse(Player player){
        PlayerResponse response = new PlayerResponse();
        response.setAge(player.getAge());
//        response.setFirstName(player.getFirstName());
        response.setRole(player.getRole());
        response.setHeight(player.getHeight());

        return  response;
    }
    private Player RequestToPlayer(PlayerRequest playerRequest){
        Player player = new Player();
        player.setLastName(playerRequest.getLastName());
        player.setAge(playerRequest.getAge());
//        player.setFirstName(playerRequest.getFirstName());
        player.setRole(playerRequest.getRole());
        player.setHeight(playerRequest.getHeight());
        return player;
    }

    public PlayerResponse getPlayerID(UUID id){
        return PlayerToResponse(playerRepository.getReferenceById(id));
    }

    public List<PlayerResponse> getAllPlayerAge(int age){
        return playerRepository.findAll().stream().filter(p -> p.getAge() == age).map(this::PlayerToResponse).collect(Collectors.toList());

    }
    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }
    public List<String> getAllPlayersBySurname(String surname){

        return (List<String>) playerRepository
                .findAll()
                .stream()
                .filter(player -> player.getLastName()
                        .equals(surname))
                .map(player -> player.getFirstName()
                        .lines().toList());

    }
    public List<Integer> getAllPlayersByData(String firstName, String lastName, int age){
        return  playerRepository
                .findAll()
                .stream()
                .filter(player -> player.getFirstName().equals(firstName))
                .filter(player -> player.getLastName().equals(lastName))
                .filter(player -> player.getAge() == age)
                .map(Player::getHeight)
                .toList();
    }
    public List<Integer> getAllPlayersByData(PlayerFilter filter){
        return  playerRepository
                .findAll()
                .stream()
                .filter(player -> player.getFirstName().equals(filter.getFirstName()))
                .filter(player -> player.getLastName().equals(filter.getLastName()))
                .filter(player -> player.getAge() == filter.getAge())
                .map(Player::getHeight)
                .toList();
    }
    public PlayerResponse addPlayer(PlayerRequest player){
        Player newPlayer = new Player();
//        newPlayer.setFirstName(player.getFirstName());
        newPlayer.setLastName(player.getLastName());
        newPlayer.setAge(player.getAge());
        newPlayer.setHeight(player.getHeight());
        newPlayer.setRole(player.getRole());
        playerRepository.save(newPlayer);
        return PlayerToResponse(newPlayer);
    }
    public String deletePlayerID(UUID id){
        playerRepository.deleteById(id);
        return "Player "+id+" deleted";
    }
    public PlayerResponse updatePlayerID(UUID id, PlayerRequest playerFromRequest){
        Player ActualPlayer = playerRepository.getReferenceById(id);
        ActualPlayer.setAge(playerFromRequest.getAge());
        ActualPlayer.setRole(playerFromRequest.getRole());
        ActualPlayer.setHeight(playerFromRequest.getHeight());
        ActualPlayer.setLastName(playerFromRequest.getLastName());
//        ActualPlayer.setFirstName(playerFromRequest.getFirstName());
        playerRepository.save(ActualPlayer);
        return PlayerToResponse(ActualPlayer);
    }
}

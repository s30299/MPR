package com.example.volleyball.services;

import com.example.volleyball.AwardsFeignClient;
import com.example.volleyball.mapping.PlayerMapper;
import com.example.volleyball.models.Player;
import com.example.volleyball.models.PlayerFilter;
import com.example.volleyball.models.PlayerRequest;
import com.example.volleyball.models.PlayerResponse;
import com.example.volleyball.repositories.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlayerService{
    private final PlayerRepository playerRepository;
    private final PlayerMapper mapper;
    private final AwardsFeignClient awardsFeignClient;



    public PlayerResponse getPlayerID(UUID id){
        return mapper.mapToPlayerResponse(playerRepository.getReferenceById(id));
    }

    public List<PlayerResponse> getAllPlayerAge(int age){
        return playerRepository.findAll().stream().filter(p -> p.getAge() == age).map(mapper::mapToPlayerResponse).collect(Collectors.toList());

    }
    public List<PlayerResponse> getAllPlayers(){
//        return playerRepository.findAll();
        return playerRepository.findAll().stream()
                .map(x->mapper.mapToPlayerResponse(x))
                .toList();
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
        newPlayer=mapper.mapToPlayer(player);
        playerRepository.save(newPlayer);
        return mapper.mapToPlayerResponse(newPlayer);
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
//        ActualPlayer=mapper.mapToPlayer(ActualPlayer);
        playerRepository.save(ActualPlayer);
        return mapper.mapToPlayerResponse(ActualPlayer);
    }

    public List<String> getAwards(UUID id){
        return awardsFeignClient.getAwardsForPlayer(id);
    }



}

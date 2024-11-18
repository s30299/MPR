package com.example.volleyball.services;

import com.example.volleyball.mapping.CarMapper;
import com.example.volleyball.models.Car;
import com.example.volleyball.models.CarFilter;
import com.example.volleyball.models.CarRequest;
import com.example.volleyball.models.CarResponse;
import com.example.volleyball.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository playerRepository;
    private final CarMapper mapper;

//    private PlayerResponse PlayerToResponse(Player player) {
////        mapper.mapToPlayerResponse(player);
//        PlayerResponse response = new PlayerResponse();
//        response.setAge(player.getAge());
////        response.setFirstName(player.getFirstName());
//        response.setRole(player.getRole());
//        response.setHeight(player.getHeight());
//
//        return  response;
//    }
//    private Player RequestToPlayer(PlayerRequest playerRequest){
//        Player player = new Player();
//        player.setLastName(playerRequest.getLastName());
//        player.setAge(playerRequest.getAge());
////        player.setFirstName(playerRequest.getFirstName());
//        player.setRole(playerRequest.getRole());
//        player.setHeight(playerRequest.getHeight());
//        return player;
//    }

    public CarResponse getPlayerID(UUID id){
        return mapper.mapToPlayerResponse(playerRepository.getReferenceById(id));
    }

    public List<CarResponse> getAllPlayerAge(int age){
        return playerRepository.findAll().stream().filter(p -> p.getAge() == age).map(mapper::mapToPlayerResponse).collect(Collectors.toList());

    }
    public List<CarResponse> getAllPlayers(){
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
                .map(Car::getHeight)
                .toList();
    }
    public List<Integer> getAllPlayersByData(CarFilter filter){
        return  playerRepository
                .findAll()
                .stream()
                .filter(player -> player.getFirstName().equals(filter.getFirstName()))
                .filter(player -> player.getLastName().equals(filter.getLastName()))
                .filter(player -> player.getAge() == filter.getAge())
                .map(Car::getHeight)
                .toList();
    }
    public CarResponse addPlayer(CarRequest player){
        Car newCar = new Car();
//        newPlayer.setFirstName(player.getFirstName());
//        newPlayer.setLastName(player.getLastName());
//        newPlayer.setAge(player.getAge());
//        newPlayer.setHeight(player.getHeight());
//        newPlayer.setRole(player.getRole());
        newCar =mapper.mapToPlayer(player);
        playerRepository.save(newCar);
        return mapper.mapToPlayerResponse(newCar);
    }
    public String deletePlayerID(UUID id){
        playerRepository.deleteById(id);
        return "Player "+id+" deleted";
    }
    public CarResponse updatePlayerID(UUID id, CarRequest playerFromRequest){
        Car actualCar = playerRepository.getReferenceById(id);
        actualCar.setAge(playerFromRequest.getAge());
        actualCar.setRole(playerFromRequest.getRole());
        actualCar.setHeight(playerFromRequest.getHeight());
        actualCar.setLastName(playerFromRequest.getLastName());
//        ActualPlayer.setFirstName(playerFromRequest.getFirstName());
//        ActualPlayer=mapper.mapToPlayer(ActualPlayer);
        playerRepository.save(actualCar);
        return mapper.mapToPlayerResponse(actualCar);
    }

}

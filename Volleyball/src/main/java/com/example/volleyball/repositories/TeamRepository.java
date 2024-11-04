package com.example.volleyball.repositories;

import com.example.volleyball.models.Team;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository {

    List<Team> getAllTeams(); //Stowrzyć osobny projekt, który zwraca liste Stringu na jakiś end point, najprostszy
    List<Team> getTeamsByName(String name);
    List<Team> getTeamsByPlayer(String player);
}

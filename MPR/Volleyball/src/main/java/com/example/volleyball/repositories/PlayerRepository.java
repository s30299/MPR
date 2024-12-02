package com.example.volleyball.repositories;

import com.example.volleyball.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PlayerRepository extends JpaRepository<Player, UUID> {

   List<Player> findByFirstNameAndLastName(String firstName, String lastName);
   List<Player> findByFirstName(String firstName);
   List<Player> findByLastName(String lastName);
   List<Player> findByHeight(Integer height); // dorzuć pare funkcji. zespol po playerze i na odwrot


}

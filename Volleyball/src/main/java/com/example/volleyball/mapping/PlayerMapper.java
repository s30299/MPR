package com.example.volleyball.mapping;


import com.example.volleyball.models.Player;
import com.example.volleyball.models.PlayerRequest;
import com.example.volleyball.models.PlayerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface PlayerMapper {
//1
    @Mapping(target= "firstName", source = "name")
    Player mapToPlayer(PlayerRequest playerRequest);

    PlayerResponse mapToPlayerResponse(Player Player);

}

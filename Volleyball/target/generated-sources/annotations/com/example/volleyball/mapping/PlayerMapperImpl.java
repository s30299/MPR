package com.example.volleyball.mapping;

import com.example.volleyball.models.Player;
import com.example.volleyball.models.PlayerRequest;
import com.example.volleyball.models.PlayerResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-18T17:12:11+0100",
    comments = "version: 1.6.2, compiler: javac, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class PlayerMapperImpl implements PlayerMapper {

    @Override
    public Player mapToPlayer(PlayerRequest playerRequest) {
        if ( playerRequest == null ) {
            return null;
        }

        Player player = new Player();

        player.setFirstName( playerRequest.getName() );
        player.setLastName( playerRequest.getLastName() );
        player.setAge( playerRequest.getAge() );
        player.setHeight( playerRequest.getHeight() );
        player.setRole( playerRequest.getRole() );

        return player;
    }

    @Override
    public PlayerResponse mapToPlayerResponse(Player Player) {
        if ( Player == null ) {
            return null;
        }

        PlayerResponse playerResponse = new PlayerResponse();

        playerResponse.setFirstName( Player.getFirstName() );
        playerResponse.setAge( Player.getAge() );
        playerResponse.setHeight( Player.getHeight() );
        playerResponse.setRole( Player.getRole() );

        return playerResponse;
    }
}

package com.task.producter.player;

import com.task.producter.teamPlayer.TeamPlayerRepository;
import graphql.GraphQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TeamPlayerRepository teamPlayerRepository;

    public List<PlayerEntity> findAll(){
        return playerRepository.findAll();
    }

    public PlayerEntity save(PlayerDTO playerDTO){


        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setName(playerDTO.getName());
        playerEntity.setSurname(playerDTO.getSurname());
        playerEntity.setPosition(playerDTO.getPosition());
        return playerRepository.save(playerEntity);
    }

    public void delete(long id){
        boolean playerExists = playerRepository.findById(id).isPresent();

        if(!playerExists){
            throw new GraphQLException("Player not found");
        }

        teamPlayerRepository.deleteAllByPlayerId(id); // if the player delete, delete players record of the players_table
        playerRepository.deleteById(id);
    }

    public boolean isPlayerExist(long id ){
        return playerRepository.findById(id).isPresent();
    }


}

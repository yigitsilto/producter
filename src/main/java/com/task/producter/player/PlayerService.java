package com.task.producter.player;

import graphql.GraphQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

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

        playerRepository.deleteById(id);
    }


}

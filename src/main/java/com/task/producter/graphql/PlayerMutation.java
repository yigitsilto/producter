package com.task.producter.graphql;

import com.task.producter.player.PlayerController;
import com.task.producter.player.PlayerDTO;
import com.task.producter.player.PlayerEntity;
import com.task.producter.player.PlayerService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PlayerMutation implements GraphQLMutationResolver {

    @Autowired
    PlayerService playerService;


    public PlayerEntity createPlayer(PlayerEntity playerEntity){
        return playerService.save(playerEntity);
    }
}

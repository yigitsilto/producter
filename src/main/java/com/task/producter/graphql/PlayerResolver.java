package com.task.producter.graphql;

import com.task.producter.player.PlayerController;
import com.task.producter.player.PlayerEntity;
import com.task.producter.player.PlayerService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class PlayerResolver implements GraphQLQueryResolver {


    
    @Autowired
    PlayerController playerController;

    public List<PlayerEntity> players(){
        return playerController.findAll();
    }
}

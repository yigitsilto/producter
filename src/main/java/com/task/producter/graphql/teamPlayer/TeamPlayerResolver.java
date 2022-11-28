package com.task.producter.graphql.teamPlayer;

import com.task.producter.teamPlayer.TeamPlayerEntity;
import com.task.producter.teamPlayer.TeamPlayerService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class TeamPlayerResolver implements GraphQLQueryResolver {

    @Autowired
    TeamPlayerService teamPlayerService;

    public List<TeamPlayerEntity> teamPlayers(){
        return teamPlayerService.findAll();
    }
}

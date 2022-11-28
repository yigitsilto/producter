package com.task.producter.graphql.team;

import com.task.producter.team.TeamEntity;
import com.task.producter.team.TeamService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class TeamResolver implements GraphQLQueryResolver {

    @Autowired
    TeamService teamService;

    public List<TeamEntity> teams(){
        return teamService.findAll();
    }
}

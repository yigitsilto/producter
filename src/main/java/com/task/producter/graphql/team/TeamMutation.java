package com.task.producter.graphql.team;

import com.task.producter.team.TeamDTO;
import com.task.producter.team.TeamEntity;
import com.task.producter.team.TeamService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Slf4j
@Component
public class TeamMutation implements GraphQLMutationResolver {

    @Autowired
    TeamService teamService;

    public TeamEntity createTeam(@Valid TeamDTO teamDTO){
        return teamService.save(teamDTO);
    }

    public void deleteTeam(long id){
        teamService.delete(id);
    }
}

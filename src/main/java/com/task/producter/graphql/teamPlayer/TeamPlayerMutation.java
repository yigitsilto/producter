package com.task.producter.graphql.teamPlayer;

import com.task.producter.teamPlayer.TeamPlayerDTO;
import com.task.producter.teamPlayer.TeamPlayerEntity;
import com.task.producter.teamPlayer.TeamPlayerService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Slf4j
@Component
public class TeamPlayerMutation implements GraphQLMutationResolver {

    @Autowired
    TeamPlayerService teamPlayerService;

    public TeamPlayerEntity createTeamPlayer(@Valid TeamPlayerDTO teamPlayerDTO){
        return teamPlayerService.save(teamPlayerDTO);
    }
}

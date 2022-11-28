package com.task.producter.team;

import com.task.producter.teamPlayer.TeamPlayerRepository;
import graphql.GraphQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Service
@Transactional
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    TeamPlayerRepository teamPlayerRepository;


    public List<TeamEntity> findAll(){
        return teamRepository.findAll();
    }

    public TeamEntity save(@Valid TeamDTO teamDTO){
        TeamEntity teamEntity = new TeamEntity();
        teamEntity.setName(teamDTO.getName());
        return teamRepository.save(teamEntity);
    }

    public void delete(long id){
        boolean teamExist = teamRepository.findById(id).isPresent();

        if (!teamExist){
            throw new GraphQLException("Team not found");
        }

        teamPlayerRepository.deleteAllByTeamId(id); // if the team delete, delete the all datas from team_players table

        teamRepository.deleteById(id);

    }

    public boolean isTeamExists(long id){
        return teamRepository.findById(id).isPresent();
    }

}

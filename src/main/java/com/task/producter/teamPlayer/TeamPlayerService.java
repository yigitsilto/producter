package com.task.producter.teamPlayer;

import com.task.producter.player.PlayerService;
import com.task.producter.team.TeamService;
import graphql.GraphQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamPlayerService {

    @Autowired
    TeamPlayerRepository teamPlayerRepository;
    @Autowired
    PlayerService playerService;
    @Autowired
    TeamService teamService;

    public List<TeamPlayerEntity> findAll() {
        return teamPlayerRepository.findAll();
    }

    public TeamPlayerEntity save(TeamPlayerDTO teamPlayerDTO) {

        long playerId = teamPlayerDTO.getPlayerId();
        long teamId = teamPlayerDTO.getTeamId();

        this.playerAndTeamIsExists(playerId,teamId); // check the player or team exists
        this.checkDuplicate(playerId,teamId); // block duplicates

        TeamPlayerEntity teamPlayerEntity = new TeamPlayerEntity();
        teamPlayerEntity.setPlayerId(playerId);
        teamPlayerEntity.setTeamId(teamId);
        return teamPlayerRepository.save(teamPlayerEntity);
    }

    public void delete(long id){
        teamPlayerRepository.deleteById(id);
    }

    public void playerAndTeamIsExists(long playerId, long teamId) {
        boolean checkPlayer = playerService.isPlayerExist(playerId);
        boolean checkTeam = teamService.isTeamExists(teamId);

        if (!checkPlayer || !checkTeam) {
            throw new GraphQLException("Data is not correct");
        }
    }

    public void checkDuplicate(long playerId , long teamId){
        boolean checkDuplicate = teamPlayerRepository.findByTeamIdAndPlayerId(teamId,playerId).isPresent();

        if (checkDuplicate){
            throw new GraphQLException("Players already in the team");
        }
    }

}

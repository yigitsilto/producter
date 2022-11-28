package com.task.producter.teamPlayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamPlayerService {

    @Autowired
    TeamPlayerRepository teamPlayerRepository;

    public List<TeamPlayerEntity> findAll(){
        return teamPlayerRepository.findAll();
    }

    public TeamPlayerEntity save(TeamPlayerDTO teamPlayerDTO){
        TeamPlayerEntity teamPlayerEntity = new TeamPlayerEntity();
        teamPlayerEntity.setPlayerId(teamPlayerDTO.getPlayerId());
        teamPlayerEntity.setTeamId(teamPlayerDTO.getTeamId());
        return teamPlayerRepository.save(teamPlayerEntity);
    }
}

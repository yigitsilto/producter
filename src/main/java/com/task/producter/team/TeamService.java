package com.task.producter.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;


    public List<TeamEntity> findAll(){
        return teamRepository.findAll();
    }

    public TeamEntity save(@Valid TeamDTO teamDTO){
        TeamEntity teamEntity = new TeamEntity();
        teamEntity.setName(teamDTO.getName());
        return teamRepository.save(teamEntity);
    }

}

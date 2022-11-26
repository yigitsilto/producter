package com.task.producter.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    public List<PlayerEntity> findAll(){
        return playerRepository.findAll();
    }
}

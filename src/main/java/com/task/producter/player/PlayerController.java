package com.task.producter.player;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @QueryMapping
    public List<PlayerEntity> findAll(){
        return playerService.findAll();
    }
}

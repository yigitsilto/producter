package com.task.producter.player;

import com.task.producter.enums.PlayerPositionsEnum;
import lombok.Data;

@Data
public class PlayerDTO {
    private String name;
    private String surname;
    private PlayerPositionsEnum position;
}

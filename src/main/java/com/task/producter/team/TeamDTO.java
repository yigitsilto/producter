package com.task.producter.team;

import com.task.producter.enums.PlayerPositionsEnum;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class TeamDTO {

    @NotNull
    @NotEmpty
    @Valid
    private String name;
}

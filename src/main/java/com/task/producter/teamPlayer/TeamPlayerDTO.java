package com.task.producter.teamPlayer;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class TeamPlayerDTO {


    @NotNull
    @NotEmpty
    @Valid
    private long teamId;

    @NotNull
    @NotEmpty
    @Valid
    private long playerId;
}

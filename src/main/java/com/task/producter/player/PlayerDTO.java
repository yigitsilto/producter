package com.task.producter.player;

import com.task.producter.enums.PlayerPositionsEnum;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class PlayerDTO {
    @NotNull
    @NotEmpty
    @NotBlank
    @Valid
    private String name;
    @NotNull
    @NotEmpty
    @Valid
    private String surname;
    @NotNull
    @NotEmpty
    @Valid
    private PlayerPositionsEnum position;
}

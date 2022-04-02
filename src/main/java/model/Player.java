package model;

import enums.PlayerSkill;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Player {
    private int id;
    private String firstName;
    private String lastName;
    private PlayerSkill playerSkill;
}

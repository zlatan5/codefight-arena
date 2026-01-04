package com.codefight.arena.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Battle {

    private int id;
    private int problemId;
    private String players;
    private String startTime;
    private String status;
    private int winnerId;
}

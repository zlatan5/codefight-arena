package com.codefight.arena.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    private int id;
    private String username;
    private String code;
    private String testResults;
    private int score;
    private Instant lastSubmitTime;
}

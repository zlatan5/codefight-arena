package com.codefight.arena.model;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Problem {

    private String id;
    private String title;
    private String description;
    private String difficulty;
    private String testCases;
    private StarterCode starterCode;
    private List<String> topics;
    private int timeLimit;
    private int memoryLimit;

}

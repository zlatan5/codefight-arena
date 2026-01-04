package com.codefight.arena.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Problem {

    private int id;
    private String title;
    private String description;
    private String difficulty;
    private String testCases;
    private String starterCode;



}

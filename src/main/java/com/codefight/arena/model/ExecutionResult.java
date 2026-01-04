package com.codefight.arena.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExecutionResult {

    private String success;
    private String output;
    private String executionTime;
    private String error;
}

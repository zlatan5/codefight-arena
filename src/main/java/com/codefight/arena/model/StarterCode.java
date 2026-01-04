package com.codefight.arena.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StarterCode {

    private String java;
    private String python;
    private String javascript;
    private String cpp;
    private String golang;
}

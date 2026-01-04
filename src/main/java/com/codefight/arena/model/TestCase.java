package com.codefight.arena.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestCase {

    private String id;
    private String input;
    private String expectedOutput;
    private boolean isHidden;
    private String explanation;
}

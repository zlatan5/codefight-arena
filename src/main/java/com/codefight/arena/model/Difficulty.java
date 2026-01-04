package com.codefight.arena.model;

public enum Difficulty {

    EASY("Easy", "#00b8a3"),      // Green
    MEDIUM("Medium", "#ffc01e"),   // Yellow
    HARD("Hard", "#ff375f");       // Red

    private final String displayName;
    private final String colorCode;

    Difficulty(String displayName, String colorCode) {
        this.displayName = displayName;
        this.colorCode = colorCode;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getColorCode() {
        return colorCode;
    }
}

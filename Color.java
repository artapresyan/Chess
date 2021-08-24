package com.company;

public enum Color {
    isBlackFigure("black"),
    isWhiteFigure("white");

    private final String color;
    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

}

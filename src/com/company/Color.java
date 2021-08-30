package com.company;

public enum Color {
    isBlackFigure("Black"),
    isWhiteFigure("White");

    private final String color;
    Color(String color) {
        this.color = color;
    }

    String getColor() {
        return color;
    }
}

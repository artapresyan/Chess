package com.company.enum_class;

public enum Color {
    isBlackFigure("Black"),
    isWhiteFigure("White");

    private final String color;
    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

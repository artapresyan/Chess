package com.company.enum_class;

public enum FigureName {
    whitePawn("w.P"),
    whiteRook("w.R"),
    whiteKnight("wKn"),
    whiteWhiteBishop("wwB"),
    whiteBlackBishop("wbB"),
    whiteKing("w.K"),
    whiteQueen("w.Q"),
    blackPawn("b.P"),
    blackRook("b.R"),
    blackKnight("bKn"),
    blackWhiteBishop("bwB"),
    blackBlackBishop("bbB"),
    blackKing("b.K"),
    blackQueen("b.Q");

    private final String name;
    FigureName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

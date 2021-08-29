package com.company;

public abstract class Figure {
    private final Color figureColor;
    private final FigureName figureName;

    public Figure(Color figureColor, FigureName figureName) {
        this.figureColor = figureColor;
        this.figureName = figureName;
    }

    public String getFigureColor() {
        return figureColor.getColor();
    }

    public String getFigureName() {
        return figureName.getName();
    }

    void moveFigure(Figure[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
    }

    boolean checkMove(Figure[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        return false;
    }

    boolean noMoves(Figure[][] chessBoard, Color color) {
        return true;
    }

    boolean coverCheck(Figure[][] chessBoard, Color color) {
        return false;
    }
}

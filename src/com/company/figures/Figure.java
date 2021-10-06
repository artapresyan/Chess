package com.company.figures;

import com.company.enum_class.Color;
import com.company.enum_class.FigureName;

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

    public void moveFigure(Figure[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
    }

    public boolean checkMove(Figure[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        return false;
    }

    public boolean noValidMoves(Figure[][] chessBoard, Color color) {
        return true;
    }
}

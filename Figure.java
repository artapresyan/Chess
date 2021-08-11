package com.company;

public abstract class Figure {
    Object white = "***";
    Object black = "###";
    void p1moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
    }
    boolean p1checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        return true;
    }
    void p2moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
    }
    boolean p2checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        return true;
    }
    Object figure(Object figureName) {
        return figureName;
    }
}

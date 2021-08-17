package com.company;

public abstract class Figure {
    private Object p1figureName;
    private Object p2figureName;
    private boolean wIsMoved=false;
    private boolean bIsMoved=false;
    public Object p1whiteFigure() {
        return p1figureName;
    }
    public Object p1blackFigure() {
        return p1figureName;
    }
    public Object p2whiteFigure() {
        return p2figureName;
    }
    public Object p2blackFigure() {
        return p2figureName;
    }
    void p1moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
    }
    void p2moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
    }
    boolean p1checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        return true;
    }
    boolean p2checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        return true;
    }
    boolean p1ValidMoves(Object[][] chessBoard) {
        return false;
    }
    boolean p2ValidMoves(Object[][] chessBoard) {
        return false;
    }
}

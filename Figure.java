package com.company;

public abstract class Figure {
    Object white = "***";
    Object black = "###";
    Object p1figureName;
    Object p2figureName;
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
    boolean p1OpenCheck(Object[][] chessBoard, int row, int column){
        return true;
    }
    boolean p2OpenCheck(Object[][] chessBoard, int row, int column){
        return true;
    }
}

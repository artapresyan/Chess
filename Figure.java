package com.company;

public abstract class Figure {
    private Object p1figureName;
    private Object p2figureName;

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
        return false;
    }//

    boolean p2checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        return false;
    }//

    boolean p1NoMoves(Object[][] chessBoard) {
        return true;
    }//

    boolean p2NoMoves(Object[][] chessBoard) {
        return true;
    }//

    boolean p1CoverCheck(Object[][] chessBoard) {
        return false;
    }

    boolean p2CoverCheck(Object[][] chessBoard) {
        return false;
    }
}

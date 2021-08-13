package com.company;

public class Knight extends Figure {
    King king=new King();
    Object p1figureName="wKn";
    Object p2figureName="bKn";
    public Object p1whiteFigure() {
        return p1figureName;
    }
    public Object p2blackFigure() {
        return p2figureName;
    }
    void p1moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
            chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
            if ((takeColumn + takeRow) % 2 == 0)
                chessBoard[takeRow][takeColumn] = white;
            else
                chessBoard[takeRow][takeColumn] = black;
            for (int i = 1; i < chessBoard.length-1; i++) {
                for (int j = 1; j < chessBoard[1].length-1; j++) {
                    if (chessBoard[i][j] == king.p1whiteFigure() ) {
                        if (king.p1KingChecked(chessBoard, i, j)){
                            System.out.println("Please be observant, check your King position...");
                            chessBoard[takeRow][takeColumn]=p1whiteFigure();
                            if ((putColumn + putRow) % 2 == 0)
                                chessBoard[putRow][putColumn] = white;
                            else
                                chessBoard[putRow][putColumn] = black;
                        }
                        break;
                    }
                }
            }
        } else
            System.out.println("Invalid move");
    }
    void p2moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
            chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
            if ((takeColumn + takeRow) % 2 == 0)
                chessBoard[takeRow][takeColumn] = white;
            else
                chessBoard[takeRow][takeColumn] = black;
            for (int i = 1; i < chessBoard.length-1; i++) {
                for (int j = 1; j < chessBoard[8].length-1; j++) {
                    if (chessBoard[i][j] == king.p2blackFigure() ) {
                        if (king.p1KingChecked(chessBoard, i, j)){
                            System.out.println("Please be observant, check your King position...");
                            chessBoard[takeRow][takeColumn]=p2blackFigure();
                            if ((putColumn + putRow) % 2 == 0)
                                chessBoard[putRow][putColumn] = white;
                            else
                                chessBoard[putRow][putColumn] = black;
                        }
                        break;
                    }
                }
            }
        } else
            System.out.println("Invalid move");
    }
    boolean p1checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (chessBoard[takeRow][takeColumn] != p1whiteFigure())
            return false;
        if (putRow - takeRow == 2 || putRow - takeRow == -2) {
            if (putColumn - takeColumn == 1 || putColumn - takeColumn == -1) {
                if (chessBoard[putRow][putColumn].toString().charAt(0) == 'b')
                    return true;
                else if (chessBoard[putRow][putColumn] == white || chessBoard[putRow][putColumn] == black)
                    return true;
            }
        } else if (putRow - takeRow == 1 || putRow - takeRow == -1) {
            if (putColumn - takeColumn == 2 || putColumn - takeColumn == -2) {
                if (chessBoard[putRow][putColumn].toString().charAt(0) == 'b')
                    return true;
                else if (chessBoard[putRow][putColumn] == white || chessBoard[putRow][putColumn] == black)
                        return true;

                }
            }
            return false;
        }

    boolean p2checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (chessBoard[takeRow][takeColumn]!=p2blackFigure())
            return false;
        if (putRow - takeRow == 2 || putRow - takeRow == -2) {
            if (putColumn - takeColumn == 1 || putColumn - takeColumn == -1) {
                if (chessBoard[putRow][putColumn].toString().charAt(0)=='w')
                    return true;
                else if (chessBoard[putRow][putColumn] == white || chessBoard[putRow][putColumn] == black)
                    return true;
            }
        } else if (putRow - takeRow == 1 || putRow - takeRow == -1) {
            if (putColumn - takeColumn == 2 || putColumn - takeColumn == -2) {
                if (chessBoard[putRow][putColumn].toString().charAt(0)=='w')
                    return true;
                else if (chessBoard[putRow][putColumn] == white || chessBoard[putRow][putColumn] == black)
                    return true;
            }
        }
        return false;
    }
}

package com.company;

public class Knight extends Figure {
    King king=new King();
    public Object figure(Object figureName) {
        return figureName;
    }
    void p1moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
            for (int i = 0; i < chessBoard.length; i++) {
                for (int j = 0; j < chessBoard[0].length; j++) {
                    if (chessBoard[i][j] == "w.K" ) {
                        if (!king.p1KingChecked(chessBoard, i, j)) {
                            chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                            if ((takeColumn + takeRow) % 2 == 0)
                                chessBoard[takeRow][takeColumn] = white;
                            else
                                chessBoard[takeRow][takeColumn] = black;
                        }
                        else
                            System.out.println("King checked, please be observant...");
                        break;
                    }
                }
            }
        } else
            System.out.println("Invalid move");
    }
    void p2moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
            for (int i = 0; i < chessBoard.length; i++) {
                for (int j = 0; j < chessBoard[0].length; j++) {
                    if (chessBoard[i][j] == "b.K" ) {
                        if (!king.p2KingChecked(chessBoard, i, j)) {
                            chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                            if ((takeColumn + takeRow) % 2 == 0)
                                chessBoard[takeRow][takeColumn] = white;
                            else
                                chessBoard[takeRow][takeColumn] = black;
                        }
                        else
                            System.out.println("King checked, please be observant...");
                        break;
                    }
                }
            }
        } else
            System.out.println("Invalid move");
    }
    boolean p1checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (!chessBoard[takeRow][takeColumn].toString().equals("wKn"))
            return false;
        if (putRow - takeRow == 2 || putRow - takeRow == -2) {
            if (putColumn - takeColumn == 1 || putColumn - takeColumn == -1) {
                if (chessBoard[putRow][putColumn].toString().charAt(0)=='b'){
                    return true;
                } else if (chessBoard[putRow][putColumn] == white || chessBoard[putRow][putColumn] == black)
                    return true;
            }
        } else if (putRow - takeRow == 1 || putRow - takeRow == -1) {
            if (putColumn - takeColumn == 2 || putColumn - takeColumn == -2) {
                if (chessBoard[putRow][putColumn] == white || chessBoard[putRow][putColumn] == black)
                    return true;

            }
        }
            return false;
    }

    boolean p2checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (!chessBoard[takeRow][takeColumn].toString().equals("bKn"))
            return false;
        if (putRow - takeRow == 2 || putRow - takeRow == -2) {
            if (putColumn - takeColumn == 1 || putColumn - takeColumn == -1) {
                if (chessBoard[putRow][putColumn].toString().charAt(0)=='w'){
                    return true;
                } else if (chessBoard[putRow][putColumn] == white || chessBoard[putRow][putColumn] == black)
                    return true;
            }
        } else if (putRow - takeRow == 1 || putRow - takeRow == -1) {
            if (putColumn - takeColumn == 2 || putColumn - takeColumn == -2) {
                if (chessBoard[putRow][putColumn].toString().charAt(0)=='w'){
                    return true;
                } else if (chessBoard[putRow][putColumn] == white || chessBoard[putRow][putColumn] == black)
                    return true;
            }
        }
        return false;
    }
}

package com.company;

public class King extends Figure{
    private int blackKingCheck=0;
    private int whiteKingCheck=0;
    public Object figure(Object figureName) {
        return figureName;
    }
    void p1moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
            if (putRow == 0 && takeRow == 0 && takeColumn - putColumn == 2 && chessBoard[0][0] == figure("w.R")) {
                chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                if ((takeColumn + takeRow) % 2 == 0)
                    chessBoard[takeRow][takeColumn] = white;
                else
                    chessBoard[takeRow][takeColumn] = black;
                chessBoard[putRow][putColumn + 1] = chessBoard[0][0];
                chessBoard[0][0] = white;
            } else if (putRow == 0 && takeRow == 0 && takeColumn - putColumn == -2 && chessBoard[0][7] == figure("w.R")) {
                chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                if ((takeColumn + takeRow) % 2 == 0)
                    chessBoard[takeRow][takeColumn] = white;
                else
                    chessBoard[takeRow][takeColumn] = black;
                chessBoard[putRow][putColumn - 1] = chessBoard[0][7];
                chessBoard[0][7] = black;
            } else {
                chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                if ((takeColumn + takeRow) % 2 == 0)
                    chessBoard[takeRow][takeColumn] = white;
                else
                    chessBoard[takeRow][takeColumn] = black;
            }
        }else
        System.out.println("Invalid move");
    }
    void p2moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
            if (putRow == 7 && takeRow == 7 && takeColumn - putColumn == 2 && chessBoard[7][0] == figure("b.R")) {
                chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                if ((takeColumn + takeRow) % 2 == 0)
                    chessBoard[takeRow][takeColumn] = white;
                else
                    chessBoard[takeRow][takeColumn] = black;
                chessBoard[putRow][putColumn + 1] = chessBoard[7][0];
                chessBoard[7][0] = black;
            } else if (putRow == 7 && takeRow == 7 && takeColumn - putColumn == -2 && chessBoard[7][7] == figure("b.R")) {
                chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                if ((takeColumn + takeRow) % 2 == 0)
                    chessBoard[takeRow][takeColumn] = white;
                else
                    chessBoard[takeRow][takeColumn] = black;
                chessBoard[putRow][putColumn - 1] = chessBoard[7][7];
                chessBoard[7][7] = white;
            } else {
                chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                if ((takeColumn + takeRow) % 2 == 0)
                    chessBoard[takeRow][takeColumn] = white;
                else
                    chessBoard[takeRow][takeColumn] = black;
            }
        } else
            System.out.println("Invalid move");
    }
    boolean p1checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (!chessBoard[takeRow][takeColumn].toString().equals("w.K"))
            return false;
        if (whiteKingCheck<1 ) {
            if (putRow == 0 && takeRow == 0 && takeColumn - putColumn == 2 && chessBoard[0][0] == figure("w.R")) {
                while (takeColumn > 1) {
                    takeColumn--;
                    if (chessBoard[0][takeColumn] != white && chessBoard[takeRow][takeColumn] != black)
                        return false;
                }
                return true;
            } else if (putRow == 0 && takeRow == 0 && takeColumn - putColumn == -2 && chessBoard[0][7] == figure("w.R")) {
                while (takeColumn < 6) {
                    takeColumn++;
                    if (chessBoard[0][takeColumn] != white && chessBoard[takeRow][takeColumn] != black)
                        return false;
                }
                return true;
            }
        } if (takeRow-putRow==-1 || takeRow-putRow==1||takeRow==putRow){
            if (takeColumn-putColumn==-1||takeColumn-putColumn==1||takeColumn==putColumn){
                if (chessBoard[putRow][putColumn].toString().charAt(0)=='b'){
                    whiteKingCheck++;
                    return true;
                }else if (chessBoard[putRow][putColumn]==white||chessBoard[putRow][putColumn]==black) {
                    whiteKingCheck++;
                    return true;
                }
            }
        }
        return false;
    }
    boolean p2checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (!chessBoard[takeRow][takeColumn].toString().equals("b.K"))
            return false;
        if (blackKingCheck<1) {
            if (putRow == 7 && takeRow == 7 && takeColumn - putColumn == 2 && chessBoard[7][0] == figure("b.R")) {
                while (takeColumn > 1) {
                    takeColumn--;
                    if (chessBoard[7][takeColumn] != white && chessBoard[takeRow][takeColumn] != black)
                        return false;
                }
                return true;
            } else if (putRow == 7 && takeRow == 7 && takeColumn - putColumn == -2 && chessBoard[7][7] == figure("b.R")) {
                while (takeColumn < 6) {
                    takeColumn++;
                    if (chessBoard[7][takeColumn] != white && chessBoard[takeRow][takeColumn] != black)
                        return false;
                }
                return true;
            }
        } if (takeRow-putRow==-1 || takeRow-putRow==1||takeRow==putRow){
            if (takeColumn-putColumn==-1||takeColumn-putColumn==1||takeColumn==putColumn) {
                if (chessBoard[putRow][putColumn].toString().charAt(0) == 'w') {
                    blackKingCheck++;
                    return true;
                } else if (chessBoard[putRow][putColumn] == white || chessBoard[putRow][putColumn] == black) {
                    blackKingCheck++;
                    return true;
                }
            }
        }
        return false;
    }
}

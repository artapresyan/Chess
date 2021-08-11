package com.company;

public class Rook extends Figure {
    public Object figure(Object figureName) {
        return figureName;
    }
    void p1moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
            chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
            if ((takeColumn + takeRow) % 2 == 0)
                chessBoard[takeRow][takeColumn] = white;
            else
                chessBoard[takeRow][takeColumn] = black;
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
        } else
            System.out.println("Invalid move");
    }
    boolean p1checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (!chessBoard[takeRow][takeColumn].toString().equals("w.R"))
            return false;
        if (takeRow == putRow) {
            if (putColumn > takeColumn) {
                while (takeColumn < putColumn - 1) {
                    takeColumn++;
                    if (chessBoard[putRow][takeColumn] != white && chessBoard[putRow][takeColumn] != black)
                        return false;
                }
                if (chessBoard[putRow][putColumn].toString().charAt(0) == 'b')
                    return true;
                else if (chessBoard[putRow][putColumn] != white && chessBoard[putRow][putColumn] != black)
                    return false;
                else
                    return true;
            } else if (putColumn < takeColumn) {
                while (takeColumn > putColumn + 1) {
                    takeColumn--;
                    if (chessBoard[putRow][takeColumn] != white && chessBoard[putRow][takeColumn] != black)
                        return false;
                }
                if (chessBoard[putRow][putColumn].toString().charAt(0) == 'b')
                    return true;
                else if (chessBoard[putRow][putColumn] != white && chessBoard[putRow][putColumn] != black)
                    return false;
                else
                    return true;
            }
        } else if (takeColumn == putColumn) {
            if (putRow > takeRow) {
                while (takeRow < putRow - 1) {
                    takeRow++;
                    if (chessBoard[takeRow][putColumn] != white && chessBoard[takeRow][putColumn] != black)
                        return false;
                }
                if (chessBoard[putRow][putColumn].toString().charAt(0) == 'b')
                    return true;
                else if (chessBoard[putRow][putColumn] != white && chessBoard[putRow][putColumn] != black)
                    return false;
                else
                    return true;
            } else if (putRow < takeRow) {
                while (takeRow > putRow + 1) {
                    takeRow--;
                    if (chessBoard[takeRow][putColumn] != white && chessBoard[takeRow][putColumn] != black)
                        return false;
                }
                if (chessBoard[putRow][putColumn].toString().charAt(0) == 'b')
                    return true;
                else if (chessBoard[putRow][putColumn] != white && chessBoard[putRow][putColumn] != black)
                    return false;
                else
                    return true;
            }
        }
        return false;
    }
    boolean p2checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (!chessBoard[takeRow][takeColumn].toString().equals("b.R"))
            return false;
        if(takeRow==putRow ) {
            if (putColumn > takeColumn) {
                while (takeColumn < putColumn - 1) {
                    takeColumn++;
                    if (chessBoard[putRow][takeColumn] != white && chessBoard[putRow][takeColumn] != black)
                        return false;
                }
                if (chessBoard[putRow][putColumn].toString().charAt(0) == 'w')
                    return true;
                else if (chessBoard[putRow][putColumn] != white && chessBoard[putRow][putColumn] != black)
                    return false;
                else
                    return true;
            } else if (putColumn < takeColumn) {
                while (takeColumn > putColumn + 1) {
                    takeColumn--;
                    if (chessBoard[putRow][takeColumn] != white && chessBoard[putRow][takeColumn] != black)
                        return false;
                }
                if (chessBoard[putRow][putColumn].toString().charAt(0) == 'w')
                    return true;
                else if (chessBoard[putRow][putColumn] != white && chessBoard[putRow][putColumn] != black)
                    return false;
                else
                    return true;
            }
        }else if (takeColumn==putColumn){
            if (putRow > takeRow) {
                while (takeRow < putRow-1) {
                    takeRow++;
                    if (chessBoard[takeRow][putColumn] != white && chessBoard[takeRow][putColumn] != black)
                        return false;
                }
                if (chessBoard[putRow][putColumn].toString().charAt(0) == 'w')
                    return true;
                else if (chessBoard[putRow][putColumn] != white && chessBoard[putRow][putColumn] != black)
                    return false;
                else
                    return true;
            }else if (putRow<takeRow){
                while (takeRow > putRow+1) {
                    takeRow--;
                    if (chessBoard[takeRow][putColumn] != white && chessBoard[takeRow][putColumn] != black)
                        return false;
                }
                if (chessBoard[putRow][putColumn].toString().charAt(0) == 'w')
                    return true;
                else if (chessBoard[putRow][putColumn] != white && chessBoard[putRow][putColumn] != black)
                    return false;
                else
                    return true;
            }
        }
            return false;
    }
}

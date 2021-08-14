package com.company;

public class Rook extends Figure {
    King king=new King();
    private Object p1figureName="w.R";
    private Object p2figureName="b.R";
    public Object p1whiteFigure() {
        return p1figureName;
    }
    public Object p2blackFigure() {
        return p2figureName;
    }
    void p1moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
            p1figureName="w.r";
            chessBoard[takeRow][takeColumn]=p1whiteFigure();
            chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
            if ((takeColumn + takeRow) % 2 == 0)
                chessBoard[takeRow][takeColumn] = white;
            else
                chessBoard[takeRow][takeColumn] = black;
            for (int i = 1; i < chessBoard.length-1; i++) {
                for (int j = 1; j < chessBoard[1].length; j++) {
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
            p2figureName="b.r";
            chessBoard[takeRow][takeColumn]=p2blackFigure();
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
        if (chessBoard[takeRow][takeColumn]!=p1whiteFigure())
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
        if (chessBoard[takeRow][takeColumn]!=p2blackFigure())
            return false;
        if (takeRow == putRow) {
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
        } else if (takeColumn == putColumn) {
            if (putRow > takeRow) {
                while (takeRow < putRow - 1) {
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
            } else if (putRow < takeRow) {
                while (takeRow > putRow + 1) {
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

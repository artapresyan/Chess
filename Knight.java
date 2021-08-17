package com.company;

public class Knight extends Figure {
    King king = new King();
    private final Object p1figureName = "wKn";
    private final Object p2figureName = "bKn";

    public Object p1whiteFigure() {
        return p1figureName;
    }

    public Object p2blackFigure() {
        return p2figureName;
    }

    void p1moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
            Object mover = chessBoard[putRow][putColumn];
            chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
            chessBoard[takeRow][takeColumn] = null;

            if (king.p1KingChecked(chessBoard)) {
                System.out.println("Please be observant, check your King position...");
                chessBoard[takeRow][takeColumn] = p1whiteFigure();
                chessBoard[putRow][putColumn] = mover;
            }
        } else
            System.out.println("Invalid move");
    }

    void p2moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
            Object mover = chessBoard[putRow][putColumn];
            chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
            chessBoard[takeRow][takeColumn] = null;

            if (king.p2KingChecked(chessBoard)) {
                System.out.println("Please be observant, check your King position...");
                chessBoard[takeRow][takeColumn] = p2blackFigure();
                chessBoard[putRow][putColumn] = mover;
            }
        } else
            System.out.println("Invalid move");
    }

    boolean p1checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (chessBoard[takeRow][takeColumn] != p1whiteFigure() || takeRow == putRow && takeColumn == putColumn)
            return false;
        if (putRow - takeRow == 2 || putRow - takeRow == -2) {
            if (putColumn - takeColumn == 1 || putColumn - takeColumn == -1) {
                if (chessBoard[putRow][putColumn] == null)
                    return true;
                else
                    return chessBoard[putRow][putColumn].toString().charAt(0) == 'b';
            }
        } else if (putRow - takeRow == 1 || putRow - takeRow == -1) {
            if (putColumn - takeColumn == 2 || putColumn - takeColumn == -2) {
                if (chessBoard[putRow][putColumn] == null)
                    return true;
                else
                    return chessBoard[putRow][putColumn].toString().charAt(0) == 'b';
            }
        }
        return false;
    }

    boolean p2checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (chessBoard[takeRow][takeColumn] != p2blackFigure() || takeRow == putRow && takeColumn == putColumn)
            return false;
        if (putRow - takeRow == 2 || putRow - takeRow == -2) {
            if (putColumn - takeColumn == 1 || putColumn - takeColumn == -1) {
                if (chessBoard[putRow][putColumn] == null)
                    return true;
                else
                    return chessBoard[putRow][putColumn].toString().charAt(0) == 'w';
            }
        } else if (putRow - takeRow == 1 || putRow - takeRow == -1) {
            if (putColumn - takeColumn == 2 || putColumn - takeColumn == -2) {
                if (chessBoard[putRow][putColumn] == null)
                    return true;
                else
                    return chessBoard[putRow][putColumn].toString().charAt(0) == 'w';
            }
        }
        return false;
    }

    boolean p1ValidMoves(Object[][] chessBoard) {
        for (int i = 1; i < chessBoard.length-1; i++) {
            for (int j = 1; j < chessBoard[1].length-1; j++) {
                if ((chessBoard[i][j] == "wKn")) {
                    try {
                        if (chessBoard[i - 2][j + 1] == null || chessBoard[i - 2][j + 1].toString().charAt(0) == 'b')
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[i - 2][j - 1] == null || chessBoard[i - 2][j + 1].toString().charAt(0) == 'b')
                            return true;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (chessBoard[i - 1][j - 2] == null || chessBoard[i - 2][j + 1].toString().charAt(0) == 'b')
                            return true;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (chessBoard[i + 1][j - 2] == null || chessBoard[i - 2][j + 1].toString().charAt(0) == 'b')
                            return true;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (chessBoard[i + 2][j - 1] == null || chessBoard[i - 2][j + 1].toString().charAt(0) == 'b')
                            return true;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (chessBoard[i + 2][j + 1] == null || chessBoard[i - 2][j + 1].toString().charAt(0) == 'b')
                            return true;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (chessBoard[i + 1][j + 2] == null || chessBoard[i - 2][j + 1].toString().charAt(0) == 'b')
                            return true;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (chessBoard[i - 1][j + 1] == null || chessBoard[i - 2][j + 1].toString().charAt(0) == 'b')
                            return true;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }

                }
            }
        }
        return false;
    }
    boolean p2ValidMoves(Object[][] chessBoard) {
        for (int i = 1; i < chessBoard.length-1; i++) {
            for (int j = 1; j < chessBoard[1].length-1; j++) {
                if ((chessBoard[i][j] == "bKn")) {
                    try {
                        if (chessBoard[i - 2][j + 1] == null || chessBoard[i - 2][j + 1].toString().charAt(0) == 'w')
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[i - 2][j - 1] == null || chessBoard[i - 2][j + 1].toString().charAt(0) == 'w')
                            return true;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (chessBoard[i - 1][j - 2] == null || chessBoard[i - 2][j + 1].toString().charAt(0) == 'w')
                            return true;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (chessBoard[i + 1][j - 2] == null || chessBoard[i - 2][j + 1].toString().charAt(0) == 'w')
                            return true;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (chessBoard[i + 2][j - 1] == null || chessBoard[i - 2][j + 1].toString().charAt(0) == 'w')
                            return true;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (chessBoard[i + 2][j + 1] == null || chessBoard[i - 2][j + 1].toString().charAt(0) == 'w')
                            return true;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (chessBoard[i + 1][j + 2] == null || chessBoard[i - 2][j + 1].toString().charAt(0) == 'w')
                            return true;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (chessBoard[i - 1][j + 1] == null || chessBoard[i - 2][j + 1].toString().charAt(0) == 'w')
                            return true;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }

                }
            }
        }
        return false;
    }
}

package com.company;

public class Knight extends Figure {
    private final Object p1figureName = "wKn";
    private final Object p2figureName = "bKn";
    public Object p1whiteFigure() {
        return p1figureName;
    }
    public Object p2blackFigure() {
        return p2figureName;
    }
    void p1moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        King king=new King();
        if (p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
            Object mover = chessBoard[putRow][putColumn];
            chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
            chessBoard[takeRow][takeColumn] = null;

            if (king.p1KingChecked(chessBoard)) {
                System.out.println("Please be observant, check your King's position...");
                chessBoard[takeRow][takeColumn] = p1whiteFigure();
                chessBoard[putRow][putColumn] = mover;
            }
        } else
            System.out.println("Invalid move");
    }
    void p2moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        King king=new King();
        if (p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
            Object mover = chessBoard[putRow][putColumn];
            chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
            chessBoard[takeRow][takeColumn] = null;

            if (king.p2KingChecked(chessBoard)) {
                System.out.println("Please be observant, check your King's position...");
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
    boolean p1NoMoves(Object[][] chessBoard) {
        for (int i = 1; i < chessBoard.length-1; i++) {
            for (int j = 1; j < chessBoard[i].length-1; j++) {
                if ((chessBoard[i][j] == "wKn")) {
                    try {
                        if (p1checkMove(chessBoard,i,j,i-2,j+1))
                            return false;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (p1checkMove(chessBoard,i,j,i-2,j-1))
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (p1checkMove(chessBoard,i,j,i-1,j-2))
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (p1checkMove(chessBoard,i,j,i+1,j-2))
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (p1checkMove(chessBoard,i,j,i+2,j-1))
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (p1checkMove(chessBoard,i,j,i+2,j+1))
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (p1checkMove(chessBoard,i,j,i+1,j+2))
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (p1checkMove(chessBoard,i,j,i-1,j+2))
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                }
            }
        }
        return true;
    }
    boolean p2NoMoves(Object[][] chessBoard) {
        for (int i = chessBoard.length-2; i > 0; i--) {
            for (int j = 1; j < chessBoard[i].length-1; j++) {
                if ((chessBoard[i][j] == "bKn")) {
                    try {
                        if (p2checkMove(chessBoard,i,j,i-2,j+1))
                            return false;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (p2checkMove(chessBoard,i,j,i-2,j-1))
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (p2checkMove(chessBoard,i,j,i-1,j-2))
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (p2checkMove(chessBoard,i,j,i+1,j-2))
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (p2checkMove(chessBoard,i,j,i+2,j-1))
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (p2checkMove(chessBoard,i,j,i+2,j+1))
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (p2checkMove(chessBoard,i,j,i+1,j+2))
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (p2checkMove(chessBoard,i,j,i-1,j+2))
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                }
            }
        }
        return true;
    }
    boolean p1CoverCheck(Object[][] chessBoard) {
        King king=new King();
        Object mover;
        for (int i = 1; i < chessBoard.length-1; i++) {
            for (int j = 1; j < chessBoard[i].length-1; j++) {
                if ((chessBoard[i][j] == "wKn")) {
                    try {
                        mover=chessBoard[i - 2][j + 1];
                        if (p1checkMove(chessBoard, i, j, i - 2, j + 1)) {
                            chessBoard[i - 2][j + 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!king.p1KingChecked(chessBoard)) {
                                chessBoard[i - 2][j + 1] = mover;
                                chessBoard[i][j] = p1whiteFigure();
                                return true;
                            }else {
                                chessBoard[i - 2][j + 1] = mover;
                                chessBoard[i][j] = p1whiteFigure();
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        mover=chessBoard[i - 2][j - 1];
                        if (p1checkMove(chessBoard, i, j, i - 2, j - 1)) {
                            chessBoard[i - 2][j - 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!king.p1KingChecked(chessBoard)) {
                                chessBoard[i - 2][j - 1] = mover;
                                chessBoard[i][j] = p1whiteFigure();
                                return true;
                            }else {
                                chessBoard[i - 2][j - 1] = mover;
                                chessBoard[i][j] = p1whiteFigure();
                            }
                        }
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        mover=chessBoard[i - 1][j - 2];
                        if (p1checkMove(chessBoard, i, j, i - 1, j - 2)) {
                            chessBoard[i - 1][j - 2] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!king.p1KingChecked(chessBoard)) {
                                chessBoard[i - 1][j - 2] = mover;
                                chessBoard[i][j] = p1whiteFigure();
                                return true;
                            }else {
                                chessBoard[i - 1][j - 2] = mover;
                                chessBoard[i][j] = p1whiteFigure();
                            }
                        }
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        mover=chessBoard[i + 1][j - 2];
                        if (p1checkMove(chessBoard, i, j, i + 1, j - 2)) {
                            chessBoard[i + 1][j - 2] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!king.p1KingChecked(chessBoard)) {
                                chessBoard[i + 1][j - 2] = mover;
                                chessBoard[i][j] = p1whiteFigure();
                                return true;
                            }else {
                                chessBoard[i + 1][j - 2] = mover;
                                chessBoard[i][j] = p1whiteFigure();
                            }
                        }
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        mover=chessBoard[i + 2][j - 1];
                        if (p1checkMove(chessBoard, i, j, i + 2, j - 1)) {
                            chessBoard[i + 2][j - 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!king.p1KingChecked(chessBoard)) {
                                chessBoard[i + 2][j - 1] = mover;
                                chessBoard[i][j] = p1whiteFigure();
                                return true;
                            }else {
                                chessBoard[i + 2][j - 1] = mover;
                                chessBoard[i][j] = p1whiteFigure();
                            }
                        }
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        mover=chessBoard[i + 2][j + 1];
                        if (p1checkMove(chessBoard, i, j, i + 2, j - 1)) {
                            chessBoard[i + 2][j + 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!king.p1KingChecked(chessBoard)) {
                                chessBoard[i + 2][j + 1] = mover;
                                chessBoard[i][j] = p1whiteFigure();
                                return true;
                            }else {
                                chessBoard[i + 2][j + 1] = mover;
                                chessBoard[i][j] = p1whiteFigure();
                            }
                        }
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        mover=chessBoard[i + 1][j + 2];
                        if (p1checkMove(chessBoard, i, j, i + 1, j + 2)) {
                            chessBoard[i + 1][j + 2] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!king.p1KingChecked(chessBoard)) {
                                chessBoard[i + 1][j + 2] = mover;
                                chessBoard[i][j] = p1whiteFigure();
                                return true;
                            }else {
                                chessBoard[i + 1][j + 2] = mover;
                                chessBoard[i][j] = p1whiteFigure();
                            }
                        }
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        mover=chessBoard[i - 1][j + 2];
                        if (p1checkMove(chessBoard, i, j, i - 1, j + 2)) {
                            chessBoard[i - 1][j + 2] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!king.p1KingChecked(chessBoard)) {
                                chessBoard[i - 1][j + 2] = mover;
                                chessBoard[i][j] = p1whiteFigure();
                                return true;
                            }else {
                                chessBoard[i - 1][j + 2] = mover;
                                chessBoard[i][j] = p1whiteFigure();
                            }
                        }
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    return false;
                }
            }
        }
        return false;
    }
    boolean p2CoverCheck(Object[][] chessBoard) {
        King king=new King();
        Object mover;
        for (int i = chessBoard.length-2; i > 0; i--) {
            for (int j = 1; j < chessBoard[i].length-1; j++) {
                if ((chessBoard[i][j] == "bKn")) {
                    try {
                        mover=chessBoard[i - 2][j + 1];
                        if (p2checkMove(chessBoard, i, j, i - 2, j + 1)) {
                            chessBoard[i - 2][j + 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!king.p2KingChecked(chessBoard)) {
                                chessBoard[i - 2][j + 1] = mover;
                                chessBoard[i][j] = p2blackFigure();
                                return true;
                            }else {
                                chessBoard[i - 2][j + 1] = mover;
                                chessBoard[i][j] = p2blackFigure();
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        mover=chessBoard[i - 2][j - 1];
                        if (p2checkMove(chessBoard, i, j, i - 2, j - 1)) {
                            chessBoard[i - 2][j - 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!king.p2KingChecked(chessBoard)) {
                                chessBoard[i - 2][j - 1] = mover;
                                chessBoard[i][j] = p2blackFigure();
                                return true;
                            }else {
                                chessBoard[i - 2][j - 1] = mover;
                                chessBoard[i][j] = p2blackFigure();
                            }
                        }
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        mover=chessBoard[i - 1][j - 2];
                        if (p2checkMove(chessBoard, i, j, i - 1, j - 2)) {
                            chessBoard[i - 1][j - 2] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!king.p2KingChecked(chessBoard)) {
                                chessBoard[i - 1][j - 2] = mover;
                                chessBoard[i][j] = p2blackFigure();
                                return true;
                            }else {
                                chessBoard[i - 1][j - 2] = mover;
                                chessBoard[i][j] = p2blackFigure();
                            }
                        }
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        mover=chessBoard[i + 1][j - 2];
                        if (p2checkMove(chessBoard, i, j, i + 1, j - 2)) {
                            chessBoard[i + 1][j - 2] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!king.p2KingChecked(chessBoard)) {
                                chessBoard[i + 1][j - 2] = mover;
                                chessBoard[i][j] = p2blackFigure();
                                return true;
                            }else {
                                chessBoard[i + 1][j - 2] = mover;
                                chessBoard[i][j] = p2blackFigure();
                            }
                        }
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        mover=chessBoard[i + 2][j - 1];
                        if (p2checkMove(chessBoard, i, j, i + 2, j - 1)) {
                            chessBoard[i + 2][j - 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!king.p2KingChecked(chessBoard)) {
                                chessBoard[i + 2][j - 1] = mover;
                                chessBoard[i][j] = p2blackFigure();
                                return true;
                            }else {
                                chessBoard[i + 2][j - 1] = mover;
                                chessBoard[i][j] = p2blackFigure();
                            }
                        }
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        mover=chessBoard[i + 2][j + 1];
                        if (p2checkMove(chessBoard, i, j, i + 2, j - 1)) {
                            chessBoard[i + 2][j + 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!king.p2KingChecked(chessBoard)) {
                                chessBoard[i + 2][j + 1] = mover;
                                chessBoard[i][j] = p2blackFigure();
                                return true;
                            }else {
                                chessBoard[i + 2][j + 1] = mover;
                                chessBoard[i][j] = p2blackFigure();
                            }
                        }
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        mover=chessBoard[i + 1][j + 2];
                        if (p2checkMove(chessBoard, i, j, i + 1, j + 2)) {
                            chessBoard[i + 1][j + 2] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!king.p2KingChecked(chessBoard)) {
                                chessBoard[i + 1][j + 2] = mover;
                                chessBoard[i][j] = p2blackFigure();
                                return true;
                            }else {
                                chessBoard[i + 1][j + 2] = mover;
                                chessBoard[i][j] = p2blackFigure();
                            }
                        }
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        mover=chessBoard[i - 1][j + 2];
                        if (p2checkMove(chessBoard, i, j, i - 1, j + 2)) {
                            chessBoard[i - 1][j + 2] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!king.p2KingChecked(chessBoard)) {
                                chessBoard[i - 1][j + 2] = mover;
                                chessBoard[i][j] = p2blackFigure();
                                return true;
                            }else {
                                chessBoard[i - 1][j + 2] = mover;
                                chessBoard[i][j] = p2blackFigure();
                            }
                        }
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    return false;
                }
            }
        }
        return false;
    }
}

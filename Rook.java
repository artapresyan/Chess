package com.company;

public class Rook extends Figure {
    private Object p1figureName = "w.R";
    private Object p2figureName = "b.R";

    //    private boolean wrIsMoved=false;
//    private boolean brIsMoved=false;
    public Object p1whiteFigure() {
        return p1figureName;
    }

    public Object p2blackFigure() {
        return p2figureName;
    }

    //    boolean wrIsMoved() {
//        return wrIsMoved;
//    }
//    boolean brIsMoved() {
//        return brIsMoved;
//    }
    void p1moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        //           wrIsMoved=true;
        p1figureName = "w.r";
        chessBoard[takeRow][takeColumn] = p1whiteFigure();
        chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
        chessBoard[takeRow][takeColumn] = null;
    }

    void p2moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
//            brIsMoved=true;
        p2figureName = "b.r";
        chessBoard[takeRow][takeColumn] = p2blackFigure();
        chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
        chessBoard[takeRow][takeColumn] = null;
    }

    boolean p1checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        King king = new King();
        int i = takeRow;
        int j = takeColumn;
        if (chessBoard[takeRow][takeColumn] != p1whiteFigure() || takeRow == putRow && takeColumn == putColumn) {
            System.out.println("P1, Invalid move");
            return false;
        }
        if (takeRow == putRow) {
            if (putColumn > takeColumn) {
                while (takeColumn < putColumn - 1) {
                    takeColumn++;
                    if (chessBoard[putRow][takeColumn] != null) {
                        System.out.println("P1, Invalid move");
                        return false;
                    }
                }
            } else {
                while (takeColumn > putColumn + 1) {
                    takeColumn--;
                    if (chessBoard[putRow][takeColumn] != null) {
                        System.out.println("P1, Invalid move");
                        return false;
                    }
                }
            }
        } else if (takeColumn == putColumn) {
            if (putRow > takeRow) {
                while (takeRow < putRow - 1) {
                    takeRow++;
                    if (chessBoard[takeRow][putColumn] != null) {
                        System.out.println("P1, Invalid move");
                        return false;
                    }
                }

            } else {
                while (takeRow > putRow + 1) {
                    takeRow--;
                    if (chessBoard[takeRow][putColumn] != null) {
                        System.out.println("P1, Invalid move");
                        return false;
                    }
                }
            }
        }
        if (chessBoard[putRow][putColumn] == null) {
            Object mover = chessBoard[putRow][putColumn];
            chessBoard[putRow][putColumn] = chessBoard[i][j];
            chessBoard[i][j] = null;

            if (king.p1KingChecked(chessBoard)) {
                System.out.println("P1, Please Be Observant And Check Your King's Position...");
                chessBoard[i][j] = p1whiteFigure();
                chessBoard[putRow][putColumn] = mover;
                return false;
            }
            chessBoard[i][j] = p1whiteFigure();
            chessBoard[putRow][putColumn] = mover;
            return true;
        }else if (chessBoard[putRow][putColumn].toString().charAt(0)=='b'){
            Object mover = chessBoard[putRow][putColumn];
            chessBoard[putRow][putColumn] = chessBoard[i][j];
            chessBoard[i][j] = null;

            if (king.p1KingChecked(chessBoard)) {
                System.out.println("P1, Please Be Observant And Check Your King's Position...");
                chessBoard[i][j] = p1whiteFigure();
                chessBoard[putRow][putColumn] = mover;
                return false;
            }
            chessBoard[i][j] = p1whiteFigure();
            chessBoard[putRow][putColumn] = mover;
            return true;
        }
        return false;
    }

    boolean p2checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        King king = new King();
        int i = takeRow;
        int j = takeColumn;
        if (chessBoard[takeRow][takeColumn] != p2blackFigure() || takeRow == putRow && takeColumn == putColumn) {
            System.out.println("P2, Invalid Move");
            return false;
        }
        if (takeRow == putRow) {
            if (putColumn > takeColumn) {
                while (takeColumn < putColumn - 1) {
                    takeColumn++;
                    if (chessBoard[putRow][takeColumn] != null) {
                        System.out.println("P2, Invalid Move");
                        return false;
                    }
                }
            } else {
                while (takeColumn > putColumn + 1) {
                    takeColumn--;
                    if (chessBoard[putRow][takeColumn] != null) {
                        System.out.println("P2, Invalid Move");
                        return false;
                    }
                }
            }
        } else if (takeColumn == putColumn) {
            if (putRow > takeRow) {
                while (takeRow < putRow - 1) {
                    takeRow++;
                    if (chessBoard[takeRow][putColumn] != null) {
                        System.out.println("P2, Invalid Move");
                        return false;
                    }
                }
            } else {
                while (takeRow > putRow + 1) {
                    takeRow--;
                    if (chessBoard[takeRow][putColumn] != null) {
                        System.out.println("P2, Invalid Move");
                        return false;
                    }
                }
            }
        }
        if (chessBoard[putRow][putColumn] == null) {
            Object mover = chessBoard[putRow][putColumn];
            chessBoard[putRow][putColumn] = chessBoard[i][j];
            chessBoard[i][j] = null;

            if (king.p2KingChecked(chessBoard)) {
                System.out.println("P2, Please Be Observant And Check Your King's Position...");
                chessBoard[i][j] = p2blackFigure();
                chessBoard[putRow][putColumn] = mover;
                return false;
            }
            chessBoard[i][j] = p2blackFigure();
            chessBoard[putRow][putColumn] = mover;
            return true;
        }else if (chessBoard[putRow][putColumn].toString().charAt(0)=='w'){
            Object mover = chessBoard[putRow][putColumn];
            chessBoard[putRow][putColumn] = chessBoard[i][j];
            chessBoard[i][j] = null;

            if (king.p2KingChecked(chessBoard)) {
                System.out.println("P2, Please Be Observant And Check Your King's Position...");
                chessBoard[i][j] = p2blackFigure();
                chessBoard[putRow][putColumn] = mover;
                return false;
            }
            chessBoard[i][j] = p2blackFigure();
            chessBoard[putRow][putColumn] = mover;
            return true;
        }
        return false;
    }

    boolean p1NoMoves(Object[][] chessBoard) {
        for (int i = 1; i < chessBoard.length - 1; i++) {
            for (int j = 1; j < chessBoard[i].length - 1; j++) {
                if (chessBoard[i][j] == "w.R" || chessBoard[i][j] == "w.r") {
                    try {
                        if (chessBoard[i + 1][j] == null || chessBoard[i + 1][j].toString().charAt(0) == 'b')
                            return false;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[i - 1][j] == null || chessBoard[i - 1][j].toString().charAt(0) == 'b')
                            return false;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[i][j + 1] == null || chessBoard[i][j - 1].toString().charAt(0) == 'b')
                            return false;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[i][j - 1] == null || chessBoard[i][j - 1].toString().charAt(0) == 'b')
                            return false;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                }
            }
        }
        return true;
    }

    boolean p2NoMoves(Object[][] chessBoard) {
        for (int i = chessBoard.length - 2; i > 0; i--) {
            for (int j = 1; j < chessBoard[i].length - 1; j++) {
                if (chessBoard[i][j] == "b.R" || chessBoard[i][j] == "b.r") {
                    try {
                        if (chessBoard[i + 1][j] == null || chessBoard[i + 1][j].toString().charAt(0) == 'w')
                            return false;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[i - 1][j] == null || chessBoard[i - 1][j].toString().charAt(0) == 'w')
                            return false;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[i][j + 1] == null || chessBoard[i][j - 1].toString().charAt(0) == 'w')
                            return false;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[i][j - 1] == null || chessBoard[i][j - 1].toString().charAt(0) == 'w')
                            return false;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                }
            }
        }
        return true;
    }

    boolean p1CoverCheck(Object[][] chessBoard) {
        King king = new King();
        Object mover;
        for (int i = 1; i < chessBoard.length - 1; i++) {
            for (int j = 1; j < chessBoard[i].length - 1; j++) {
                if (chessBoard[i][j] == "w.R" || chessBoard[i][j] == "w.r") {
                    try {
                        int row = i;
                        while (row < chessBoard.length - 2) {
                            row++;
                            mover = chessBoard[row][j];
                            if (chessBoard[row][j] == null) {
                                chessBoard[row][j] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p1KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p1whiteFigure();
                                    chessBoard[row][j] = mover;
                                    return true;
                                } else {
                                    chessBoard[i][j] = p1whiteFigure();
                                    chessBoard[row][j] = mover;
                                }
                            } else if (chessBoard[row][j].toString().charAt(0) == 'b') {
                                chessBoard[row][j] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p1KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p1whiteFigure();
                                    chessBoard[row][j] = mover;
                                    return true;
                                }
                                chessBoard[i][j] = p1whiteFigure();
                                chessBoard[row][j] = mover;
                                break;
                            } else
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        int row = i;
                        while (row > 1) {
                            row--;
                            mover = chessBoard[row][j];
                            if (chessBoard[row][j] == null) {
                                chessBoard[row][j] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p1KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p1whiteFigure();
                                    chessBoard[row][j] = mover;
                                    return true;
                                } else {
                                    chessBoard[i][j] = p1whiteFigure();
                                    chessBoard[row][j] = mover;
                                }
                            } else if (chessBoard[row][j].toString().charAt(0) == 'b') {
                                chessBoard[row][j] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p1KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p1whiteFigure();
                                    chessBoard[row][j] = mover;
                                    return true;
                                }
                                chessBoard[i][j] = p1whiteFigure();
                                chessBoard[row][j] = mover;
                                break;
                            } else
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        int column = j;
                        while (column < chessBoard.length - 2) {
                            column++;
                            mover = chessBoard[i][column];
                            if (chessBoard[i][column] == null) {
                                chessBoard[i][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p1KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p1whiteFigure();
                                    chessBoard[i][column] = mover;
                                    return true;
                                } else {
                                    chessBoard[i][j] = p1whiteFigure();
                                    chessBoard[i][column] = mover;
                                }
                            } else if (chessBoard[i][column].toString().charAt(0) == 'b') {
                                chessBoard[i][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p1KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p1whiteFigure();
                                    chessBoard[i][column] = mover;
                                    return true;
                                }
                                chessBoard[i][j] = p1whiteFigure();
                                chessBoard[i][column] = mover;
                                break;
                            } else
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        int column = j;
                        while (column > 1) {
                            column--;
                            mover = chessBoard[i][column];
                            if (chessBoard[i][column] == null) {
                                chessBoard[i][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p1KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p1whiteFigure();
                                    chessBoard[i][column] = mover;
                                    return true;
                                } else {
                                    chessBoard[i][j] = p1whiteFigure();
                                    chessBoard[i][column] = mover;
                                }
                            } else if (chessBoard[i][column].toString().charAt(0) == 'b') {
                                chessBoard[i][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p1KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p1whiteFigure();
                                    chessBoard[i][column] = mover;
                                    return true;
                                }
                                chessBoard[i][j] = p1whiteFigure();
                                chessBoard[i][column] = mover;
                                break;
                            } else
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                }
            }
        }
        return false;
    }

    boolean p2CoverCheck(Object[][] chessBoard) {
        King king = new King();
        Object mover;
        for (int i = chessBoard.length - 2; i > 0; i--) {
            for (int j = 1; j < chessBoard[i].length - 1; j++) {
                if (chessBoard[i][j] == "b.R" || chessBoard[i][j] == "b.r") {
                    try {
                        int row = i;
                        while (row < chessBoard.length - 2) {
                            row++;
                            mover = chessBoard[row][j];
                            if (chessBoard[row][j] == null) {
                                chessBoard[row][j] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p2KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][j] = mover;
                                    return true;
                                } else {
                                    chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][j] = mover;
                                }
                            } else if (chessBoard[row][j].toString().charAt(0) == 'w') {
                                chessBoard[row][j] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p2KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][j] = mover;
                                    return true;
                                }
                                chessBoard[i][j] = p2blackFigure();
                                chessBoard[row][j] = mover;
                                break;
                            } else
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        int row = i;
                        while (row > 1) {
                            row--;
                            mover = chessBoard[row][j];
                            if (chessBoard[row][j] == null) {
                                chessBoard[row][j] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p2KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][j] = mover;
                                    return true;
                                } else {
                                    chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][j] = mover;
                                }
                            } else if (chessBoard[row][j].toString().charAt(0) == 'w') {
                                chessBoard[row][j] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p2KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][j] = mover;
                                    return true;
                                }
                                chessBoard[i][j] = p2blackFigure();
                                chessBoard[row][j] = mover;
                                break;
                            } else
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        int column = j;
                        while (column < chessBoard.length - 2) {
                            column++;
                            mover = chessBoard[i][column];
                            if (chessBoard[i][column] == null) {
                                chessBoard[i][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p2KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p2blackFigure();
                                    chessBoard[i][column] = mover;
                                    return true;
                                } else {
                                    chessBoard[i][j] = p2blackFigure();
                                    chessBoard[i][column] = mover;
                                }
                            } else if (chessBoard[i][column].toString().charAt(0) == 'w') {
                                chessBoard[i][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p2KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p2blackFigure();
                                    chessBoard[i][column] = mover;
                                    return true;
                                }
                                chessBoard[i][j] = p2blackFigure();
                                chessBoard[i][column] = mover;
                                break;
                            } else
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        int column = j;
                        while (column > 1) {
                            column--;
                            mover = chessBoard[i][column];
                            if (chessBoard[i][column] == null) {
                                chessBoard[i][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p2KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p2blackFigure();
                                    chessBoard[i][column] = mover;
                                    return true;
                                } else {
                                    chessBoard[i][j] = p2blackFigure();
                                    chessBoard[i][column] = mover;
                                }
                            } else if (chessBoard[i][column].toString().charAt(0) == 'w') {
                                chessBoard[i][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p2KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p2blackFigure();
                                    chessBoard[i][column] = mover;
                                    return true;
                                }
                                chessBoard[i][j] = p2blackFigure();
                                chessBoard[i][column] = mover;
                                break;
                            } else
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                }
            }
        }
        return false;
    }
}

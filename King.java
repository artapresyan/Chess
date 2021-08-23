package com.company;

public class King extends Figure {
    private final Object p1figureName = "w.K";
    private final Object p2figureName = "b.K";
    private boolean wkIsMoved = false;
    private boolean bkIsMoved = false;

    public Object p1whiteFigure() {
        return p1figureName;
    }

    public Object p2blackFigure() {
        return p2figureName;
    }

    void p1moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (putRow == 1 && takeRow == 1 && takeColumn - putColumn == 2 && chessBoard[1][1] == "w.R") {
            chessBoard[1][putColumn] = chessBoard[1][takeColumn];
            chessBoard[1][takeColumn] = null;
            chessBoard[1][putColumn + 1] = chessBoard[1][1];
            chessBoard[1][1] = null;
        } else if (putRow == 1 && takeRow == 1 && takeColumn - putColumn == -2 && chessBoard[1][8] == "w.R") {
            chessBoard[1][putColumn] = chessBoard[1][takeColumn];
            chessBoard[1][takeColumn] = null;
            chessBoard[1][putColumn - 1] = chessBoard[1][8];
            chessBoard[1][8] = null;
        } else {
            wkIsMoved = true;
            chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
            chessBoard[takeRow][takeColumn] = null;
        }
    }

    void p2moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (putRow == 8 && takeRow == 8 && takeColumn - putColumn == 2 && chessBoard[8][1] == "w.R") {
            chessBoard[8][putColumn] = chessBoard[8][takeColumn];
            chessBoard[8][takeColumn] = null;
            chessBoard[8][putColumn + 1] = chessBoard[8][1];
            chessBoard[8][1] = null;
        } else if (putRow == 8 && takeRow == 8 && takeColumn - putColumn == -2 && chessBoard[8][8] == "w.R") {
            chessBoard[8][putColumn] = chessBoard[8][takeColumn];
            chessBoard[8][takeColumn] = null;
            chessBoard[8][putColumn - 1] = chessBoard[8][8];
            chessBoard[8][8] = null;
        } else {
            bkIsMoved = true;
            chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
            chessBoard[takeRow][takeColumn] = null;
        }
    }

    boolean p1checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (chessBoard[takeRow][takeColumn] != p1whiteFigure() || takeRow == putRow && takeColumn == putColumn)
            return false;
        if (!wkIsMoved && !p1KingChecked(chessBoard)) {
            if (putRow == 1 && takeRow == 1 && takeColumn - putColumn == 2 && chessBoard[1][1] == "w.R") {
                while (takeColumn > 2) {
                    takeColumn--;
                    if (chessBoard[1][takeColumn] != null) {
                        System.out.println("P1, Invalid move");
                        return false;
                    }
                }
                chessBoard[1][putColumn + 1] = chessBoard[1][takeColumn];
                chessBoard[1][takeColumn] = null;
                if (p1KingChecked(chessBoard)) {
                    System.out.println("P1, Please Be Observant And Check Your King's Position...");
                    chessBoard[1][takeColumn] = p1whiteFigure();
                    chessBoard[1][putColumn + 1] = null;
                    return false;
                }
                chessBoard[1][putColumn] = chessBoard[1][putColumn + 1];
                chessBoard[1][putColumn + 1] = null;
                if (p1KingChecked(chessBoard)) {
                    System.out.println("P1, Please Be Observant And Check Your King's Position...");
                    chessBoard[1][takeColumn] = p1whiteFigure();
                    chessBoard[1][putColumn] = null;
                    return false;
                }
                chessBoard[1][takeColumn] = p1whiteFigure();
                chessBoard[1][putColumn] = null;
                return true;
            } else if (putRow == 1 && takeRow == 1 && takeColumn - putColumn == -2 && chessBoard[1][8] == "w.R") {
                while (takeColumn < 7) {
                    takeColumn++;
                    if (chessBoard[1][takeColumn] != null) {
                        System.out.println("P1, Invalid move");
                        return false;
                    }
                }
                chessBoard[1][putColumn - 1] = chessBoard[takeRow][takeColumn];
                chessBoard[takeRow][takeColumn] = null;
                if (p1KingChecked(chessBoard)) {
                    System.out.println("P1, Please Be Observant And Check Your King's Position...");
                    chessBoard[1][takeColumn] = p1whiteFigure();
                    chessBoard[1][putColumn] = null;
                    return false;
                }
                chessBoard[1][putColumn] = chessBoard[1][putColumn - 1];
                chessBoard[1][putColumn - 1] = null;
                if (p1KingChecked(chessBoard)) {
                    System.out.println("P1, Please Be Observant And Check Your King's Position...");
                    chessBoard[1][takeColumn] = p1whiteFigure();
                    chessBoard[1][putColumn] = null;
                    return false;
                }
                chessBoard[1][takeColumn] = p1whiteFigure();
                chessBoard[1][putColumn] = null;
                return true;
            }
        }
        if (takeRow - putRow == -1 || takeRow - putRow == 1 || takeRow == putRow) {
            if (takeColumn - putColumn == -1 || takeColumn - putColumn == 1 || takeColumn == putColumn) {
                if (chessBoard[putRow][putColumn] == null) {
                    Object mover = chessBoard[putRow][putColumn];
                    chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                    chessBoard[takeRow][takeColumn] = null;

                    if (p2KingChecked(chessBoard)) {
                        System.out.println("P2, Please Be Observant And Check Your King's Position...");
                        chessBoard[takeRow][takeColumn] = p2blackFigure();
                        chessBoard[putRow][putColumn] = mover;
                        return false;
                    }
                    chessBoard[takeRow][takeColumn] = p2blackFigure();
                    chessBoard[putRow][putColumn] = mover;
                    return true;
                }else if (chessBoard[putRow][putColumn].toString().charAt(0)=='w'){
                    Object mover = chessBoard[putRow][putColumn];
                    chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                    chessBoard[takeRow][takeColumn] = null;

                    if (p2KingChecked(chessBoard)) {
                        System.out.println("P2, Please Be Observant And Check Your King's Position...");
                        chessBoard[takeRow][takeColumn] = p2blackFigure();
                        chessBoard[putRow][putColumn] = mover;
                        return false;
                    }
                    chessBoard[takeRow][takeColumn] = p2blackFigure();
                    chessBoard[putRow][putColumn] = mover;
                    return true;
                }
            }
        }
        return false;
    }

    boolean p2checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (chessBoard[takeRow][takeColumn] != p2blackFigure() || takeRow == putRow && takeColumn == putColumn) {
            System.out.println("P2, Invalid move");
            return false;
        }
        if (!bkIsMoved && !p2KingChecked(chessBoard)) {
            if (putRow == 8 && takeRow == 8 && takeColumn - putColumn == 2 && chessBoard[8][1] == "b.R") {
                while (takeColumn > 2) {
                    takeColumn--;
                    if (chessBoard[8][takeColumn] != null) {
                        System.out.println("P2, Invalid move");
                        return false;
                    }
                }
                chessBoard[8][putColumn + 1] = chessBoard[8][takeColumn];
                chessBoard[8][takeColumn] = null;
                if (p2KingChecked(chessBoard)) {
                    System.out.println("P2, Please Be Observant And Check Your King's Position...");
                    chessBoard[8][takeColumn] = p2blackFigure();
                    chessBoard[8][putColumn + 1] = null;
                    return false;
                }
                chessBoard[8][putColumn] = chessBoard[8][putColumn + 1];
                chessBoard[8][putColumn + 1] = null;
                if (p2KingChecked(chessBoard)) {
                    System.out.println("P2, Please Be Observant And Check Your King's Position...");
                    chessBoard[8][takeColumn] = p2blackFigure();
                    chessBoard[8][putColumn] = null;
                    return false;
                }
                chessBoard[8][takeColumn] = p2blackFigure();
                chessBoard[8][putColumn] = null;
                return true;
            } else if (putRow == 8 && takeRow == 8 && takeColumn - putColumn == -2 && chessBoard[8][8] == "b.R") {
                while (takeColumn < 7) {
                    takeColumn++;
                    if (chessBoard[8][takeColumn] != null) {
                        System.out.println("P2, Invalid move");
                        return false;
                    }
                }
                chessBoard[8][putColumn - 1] = chessBoard[takeRow][takeColumn];
                chessBoard[takeRow][takeColumn] = null;
                if (p2KingChecked(chessBoard)) {
                    System.out.println("P2, Please Be Observant And Check Your King's Position...");
                    chessBoard[8][takeColumn] = p2blackFigure();
                    chessBoard[8][putColumn] = null;
                    return false;
                }
                chessBoard[8][putColumn] = chessBoard[8][putColumn - 1];
                chessBoard[8][putColumn - 1] = null;
                if (p2KingChecked(chessBoard)) {
                    System.out.println("P2, Please Be Observant And Check Your King's Position...");
                    chessBoard[8][takeColumn] = p2blackFigure();
                    chessBoard[8][putColumn] = null;
                    return false;
                }
                chessBoard[8][takeColumn] = p2blackFigure();
                chessBoard[8][putColumn] = null;
                return true;
            }
        }
        if (takeRow - putRow == -1 || takeRow - putRow == 1 || takeRow == putRow) {
            if (takeColumn - putColumn == -1 || takeColumn - putColumn == 1 || takeColumn == putColumn) {
                if (chessBoard[putRow][putColumn] == null || chessBoard[putRow][putColumn].toString().charAt(0) == 'w') {
                    Object mover = chessBoard[putRow][putColumn];
                    chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                    chessBoard[takeRow][takeColumn] = null;
                    if (p2KingChecked(chessBoard)) {
                        System.out.println("P2, Please Be Observant And Check Your King's Position...");
                        chessBoard[putRow][putColumn] = mover;
                        chessBoard[takeRow][takeColumn] = p2blackFigure();
                        return false;
                    }
                    chessBoard[putRow][putColumn] = mover;
                    chessBoard[takeRow][takeColumn] = p2blackFigure();
                    return true;
                }
            }
        }
        return false;
    }

    boolean p1KingChecked(Object[][] chessBoard) {
        int i = 0;
        int j;
        while (i < chessBoard.length - 2) {
            i++;
            j = 0;
            while (j < chessBoard[1].length - 2) {
                j++;
                if (chessBoard[i][j] == "w.K") {
                    int row = i;
                    int column = j;
                    try {
                        if (chessBoard[row + 1][column + 1] == "b.P")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row + 1][column - 1] == "b.P")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row + 1][column + 2] == "bKn")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row + 1][column - 2] == "bKn")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row + 2][column + 1] == "bKn")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row + 2][column - 1] == "bKn")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row - 1][column + 2] == "bKn")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row - 1][column - 2] == "bKn")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row - 2][column + 1] == "bKn")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row - 2][column - 1] == "bKn")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row + 1][column + 1] == "b.K")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row + 1][column] == "b.K")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row + 1][column - 1] == "b.K")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row][column - 1] == "b.K")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row - 1][column - 1] == "b.K")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row - 1][column] == "b.K")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row - 1][column + 1] == "b.K")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row][column + 1] == "b.K")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        do {
                            row++;
                            column++;
                            if (chessBoard[row][column] == "bbB" || chessBoard[row][column] == "bwB" || chessBoard[row][column] == "b.Q")
                                return true;
                        } while (chessBoard[row][column] == null);
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    row = i;
                    column = j;

                    try {
                        do {
                            row--;
                            column--;
                            if (chessBoard[row][column] == "bbB" || chessBoard[row][column] == "bwB" || chessBoard[row][column] == "b.Q")
                                return true;
                        } while (chessBoard[row][column] == null);
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    row = i;
                    column = j;

                    try {
                        do {
                            row--;
                            column++;
                            if (chessBoard[row][column] == "bbB" || chessBoard[row][column] == "bwB" || chessBoard[row][column] == "b.Q")
                                return true;
                        } while (chessBoard[row][column] == null);
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    row = i;
                    column = j;

                    try {
                        do {
                            row++;
                            column--;
                            if (chessBoard[row][column] == "bbB" || chessBoard[row][column] == "bwB" || chessBoard[row][column] == "b.Q")
                                return true;
                        } while (chessBoard[row][column] == null);
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    row = i;
                    column = j;

                    try {
                        do {
                            row++;
                            if (chessBoard[row][column] == "b.R" || chessBoard[row][column] == "b.r" || chessBoard[row][column] == "b.Q")
                                return true;
                        } while (chessBoard[row][column] == null);
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    row = i;

                    try {
                        do {
                            row--;
                            if (chessBoard[row][column] == "b.R" || chessBoard[row][column] == "b.r" || chessBoard[row][column] == "b.Q")
                                return true;
                        } while (chessBoard[row][column] == null);
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    row = i;

                    try {
                        do {
                            column++;
                            if (chessBoard[row][column] == "b.R" || chessBoard[row][column] == "b.r" || chessBoard[row][column] == "b.Q")
                                return true;
                        } while (chessBoard[row][column] == null);
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    column = j;

                    try {
                        do {
                            column--;
                            if (chessBoard[row][column] == "b.R" || chessBoard[row][column] == "b.r" || chessBoard[row][column] == "b.Q")
                                return true;
                        } while (chessBoard[row][column] == null);
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    return false;
                }
            }
        }
        return false;
    }

    boolean p2KingChecked(Object[][] chessBoard) {
        int i = 9;
        int j;
        while (i > 1) {
            i--;
            j = 0;
            while (j < chessBoard[1].length - 2) {
                j++;
                if (chessBoard[i][j] == "b.K") {
                    int row = i;
                    int column = j;
                    try {
                        if (chessBoard[row - 1][column - 1] == "w.P")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row - 1][column + 1] == "w.P")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row + 1][column + 2] == "wKn")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row + 1][column - 2] == "wKn")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row + 2][column + 1] == "wKn")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row + 2][column - 1] == "wKn")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row - 1][column + 2] == "wKn")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row - 1][column - 2] == "wKn")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row - 2][column + 1] == "wKn")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row - 2][column - 1] == "wKn")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row + 1][column + 1] == "w.K")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row + 1][column] == "w.K")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row + 1][column - 1] == "w.K")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row][column - 1] == "w.K")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row - 1][column - 1] == "w.K")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row - 1][column] == "w.K")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row - 1][column + 1] == "w.K")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[row][column + 1] == "w.K")
                            return true;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        do {
                            row++;
                            column++;
                            if (chessBoard[row][column] == "wbB" || chessBoard[row][column] == "wwB" || chessBoard[row][column] == "w.Q")
                                return true;
                        } while (chessBoard[row][column] == null);
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    row = i;
                    column = j;

                    try {
                        do {
                            row++;
                            if (chessBoard[row][column] == "w.R" || chessBoard[row][column] == "w.r" || chessBoard[row][column] == "w.Q")
                                return true;

                        } while (chessBoard[row][column] == null);
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    row = i;

                    try {
                        do {
                            row--;
                            column--;
                            if (chessBoard[row][column] == "wbB" || chessBoard[row][column] == "wwB" || chessBoard[row][column] == "w.Q")
                                return true;
                        } while (chessBoard[row][column] == null);
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    row = i;
                    column = j;

                    try {
                        do {
                            row--;
                            if (chessBoard[row][column] == "w.R" || chessBoard[row][column] == "w.r" || chessBoard[row][column] == "w.Q")
                                return true;
                        } while (chessBoard[row][column] == null);
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    row = i;

                    try {
                        do {
                            column++;
                            if (chessBoard[row][column] == "w.R" || chessBoard[row][column] == "w.r" || chessBoard[row][column] == "w.Q")
                                return true;
                        } while (chessBoard[row][column] == null);
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    column = j;

                    try {
                        do {
                            column--;
                            if (chessBoard[row][column] == "w.R" || chessBoard[row][column] == "w.r" || chessBoard[row][column] == "w.Q")
                                return true;
                        } while (chessBoard[row][column] == null);
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    column = j;

                    try {
                        do {
                            row--;
                            column++;
                            if (chessBoard[row][column] == "wbB" || chessBoard[row][column] == "wwB" || chessBoard[row][column] == "w.Q")
                                return true;
                        } while (chessBoard[row][column] == null);
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    row = i;
                    column = j;

                    try {
                        do {
                            row++;
                            column--;
                            if (chessBoard[row][column] == "wbB" || chessBoard[row][column] == "wwB" || chessBoard[row][column] == "w.Q")
                                return true;
                        } while (chessBoard[row][column] == null);
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    return false;
                }
            }
        }
        return false;
    }

    boolean p1NoMoves(Object[][] chessBoard) {
        Object mover;
        for (int i = 1; i < chessBoard.length - 1; i++) {
            for (int j = 1; j < chessBoard[i].length - 1; j++) {
                if ((chessBoard[i][j] == "w.K")) {
                    try {
                        mover = chessBoard[i + 1][j];
                        if (mover == null || mover.toString().charAt(0) == 'b') {
                            chessBoard[i + 1][j] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p1KingChecked(chessBoard)) {
                                chessBoard[i][j] = p1whiteFigure();
                                chessBoard[i + 1][j] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p1whiteFigure();
                        chessBoard[i + 1][j] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        mover = chessBoard[i + 1][j - 1];
                        if (mover == null || mover.toString().charAt(0) == 'b') {
                            chessBoard[i + 1][j - 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p1KingChecked(chessBoard)) {
                                chessBoard[i][j] = p1whiteFigure();
                                chessBoard[i + 1][j - 1] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p1whiteFigure();
                        chessBoard[i + 1][j - 1] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        mover = chessBoard[i + 1][j + 1];
                        if (mover == null || mover.toString().charAt(0) == 'b') {
                            chessBoard[i + 1][j + 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p1KingChecked(chessBoard)) {
                                chessBoard[i][j] = p1whiteFigure();
                                chessBoard[i + 1][j + 1] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p1whiteFigure();
                        chessBoard[i + 1][j + 1] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        mover = chessBoard[i][j - 1];
                        if (mover == null || mover.toString().charAt(0) == 'b') {
                            chessBoard[i][j - 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p1KingChecked(chessBoard)) {
                                chessBoard[i][j] = p1whiteFigure();
                                chessBoard[i][j - 1] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p1whiteFigure();
                        chessBoard[i][j - 1] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        mover = chessBoard[i][j + 1];
                        if (mover == null || mover.toString().charAt(0) == 'b') {
                            chessBoard[i][j + 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p1KingChecked(chessBoard)) {
                                chessBoard[i][j] = p1whiteFigure();
                                chessBoard[i][j + 1] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p1whiteFigure();
                        chessBoard[i][j + 1] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        mover = chessBoard[i - 1][j - 1];
                        if (mover == null || mover.toString().charAt(0) == 'b') {
                            chessBoard[i - 1][j - 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p1KingChecked(chessBoard)) {
                                chessBoard[i][j] = p1whiteFigure();
                                chessBoard[i - 1][j - 1] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p1whiteFigure();
                        chessBoard[i - 1][j - 1] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        mover = chessBoard[i - 1][j];
                        if (mover == null || mover.toString().charAt(0) == 'b') {
                            chessBoard[i - 1][j] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p1KingChecked(chessBoard)) {
                                chessBoard[i][j] = p1whiteFigure();
                                chessBoard[i - 1][j] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p1whiteFigure();
                        chessBoard[i - 1][j] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        mover = chessBoard[i - 1][j + 1];
                        if (mover == null || mover.toString().charAt(0) == 'b') {
                            chessBoard[i - 1][j + 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p1KingChecked(chessBoard)) {
                                chessBoard[i][j] = p1whiteFigure();
                                chessBoard[i - 1][j + 1] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p1whiteFigure();
                        chessBoard[i - 1][j + 1] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    return true;
                }
            }
        }
        return true;
    }

    boolean p2NoMoves(Object[][] chessBoard) {
        Object mover;
        for (int i = chessBoard.length - 2; i > 0; i--) {
            for (int j = 0; j < chessBoard[i].length - 1; j++) {
                if ((chessBoard[i][j] == "b.K")) {
                    try {
                        mover = chessBoard[i + 1][j];
                        if (mover == null || mover.toString().charAt(0) == 'w') {
                            chessBoard[i + 1][j] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p2KingChecked(chessBoard)) {
                                chessBoard[i][j] = p2blackFigure();
                                chessBoard[i + 1][j] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p2blackFigure();
                        chessBoard[i + 1][j] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        mover = chessBoard[i + 1][j - 1];
                        if (mover == null || mover.toString().charAt(0) == 'w') {
                            chessBoard[i + 1][j - 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p2KingChecked(chessBoard)) {
                                chessBoard[i][j] = p2blackFigure();
                                chessBoard[i + 1][j - 1] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p2blackFigure();
                        chessBoard[i + 1][j - 1] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        mover = chessBoard[i + 1][j + 1];
                        if (mover == null || mover.toString().charAt(0) == 'w') {
                            chessBoard[i + 1][j + 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p2KingChecked(chessBoard)) {
                                chessBoard[i][j] = p2blackFigure();
                                chessBoard[i + 1][j + 1] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p2blackFigure();
                        chessBoard[i + 1][j + 1] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        mover = chessBoard[i][j - 1];
                        if (mover == null || mover.toString().charAt(0) == 'w') {
                            chessBoard[i][j - 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p2KingChecked(chessBoard)) {
                                chessBoard[i][j] = p2blackFigure();
                                chessBoard[i][j - 1] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p2blackFigure();
                        chessBoard[i][j - 1] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        mover = chessBoard[i][j + 1];
                        if (mover == null || mover.toString().charAt(0) == 'w') {
                            chessBoard[i][j + 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p2KingChecked(chessBoard)) {
                                chessBoard[i][j] = p2blackFigure();
                                chessBoard[i][j + 1] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p2blackFigure();
                        chessBoard[i][j + 1] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        mover = chessBoard[i - 1][j - 1];
                        if (mover == null || mover.toString().charAt(0) == 'w') {
                            chessBoard[i - 1][j - 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p2KingChecked(chessBoard)) {
                                chessBoard[i][j] = p2blackFigure();
                                chessBoard[i - 1][j - 1] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p2blackFigure();
                        chessBoard[i - 1][j - 1] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        mover = chessBoard[i - 1][j];
                        if (mover == null || mover.toString().charAt(0) == 'w') {
                            chessBoard[i - 1][j] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p2KingChecked(chessBoard)) {
                                chessBoard[i][j] = p2blackFigure();
                                chessBoard[i - 1][j] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p2blackFigure();
                        chessBoard[i - 1][j] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        mover = chessBoard[i - 1][j + 1];
                        if (mover == null || mover.toString().charAt(0) == 'w') {
                            chessBoard[i - 1][j + 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p2KingChecked(chessBoard)) {
                                chessBoard[i][j] = p2blackFigure();
                                chessBoard[i - 1][j + 1] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p2blackFigure();
                        chessBoard[i - 1][j + 1] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    return true;
                }
            }
        }
        return true;
    }

    boolean p1Mated(Object[][] chessBoard) {
        Figure rook = new Rook();
        Figure knight = new Knight();
        Figure bishop = new Bishop();
        Figure queen = new Queen();
        Figure pawn = new Pawn();
        if (p1KingChecked(chessBoard) && p1NoMoves(chessBoard)) {
            return !rook.p1CoverCheck(chessBoard) && !bishop.p1CoverCheck(chessBoard) && !queen.p1CoverCheck(chessBoard) && !knight.p1CoverCheck(chessBoard) && !pawn.p1CoverCheck(chessBoard);
        }
        return false;
    }

    boolean p2Mated(Object[][] chessBoard) {
        Figure rook = new Rook();
        Figure knight = new Knight();
        Figure bishop = new Bishop();
        Figure queen = new Queen();
        Figure pawn = new Pawn();
        if (p2KingChecked(chessBoard) && p2NoMoves(chessBoard)) {
            return !rook.p2CoverCheck(chessBoard) && !bishop.p2CoverCheck(chessBoard) && !queen.p2CoverCheck(chessBoard) && !knight.p2CoverCheck(chessBoard) && !pawn.p2CoverCheck(chessBoard);
        }
        return false;
    }

    boolean p1StaleMate(Object[][] chessBoard) {
        Figure rook = new Rook();
        Figure knight = new Knight();
        Figure bishop = new Bishop();
        Figure queen = new Queen();
        Figure pawn = new Pawn();
        if (!p1KingChecked(chessBoard) && p1NoMoves(chessBoard))
            return rook.p1NoMoves(chessBoard) && bishop.p1NoMoves(chessBoard) && knight.p1NoMoves(chessBoard) && pawn.p1NoMoves(chessBoard) && queen.p1NoMoves(chessBoard);
        return false;
    }

    boolean p2StaleMate(Object[][] chessBoard) {
        Figure rook = new Rook();
        Figure knight = new Knight();
        Figure bishop = new Bishop();
        Figure queen = new Queen();
        Figure pawn = new Pawn();
        if (!p2KingChecked(chessBoard) && p2NoMoves(chessBoard))
            return rook.p2NoMoves(chessBoard) && bishop.p2NoMoves(chessBoard) && knight.p2NoMoves(chessBoard) && pawn.p2NoMoves(chessBoard) && queen.p2NoMoves(chessBoard);
        return false;
    }
}

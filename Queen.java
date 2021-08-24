package com.company;

public class Queen extends Figure {
    private final Object p1figureName = "w.Q";
    private final Object p2figureName = "b.Q";

    public Object p1whiteFigure() {
        return p1figureName;
    }

    public Object p2blackFigure() {
        return p2figureName;
    }

    void p1moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
        chessBoard[takeRow][takeColumn] = null;
    }

    void p2moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
        chessBoard[takeRow][takeColumn] = null;
    }

    boolean p1checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        King king = new King();
        int i = takeRow;
        int j = takeColumn;
        if (chessBoard[takeRow][takeColumn] != p1whiteFigure() || takeRow == putRow && takeColumn == putColumn)
            return super.p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
        if (takeRow == putRow) {
            if (putColumn > takeColumn) {
                while (takeColumn < putColumn - 1) {
                    takeColumn++;
                    if (chessBoard[putRow][takeColumn] != null)
                        return super.p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
            } else {
                while (takeColumn > putColumn + 1) {
                    takeColumn--;
                    if (chessBoard[putRow][takeColumn] != null)
                        return super.p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
            }
        } else if (takeColumn == putColumn) {
            if (putRow > takeRow) {
                while (takeRow < putRow - 1) {
                    takeRow++;
                    if (chessBoard[takeRow][putColumn] != null)
                        return super.p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
            } else {
                while (takeRow > putRow + 1) {
                    takeRow--;
                    if (chessBoard[takeRow][putColumn] != null)
                        return super.p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
            }
        } else if (putRow > takeRow && putColumn > takeColumn) {
            while (takeRow < putRow - 1 && takeColumn < putColumn - 1) {
                takeRow++;
                takeColumn++;
                if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                    return super.p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
            }
        } else if (putRow > takeRow) {
            while (takeRow < putRow - 1 && takeColumn > putColumn + 1) {
                takeRow++;
                takeColumn--;
                if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                    return super.p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
            }
        } else if (putColumn < takeColumn) {
            while (takeRow > putRow + 1 && takeColumn > putColumn + 1) {
                takeRow--;
                takeColumn--;
                if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                    return super.p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
            }
        } else {
            while (takeRow > putRow + 1 && takeColumn < putColumn - 1) {
                takeRow--;
                takeColumn++;
                if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                    return super.p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
            }
        }
        if (chessBoard[putRow][putColumn] == null) {
            Object mover = chessBoard[putRow][putColumn];
            chessBoard[putRow][putColumn] = chessBoard[i][j];
            chessBoard[i][j] = null;

            if (king.p1KingChecked(chessBoard)) {
                System.out.println("\n"+"P1, Please Be Observant And Check Your King's Position...");
                chessBoard[i][j] = p1whiteFigure();
                chessBoard[putRow][putColumn] = mover;
                return super.p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
            }
            chessBoard[i][j] = p1whiteFigure();
            chessBoard[putRow][putColumn] = mover;
            return true;
        }else if (chessBoard[putRow][putColumn].toString().charAt(0)=='b'){
            Object mover = chessBoard[putRow][putColumn];
            chessBoard[putRow][putColumn] = chessBoard[i][j];
            chessBoard[i][j] = null;

            if (king.p1KingChecked(chessBoard)) {
                System.out.println("\n"+"P1, Please Be Observant And Check Your King's Position...");
                chessBoard[i][j] = p1whiteFigure();
                chessBoard[putRow][putColumn] = mover;
                return super.p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
            }
            chessBoard[i][j] = p1whiteFigure();
            chessBoard[putRow][putColumn] = mover;
            return true;
        }
        return super.p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
    }

    boolean p2checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        King king = new King();
        int i = takeRow;
        int j = takeColumn;
        if (chessBoard[takeRow][takeColumn] != p2blackFigure() || takeRow == putRow && takeColumn == putColumn)
            return super.p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
        if (takeRow == putRow) {
            if (putColumn > takeColumn) {
                while (takeColumn < putColumn - 1) {
                    takeColumn++;
                    if (chessBoard[putRow][takeColumn] != null)
                        return super.p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
            } else {
                while (takeColumn > putColumn + 1) {
                    takeColumn--;
                    if (chessBoard[putRow][takeColumn] != null)
                        return super.p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
            }
        } else if (takeColumn == putColumn) {
            if (putRow > takeRow) {
                while (takeRow < putRow - 1) {
                    takeRow++;
                    if (chessBoard[takeRow][putColumn] != null)
                        return super.p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
            } else {
                while (takeRow > putRow + 1) {
                    takeRow--;
                    if (chessBoard[takeRow][putColumn] != null)
                        return super.p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
            }
        } else if (putRow > takeRow && putColumn > takeColumn) {
            while (takeRow < putRow - 1 && takeColumn < putColumn - 1) {
                takeRow++;
                takeColumn++;
                if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                    return super.p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
            }
        } else if (putRow > takeRow) {
            while (takeRow < putRow - 1 && takeColumn > putColumn + 1) {
                takeRow++;
                takeColumn--;
                if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                    return super.p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
            }
        } else if (putColumn < takeColumn) {
            while (takeRow > putRow + 1 && takeColumn > putColumn + 1) {
                takeRow--;
                takeColumn--;
                if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                    return super.p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
            }
        } else {
            while (takeRow > putRow + 1 && takeColumn < putColumn - 1) {
                takeRow--;
                takeColumn++;
                if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                    return super.p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
            }
        }
        if (chessBoard[putRow][putColumn] == null) {
            Object mover = chessBoard[putRow][putColumn];
            chessBoard[putRow][putColumn] = chessBoard[i][j];
            chessBoard[i][j] = null;

            if (king.p2KingChecked(chessBoard)) {
                System.out.println("\n"+"P2, Please Be Observant And Check Your King's Position...");
                chessBoard[i][j] = p2blackFigure();
                chessBoard[putRow][putColumn] = mover;
                return super.p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
            }
            chessBoard[i][j] = p2blackFigure();
            chessBoard[putRow][putColumn] = mover;
            return true;
        }else if (chessBoard[putRow][putColumn].toString().charAt(0)=='w'){
            Object mover = chessBoard[putRow][putColumn];
            chessBoard[putRow][putColumn] = chessBoard[i][j];
            chessBoard[i][j] = null;

            if (king.p2KingChecked(chessBoard)) {
                System.out.println("\n"+"P2, Please Be Observant And Check Your King's Position...");
                chessBoard[i][j] = p2blackFigure();
                chessBoard[putRow][putColumn] = mover;
                return super.p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
            }
            chessBoard[i][j] = p2blackFigure();
            chessBoard[putRow][putColumn] = mover;
            return true;
        }
        return super.p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
    }

    boolean p1NoMoves(Object[][] chessBoard) {
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                if (chessBoard[i][j] == "w.Q") {
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
                    try {
                        if (chessBoard[i + 1][j - 1] == null || chessBoard[i + 1][j].toString().charAt(0) == 'b')
                            return false;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[i + 1][j + 1] == null || chessBoard[i - 1][j].toString().charAt(0) == 'b')
                            return false;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[i - 1][j + 1] == null || chessBoard[i][j - 1].toString().charAt(0) == 'b')
                            return false;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[i - 1][j - 1] == null || chessBoard[i][j - 1].toString().charAt(0) == 'b')
                            return false;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                }
            }
        }
        return super.p1NoMoves(chessBoard);
    }

    boolean p2NoMoves(Object[][] chessBoard) {
        for (int i = chessBoard.length - 1; i >= 0; i--) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                if (chessBoard[i][j] == "b.Q") {
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
                    try {
                        if (chessBoard[i + 1][j - 1] == null || chessBoard[i + 1][j].toString().charAt(0) == 'w')
                            return false;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[i + 1][j + 1] == null || chessBoard[i - 1][j].toString().charAt(0) == 'w')
                            return false;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[i - 1][j + 1] == null || chessBoard[i][j - 1].toString().charAt(0) == 'w')
                            return false;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (chessBoard[i - 1][j - 1] == null || chessBoard[i][j - 1].toString().charAt(0) == 'w')
                            return false;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                }
            }
        }
        return super.p2NoMoves(chessBoard);
    }

    boolean p1CoverCheck(Object[][] chessBoard) {
        King king = new King();
        Object mover;
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                if (chessBoard[i][j] == "w.Q") {
                    try {
                        int row = i;
                        int column = j;
                        while (true) {
                            row++;
                            column++;
                            mover = chessBoard[row][column];
                            if (chessBoard[row][column] == null) {
                                chessBoard[row][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p1KingChecked(chessBoard)) {
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = p1whiteFigure();
                                    else
                                        chessBoard[i][j] = p1blackFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                } else {
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = p1whiteFigure();
                                    else
                                        chessBoard[i][j] = p1blackFigure();
                                    chessBoard[row][column] = mover;
                                }
                            } else if (chessBoard[row][column].toString().charAt(0) == 'b') {
                                chessBoard[row][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p1KingChecked(chessBoard)) {
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = p1whiteFigure();
                                    else
                                        chessBoard[i][j] = p1blackFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                }
                                if ((i + j) % 2 == 0)
                                    chessBoard[i][j] = p1whiteFigure();
                                else
                                    chessBoard[i][j] = p1blackFigure();
                                chessBoard[row][column] = mover;
                                break;
                            } else
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        int row = i;
                        int column = j;
                        while (true) {
                            row++;
                            column--;
                            mover = chessBoard[row][column];
                            if (chessBoard[row][column] == null) {
                                chessBoard[row][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p1KingChecked(chessBoard)) {
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = p1whiteFigure();
                                    else
                                        chessBoard[i][j] = p1blackFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                } else {
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = p1whiteFigure();
                                    else
                                        chessBoard[i][j] = p1blackFigure();
                                    chessBoard[row][column] = mover;
                                }
                            } else if (chessBoard[row][column].toString().charAt(0) == 'b') {
                                chessBoard[row][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p1KingChecked(chessBoard)) {
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = p1whiteFigure();
                                    else
                                        chessBoard[i][j] = p1blackFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                }
                                if ((i + j) % 2 == 0)
                                    chessBoard[i][j] = p1whiteFigure();
                                else
                                    chessBoard[i][j] = p1blackFigure();
                                chessBoard[row][column] = mover;
                                break;
                            } else
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        int row = i;
                        int column = j;
                        while (true) {
                            row--;
                            column++;
                            mover = chessBoard[row][column];
                            if (chessBoard[row][column] == null) {
                                chessBoard[row][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p1KingChecked(chessBoard)) {
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = p1whiteFigure();
                                    else
                                        chessBoard[i][j] = p1blackFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                } else {
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = p1whiteFigure();
                                    else
                                        chessBoard[i][j] = p1blackFigure();
                                    chessBoard[row][column] = mover;
                                }
                            } else if (chessBoard[row][column].toString().charAt(0) == 'b') {
                                chessBoard[row][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p1KingChecked(chessBoard)) {
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = p1whiteFigure();
                                    else
                                        chessBoard[i][j] = p1blackFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                }
                                if ((i + j) % 2 == 0)
                                    chessBoard[i][j] = p1whiteFigure();
                                else
                                    chessBoard[i][j] = p1blackFigure();
                                chessBoard[row][column] = mover;
                                break;
                            } else
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        int row = i;
                        int column = j;
                        while (true) {
                            row--;
                            column--;
                            mover = chessBoard[row][column];
                            if (chessBoard[row][column] == null) {
                                chessBoard[row][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p1KingChecked(chessBoard)) {
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = p1whiteFigure();
                                    else
                                        chessBoard[i][j] = p1blackFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                } else {
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = p1whiteFigure();
                                    else
                                        chessBoard[i][j] = p1blackFigure();
                                    chessBoard[row][column] = mover;
                                }
                            } else if (chessBoard[row][column].toString().charAt(0) == 'b') {
                                chessBoard[row][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p1KingChecked(chessBoard)) {
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = p1whiteFigure();
                                    else
                                        chessBoard[i][j] = p1blackFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                }
                                if ((i + j) % 2 == 0)
                                    chessBoard[i][j] = p1whiteFigure();
                                else
                                    chessBoard[i][j] = p1blackFigure();
                                chessBoard[row][column] = mover;
                                break;
                            } else
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        int row = i;
                        while (row < chessBoard.length - 1) {
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
                        while (row > 0) {
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
                        while (column < chessBoard.length - 1) {
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
                        while (column > 0) {
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
        return super.p1CoverCheck(chessBoard);
    }

    boolean p2CoverCheck(Object[][] chessBoard) {
        King king = new King();
        Object mover;
        for (int i = chessBoard.length - 1; i >= 0; i--) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                if (chessBoard[i][j] == "b.Q") {
                    try {
                        int row = i;
                        int column = j;
                        while (true) {
                            row++;
                            column++;
                            mover = chessBoard[row][column];
                            if (chessBoard[row][column] == null) {
                                chessBoard[row][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p2KingChecked(chessBoard)) {
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = p2whiteFigure();
                                    else
                                        chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                } else {
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = p2whiteFigure();
                                    else
                                        chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][column] = mover;
                                }
                            } else if (chessBoard[row][column].toString().charAt(0) == 'w') {
                                chessBoard[row][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p2KingChecked(chessBoard)) {
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = p2whiteFigure();
                                    else
                                        chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                }
                                if ((i + j) % 2 == 0)
                                    chessBoard[i][j] = p2whiteFigure();
                                else
                                    chessBoard[i][j] = p2blackFigure();
                                chessBoard[row][column] = mover;
                                break;
                            } else
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        int row = i;
                        int column = j;
                        while (true) {
                            row++;
                            column--;
                            mover = chessBoard[row][column];
                            if (chessBoard[row][column] == null) {
                                chessBoard[row][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p2KingChecked(chessBoard)) {
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = p2whiteFigure();
                                    else
                                        chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                } else {
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = p2whiteFigure();
                                    else
                                        chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][column] = mover;
                                }
                            } else if (chessBoard[row][column].toString().charAt(0) == 'w') {
                                chessBoard[row][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p2KingChecked(chessBoard)) {
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = p2whiteFigure();
                                    else
                                        chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                }
                                if ((i + j) % 2 == 0)
                                    chessBoard[i][j] = p2whiteFigure();
                                else
                                    chessBoard[i][j] = p2blackFigure();
                                chessBoard[row][column] = mover;
                                break;
                            } else
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        int row = i;
                        int column = j;
                        while (true) {
                            row--;
                            column++;
                            mover = chessBoard[row][column];
                            if (chessBoard[row][column] == null) {
                                chessBoard[row][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p2KingChecked(chessBoard)) {
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = p2whiteFigure();
                                    else
                                        chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                } else {
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = p2whiteFigure();
                                    else
                                        chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][column] = mover;
                                }
                            } else if (chessBoard[row][column].toString().charAt(0) == 'w') {
                                chessBoard[row][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p2KingChecked(chessBoard)) {
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = p2whiteFigure();
                                    else
                                        chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                }
                                if ((i + j) % 2 == 0)
                                    chessBoard[i][j] = p2whiteFigure();
                                else
                                    chessBoard[i][j] = p2blackFigure();
                                chessBoard[row][column] = mover;
                                break;
                            } else
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        int row = i;
                        int column = j;
                        while (true) {
                            row--;
                            column--;
                            mover = chessBoard[row][column];
                            if (chessBoard[row][column] == null) {
                                chessBoard[row][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p2KingChecked(chessBoard)) {
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = p2whiteFigure();
                                    else
                                        chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                } else {
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = p2whiteFigure();
                                    else
                                        chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][column] = mover;
                                }
                            } else if (chessBoard[row][column].toString().charAt(0) == 'w') {
                                chessBoard[row][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p2KingChecked(chessBoard)) {
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = p2whiteFigure();
                                    else
                                        chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                }
                                if ((i + j) % 2 == 0)
                                    chessBoard[i][j] = p2whiteFigure();
                                else
                                    chessBoard[i][j] = p2blackFigure();
                                chessBoard[row][column] = mover;
                                break;
                            } else
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        int row = i;
                        while (row < chessBoard.length - 1) {
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
                        while (row > 0) {
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
                        while (column < chessBoard.length - 1) {
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
                        while (column > 0) {
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
        return super.p2CoverCheck(chessBoard);
    }
}



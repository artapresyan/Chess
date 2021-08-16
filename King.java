package com.company;

public class King extends Figure {
    private final Object p1figureName="w.K";
    private final Object p2figureName="b.K";
    private boolean wIsMoved=false;
    private boolean bIsMoved=false;
    public Object p1whiteFigure() {
        return p1figureName;
    }
    public Object p2blackFigure() {
        return p2figureName;
    }
    boolean wIsMoved() {
        return wIsMoved;
    }
    boolean bIsMoved() {
        return bIsMoved;
    }
    void p1moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
            if (putRow == 1 && takeRow == 1 && takeColumn - putColumn == 2 && chessBoard[1][1] == "w.R") {
                chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                chessBoard[putRow][putColumn + 1] = chessBoard[1][1];
                chessBoard[takeRow][takeColumn]=null;
                chessBoard[1][1] = null;
            } else if (putRow == 1 && takeRow == 1 && takeColumn - putColumn == -2 && chessBoard[1][8] == "w.R") {
                chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                chessBoard[putRow][putColumn - 1] = chessBoard[1][8];
                chessBoard[takeRow][takeColumn]=null;
                chessBoard[1][8] = null;
            } else {
                wIsMoved=true;
                chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                chessBoard[takeRow][takeColumn]=null;
            }
        } else
            System.out.println("Invalid move");
    }

    void p2moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
            if (putRow == 8 && takeRow == 8 && takeColumn - putColumn == 2 && chessBoard[8][1] == "b.R") {
                chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                chessBoard[putRow][putColumn + 1] = chessBoard[8][1];
                chessBoard[takeRow][takeColumn]=null;
                chessBoard[8][1] = null;
            } else if (putRow == 8 && takeRow == 8 && takeColumn - putColumn == -2 && chessBoard[8][8] == "b.R") {
                chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                chessBoard[putRow][putColumn - 1] = chessBoard[8][8];
                chessBoard[takeRow][takeColumn]=null;
                chessBoard[8][8] = null;
            } else if (takeRow - putRow == -1 || takeRow - putRow == 1 || takeRow == putRow) {
                if (takeColumn - putColumn == -1 || takeColumn - putColumn == 1 || takeColumn == putColumn) {
                    bIsMoved=true;
                    chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                    chessBoard[takeRow][takeColumn]=null;
                }
            }
        }else
            System.out.println("Invalid move");

    }
    boolean p1checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (chessBoard[takeRow][takeColumn]!=p1whiteFigure() || p1KingChecked(chessBoard, putRow, putColumn) || takeRow==putColumn && takeColumn==putColumn)
            return false;
        if (!wIsMoved) {
            if (putRow == 1 && takeRow == 1 && takeColumn - putColumn == 2 && chessBoard[1][1] == "w.R" && !p1KingChecked(chessBoard, putRow, putColumn +1)) {
                while (takeColumn > 2) {
                    takeColumn--;
                    if (chessBoard[1][takeColumn] != null)
                        return false;
                }
                return true;
            } else if (putRow == 1 && takeRow == 1 && takeColumn - putColumn == -2 && chessBoard[1][8] == "w.R" && !p1KingChecked(chessBoard, putRow, putColumn - 1)) {
                while (takeColumn < 7) {
                    takeColumn++;
                    if (chessBoard[1][takeColumn] != null)
                        return false;
                }
                return true;
            }
        }
        if (takeRow - putRow == -1 || takeRow - putRow == 1 || takeRow == putRow) {
            if (takeColumn - putColumn == -1 || takeColumn - putColumn == 1 || takeColumn == putColumn) {
                if (chessBoard[putRow][putColumn] == null)
                    return true;
                else
                    return chessBoard[putRow][putColumn].toString().charAt(0) == 'b';
            }
        }
        return false;
    }

    boolean p2checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (chessBoard[takeRow][takeColumn]!=p2blackFigure() || p2KingChecked(chessBoard, putRow, putColumn) || takeRow==putColumn && takeColumn==putColumn)
            return false;
        if (!bIsMoved) {
            if (putRow == 8 && takeRow == 8 && takeColumn - putColumn == 2 && chessBoard[8][1] == "b.R" && !p2KingChecked(chessBoard, putRow, putColumn + 1)) {
                while (takeColumn > 2) {
                    takeColumn--;
                    if (chessBoard[8][takeColumn] != null)
                        return false;
                }
            } else if (putRow == 8 && takeRow == 8 && takeColumn - putColumn == -2 && chessBoard[8][8] == "b.R" && !p2KingChecked(chessBoard, putRow, putColumn - 1)) {
                while (takeColumn < 7) {
                    takeColumn++;
                    if (chessBoard[8][takeColumn] != null)
                        return false;
                }
            }
            return true;
        }
        if (takeRow - putRow == -1 || takeRow - putRow == 1 || takeRow == putRow) {
            if (takeColumn - putColumn == -1 || takeColumn - putColumn == 1 || takeColumn == putColumn) {
                if (chessBoard[putRow][putColumn] == null)
                    return true;
                else
                    return chessBoard[putRow][putColumn].toString().charAt(0) == 'w';
            }
        }
        return false;
    }

    boolean p1KingChecked(Object[][] chessBoard, int Row, int Column) {
        int row = Row;
        int column = Column;
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
        }catch (ArrayIndexOutOfBoundsException ignore) {
        }
        row = Row;
        column = Column;

        try {
            do {
                row--;
                column--;
                if (chessBoard[row][column] == "bbB" || chessBoard[row][column] == "bwB" || chessBoard[row][column] == "b.Q")
                    return true;
            } while (chessBoard[row][column] == null);
        }catch (ArrayIndexOutOfBoundsException ignore) {
        }
        row = Row;
        column = Column;

        try {
            do {
                row--;
                column++;
                if (chessBoard[row][column] == "bbB" || chessBoard[row][column] == "bwB" || chessBoard[row][column] == "b.Q")
                    return true;
            } while (chessBoard[row][column] == null);
        }catch (ArrayIndexOutOfBoundsException ignore) {
        }
        row = Row;
        column = Column;

        try {
            do {
                row++;
                column--;
                if (chessBoard[row][column] == "bbB" || chessBoard[row][column] == "bwB" || chessBoard[row][column] == "b.Q")
                    return true;
            } while (chessBoard[row][column] == null);
        } catch (ArrayIndexOutOfBoundsException ignore) {
        }
        row = Row;
        column = Column;

        try {
            do {
                row++;
                if (chessBoard[row][column] == "b.R" || chessBoard[row][column] == "b.r" || chessBoard[row][column] == "b.Q")
                    return true;
            } while (chessBoard[row][column] == null);
        } catch (ArrayIndexOutOfBoundsException ignore) {
        }
        row = Row;

        try {
            do {
                row--;
                if (chessBoard[row][column] == "b.R" || chessBoard[row][column] == "b.r" || chessBoard[row][column] == "b.Q")
                    return true;
            } while (chessBoard[row][column] == null);
        }catch (ArrayIndexOutOfBoundsException ignore) {
        }
        row = Row;

        try {
            do {
                column++;
                if (chessBoard[row][column] == "b.R" || chessBoard[row][column] == "b.r" || chessBoard[row][column] == "b.Q")
                    return true;
            } while (chessBoard[row][column] == null);
        }catch (ArrayIndexOutOfBoundsException ignore) {
        }
        column = Column;

        try {
            do {
                column--;
                if (chessBoard[row][column] == "b.R" || chessBoard[row][column] == "b.r" || chessBoard[row][column] == "b.Q")
                    return true;
            } while (chessBoard[row][column] == null);
        }catch (ArrayIndexOutOfBoundsException ignore) {
        }
        return false;
    }
        boolean p2KingChecked (Object[][]chessBoard,int Row, int Column){
            int row = Row;
            int column = Column;
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
            }catch (ArrayIndexOutOfBoundsException ignore) {
            }
            try {
                if (chessBoard[row + 2][column + 1] == "wKn")
                    return true;
            }catch (ArrayIndexOutOfBoundsException ignore) {
            }
            try {
                if (chessBoard[row + 2][column - 1] == "wKn")
                    return true;
            }catch (ArrayIndexOutOfBoundsException ignore) {
            }
            try{
                if (chessBoard[row - 1][column + 2] == "wKn")
                    return true;
            }catch (ArrayIndexOutOfBoundsException ignore) {
            }
            try {
                if (chessBoard[row - 1][column - 2] == "wKn")
                    return true;
            }catch (ArrayIndexOutOfBoundsException ignore) {
            }
            try {
                if (chessBoard[row - 2][column + 1] == "wKn")
                    return true;
            }catch (ArrayIndexOutOfBoundsException ignore) {
            }
            try {
                if (chessBoard[row - 2][column - 1] == "wKn")
                    return true;
            }catch (ArrayIndexOutOfBoundsException ignore) {
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
            }catch (ArrayIndexOutOfBoundsException ignore) {
            }
            row = Row;
            column = Column;

            try {
                do {
                    row++;
                    if (chessBoard[row][column] == "w.R" || chessBoard[row][column] == "w.r" || chessBoard[row][column] == "w.Q")
                        return true;

                } while (chessBoard[row][column] == null);
            }catch (ArrayIndexOutOfBoundsException ignore) {
            }
            row = Row;

            try {
                do {
                    row--;
                    column--;
                    if (chessBoard[row][column] == "wbB" || chessBoard[row][column] == "wwB" || chessBoard[row][column] == "w.Q")
                        return true;
                } while (chessBoard[row][column] == null);
            }catch (ArrayIndexOutOfBoundsException ignore) {
            }
            row = Row;
            column = Column;

            try {
                do {
                    row--;
                    if (chessBoard[row][column] == "w.R" || chessBoard[row][column] == "w.r" || chessBoard[row][column] == "w.Q")
                        return true;
                } while (chessBoard[row][column] == null);
            }catch (ArrayIndexOutOfBoundsException ignore) {
            }
            row = Row;

            try {
                do {
                    column++;
                    if (chessBoard[row][column] == "w.R" || chessBoard[row][column] == "w.r" || chessBoard[row][column] == "w.Q")
                        return true;
                } while (chessBoard[row][column] == null);
            }catch (ArrayIndexOutOfBoundsException ignore) {
            }
            column = Column;

            try {
                do {
                    column--;
                    if (chessBoard[row][column] == "w.R" || chessBoard[row][column] == "w.r" || chessBoard[row][column] == "w.Q")
                        return true;
                } while (chessBoard[row][column] == null);
            }catch (ArrayIndexOutOfBoundsException ignore) {
            }
            column=Column;

            try {
                do {
                    row--;
                    column++;
                    if (chessBoard[row][column] == "bbB" || chessBoard[row][column] == "bwB" || chessBoard[row][column] == "b.Q")
                        return true;
                } while (chessBoard[row][column] == null);
            }catch (ArrayIndexOutOfBoundsException ignore) {
            }
            row = Row;
            column = Column;

            try {
                do {
                    row++;
                    column--;
                    if (chessBoard[row][column] == "bbB" || chessBoard[row][column] == "bwB" || chessBoard[row][column] == "b.Q")
                        return true;
                } while (chessBoard[row][column] == null);
            } catch (ArrayIndexOutOfBoundsException ignore) {
            }
            return false;
        }
    }

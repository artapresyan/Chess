package com.company;

public class Bishop extends Figure {
    private final Object p1whiteFigureName = "wwB";
    private final Object p1blackFigureName = "wbB";
    private final Object p2whiteFigureName = "bwB";
    private final Object p2blackFigureName = "bbB";
    public Object p1whiteFigure() {
        return p1whiteFigureName;
    }
    public Object p1blackFigure() {
        return p1blackFigureName;
    }
    public Object p2whiteFigure() {
        return p2whiteFigureName;
    }
    public Object p2blackFigure() {
        return p2blackFigureName;
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
        if (chessBoard[takeRow][takeColumn] != p1whiteFigure() && chessBoard[takeRow][takeColumn] != p1blackFigure() || takeRow == putRow && takeColumn == putColumn)
            return false;
        if (putRow > takeRow && putColumn > takeColumn) {
            while (takeRow < putRow - 1 && takeColumn < putColumn - 1) {
                takeRow++;
                takeColumn++;
                if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                    return false;
            }
        } else if (putRow > takeRow && putColumn < takeColumn) {
            while (takeRow < putRow - 1 && takeColumn > putColumn + 1) {
                takeRow++;
                takeColumn--;
                if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                    return false;
            }
        } else if (putRow < takeRow && putColumn < takeColumn) {
            while (takeRow > putRow + 1 && takeColumn > putColumn + 1) {
                takeRow--;
                takeColumn--;
                if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                    return false;
            }
        } else if (putRow < takeRow && putColumn > takeColumn) {
            while (takeRow > putRow + 1 && takeColumn < putColumn - 1) {
                takeRow--;
                takeColumn++;
                if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                    return false;
            }
        }
        if (chessBoard[putRow][putColumn] == null)
            return true;
        else
            return chessBoard[putRow][putColumn].toString().charAt(0) == 'b';
    }
    boolean p2checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (chessBoard[takeRow][takeColumn] != p2blackFigure() && chessBoard[takeRow][takeColumn] != p2whiteFigure() || takeRow == putRow && takeColumn == putColumn)
            return false;
        if (putRow > takeRow && putColumn > takeColumn) {
            while (takeRow < putRow - 1 && takeColumn < putColumn - 1) {
                takeRow++;
                takeColumn++;
                if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                    return false;
            }
        } else if (putRow > takeRow && putColumn < takeColumn) {
            while (takeRow < putRow - 1 && takeColumn > putColumn + 1) {
                takeRow++;
                takeColumn--;
                if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                    return false;
            }
        } else if (putRow < takeRow && putColumn < takeColumn) {
            while (takeRow > putRow + 1 && takeColumn > putColumn + 1) {
                takeRow--;
                takeColumn--;
                if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                    return false;
            }
        } else if (putRow < takeRow && putColumn > takeColumn) {
            while (takeRow > putRow + 1 && takeColumn < putColumn - 1) {
                takeRow--;
                takeColumn++;
                if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                    return false;
            }
        }
        if (chessBoard[putRow][putColumn] == null)
            return true;
        else
            return chessBoard[putRow][putColumn].toString().charAt(0) == 'w';
    }
    boolean p1NoMoves(Object[][] chessBoard) {
        for (int i = 1; i < chessBoard.length-1; i++) {
            for (int j = 1; j < chessBoard[i].length-1; j++) {
                if (chessBoard[i][j]=="wwB" || chessBoard[i][j]=="wbB"){
                    try {
                        if (chessBoard[i+1][j-1]==null || chessBoard[i+1][j].toString().charAt(0)=='b')
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (chessBoard[i+1][j+1]==null || chessBoard[i-1][j].toString().charAt(0)=='b')
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (chessBoard[i-1][j+1]==null || chessBoard[i][j-1].toString().charAt(0)=='b')
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (chessBoard[i-1][j-1]==null || chessBoard[i][j-1].toString().charAt(0)=='b')
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
                if (chessBoard[i][j]=="bwB" || chessBoard[i][j]=="bbB"){
                    try {
                        if (chessBoard[i+1][j-1]==null || chessBoard[i+1][j].toString().charAt(0)=='w')
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (chessBoard[i+1][j+1]==null || chessBoard[i-1][j].toString().charAt(0)=='w')
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (chessBoard[i-1][j+1]==null || chessBoard[i][j-1].toString().charAt(0)=='w')
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (chessBoard[i-1][j-1]==null || chessBoard[i][j-1].toString().charAt(0)=='w')
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
            for (int j = 1; j < chessBoard[i].length - 1; j++) {
                if (chessBoard[i][j] == "wwB" || chessBoard[i][j] == "wbB") {
                    try {
                        int row = i;
                        int column=j;
                        while (true) {
                            row++;
                            column++;
                            mover = chessBoard[row][column];
                            if (p1checkMove(chessBoard, i, j, row, column)) {
                                chessBoard[row][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p1KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p1whiteFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                }else {
                                    chessBoard[i][j] = p1whiteFigure();
                                    chessBoard[row][column] = mover;
                                }
                            } else
                                break;
                        }
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        int row = i;
                        int column=j;
                        while (true) {
                            row++;
                            column--;
                            mover = chessBoard[row][column];
                            if (p1checkMove(chessBoard, i, j, row, column)) {
                                chessBoard[row][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p1KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p1whiteFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                }else {
                                    chessBoard[i][j] = p1whiteFigure();
                                    chessBoard[row][column] = mover;
                                }
                            } else
                                break;
                        }
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        int row = i;
                        int column=j;
                        while (true) {
                            row--;
                            column++;
                            mover = chessBoard[row][column];
                            if (p1checkMove(chessBoard, i, j, row, column)) {
                                chessBoard[row][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p1KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p1whiteFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                }else {
                                    chessBoard[i][j] = p1whiteFigure();
                                    chessBoard[row][column] = mover;
                                }
                            } else
                                break;
                        }
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        int row = i;
                        int column=j;
                        while (true) {
                            row--;
                            column--;
                            mover = chessBoard[row][column];
                            if (p1checkMove(chessBoard, i, j, row, column)) {
                                chessBoard[row][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p1KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p1whiteFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                }else {
                                    chessBoard[i][j] = p1whiteFigure();
                                    chessBoard[row][column] = mover;
                                }
                            } else
                                break;
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
            for (int j = 1; j < chessBoard[i].length - 1; j++) {
                if (chessBoard[i][j] == "bwB" || chessBoard[i][j] == "bbB") {
                    try {
                        int row = i;
                        int column=j;
                        while (true) {
                            row++;
                            column++;
                            mover = chessBoard[row][column];
                            if (p2checkMove(chessBoard, i, j, row, column)) {
                                chessBoard[row][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p2KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                }else {
                                    chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][column] = mover;
                                }
                            } else
                                break;
                        }
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        int row = i;
                        int column=j;
                        while (true) {
                            row++;
                            column--;
                            mover = chessBoard[row][column];
                            if (p2checkMove(chessBoard, i, j, row, column)) {
                                chessBoard[row][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p2KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                }else {
                                    chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][column] = mover;
                                }
                            } else
                                break;
                        }
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        int row = i;
                        int column=j;
                        while (true) {
                            row--;
                            column++;
                            mover = chessBoard[row][column];
                            if (p2checkMove(chessBoard, i, j, row, column)) {
                                chessBoard[row][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p2KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                }else {
                                    chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][column] = mover;
                                }
                            } else
                                break;
                        }
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        int row = i;
                        int column=j;
                        while (true) {
                            row--;
                            column--;
                            mover = chessBoard[row][column];
                            if (p2checkMove(chessBoard, i, j, row, column)) {
                                chessBoard[row][column] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!king.p2KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                }else {
                                    chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][column] = mover;
                                }
                            } else
                                break;
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

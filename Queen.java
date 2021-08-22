package com.company;

public class Queen extends Figure {
    private final Object p1figureName="w.Q";
    private final Object p2figureName="b.Q";
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
        if (chessBoard[takeRow][takeColumn]!=p1whiteFigure() || takeRow==putRow && takeColumn==putColumn)
            return false;
        if (takeRow == putRow) {
            if (putColumn > takeColumn) {
                while (takeColumn < putColumn - 1) {
                    takeColumn++;
                    if (chessBoard[putRow][takeColumn] != null)
                        return false;
                }
            } else {
                while (takeColumn > putColumn + 1) {
                    takeColumn--;
                    if (chessBoard[putRow][takeColumn] != null)
                        return false;
                }
            }
        } else if (takeColumn == putColumn) {
            if (putRow > takeRow) {
                while (takeRow < putRow - 1) {
                    takeRow++;
                    if (chessBoard[takeRow][putColumn] != null)
                        return false;
                }

            } else {
                while (takeRow > putRow + 1) {
                    takeRow--;
                    if (chessBoard[takeRow][putColumn] != null)
                        return false;
                }
            }
        }else if (putRow>takeRow && putColumn>takeColumn){
            while(takeRow<putRow-1 && takeColumn<putColumn-1){
                takeRow++;
                takeColumn++;
                if (chessBoard[takeRow][takeColumn]!=null || takeRow==putRow && takeColumn!=putColumn || takeRow!=putRow && takeColumn==putColumn)
                    return false;
            }
        }else if (putRow>takeRow) {
            while (takeRow < putRow - 1 && takeColumn > putColumn + 1) {
                takeRow++;
                takeColumn--;
                if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                    return false;
            }
        }else if (putColumn<takeColumn){
            while (takeRow>putRow+1 && takeColumn>putColumn+1){
                takeRow--;
                takeColumn--;
                if (chessBoard[takeRow][takeColumn]!=null || takeRow==putRow && takeColumn!=putColumn || takeRow!=putRow && takeColumn==putColumn)
                    return false;
            }
        }else {
            while (takeRow>putRow+1 && takeColumn<putColumn-1){
                takeRow--;
                takeColumn++;
                if (chessBoard[takeRow][takeColumn]!=null || takeRow==putRow && takeColumn!=putColumn || takeRow!=putRow && takeColumn==putColumn)
                    return false;
            }
        }
        if (chessBoard[putRow][putColumn] == null)
            return true;
        else
            return chessBoard[putRow][putColumn].toString().charAt(0) == 'b';
    }
    boolean p2checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (chessBoard[takeRow][takeColumn]!=p2blackFigure() || takeRow==putRow && takeColumn==putColumn)
            return false;
        if (takeRow == putRow) {
            if (putColumn > takeColumn) {
                while (takeColumn < putColumn - 1) {
                    takeColumn++;
                    if (chessBoard[putRow][takeColumn] != null)
                        return false;
                }
            } else {
                while (takeColumn > putColumn + 1) {
                    takeColumn--;
                    if (chessBoard[putRow][takeColumn] != null)
                        return false;
                }
            }
        } else if (takeColumn == putColumn) {
            if (putRow > takeRow) {
                while (takeRow < putRow - 1) {
                    takeRow++;
                    if (chessBoard[takeRow][putColumn] != null)
                        return false;
                }
            } else {
                while (takeRow > putRow + 1) {
                    takeRow--;
                    if (chessBoard[takeRow][putColumn] !=null)
                        return false;
                }
            }
        }else  if (putRow > takeRow && putColumn > takeColumn) {
            while (takeRow < putRow - 1 && takeColumn < putColumn - 1) {
                takeRow++;
                takeColumn++;
                if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                    return false;
            }
        } else if (putRow > takeRow) {
            while (takeRow < putRow - 1 && takeColumn > putColumn + 1) {
                takeRow++;
                takeColumn--;
                if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                    return false;
            }
        } else if (putColumn < takeColumn) {
            while (takeRow > putRow + 1 && takeColumn > putColumn + 1) {
                takeRow--;
                takeColumn--;
                if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                    return false;
            }
        } else {
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
                if (chessBoard[i][j]=="w.Q"){
                    try {
                        if (chessBoard[i+1][j]==null || chessBoard[i+1][j].toString().charAt(0)=='b')
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (chessBoard[i-1][j]==null || chessBoard[i-1][j].toString().charAt(0)=='b')
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (chessBoard[i][j+1]==null || chessBoard[i][j-1].toString().charAt(0)=='b')
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (chessBoard[i][j-1]==null || chessBoard[i][j-1].toString().charAt(0)=='b')
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
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
                if (chessBoard[i][j]=="b.Q"){
                    try {
                        if (chessBoard[i+1][j]==null || chessBoard[i+1][j].toString().charAt(0)=='w')
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (chessBoard[i-1][j]==null || chessBoard[i-1][j].toString().charAt(0)=='w')
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (chessBoard[i][j+1]==null || chessBoard[i][j-1].toString().charAt(0)=='w')
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (chessBoard[i][j-1]==null || chessBoard[i][j-1].toString().charAt(0)=='w')
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
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
                if (chessBoard[i][j] == "w.Q") {
                    try {
                        int row = i;
                        while (row<chessBoard.length-2) {
                            row++;
                            mover = chessBoard[row][j];
                            if (p1checkMove(chessBoard, row - 1, j, row, j)) {
                                chessBoard[row][j] = chessBoard[row - 1][j];
                                chessBoard[row - 1][j] = null;
                                if (!king.p1KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p1whiteFigure();
                                    chessBoard[row][j] = mover;
                                    return true;
                                }
                            } else {
                                chessBoard[i][j] = p1whiteFigure();
                                chessBoard[row][j] = mover;
                                break;
                            }
                        }
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        int row = i;
                        while (row>1) {
                            row--;
                            mover = chessBoard[row][j];
                            if (p1checkMove(chessBoard, row+1, j, row, j)) {
                                chessBoard[row][j] = chessBoard[row+1][j];
                                chessBoard[row+1][j] = null;
                                if (!king.p1KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p1whiteFigure();
                                    chessBoard[row][j] = mover;
                                    return true;
                                }
                            } else {
                                chessBoard[i][j] = p1whiteFigure();
                                chessBoard[row][j] = mover;
                                break;
                            }
                        }
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        int column = j;
                        while (column<chessBoard.length-2) {
                            column++;
                            mover = chessBoard[i][column];
                            if (p1checkMove(chessBoard, i, column-1, i, column)) {
                                chessBoard[i][column] =  chessBoard[i][column-1];
                                chessBoard[i][column-1] = null;
                                if (!king.p1KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p1whiteFigure();
                                    chessBoard[i][column] = mover;
                                    return true;
                                }
                            } else {
                                chessBoard[i][j] = p1whiteFigure();
                                chessBoard[i][column] = mover;
                                break;
                            }
                        }
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        int column = j;
                        while (column>1) {
                            column--;
                            mover = chessBoard[i][column];
                            if (p1checkMove(chessBoard, i, column+1, i, column)) {
                                chessBoard[i][column] =  chessBoard[i][column+1];
                                chessBoard[i][column+1] = null;
                                if (!king.p1KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p1whiteFigure();
                                    chessBoard[i][column] = mover;
                                    return true;
                                }
                            } else {
                                chessBoard[i][j] = p1whiteFigure();
                                chessBoard[i][column] = mover;
                                break;
                            }
                        }
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        int row = i;
                        int column=j;
                        while (true) {
                            row++;
                            column++;
                            mover = chessBoard[row][column];
                            if (p1checkMove(chessBoard, row - 1, column-1, row, column)) {
                                chessBoard[row][column] = chessBoard[row - 1][column-1];
                                chessBoard[row - 1][column-1] = null;
                                if (!king.p1KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p1whiteFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                }
                            } else {
                                chessBoard[i][j] = p1whiteFigure();
                                chessBoard[row][column] = mover;
                                break;
                            }
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
                            if (p1checkMove(chessBoard, row - 1, column+1, row, column)) {
                                chessBoard[row][column] = chessBoard[row - 1][column+1];
                                chessBoard[row - 1][column+1] = null;
                                if (!king.p1KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p1whiteFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                }
                            } else {
                                chessBoard[i][j] = p1whiteFigure();
                                chessBoard[row][column] = mover;
                                break;
                            }
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
                            if (p1checkMove(chessBoard, row + 1, column-1, row, column)) {
                                chessBoard[row][column] = chessBoard[row + 1][column-1];
                                chessBoard[row + 1][column-1] = null;
                                if (!king.p1KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p1whiteFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                }
                            } else {
                                chessBoard[i][j] = p1whiteFigure();
                                chessBoard[row][column] = mover;
                                break;
                            }
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
                            if (p1checkMove(chessBoard, row + 1, column+1, row, column)) {
                                chessBoard[row][column] = chessBoard[row + 1][column+1];
                                chessBoard[row + 1][column+1] = null;
                                if (!king.p1KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p1whiteFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                }
                            } else {
                                chessBoard[i][j] = p1whiteFigure();
                                chessBoard[row][column] = mover;
                                break;
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
            for (int j = 1; j < chessBoard[i].length - 1; j++) {
                if (chessBoard[i][j] == "b.Q") {
                    try {
                        int row = i;
                        while (row<chessBoard.length-2) {
                            row++;
                            mover = chessBoard[row][j];
                            if (p2checkMove(chessBoard, row - 1, j, row, j)) {
                                chessBoard[row][j] = chessBoard[row - 1][j];
                                chessBoard[row - 1][j] = null;
                                if (!king.p2KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][j] = mover;
                                    return true;
                                }
                            } else {
                                chessBoard[i][j] = p2blackFigure();
                                chessBoard[row][j] = mover;
                                break;
                            }
                        }
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        int row = i;
                        while (row>1) {
                            row--;
                            mover = chessBoard[row][j];
                            if (p2checkMove(chessBoard, row+1, j, row, j)) {
                                chessBoard[row][j] = chessBoard[row+1][j];
                                chessBoard[row+1][j] = null;
                                if (!king.p2KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][j] = mover;
                                    return true;
                                }
                            } else {
                                chessBoard[i][j] = p2blackFigure();
                                chessBoard[row][j] = mover;
                                break;
                            }
                        }
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        int column = j;
                        while (column<chessBoard.length-2) {
                            column++;
                            mover = chessBoard[i][column];
                            if (p2checkMove(chessBoard, i, column-1, i, column)) {
                                chessBoard[i][column] =  chessBoard[i][column-1];
                                chessBoard[i][column-1] = null;
                                if (!king.p2KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p2blackFigure();
                                    chessBoard[i][column] = mover;
                                    return true;
                                }
                            } else {
                                chessBoard[i][j] = p2blackFigure();
                                chessBoard[i][column] = mover;
                                break;
                            }
                        }
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        int column = j;
                        while (column>1) {
                            column--;
                            mover = chessBoard[i][column];
                            if (p2checkMove(chessBoard, i, column+1, i, column)) {
                                chessBoard[i][column] =  chessBoard[i][column+1];
                                chessBoard[i][column+1] = null;
                                if (!king.p2KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p2blackFigure();
                                    chessBoard[i][column] = mover;
                                    return true;
                                }
                            } else {
                                chessBoard[i][j] = p2blackFigure();
                                chessBoard[i][column] = mover;
                                break;
                            }
                        }
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        int row = i;
                        int column=j;
                        while (true) {
                            row++;
                            column++;
                            mover = chessBoard[row][column];
                            if (p2checkMove(chessBoard, row - 1, column-1, row, column)) {
                                chessBoard[row][column] = chessBoard[row - 1][column-1];
                                chessBoard[row - 1][column-1] = null;
                                if (!king.p2KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                }
                            } else {
                                chessBoard[i][j] = p2blackFigure();
                                chessBoard[row][column] = mover;
                                break;
                            }
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
                            if (p2checkMove(chessBoard, row - 1, column+1, row, column)) {
                                chessBoard[row][column] = chessBoard[row - 1][column+1];
                                chessBoard[row - 1][column+1] = null;
                                if (!king.p2KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                }
                            } else {
                                chessBoard[i][j] = p2blackFigure();
                                chessBoard[row][column] = mover;
                                break;
                            }
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
                            if (p2checkMove(chessBoard, row + 1, column-1, row, column)) {
                                chessBoard[row][column] = chessBoard[row + 1][column-1];
                                chessBoard[row + 1][column-1] = null;
                                if (!king.p2KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                }
                            } else {
                                chessBoard[i][j] = p2blackFigure();
                                chessBoard[row][column] = mover;
                                break;
                            }
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
                            if (p2checkMove(chessBoard, row + 1, column+1, row, column)) {
                                chessBoard[row][column] = chessBoard[row + 1][column+1];
                                chessBoard[row + 1][column+1] = null;
                                if (!king.p2KingChecked(chessBoard)) {
                                    chessBoard[i][j] = p2blackFigure();
                                    chessBoard[row][column] = mover;
                                    return true;
                                }
                            } else {
                                chessBoard[i][j] = p2blackFigure();
                                chessBoard[row][column] = mover;
                                break;
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



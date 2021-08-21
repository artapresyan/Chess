package com.company;

public class Rook extends Figure {
    private Object p1figureName="w.R";
    private Object p2figureName="b.R";
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
        King king=new King();
        if (p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
            p1figureName = "w.r";
            //           wrIsMoved=true;
            chessBoard[takeRow][takeColumn] = p1whiteFigure();
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
        King king=new King();
        if (p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
            p2figureName = "b.r";
//            brIsMoved=true;
            chessBoard[takeRow][takeColumn] = p2blackFigure();
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
                    if (chessBoard[takeRow][putColumn] != null)
                        return false;
                }
            }
        }
        if (chessBoard[putRow][putColumn] == null)
            return true;
        else
            return chessBoard[putRow][putColumn].toString().charAt(0) == 'w';
    }
    boolean p1NoMoves(Object[][] chessBoard) {
        for (int i = 1; i < chessBoard.length-1; i++) {
            for (int j = 1; j < chessBoard[1].length-1; j++) {
                if (chessBoard[i][j] == "w.R"||chessBoard[i][j] == "w.r") {
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
                }
            }
        }
        return true;
    }
    boolean p2NoMoves(Object[][] chessBoard) {
        for (int i = 1; i < chessBoard.length-1; i++) {
            for (int j = 1; j < chessBoard[1].length-1; j++) {
                if (chessBoard[i][j] == "b.R"||chessBoard[i][j] == "b.r") {
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
                }
            }
        }
        return true;
    }
    boolean p1CoverCheck(Object[][] chessBoard) {
        King king=new King();
        for (int i = 1; i < chessBoard.length-1; i++) {
            for (int j = 1; j < chessBoard[1].length - 1; j++) {
                if (chessBoard[i][j] == "w.R" || chessBoard[i][j] == "w.r") {
                    try {
                        int row = i;
                        do {
                            row++;
                            if (p1checkMove(chessBoard,i,j,row,j)){
                                chessBoard[row][j] = chessBoard[i][j];
                            }
                        } while (!king.p1KingChecked(chessBoard) || !p1checkMove(chessBoard,i,j,row,j));
                        return true;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        int row = i;
                        do {
                            row--;
                            if (p1checkMove(chessBoard,i,j,row,j)){
                                chessBoard[row][j] = chessBoard[i][j];
                            }
                        } while (!king.p1KingChecked(chessBoard) || !p1checkMove(chessBoard,i,j,row,j));
                        return true;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        int column = j;
                        do {
                            column++;
                            if (p1checkMove(chessBoard,i,j,i,column)){
                                chessBoard[i][column] = chessBoard[i][j];
                            }
                        } while (!king.p1KingChecked(chessBoard) || !p1checkMove(chessBoard,i,j,i,column));
                        return true;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        int column = j;
                        do {
                            column--;
                            if (p1checkMove(chessBoard,i,j,i,column)){
                                chessBoard[i][column] = chessBoard[i][j];
                            }
                        } while (!king.p1KingChecked(chessBoard) || !p1checkMove(chessBoard,i,j,i,column));
                        return true;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                }
            }
        }
        return false;
    }
    boolean p2CoverCheck(Object[][] chessBoard) {
        King king=new King();
        for (int i = 1; i < chessBoard.length-1; i++) {
            for (int j = 1; j < chessBoard[1].length - 1; j++) {
                if (chessBoard[i][j] == "b.R" || chessBoard[i][j] == "b.r") {
                    try {
                        int row = i;
                        do {
                            row++;
                            if (p2checkMove(chessBoard,i,j,row,j)){
                                chessBoard[row][j] = chessBoard[i][j];
                            }
                        } while (!king.p2KingChecked(chessBoard) || !p2checkMove(chessBoard,i,j,row,j));
                        return true;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        int row = i;
                        do {
                            row--;
                            if (p2checkMove(chessBoard,i,j,row,j)){
                                chessBoard[row][j] = chessBoard[i][j];
                            }
                        } while (!king.p2KingChecked(chessBoard) || !p2checkMove(chessBoard,i,j,row,j));
                        return true;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        int column = j;
                        do {
                            column++;
                            if (p2checkMove(chessBoard,i,j,i,column)){
                                chessBoard[i][column] = chessBoard[i][j];
                            }
                        } while (!king.p2KingChecked(chessBoard) || !p2checkMove(chessBoard,i,j,i,column));
                        return true;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        int column = j;
                        do {
                            column--;
                            if (p2checkMove(chessBoard,i,j,i,column)){
                                chessBoard[i][column] = chessBoard[i][j];
                            }
                        } while (!king.p2KingChecked(chessBoard) || !p2checkMove(chessBoard,i,j,i,column));
                        return true;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                }
            }
        }
        return false;
    }
}

package com.company;

import java.util.Scanner;

public class Pawn extends Figure {
    private final Object p1figureName="w.P";
    private final Object p2figureName="b.P";
    private String name;
    Scanner a=new Scanner(System.in);
    public Object p1whiteFigure() {
        return p1figureName;
    }
    public Object p2blackFigure() {
        return p2figureName;
    }

    void p1moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        King king=new King();
        Rook rook=new Rook();
        Knight knight=new Knight();
        Bishop bishop=new Bishop();
        Queen queen=new Queen();
        if (p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
            Object mover;
            if (putRow == 8) {
                mover = chessBoard[putRow][putColumn];
                chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                chessBoard[takeRow][takeColumn] = null;
                System.out.println("Choose figure");
                name = a.nextLine();
                if (name.equalsIgnoreCase("Knight"))
                    chessBoard[8][putColumn] = knight.p1whiteFigure();
                else if (name.equalsIgnoreCase("Bishop")) {
                    if ((8 + putColumn) % 2 == 0)
                        chessBoard[8][putColumn] = bishop.p1whiteFigure();
                    else
                        chessBoard[8][putColumn] = bishop.p1blackFigure();
                } else if (name.equalsIgnoreCase("Rook"))
                    chessBoard[8][putColumn] = rook.p1whiteFigure();
                else if (name.equalsIgnoreCase("Queen"))
                    chessBoard[8][putColumn] = queen.p1whiteFigure();
                else
                    System.out.println("Invalid figure");
            } else {
                mover = chessBoard[putRow][putColumn];
                chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                chessBoard[takeRow][takeColumn] = null;
            }
            if (king.p1KingChecked(chessBoard)) {
                System.out.println("Please be observant, check your King position...");
                chessBoard[takeRow][takeColumn] = p1whiteFigure();
                chessBoard[putRow][putColumn] = mover;
            }
        }else
            System.out.println("Invalid move");
    }
    void p2moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        King king=new King();
        Rook rook=new Rook();
        Knight knight=new Knight();
        Bishop bishop=new Bishop();
        Queen queen=new Queen();
        if (p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
            Object mover;
            if (putRow == 1) {
                mover = chessBoard[putRow][putColumn];
                chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                chessBoard[takeRow][takeColumn] = null;
                System.out.println("Choose figure");
                name = a.nextLine();
                if (name.equalsIgnoreCase("Knight"))
                    chessBoard[1][putColumn] = knight.p2blackFigure();
                else if (name.equalsIgnoreCase("Bishop")) {
                    if (putColumn % 2 == 0)
                        chessBoard[1][putColumn] = bishop.p2whiteFigure();
                    else
                        chessBoard[1][putColumn] = bishop.p2blackFigure();
                } else if (name.equalsIgnoreCase("Rook"))
                    chessBoard[1][putColumn] = rook.p2blackFigure();
                else if (name.equalsIgnoreCase("Queen"))
                    chessBoard[1][putColumn] = queen.p2blackFigure();
                else
                    System.out.println("Invalid figure");
            } else {
                mover = chessBoard[putRow][putColumn];
                chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                chessBoard[takeRow][takeColumn] = null;
            }
            if (king.p2KingChecked(chessBoard)) {
                System.out.println("Please be observant, check your King position...");
                chessBoard[takeRow][takeColumn] = p2blackFigure();
                chessBoard[putRow][putColumn] = mover;
            }
        }else
            System.out.println("Invalid move");
    }
    boolean p1checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (chessBoard[takeRow][takeColumn]!=p1whiteFigure() || takeRow==putRow && takeColumn==putColumn)
             return false;
         if (takeRow == 2 && takeRow - putRow == -2) {
             while (takeRow < putRow) {
                 takeRow++;
                 if (takeColumn!=putColumn || chessBoard[takeRow][putColumn] != null)
                     return false;
             }
                 return true;
         } else if (takeRow - putRow == -1) {
             if (takeColumn == putColumn && chessBoard[putRow][putColumn] == null) {
                 return true;
             } else if (chessBoard[putRow][putColumn]!=null)
                 return (takeColumn - putColumn == -1 || takeColumn - putColumn == 1) && chessBoard[putRow][putColumn].toString().charAt(0) == 'b';
         }
             return false;
    }
    boolean p2checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (chessBoard[takeRow][takeColumn]!=p2blackFigure() || takeRow==putRow && takeColumn==putColumn)
            return false;
        if (takeRow == 7 && takeRow - putRow == 2) {
            while (takeRow > putRow) {
                takeRow--;
                if (takeColumn!=putColumn || chessBoard[takeRow][putColumn] != null)
                    return false;
            }
            return true;
        } else if (takeRow - putRow == 1) {
            if (takeColumn == putColumn && chessBoard[putRow][putColumn] == null) {
                return true;
            } else if (chessBoard[putRow][putColumn]!=null)
                return (takeColumn - putColumn == -1 || takeColumn - putColumn == 1) && chessBoard[putRow][putColumn].toString().charAt(0) == 'w';
        }
            return false;
    }
    boolean p1NoMoves(Object[][] chessBoard) {
        for (int i = 1; i < chessBoard.length-1; i++) {
            for (int j = 1; j < chessBoard[1].length-1; j++) {
                if (chessBoard[i][j] == "w.P") {
                    try {
                        if (p1checkMove(chessBoard,i,j,i+1,j))
                        return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (p1checkMove(chessBoard,i,j,i+1,j+1))
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (p1checkMove(chessBoard,i,j,i+1,j-1))
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
                if (chessBoard[i][j] == "b.P") {
                    try {
                        if (p2checkMove(chessBoard,i,j,i+1,j))
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (p2checkMove(chessBoard,i,j,i+1,j+1))
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (p2checkMove(chessBoard,i,j,i+1,j-1))
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
            for (int j = 1; j < chessBoard[1].length-1; j++) {
                if (chessBoard[i][j] == "w.P") {
                    try {
                        if (p1checkMove(chessBoard,i,j,i+1,j))
                            chessBoard[i+1][j]=chessBoard[i][j];
                        if (king.p1KingChecked(chessBoard))
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (p1checkMove(chessBoard,i,j,i+1,j+1))
                            chessBoard[i+1][j+1]=chessBoard[i][j];
                        if (king.p1KingChecked(chessBoard))
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (p1checkMove(chessBoard,i,j,i+1,j-1))
                            chessBoard[i+1][j-1]=chessBoard[i][j];
                        if (king.p1KingChecked(chessBoard))
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                }
            }
        }
        return true;
    }
    boolean p2CoverCheck(Object[][] chessBoard) {
        King king=new King();
        for (int i = 1; i < chessBoard.length-1; i++) {
            for (int j = 1; j < chessBoard[1].length-1; j++) {
                if (chessBoard[i][j] == "b.P") {
                    try {
                        if (p2checkMove(chessBoard,i,j,i-1,j))
                            chessBoard[i-1][j]=chessBoard[i][j];
                        if (king.p2KingChecked(chessBoard))
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (p2checkMove(chessBoard,i,j,i-1,j+1))
                            chessBoard[i-1][j+1]=chessBoard[i][j];
                        if (king.p2KingChecked(chessBoard))
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                    try {
                        if (p2checkMove(chessBoard,i,j,i-1,j-1))
                            chessBoard[i-1][j-1]=chessBoard[i][j];
                        if (king.p2KingChecked(chessBoard))
                            return false;
                    }catch (ArrayIndexOutOfBoundsException ignore){
                    }
                }
            }
        }
        return true;
    }
}


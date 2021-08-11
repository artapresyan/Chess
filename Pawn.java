package com.company;

import java.util.Scanner;

public class Pawn extends Figure {
    String name;
    Scanner a=new Scanner(System.in);
    Figure rook=new Rook();
    Figure knight=new Knight();
    Figure bishop=new Bishop();
    Figure queen=new Queen();
    public Object figure(Object figureName) {
        return figureName;
    }
    void p1moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
            if (putRow == 7) {
                if ((takeRow + takeColumn) % 2 == 0)
                    chessBoard[takeRow][takeColumn] = white;
                else
                    chessBoard[takeRow][takeColumn] = black;
                System.out.println("Choose figure");
                name = a.nextLine();
                if (name.equalsIgnoreCase("Knight"))
                    chessBoard[7][putColumn] = knight.figure("wKn");
                else if (name.equalsIgnoreCase("Bishop")) {
                    if ((7 + putColumn) % 2 == 0)
                        chessBoard[7][putColumn] = bishop.figure("wwB");
                    else
                        chessBoard[7][putColumn] = bishop.figure("wbB");
                }
                else if (name.equalsIgnoreCase("Rook"))
                    chessBoard[7][putColumn] = rook.figure("w.R");
                else if (name.equalsIgnoreCase("Queen"))
                    chessBoard[7][putColumn] = queen.figure("w.Q");
                else
                    System.out.println("Invalid figure");
            } else {
                chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                if ((takeColumn + takeRow) % 2 == 0)
                    chessBoard[takeRow][takeColumn] = white;
                else
                    chessBoard[takeRow][takeColumn] = black;
            }
        }else {
            System.out.println("Invalid move");
        }
    }
    void p2moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
            if (putRow == 0) {
                if ((takeRow + takeColumn) % 2 == 0)
                    chessBoard[takeRow][takeColumn] = white;
                else
                    chessBoard[takeRow][takeColumn] = black;
                System.out.println("Choose figure");
                name = a.nextLine();
                if (name.equalsIgnoreCase("Knight"))
                    chessBoard[0][putColumn] = knight.figure("wKn");
                else if (name.equalsIgnoreCase("Bishop")) {
                    if (putColumn % 2 == 0)
                        chessBoard[0][putColumn] = bishop.figure("wwB");
                    else
                        chessBoard[0][putColumn] = bishop.figure("wbB");
                }
                else if (name.equalsIgnoreCase("Rook"))
                    chessBoard[0][putColumn] = rook.figure("w.R");
                else if (name.equalsIgnoreCase("Queen"))
                    chessBoard[0][putColumn] = queen.figure("w.Q");
                else
                    System.out.println("Invalid figure");
            } else {
                chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                if ((takeRow + takeColumn) % 2 == 0)
                    chessBoard[takeRow][takeColumn] = white;
                else
                    chessBoard[takeRow][takeColumn] = black;
            }
        }else {
            System.out.println("Invalid move");
        }
    }
    boolean p1checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (!chessBoard[takeRow][takeColumn].toString().equals("w.P"))
             return false;
         if (takeRow == 1 && takeRow - putRow == -2) {
             while (takeRow < putRow) {
                 takeRow++;
                 if (takeColumn!=putColumn || (chessBoard[takeRow][putColumn] != white && chessBoard[takeRow][putColumn] != black))
                     return false;
             }
                 return true;
         } else if (takeRow - putRow == -1) {
             if ((takeColumn - putColumn == -1 || takeColumn - putColumn == 1) && chessBoard[putRow][putColumn].toString().charAt(0) == 'b') {
                 return true;
             }
             else if (takeColumn==putColumn && (chessBoard[putRow][putColumn] == white || chessBoard[putRow][putColumn] == black)) {
                 return true;
             }
         }
             return false;
    }
    boolean p2checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (!chessBoard[takeRow][takeColumn].toString().equals("b.P"))
            return false;
        if (takeRow == 6 && takeRow - putRow == 2) {
            while (takeRow > putRow) {
                takeRow--;
                if (takeColumn!=putColumn || (chessBoard[takeRow][putColumn] != white && chessBoard[takeRow][putColumn] != black))
                    return false;
            }
            return true;
        } else if (takeRow - putRow == 1) {
            if ((takeColumn - putColumn == -1 || takeColumn - putColumn == 1) && chessBoard[putRow][putColumn].toString().charAt(0) == 'w') {
                return true;
            } else if (takeColumn == putColumn && (chessBoard[putRow][putColumn] == white || chessBoard[putRow][putColumn] == black)) {
                return true;
            }
        }
            return false;
    }
}


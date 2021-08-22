package com.company;
import java.util.Scanner;

public class Chess {
    static boolean p1ValidMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn){
        Figure rook = new Rook();
        Figure knight = new Knight();
        Figure bishop = new Bishop();
        Figure queen = new Queen();
        King king = new King();
        Figure pawn = new Pawn();
        if (rook.p1checkMove(chessBoard,takeRow,takeColumn,putRow,putColumn))
            return true;
        else if(knight.p1checkMove(chessBoard,takeRow,takeColumn,putRow,putColumn))
            return true;
        else if(bishop.p1checkMove(chessBoard,takeRow,takeColumn,putRow,putColumn))
            return true;
        else if(queen.p1checkMove(chessBoard,takeRow,takeColumn,putRow,putColumn))
            return true;
        else if(king.p1checkMove(chessBoard,takeRow,takeColumn,putRow,putColumn))
            return true;
        else if (pawn.p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn))
            return true;
        System.out.println("P1 be watchful it is invalid move..."+"\n");
        return false;
    }
    static boolean p2ValidMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn){
        Figure rook = new Rook();
        Figure knight = new Knight();
        Figure bishop = new Bishop();
        Figure queen = new Queen();
        King king = new King();
        Figure pawn = new Pawn();
        if (rook.p2checkMove(chessBoard,takeRow,takeColumn,putRow,putColumn))
            return true;
        else if(knight.p2checkMove(chessBoard,takeRow,takeColumn,putRow,putColumn))
            return true;
        else if(bishop.p2checkMove(chessBoard,takeRow,takeColumn,putRow,putColumn))
            return true;
        else if(queen.p2checkMove(chessBoard,takeRow,takeColumn,putRow,putColumn))
            return true;
        else if(king.p2checkMove(chessBoard,takeRow,takeColumn,putRow,putColumn))
            return true;
        else if (pawn.p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn))
            return true;
        System.out.println("P2 be watchful it is invalid move..."+"\n");
        return false;
    }
    public static void main(String[] args) {
        Board board = new Board();
    //    Scanner getLet = new Scanner(System.in);
        Scanner getNum = new Scanner(System.in);
        Figure rook = new Rook();
        Figure knight = new Knight();
        Figure bishop = new Bishop();
        Figure queen = new Queen();
        King king = new King();
        Figure pawn = new Pawn();
        int queue = 1;
        boolean gameOver=false;
        int takeRow, takeColumn, putRow, putColumn;
        Object[][] chessBoard = new Object[10][10];
        board.createBoard(chessBoard);
        pawn.p1moveFigure(chessBoard,2,4,4,4);
        queen.p1moveFigure(chessBoard,1,5,3,3);
        queen.p1moveFigure(chessBoard,3,3,7,3);
        queen.p1moveFigure(chessBoard,7,3,7,2);
        queen.p1moveFigure(chessBoard,7,2,7,1);
        queen.p1moveFigure(chessBoard,7,1,7,4);
        queen.p1moveFigure(chessBoard,7,4,7,5);
        queen.p1moveFigure(chessBoard,7,5,7,6);
        queen.p1moveFigure(chessBoard,7,6,7,7);
        queen.p1moveFigure(chessBoard,7,7,7,8);
        queen.p1moveFigure(chessBoard,7,8,8,8);
        queen.p1moveFigure(chessBoard,8,8,8,7);
        queen.p1moveFigure(chessBoard,8,7,8,6);
        queen.p1moveFigure(chessBoard,8,6,8,5);
        queen.p1moveFigure(chessBoard,8,5,7,5);
        queen.p1moveFigure(chessBoard,7,5,7,3);
        queen.p1moveFigure(chessBoard,7,3,8,3);
        queen.p1moveFigure(chessBoard,8,3,8,2);
        queen.p1moveFigure(chessBoard,8,2,6,2);
        king.p2moveFigure(chessBoard,8,4,7,5);
        king.p2moveFigure(chessBoard,7,5,8,6);
        king.p2moveFigure(chessBoard,8,6,8,7);
        king.p2moveFigure(chessBoard,8,7,8,8);
        pawn.p1moveFigure(chessBoard,4,4,5,4);
        pawn.p1moveFigure(chessBoard,5,4,6,4);
        pawn.p1moveFigure(chessBoard,6,4,7,4);
        king.p2moveFigure(chessBoard,8,8,7,7);
        pawn.p1moveFigure(chessBoard,7,4,8,4);
        queen.p1moveFigure(chessBoard,8,4,7,4);
        king.p2moveFigure(chessBoard,7,7,8,7);
        board.printBoard(chessBoard);
        while (!gameOver) {
            queue++;
            board.getBoard(chessBoard);
            if (queue % 2 == 0) {
                if (king.p1Mated(chessBoard)) {
                    System.out.println("\n"+"P1 lost the game by checkmate");
                    gameOver=true;
                }else if(king.p1StaleMate(chessBoard)) {
                    System.out.println("\n"+"P2 made stalemate");
                    gameOver=true;
                } else {
                    do {
                        System.out.println("P1 Enter takeRow");
                        takeRow = getNum.nextByte();
                        System.out.println("P1 Enter takeColumn");
                        takeColumn = getNum.nextByte();
                        System.out.println("P1 Enter putRow");
                        putRow = getNum.nextByte();
                        System.out.println("P1 Enter putColumn");
                        putColumn = getNum.nextByte();
                    }while (!p1ValidMove(chessBoard,takeRow,takeColumn,putRow,putColumn));
                    if (chessBoard[takeRow][takeColumn] == "w.R" || chessBoard[takeRow][takeColumn] == "w.r") {
                        rook.p1moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    } else if (chessBoard[takeRow][takeColumn] == "wKn") {
                        knight.p1moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    } else if (chessBoard[takeRow][takeColumn] == "wwB" || chessBoard[takeRow][takeColumn] == "wbB") {
                        bishop.p1moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    } else if (chessBoard[takeRow][takeColumn] == "w.K") {
                        king.p1moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    } else if (chessBoard[takeRow][takeColumn] == "w.Q") {
                        queen.p1moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    } else if (chessBoard[takeRow][takeColumn] == "w.P") {
                        pawn.p1moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                }
            }else {
                if (king.p2Mated(chessBoard)) {
                    System.out.println("\n"+"P2 lost the game by checkmate");
                    gameOver=true;
                }else if(king.p2StaleMate(chessBoard)) {
                    System.out.println("\n"+"P1 made stalemate");
                    gameOver=true;
                } else {
                    do {
                        System.out.println("P2 Enter takeRow");
                        takeRow = getNum.nextByte();
                        System.out.println("P2 Enter takeColumn");
                        takeColumn = getNum.nextByte();
                        System.out.println("P2 Enter putRow");
                        putRow = getNum.nextByte();
                        System.out.println("P2 Enter putColumn");
                        putColumn = getNum.nextByte();
                    }while (!p2ValidMove(chessBoard,takeRow,takeColumn,putRow,putColumn));
                    if (chessBoard[takeRow][takeColumn] == "b.R" || chessBoard[takeRow][takeColumn] == "b.r") {
                        rook.p2moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    } else if (chessBoard[takeRow][takeColumn] == "bKn") {
                        knight.p2moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    } else if (chessBoard[takeRow][takeColumn] == "bbB" || chessBoard[takeRow][takeColumn] == "bwB") {
                        bishop.p2moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    } else if (chessBoard[takeRow][takeColumn] == "b.K") {
                        king.p2moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    } else if (chessBoard[takeRow][takeColumn] == "b.Q") {
                        queen.p2moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    } else if (chessBoard[takeRow][takeColumn] == "b.P") {
                        pawn.p2moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                }
            }
            board.printBoard(chessBoard);
        }
        System.out.println("Game Over");
    }
}

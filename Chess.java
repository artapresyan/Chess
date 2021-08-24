package com.company;
import java.util.Scanner;

public class Chess {

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
        boolean p1ValidMove=false;
        boolean p2ValidMove=false;
        int takeRow, takeColumn, putRow, putColumn;
        Object[][] chessBoard = new Object[8][8];
        board.createBoard(chessBoard);
        System.out.println("""
                
                            Game Stared
                """);
        board.printBoard(chessBoard);
        while (!gameOver) {
            queue++;
            if (queue % 2 == 0) {
                if (king.p1Mated(chessBoard)) {
                    System.out.println("""

                            P1 Lost The Game By Checkmate
                            """);
                    gameOver=true;
                }else if(king.p1StaleMate(chessBoard)) {
                    System.out.println("""

                            P2 Made Stalemate
                            """);
                    gameOver=true;
                } else {
                    do {
                        System.out.println("\n"+"P1 Enter takeRow");
                        takeRow = getNum.nextByte();
                        System.out.println("\n"+"P1 Enter takeColumn");
                        takeColumn = getNum.nextByte();
                        System.out.println("\n"+"P1 Enter putRow");
                        putRow = getNum.nextByte();
                        System.out.println("\n"+"P1 Enter putColumn");
                        putColumn = getNum.nextByte();

                        if (chessBoard[takeRow-1][takeColumn-1] == "w.R" || chessBoard[takeRow-1][takeColumn-1] == "w.r") {
                            if (rook.p1checkMove(chessBoard, takeRow-1, takeColumn-1, putRow-1, putColumn-1)) {
                                rook.p1moveFigure(chessBoard, takeRow-1, takeColumn-1, putRow-1, putColumn-1);
                                p1ValidMove = true;
                            }else
                                System.out.println("P1 Enter Valid Move");
                        } else if (chessBoard[takeRow-1][takeColumn-1] == "wKn") {
                            if (knight.p1checkMove(chessBoard, takeRow-1, takeColumn-1, putRow-1, putColumn-1)) {
                                knight.p1moveFigure(chessBoard, takeRow-1, takeColumn-1, putRow-1, putColumn-1);
                                p1ValidMove = true;
                            }else
                                System.out.println("P1 Enter Valid Move");
                        } else if (chessBoard[takeRow-1][takeColumn-1] == "wwB" || chessBoard[takeRow-1][takeColumn-1] == "wbB") {
                            if (bishop.p1checkMove(chessBoard, takeRow-1, takeColumn-1, putRow-1, putColumn-1)) {
                                bishop.p1moveFigure(chessBoard, takeRow-1, takeColumn-1, putRow-1, putColumn-1);
                                p1ValidMove = true;
                            }else
                                System.out.println("P1 Enter Valid Move");
                        } else if (chessBoard[takeRow-1][takeColumn-1] == "w.K") {
                            if (king.p1checkMove(chessBoard, takeRow-1, takeColumn-1, putRow-1, putColumn-1)) {
                                king.p1moveFigure(chessBoard, takeRow-1, takeColumn-1, putRow-1, putColumn-1);
                                p1ValidMove = true;
                            }else
                                System.out.println("P1 Enter Valid Move");
                        } else if (chessBoard[takeRow-1][takeColumn-1] == "w.Q") {
                            if (queen.p1checkMove(chessBoard, takeRow-1, takeColumn-1, putRow-1, putColumn-1)) {
                                queen.p1moveFigure(chessBoard, takeRow-1, takeColumn-1, putRow-1, putColumn-1);
                                p1ValidMove = true;
                            }else
                                System.out.println("P1 Enter Valid Move");
                        } else if (chessBoard[takeRow-1][takeColumn-1] == "w.P") {
                            if (pawn.p1checkMove(chessBoard, takeRow-1, takeColumn-1, putRow-1, putColumn-1)) {
                                pawn.p1moveFigure(chessBoard, takeRow-1, takeColumn-1, putRow-1, putColumn-1);
                                p1ValidMove = true;
                            }else
                                System.out.println("P1 Enter Valid Move");
                        }else
                            System.out.println("P1 Take You Figure");
                    }while (!p1ValidMove);
                    p1ValidMove=false;
                }
            }else {
                if (king.p2Mated(chessBoard)) {
                    System.out.println("""

                            P2 Lost The Game By Checkmate
                            """);
                    gameOver=true;
                }else if(king.p2StaleMate(chessBoard)) {
                    System.out.println("""

                            P1 Made Stalemate
                            """);
                    gameOver=true;
                } else {
                    do {
                        System.out.println("\n"+"P2 Enter TakeRow");
                        takeRow = getNum.nextByte();
                        System.out.println("\n"+"P2 Enter TakeColumn");
                        takeColumn = getNum.nextByte();
                        System.out.println("\n"+"P2 Enter PutRow");
                        putRow = getNum.nextByte();
                        System.out.println("\n"+"P2 Enter PutColumn");
                        putColumn = getNum.nextByte();
                    if (chessBoard[takeRow-1][takeColumn-1] == "b.R" || chessBoard[takeRow-1][takeColumn-1] == "b.r") {
                        if (rook.p2checkMove(chessBoard, takeRow-1, takeColumn-1, putRow-1, putColumn-1)) {
                            rook.p2moveFigure(chessBoard, takeRow-1, takeColumn-1, putRow-1, putColumn-1);
                            p2ValidMove = true;
                        }else
                            System.out.println("P2 Enter Valid Move");
                    } else if (chessBoard[takeRow-1][takeColumn-1] == "bKn") {
                        if (knight.p2checkMove(chessBoard, takeRow-1, takeColumn-1, putRow-1, putColumn-1)) {
                            knight.p2moveFigure(chessBoard, takeRow-1, takeColumn-1, putRow-1, putColumn-1);
                            p2ValidMove = true;
                        }else
                            System.out.println("P2 Enter Valid Move");
                    } else if (chessBoard[takeRow-1][takeColumn-1] == "bbB" || chessBoard[takeRow-1][takeColumn-1] == "bwB") {
                        if (bishop.p2checkMove(chessBoard, takeRow-1, takeColumn-1, putRow-1, putColumn-1)) {
                            bishop.p2moveFigure(chessBoard, takeRow-1, takeColumn-1, putRow-1, putColumn-1);
                            p2ValidMove = true;
                        }else
                            System.out.println("P2 Enter Valid Move");
                    } else if (chessBoard[takeRow-1][takeColumn-1] == "b.K") {
                        if (king.p2checkMove(chessBoard, takeRow-1, takeColumn-1, putRow-1, putColumn-1)) {
                            king.p2moveFigure(chessBoard, takeRow-1, takeColumn-1, putRow-1, putColumn-1);
                            p2ValidMove = true;
                        }else
                            System.out.println("P2 Enter Valid Move");
                    } else if (chessBoard[takeRow-1][takeColumn-1] == "b.Q") {
                        if (rook.p2checkMove(chessBoard, takeRow-1, takeColumn-1, putRow-1, putColumn-1)) {
                            queen.p2moveFigure(chessBoard, takeRow-1, takeColumn-1, putRow-1, putColumn-1);
                            p2ValidMove = true;
                        }else
                            System.out.println("P2 Enter Valid Move");
                    } else if (chessBoard[takeRow-1][takeColumn-1] == "b.P") {
                        if (pawn.p2checkMove(chessBoard,  takeRow-1, takeColumn-1, putRow-1, putColumn-1)) {
                            pawn.p2moveFigure(chessBoard,  takeRow-1, takeColumn-1, putRow-1, putColumn-1);
                            p2ValidMove = true;
                        }else
                            System.out.println("P2 Enter Valid Move");
                    }else
                        System.out.println("P2 Take You Figure");
                    }while (!p2ValidMove);
                    p2ValidMove=false;
                }
            }
            board.printBoard(chessBoard);
        }
        System.out.println("""
                
                            Game Over
                """);
    }
}

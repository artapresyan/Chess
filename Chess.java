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
        Object[][] chessBoard = new Object[10][10];
        board.createBoard(chessBoard);
        System.out.println("""
                
                            Game Stared
                """);
        board.printBoard(chessBoard);
        while (!gameOver) {
            queue++;
            board.getBoard(chessBoard);
            if (queue % 2 == 0) {
                if (king.p1Mated(chessBoard)) {
                    System.out.println("\n"+"P1 Lost The Game By Checkmate");
                    gameOver=true;
                }else if(king.p1StaleMate(chessBoard)) {
                    System.out.println("\n"+"P2 Made Stalemate");
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

                        if (chessBoard[takeRow][takeColumn] == "w.R" || chessBoard[takeRow][takeColumn] == "w.r") {
                            if (rook.p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
                                rook.p1moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                                p1ValidMove = true;
                            }else
                                System.out.println("P1 Enter Valid Move");
                        } else if (chessBoard[takeRow][takeColumn] == "wKn") {
                            if (knight.p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
                                knight.p1moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                                p1ValidMove = true;
                            }else
                                System.out.println("P1 Enter Valid Move");
                        } else if (chessBoard[takeRow][takeColumn] == "wwB" || chessBoard[takeRow][takeColumn] == "wbB") {
                            if (bishop.p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
                                bishop.p1moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                                p1ValidMove = true;
                            }else
                                System.out.println("P1 Enter Valid Move");
                        } else if (chessBoard[takeRow][takeColumn] == "w.K") {
                            if (king.p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
                                king.p1moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                                p1ValidMove = true;
                            }else
                                System.out.println("P1 Enter Valid Move");
                        } else if (chessBoard[takeRow][takeColumn] == "w.Q") {
                            if (queen.p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
                                queen.p1moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                                p1ValidMove = true;
                            }else
                                System.out.println("P1 Enter Valid Move");
                        } else if (chessBoard[takeRow][takeColumn] == "w.P") {
                            if (pawn.p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
                                pawn.p1moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                                p1ValidMove = true;
                            }else
                                System.out.println("P1 Enter Valid Move");
                        }
                    }while (!p1ValidMove);
                    p1ValidMove=false;
                }
            }else {
                if (king.p2Mated(chessBoard)) {
                    System.out.println("\n"+"P2 Lost The Game By Checkmate");
                    gameOver=true;
                }else if(king.p2StaleMate(chessBoard)) {
                    System.out.println("\n"+"P1 Made Stalemate");
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
                    if (chessBoard[takeRow][takeColumn] == "b.R" || chessBoard[takeRow][takeColumn] == "b.r") {
                        if (rook.p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
                            rook.p2moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                            p2ValidMove = true;
                        }else
                            System.out.println("P2 Enter Valid Move");
                    } else if (chessBoard[takeRow][takeColumn] == "bKn") {
                        if (knight.p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
                            knight.p2moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                            p2ValidMove = true;
                        }else
                            System.out.println("P2 Enter Valid Move");
                    } else if (chessBoard[takeRow][takeColumn] == "bbB" || chessBoard[takeRow][takeColumn] == "bwB") {
                        if (bishop.p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
                            bishop.p2moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                            p2ValidMove = true;
                        }else
                            System.out.println("P2 Enter Valid Move");
                    } else if (chessBoard[takeRow][takeColumn] == "b.K") {
                        if (king.p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
                            king.p2moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                            p2ValidMove = true;
                        }else
                            System.out.println("P2 Enter Valid Move");
                    } else if (chessBoard[takeRow][takeColumn] == "b.Q") {
                        if (rook.p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
                            queen.p2moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                            p2ValidMove = true;
                        }else
                            System.out.println("P2 Enter Valid Move");
                    } else if (chessBoard[takeRow][takeColumn] == "b.P") {
                        if (pawn.p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
                            pawn.p2moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                            p2ValidMove = true;
                        }else
                            System.out.println("P2 Enter Valid Move");
                    }
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

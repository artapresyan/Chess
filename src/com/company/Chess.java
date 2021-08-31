package com.company;
import java.util.Scanner;

public class Chess {

    public static void main(String[] args) {
        Board board = new Board();
        Scanner getString = new Scanner(System.in);
        Figure whiteRook = new Rook(Color.isWhiteFigure, FigureName.whiteRook);
        Figure whiteKnight = new Knight(Color.isWhiteFigure, FigureName.whiteKnight);
        Figure whiteBishop = new Bishop(Color.isWhiteFigure, FigureName.whiteWhiteBishop);
        Figure whiteQueen = new Queen(Color.isWhiteFigure, FigureName.whiteQueen);
        King whiteKing = new King(Color.isWhiteFigure, FigureName.whiteKing);
        Figure whitePawn = new Pawn(Color.isWhiteFigure, FigureName.whitePawn);
        Figure blackRook = new Rook(Color.isBlackFigure, FigureName.blackRook);
        Figure blackKnight = new Knight(Color.isBlackFigure, FigureName.blackKnight);
        Figure blackBishop = new Bishop(Color.isBlackFigure, FigureName.blackBlackBishop);
        Figure blackQueen = new Queen(Color.isBlackFigure, FigureName.blackQueen);
        King blackKing = new King(Color.isBlackFigure, FigureName.blackKing);
        Figure blackPawn = new Pawn(Color.isBlackFigure, FigureName.blackPawn);
        int queue = 1;
        boolean gameOver = false;
        boolean p1ValidMove = false;
        boolean p2ValidMove = false;
        int takeRow, takeColumn, putRow, putColumn;
        String takeColumnString, putColumnString,takeRowString,putRowString;
        Figure[][] chessBoard = new Figure[8][8];
        board.createBoard(chessBoard);
        System.out.println("""
                                
                            Game Stared
                """);
        board.printBoard(chessBoard);
        while (!gameOver) {
            queue++;
            if (queue % 2 == 0) {
                if (whiteKing.mated(chessBoard, Color.isWhiteFigure)) {
                    System.out.println("""

                            P1 Lost The Game By Checkmate
                            """);
                    gameOver = true;
                } else if (whiteKing.staleMate(chessBoard, Color.isWhiteFigure)) {
                    System.out.println("""

                            P2 Made Stalemate
                            """);
                    gameOver = true;
                } else {
                    do {
                        do {
                            do {
                                do {
                                    System.out.println("\n" + "P1 Enter Letter From Which Column To Take");
                                    takeColumnString = getString.nextLine();
                                    if (!takeColumnString.matches("[a-hA-H]"))
                                        System.out.println("P1 Enter Valid Column");
                                } while (!takeColumnString.matches("[a-hA-H]"));
                                do {
                                    System.out.println("\n" + "P1 Enter Number From Which Row To Take");
                                    takeRowString = getString.nextLine();
                                    if (!takeRowString.matches("[1-8]"))
                                        System.out.println("P1 Enter Valid Row");
                                } while (!takeRowString.matches("[1-8]"));
                                takeColumn = 104 - takeColumnString.charAt(0);
                                takeRow=Integer.parseInt(takeRowString)-1;
                                if (chessBoard[takeRow][takeColumn] == null)
                                    System.out.println("There Is No Figure There");
                            } while (chessBoard[takeRow][takeColumn] == null);
                            if (!chessBoard[takeRow][takeColumn].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                System.out.println("You Can Play Only With White Figures");
                        } while (!chessBoard[takeRow][takeColumn].getFigureColor().equals(Color.isWhiteFigure.getColor()));
                        do {
                            System.out.println("\n" + "P1 Enter Letter On Which Column To Put");
                            putColumnString = getString.nextLine();
                            if (!putColumnString.matches("[a-hA-H]"))
                                System.out.println("P1 Enter Valid Column");
                        } while (!putColumnString.matches("[a-hA-H]"));
                        do {
                            System.out.println("\n" + "P1 Enter Number On Which Row to Put");
                            putRowString = getString.nextLine();
                            if (!putRowString.matches("[1-8]"))
                                System.out.println("P1 Enter Valid Row");
                        } while (!putRowString.matches("[1-8]"));
                        putColumn = 104 - putColumnString.charAt(0);
                        putRow=Integer.parseInt(putRowString)-1;
                        if (chessBoard[takeRow][takeColumn] instanceof Rook) {
                            if (whiteRook.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
                                whiteRook.moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                                p1ValidMove = true;
                            } else
                                System.out.println("P1 Enter Valid Move");
                        } else if (chessBoard[takeRow][takeColumn] instanceof Knight) {
                            if (whiteKnight.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
                                whiteKnight.moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                                p1ValidMove = true;
                            } else
                                System.out.println("P1 Enter Valid Move");
                        } else if (chessBoard[takeRow][takeColumn] instanceof Bishop) {
                            if (whiteBishop.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
                                whiteBishop.moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                                p1ValidMove = true;
                            } else
                                System.out.println("P1 Enter Valid Move");
                        } else if (chessBoard[takeRow][takeColumn] instanceof King) {
                            if (whiteKing.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
                                whiteKing.moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                                p1ValidMove = true;
                            } else
                                System.out.println("P1 Enter Valid Move");
                        } else if (chessBoard[takeRow][takeColumn] instanceof Queen) {
                            if (whiteQueen.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
                                whiteQueen.moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                                p1ValidMove = true;
                            } else
                                System.out.println("P1 Enter Valid Move");
                        } else if (chessBoard[takeRow][takeColumn] instanceof Pawn) {
                            if (whitePawn.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
                                whitePawn.moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                                p1ValidMove = true;
                            } else
                                System.out.println("P1 Enter Valid Move");
                        }
                    } while (!p1ValidMove);
                    p1ValidMove = false;
                }
            } else {
                if (blackKing.mated(chessBoard, Color.isBlackFigure)) {
                    System.out.println("""

                            P2 Lost The Game By Checkmate
                            """);
                    gameOver = true;
                } else if (blackKing.staleMate(chessBoard, Color.isBlackFigure)) {
                    System.out.println("""

                            P1 Made Stalemate
                            """);
                    gameOver = true;
                } else {
                    do {
                        do {
                            do {
                                do {
                                    System.out.println("\n" + "P2 Enter Letter From Which Column To Take");
                                    takeColumnString = getString.nextLine();
                                    if (!takeColumnString.matches("[a-hA-H]"))
                                        System.out.println("P2 Enter Valid Column");
                                } while (!takeColumnString.matches("[a-hA-H]"));
                                do {
                                    System.out.println("\n" + "P2 Enter Number From Which Row To Take");
                                    takeRowString = getString.nextLine();
                                    if (!takeRowString.matches("[1-8]"))
                                        System.out.println("P2 Enter Valid Row");
                                } while (!takeRowString.matches("[1-8]"));
                                takeColumn = 104 - takeColumnString.charAt(0);
                                takeRow=Integer.parseInt(takeRowString)-1;
                                if (chessBoard[takeRow][takeColumn] == null)
                                    System.out.println("There Is No Figure There");
                            } while (chessBoard[takeRow][takeColumn] == null);
                            if (!chessBoard[takeRow][takeColumn].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                System.out.println("You Can Play Only With Black Figures");
                        } while (!chessBoard[takeRow][takeColumn].getFigureColor().equals(Color.isBlackFigure.getColor()));
                        do {
                            System.out.println("\n" + "P2 Enter Letter On Which Column To Put");
                            putColumnString = getString.nextLine();
                            if (!putColumnString.matches("[a-hA-H]"))
                                System.out.println("P2 Enter Valid Column");
                        } while (!putColumnString.matches("[a-hA-H]"));
                        do {
                            System.out.println("\n" + "P2 Enter Number On Which Row to Put");
                            putRowString = getString.nextLine();
                            if (!putRowString.matches("[1-8]"))
                                System.out.println("P2 Enter Valid Row");
                        } while (!putRowString.matches("[1-8]"));
                        putColumn = 104 - putColumnString.charAt(0);
                        putRow=Integer.parseInt(putRowString)-1;
                        if (chessBoard[takeRow][takeColumn] instanceof Rook) {
                            if (blackRook.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
                                blackRook.moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                                p2ValidMove = true;
                            } else
                                System.out.println("P2 Enter Valid Move");
                        } else if (chessBoard[takeRow][takeColumn] instanceof Knight) {
                            if (blackKnight.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
                                blackKnight.moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                                p2ValidMove = true;
                            } else
                                System.out.println("P2 Enter Valid Move");
                        } else if (chessBoard[takeRow][takeColumn] instanceof Bishop) {
                            if (blackBishop.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
                                blackBishop.moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                                p2ValidMove = true;
                            } else
                                System.out.println("P2 Enter Valid Move");
                        } else if (chessBoard[takeRow][takeColumn] instanceof King) {
                            if (blackKing.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
                                blackKing.moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                                p2ValidMove = true;
                            } else
                                System.out.println("P2 Enter Valid Move");
                        } else if (chessBoard[takeRow][takeColumn] instanceof Queen) {
                            if (blackQueen.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
                                blackQueen.moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                                p2ValidMove = true;
                            } else
                                System.out.println("P2 Enter Valid Move");
                        } else if (chessBoard[takeRow][takeColumn] instanceof Pawn) {
                            if (blackPawn.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
                                blackPawn.moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                                p2ValidMove = true;
                            } else
                                System.out.println("P2 Enter Valid Move");
                        }
                    } while (!p2ValidMove);
                    p2ValidMove = false;
                }
            }
            board.printBoard(chessBoard);
        }
        System.out.println("""

                            Game Over
                """);
    }
}

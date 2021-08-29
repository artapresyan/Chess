package com.company;
import java.util.Scanner;

public class Chess {

    public static void main(String[] args) {
        Board board = new Board();
        Scanner getLet = new Scanner(System.in);
        Scanner getNum = new Scanner(System.in);
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
        String takeColumnLet, putColumnLet;
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
                                    takeColumnLet = getLet.nextLine();
                                    if (!takeColumnLet.matches("[a-hA-H]"))
                                        System.out.println("P1 Enter Valid Column");
                                } while (!takeColumnLet.matches("[a-hA-H]"));
                                do {
                                    System.out.println("\n" + "P1 Enter Number From Which Row To Take");
                                    takeRow = getNum.nextByte();
                                    if (takeRow < 1 || takeRow > 8)
                                        System.out.println("P1 Enter Valid Row");
                                } while (takeRow < 1 || takeRow > 8);
                                takeColumn = 105 - takeColumnLet.charAt(0);
                                if (chessBoard[takeRow - 1][takeColumn - 1] == null)
                                    System.out.println("There Is No Figure There");
                            } while (chessBoard[takeRow - 1][takeColumn - 1] == null);
                            if (!chessBoard[takeRow - 1][takeColumn - 1].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                System.out.println("You Can Play Only With White Figures");
                        } while (!chessBoard[takeRow - 1][takeColumn - 1].getFigureColor().equals(Color.isWhiteFigure.getColor()));
                        do {
                            System.out.println("\n" + "P1 Enter Letter On Which Column To Put");
                            putColumnLet = getLet.nextLine();
                            if (!putColumnLet.matches("[a-hA-H]"))
                                System.out.println("P1 Enter Valid Column");
                        } while (!putColumnLet.matches("[a-hA-H]"));
                        do {
                            System.out.println("\n" + "P1 Enter Number On Which Row to Put");
                            putRow = getNum.nextByte();
                            if (putRow < 1 || putRow > 8)
                                System.out.println("P1 Enter Valid Row");
                        } while (putRow < 1 || putRow > 8);
                        putColumn = 105 - putColumnLet.charAt(0);
                        if (chessBoard[takeRow - 1][takeColumn - 1] instanceof Rook) {
                            if (whiteRook.checkMove(chessBoard, takeRow - 1, takeColumn - 1, putRow - 1, putColumn - 1)) {
                                whiteRook.moveFigure(chessBoard, takeRow - 1, takeColumn - 1, putRow - 1, putColumn - 1);
                                p1ValidMove = true;
                            } else
                                System.out.println("P1 Enter Valid Move");
                        } else if (chessBoard[takeRow - 1][takeColumn - 1] instanceof Knight) {
                            if (whiteKnight.checkMove(chessBoard, takeRow - 1, takeColumn - 1, putRow - 1, putColumn - 1)) {
                                whiteKnight.moveFigure(chessBoard, takeRow - 1, takeColumn - 1, putRow - 1, putColumn - 1);
                                p1ValidMove = true;
                            } else
                                System.out.println("P1 Enter Valid Move");
                        } else if (chessBoard[takeRow - 1][takeColumn - 1] instanceof Bishop) {
                            if (whiteBishop.checkMove(chessBoard, takeRow - 1, takeColumn - 1, putRow - 1, putColumn - 1)) {
                                whiteBishop.moveFigure(chessBoard, takeRow - 1, takeColumn - 1, putRow - 1, putColumn - 1);
                                p1ValidMove = true;
                            } else
                                System.out.println("P1 Enter Valid Move");
                        } else if (chessBoard[takeRow - 1][takeColumn - 1] instanceof King) {
                            if (whiteKing.checkMove(chessBoard, takeRow - 1, takeColumn - 1, putRow - 1, putColumn - 1)) {
                                whiteKing.moveFigure(chessBoard, takeRow - 1, takeColumn - 1, putRow - 1, putColumn - 1);
                                p1ValidMove = true;
                            } else
                                System.out.println("P1 Enter Valid Move");
                        } else if (chessBoard[takeRow - 1][takeColumn - 1] instanceof Queen) {
                            if (whiteQueen.checkMove(chessBoard, takeRow - 1, takeColumn - 1, putRow - 1, putColumn - 1)) {
                                whiteQueen.moveFigure(chessBoard, takeRow - 1, takeColumn - 1, putRow - 1, putColumn - 1);
                                p1ValidMove = true;
                            } else
                                System.out.println("P1 Enter Valid Move");
                        } else if (chessBoard[takeRow - 1][takeColumn - 1] instanceof Pawn) {
                            if (whitePawn.checkMove(chessBoard, takeRow - 1, takeColumn - 1, putRow - 1, putColumn - 1)) {
                                whitePawn.moveFigure(chessBoard, takeRow - 1, takeColumn - 1, putRow - 1, putColumn - 1);
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
                                    takeColumnLet = getLet.nextLine();
                                    if (!takeColumnLet.matches("[a-hA-H]"))
                                        System.out.println("P2 Enter Valid Column");
                                } while (!takeColumnLet.matches("[a-hA-H]"));
                                do {
                                    System.out.println("\n" + "P2 Enter Number From Which Row To Take");
                                    takeRow = getNum.nextByte();
                                    if (takeRow < 1 || takeRow > 8)
                                        System.out.println("P2 Enter Valid Row");
                                } while (takeRow < 1 || takeRow > 8);
                                takeColumn = 105 - takeColumnLet.charAt(0);
                                if (chessBoard[takeRow - 1][takeColumn - 1] == null)
                                    System.out.println("There Is No Figure There");
                            } while (chessBoard[takeRow - 1][takeColumn - 1] == null);
                            if (!chessBoard[takeRow - 1][takeColumn - 1].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                System.out.println("You Can Play Only With Black Figures");
                        } while (!chessBoard[takeRow - 1][takeColumn - 1].getFigureColor().equals(Color.isBlackFigure.getColor()));
                        do {
                            System.out.println("\n" + "P2 Enter Letter On Which Column To Put");
                            putColumnLet = getLet.nextLine();
                            if (!putColumnLet.matches("[a-hA-H]"))
                                System.out.println("P2 Enter Valid Column");
                        } while (!putColumnLet.matches("[a-hA-H]"));
                        do {
                            System.out.println("\n" + "P2 Enter Number On Which Row to Put");
                            putRow = getNum.nextByte();
                            if (putRow < 1 || putRow > 8)
                                System.out.println("P2 Enter Valid Row");
                        } while (putRow < 1 || putRow > 8);
                        putColumn = 105 - putColumnLet.charAt(0);
                        if (chessBoard[takeRow - 1][takeColumn - 1] instanceof Rook) {
                            if (blackRook.checkMove(chessBoard, takeRow - 1, takeColumn - 1, putRow - 1, putColumn - 1)) {
                                blackRook.moveFigure(chessBoard, takeRow - 1, takeColumn - 1, putRow - 1, putColumn - 1);
                                p2ValidMove = true;
                            } else
                                System.out.println("P2 Enter Valid Move");
                        } else if (chessBoard[takeRow - 1][takeColumn - 1] instanceof Knight) {
                            if (blackKnight.checkMove(chessBoard, takeRow - 1, takeColumn - 1, putRow - 1, putColumn - 1)) {
                                blackKnight.moveFigure(chessBoard, takeRow - 1, takeColumn - 1, putRow - 1, putColumn - 1);
                                p2ValidMove = true;
                            } else
                                System.out.println("P2 Enter Valid Move");
                        } else if (chessBoard[takeRow - 1][takeColumn - 1] instanceof Bishop) {
                            if (blackBishop.checkMove(chessBoard, takeRow - 1, takeColumn - 1, putRow - 1, putColumn - 1)) {
                                blackBishop.moveFigure(chessBoard, takeRow - 1, takeColumn - 1, putRow - 1, putColumn - 1);
                                p2ValidMove = true;
                            } else
                                System.out.println("P2 Enter Valid Move");
                        } else if (chessBoard[takeRow - 1][takeColumn - 1] instanceof King) {
                            if (blackKing.checkMove(chessBoard, takeRow - 1, takeColumn - 1, putRow - 1, putColumn - 1)) {
                                blackKing.moveFigure(chessBoard, takeRow - 1, takeColumn - 1, putRow - 1, putColumn - 1);
                                p2ValidMove = true;
                            } else
                                System.out.println("P2 Enter Valid Move");
                        } else if (chessBoard[takeRow - 1][takeColumn - 1] instanceof Queen) {
                            if (blackQueen.checkMove(chessBoard, takeRow - 1, takeColumn - 1, putRow - 1, putColumn - 1)) {
                                blackQueen.moveFigure(chessBoard, takeRow - 1, takeColumn - 1, putRow - 1, putColumn - 1);
                                p2ValidMove = true;
                            } else
                                System.out.println("P2 Enter Valid Move");
                        } else if (chessBoard[takeRow - 1][takeColumn - 1] instanceof Pawn) {
                            if (blackPawn.checkMove(chessBoard, takeRow - 1, takeColumn - 1, putRow - 1, putColumn - 1)) {
                                blackPawn.moveFigure(chessBoard, takeRow - 1, takeColumn - 1, putRow - 1, putColumn - 1);
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

package com.company;
import java.util.Scanner;

public class Chess {

    public static void main(String[] args) {
        Board board = new Board();
        int queue = 1;
        boolean gameOver = false;
        boolean p1ValidMove = false;
        boolean p2ValidMove = false;
        King whiteKing = new King(Color.isWhiteFigure, FigureName.whiteKing);
        King blackKing = new King(Color.isBlackFigure, FigureName.blackKing);
        int takeRow, takeColumn, putRow, putColumn;
        String takeFigure, putFigure;
        Figure[][] chessBoard = new Figure[8][8];
        Figure figure;
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
                        takeFigure = takeRightFigure(chessBoard, queue);
                        takeColumn = 104 - takeFigure.charAt(0);
                        takeRow = Integer.parseInt(String.valueOf(takeFigure.charAt(1))) - 1;

                        putFigure = putRightField(queue);
                        putColumn = 104 - putFigure.charAt(0);
                        putRow = Integer.parseInt(String.valueOf(putFigure.charAt(1))) - 1;

                        figure = determineFigure(chessBoard, takeRow, takeColumn, queue);

                        if (figure.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
                            figure.moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                            p1ValidMove = true;
                        } else
                            System.out.println("P1 Enter Valid Move");

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
                        takeFigure = takeRightFigure(chessBoard, queue);
                        takeColumn = 104 - takeFigure.charAt(0);
                        takeRow = Integer.parseInt(String.valueOf(takeFigure.charAt(1))) - 1;

                        putFigure = putRightField(queue);
                        putColumn = 104 - putFigure.charAt(0);
                        putRow = Integer.parseInt(String.valueOf(putFigure.charAt(1))) - 1;

                        figure = determineFigure(chessBoard, takeRow, takeColumn, queue);

                        if (figure.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
                            figure.moveFigure(chessBoard, takeRow, takeColumn, putRow, putColumn);
                            p2ValidMove = true;
                        } else
                            System.out.println("P2 Enter Valid Move");

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

    static Figure determineFigure(Figure[][] chessBoard, int takeRow, int takeColumn, int queue) {
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
        if (chessBoard[takeRow][takeColumn] instanceof Rook) {
            if (queue % 2 == 0)
                return whiteRook;
            else
                return blackRook;
        } else if (chessBoard[takeRow][takeColumn] instanceof Knight) {
            if (queue % 2 == 0)
                return whiteKnight;
            else
                return blackKnight;
        } else if (chessBoard[takeRow][takeColumn] instanceof Bishop) {
            if (queue % 2 == 0)
                return whiteBishop;
            else
                return blackBishop;
        } else if (chessBoard[takeRow][takeColumn] instanceof Queen) {
            if (queue % 2 == 0)
                return whiteQueen;
            else
                return blackQueen;
        } else if (chessBoard[takeRow][takeColumn] instanceof King) {
            if (queue % 2 == 0)
                return whiteKing;
            else
                return blackKing;
        } else {
            if (queue % 2 == 0)
                return whitePawn;
            else
                return blackPawn;
        }
    }

    static String takeRightFigure(Figure[][] chessBoard, int queue) {
        Scanner getString = new Scanner(System.in);
        String player, figure;
        Color color;
        if (queue % 2 == 0) {
            player = "P1";
            color = Color.isWhiteFigure;
        } else {
            player = "P2";
            color = Color.isBlackFigure;
        }
        int takeRow, takeColumn;
        do {
            do {
                do {
                    System.out.print("\n" + player + " Take Figure: ");
                    figure = getString.nextLine();
                    if (!figure.matches("[a-hA-H][1-8]"))
                        System.out.println(player + " Enter Valid Field");
                } while (!figure.matches("[a-hA-H][1-8]"));
                takeColumn = 104 - figure.charAt(0);
                takeRow = Integer.parseInt(String.valueOf(figure.charAt(1))) - 1;
                if (chessBoard[takeRow][takeColumn] == null)
                    System.out.println(player + " There Is No Figure");
            } while (chessBoard[takeRow][takeColumn] == null);
            if (!chessBoard[takeRow][takeColumn].getFigureColor().equals(color.getColor()))
                System.out.println(player + " You Can Play Only With " + color.getColor() + " Figures");
        } while (!chessBoard[takeRow][takeColumn].getFigureColor().equals(color.getColor()));
        return figure;
    }

    static String putRightField(int queue) {
        Scanner getString = new Scanner(System.in);
        String player, field;
        if (queue % 2 == 0)
            player = "P1";
        else
            player = "P2";
        do {
            System.out.print("\n" + player + " Put Figure: ");
            field = getString.nextLine();
            if (!field.matches("[a-hA-H][1-8]"))
                System.out.println(player + " Enter Valid Field To Put Figure");
        } while (!field.matches("[a-hA-H][1-8]"));
        return field;
    }
}

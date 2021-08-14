package com.company;

import java.util.Scanner;

public class Chess {

    public static void main(String[] args) {
        Board board=new Board();
        Scanner getLet=new Scanner(System.in);
        Scanner getNum=new Scanner(System.in);
        Figure rook=new Rook();
        Figure knight=new Knight();
        Figure bishop=new Bishop();
        Figure queen=new Queen();
        Figure king=new King();
        Figure pawn=new Pawn();
        Object let1,let2;
        int num1,num2;
        Object[][] chessBoard = new Object[10][10];
        board.createBoard(chessBoard);
        
        pawn.p2moveFigure(chessBoard,7,3,6,3);
        pawn.p1moveFigure(chessBoard,2,4,3,4);
        queen.p1moveFigure(chessBoard,1,5,5,1);
        pawn.p2moveFigure(chessBoard,7,2,6,2);
        pawn.p2moveFigure(chessBoard,6,3,5,3);

        board.getBoard(chessBoard);
    }
}

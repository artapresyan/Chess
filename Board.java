package com.company;

public class Board {
    void createBoard(Object[][] chessBoard){
        Figure rook=new Rook();
        Figure knight=new Knight();
        Figure bishop=new Bishop();
        Figure queen=new Queen();
        Figure king=new King();
        Figure pawn=new Pawn();

        for (int i=1,x=1;i<chessBoard.length-1;i++,x++)
            chessBoard[i][0]=x+" ";
        for (int i=1,x=1;i<chessBoard.length-1;i++,x++)
            chessBoard[i][9]=" "+x;
        for (char a='H', i=1;i<chessBoard.length-1;a--,i++)
            chessBoard[0][i]=" "+a+" ";
        for (char a='H', i=1;i<chessBoard.length-1;a--,i++)
            chessBoard[9][i]=" "+a+" ";
        chessBoard[0][0]="  ";
        chessBoard[9][0]="  ";
        chessBoard[0][9]="  ";
        chessBoard[9][9]="  ";
        chessBoard[1][1] = rook.p1whiteFigure();
        chessBoard[1][2] = knight.p1whiteFigure();
        chessBoard[1][3] = bishop.p1whiteFigure();
        chessBoard[1][4] = king.p1whiteFigure();
        chessBoard[1][5] = queen.p1whiteFigure();
        chessBoard[1][6] = bishop.p1blackFigure();
        chessBoard[1][7] = knight.p1whiteFigure();
        chessBoard[1][8] = rook.p1whiteFigure();
        for (int i=1;i<chessBoard[1].length-1;i++)
            chessBoard[2][i]=pawn.p1whiteFigure();
        chessBoard[8][1] = rook.p2blackFigure();
        chessBoard[8][2] = knight.p2blackFigure();
        chessBoard[8][3] = bishop.p2blackFigure();
        chessBoard[8][4] = king.p2blackFigure();
        chessBoard[8][5] = queen.p2blackFigure();
        chessBoard[8][6] = bishop.p2whiteFigure();
        chessBoard[8][7] = knight.p2blackFigure();
        chessBoard[8][8] = rook.p2blackFigure();
        for (int i=1;i<chessBoard[7].length-1;i++)
            chessBoard[7][i]=pawn.p2blackFigure();
    }
    void printBoard(Object[][] chessBoard){
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[1].length; j++) {
                if (chessBoard[i][j]==null){
                    if ((i + j) % 2 == 0)
                        chessBoard[i][j] = "***";//white
                    else
                        chessBoard[i][j] = "###";//black
                }
                System.out.print(chessBoard[i][j] + " ");
            }
            System.out.println();
        }
    }
    void getBoard(Object[][] chessBoard) {
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[1].length; j++) {
                if (chessBoard[i][j] == "###" || chessBoard[i][j] == "***") {
                    chessBoard[i][j]=null;
                }
            }
        }
    }
}

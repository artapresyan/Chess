package com.company;

public class Chess {

    public static void main(String[] args) {
        Object white="***";
        Object black="###";
        Figure rook=new Rook();
        Figure knight=new Knight();
        Figure bishop=new Bishop();
        Figure queen=new Queen();
        Figure king=new King();
        Figure pawn=new Pawn();
        Object[][] chessBoard = new Object[8][8];
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[0].length; j++) {
                if ((i + j) % 2 == 0)
                    chessBoard[i][j] = white;//spitak
                else
                    chessBoard[i][j] = black;//sev
            }
        }
        chessBoard[0][0] = rook.figure("w.R");
        chessBoard[0][1] = knight.figure("wKn");
        chessBoard[0][2] = bishop.figure("wwB");
        chessBoard[0][3] = king.figure("w.K");
        chessBoard[0][4] = queen.figure("w.Q");
        chessBoard[0][5] = bishop.figure("wbB");
        chessBoard[0][6] = knight.figure("wKn");
        chessBoard[0][7] = rook.figure("w.R");
        chessBoard[1][0]=pawn.figure("w.P");chessBoard[1][1]=pawn.figure("w.P");chessBoard[1][2]=pawn.figure("w.P");chessBoard[1][3]=pawn.figure("w.P");chessBoard[1][4]=pawn.figure("w.P");chessBoard[1][5]=pawn.figure("w.P");chessBoard[1][6]=pawn.figure("w.P");chessBoard[1][7]=pawn.figure("w.P");
        chessBoard[6][0]=pawn.figure("b.P");chessBoard[6][1]=pawn.figure("b.P");chessBoard[6][2]=pawn.figure("b.P");chessBoard[6][3]=pawn.figure("b.P");chessBoard[6][4]=pawn.figure("b.P");chessBoard[6][5]=pawn.figure("b.P");chessBoard[6][6]=pawn.figure("b.P");chessBoard[6][7]=pawn.figure("b.P");
        chessBoard[7][0] = rook.figure("b.R");
        chessBoard[7][1] = knight.figure("bKn");
        chessBoard[7][2] = bishop.figure("bwB");
        chessBoard[7][3] = king.figure("b.K");
        chessBoard[7][4] = queen.figure("b.Q");
        chessBoard[7][5] = bishop.figure("bbB");
        chessBoard[7][6] = knight.figure("bKn");
        chessBoard[7][7] = rook.figure("b.R");

        pawn.p1moveFigure(chessBoard,1,3,3,3);
        pawn.p1moveFigure(chessBoard,1,2,3,2);
        bishop.p1moveFigure(chessBoard,0,2,4,6);
        knight.p1moveFigure(chessBoard,0,1,2,0);
        queen.p1moveFigure(chessBoard,0,4,3,1);
        pawn.p1moveFigure(chessBoard,1,4,2,4);
        bishop.p1moveFigure(chessBoard,0,5,2,3);
        knight.p1moveFigure(chessBoard,0,6,2,5);
        rook.p1moveFigure(chessBoard,0,0,0,1);
        rook.p1moveFigure(chessBoard,0,1,0,0);
        rook.p1moveFigure(chessBoard,0,7,0,6);
        king.p1moveFigure(chessBoard,0,3,0,1);


        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[0].length; j++) {
                System.out.print(chessBoard[i][j] + " ");
            }
            System.out.println();
        }
    }
}

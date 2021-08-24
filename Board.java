package com.company;

public class Board {
    void createBoard(Object[][] chessBoard) {
        Figure rook = new Rook();
        Figure knight = new Knight();
        Figure bishop = new Bishop();
        Figure queen = new Queen();
        Figure king = new King();
        Figure pawn = new Pawn();

        chessBoard[0][0] = rook.p1whiteFigure();
        chessBoard[0][1] = knight.p1whiteFigure();
        chessBoard[0][2] = bishop.p1whiteFigure();
        chessBoard[0][3] = king.p1whiteFigure();
        chessBoard[0][4] = queen.p1whiteFigure();
        chessBoard[0][5] = bishop.p1blackFigure();
        chessBoard[0][6] = knight.p1whiteFigure();
        chessBoard[0][7] = rook.p1whiteFigure();
        for (int i = 0; i < chessBoard[1].length; i++)
            chessBoard[1][i] = pawn.p1whiteFigure();
        chessBoard[7][0] = rook.p2blackFigure();
        chessBoard[7][1] = knight.p2blackFigure();
        chessBoard[7][2] = bishop.p2blackFigure();
        chessBoard[7][3] = king.p2blackFigure();
        chessBoard[7][4] = queen.p2blackFigure();
        chessBoard[7][5] = bishop.p2whiteFigure();
        chessBoard[7][6] = knight.p2blackFigure();
        chessBoard[7][7] = rook.p2blackFigure();
        for (int i = 0; i < chessBoard[6].length; i++)
            chessBoard[6][i] = pawn.p2blackFigure();
    }

    void printBoard(Object[][] chessBoard) {
        Object[][] printBoard = new Object[10][10];
        printBoard[0][0] = "  ";
        printBoard[0][9] = "  ";
        printBoard[9][0] = "  ";
        printBoard[9][9] = "  ";
        for (int a = 1, x = 1; a < printBoard.length - 1; a++, x++)
            printBoard[a][9] = " " + x;
        for (char a = 'H', x = 1; x < printBoard.length - 1; a--, x++)
            printBoard[9][x] = " " + a + " ";
        for (int a = 1, x = 1; a < printBoard.length - 1; a++, x++)
            printBoard[a][0] = x + " ";
        for (char a = 'H', x = 1; x < printBoard[0].length - 1; a--, x++)
            printBoard[0][x] = " " + a + " ";

        for (int i = 0; i < printBoard.length; i++) {
            for (int j = 0; j < printBoard[i].length; j++) {
                if (i>0 && i<printBoard.length-1 && j>0 && j<printBoard[i].length-1) {
                    if (chessBoard[i-1][j-1] == null) {
                        if ((i + j) % 2 == 0)
                            printBoard[i][j] = "***";//white
                        else
                            printBoard[i][j] = "###";//black
                    } else
                        printBoard[i][j] = chessBoard[i-1][j-1];
                }
                System.out.print(printBoard[i][j] + " ");
            }
            System.out.println();
        }
    }
}


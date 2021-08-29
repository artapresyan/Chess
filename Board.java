package com.company;

public class Board {
    void createBoard(Figure[][] chessBoard) {
        chessBoard[0][0] = new Rook(Color.isWhiteFigure,FigureName.whiteRook);
        chessBoard[0][1] = new Knight(Color.isWhiteFigure,FigureName.whiteKnight);
        chessBoard[0][2] = new Bishop(Color.isWhiteFigure,FigureName.whiteWhiteBishop);
        chessBoard[0][3] = new King(Color.isWhiteFigure,FigureName.whiteKing);
        chessBoard[0][4] = new Queen(Color.isWhiteFigure,FigureName.whiteQueen);
        chessBoard[0][5] = new Bishop(Color.isWhiteFigure,FigureName.whiteBlackBishop);
        chessBoard[0][6] = new Knight(Color.isWhiteFigure,FigureName.whiteKnight);
        chessBoard[0][7] = new Rook(Color.isWhiteFigure,FigureName.whiteRook);
        for (int i = 0; i < chessBoard[1].length; i++)
            chessBoard[1][i] = new Pawn(Color.isWhiteFigure,FigureName.whitePawn);
        chessBoard[7][0] = new Rook(Color.isBlackFigure,FigureName.blackRook);
        chessBoard[7][1] = new Knight(Color.isBlackFigure,FigureName.blackKnight);
        chessBoard[7][2] = new Bishop(Color.isBlackFigure,FigureName.blackBlackBishop);
        chessBoard[7][3] = new King(Color.isBlackFigure,FigureName.blackKing);
        chessBoard[7][4] = new Queen(Color.isBlackFigure,FigureName.blackQueen);
        chessBoard[7][5] = new Bishop(Color.isBlackFigure,FigureName.blackWhiteBishop);
        chessBoard[7][6] = new Knight(Color.isBlackFigure,FigureName.blackKnight);
        chessBoard[7][7] = new Rook(Color.isBlackFigure,FigureName.blackRook);
        for (int i = 0; i < chessBoard[6].length; i++)
            chessBoard[6][i] = new Pawn(Color.isBlackFigure,FigureName.blackPawn);
    }

    void printBoard(Figure[][] chessBoard) {
        Object[][] printBoard = new Object[10][10];
        printBoard[0][0] = "  ";
        printBoard[0][9] = "  ";
        printBoard[9][0] = "  ";
        printBoard[9][9] = "  ";
        for (int a = 1, x = 1; a < printBoard.length - 1; a++, x++)
            printBoard[a][9] = " " + x;
        for (char a = 'A', x = 1; x < printBoard.length - 1; a++, x++)
            printBoard[9][x] = " " + a + " ";
        for (int a = 1, x = 1; a < printBoard.length - 1; a++, x++)
            printBoard[a][0] = x + " ";
        for (char a = 'A', x = 1; x < printBoard[0].length - 1; a++, x++)
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
                        printBoard[i][j] = chessBoard[i-1][j-1].getFigureName();
                }
                System.out.print(printBoard[i][j] + " ");
            }
            System.out.println();
        }
    }
}


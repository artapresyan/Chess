package com.company.figures;

import com.company.enum_class.Color;
import com.company.enum_class.FigureName;

import java.util.Scanner;

public class Pawn extends Figure {
    public Pawn(Color figureColor, FigureName figureName) {
        super(figureColor, figureName);
    }

    @Override
    public String getFigureColor() {
        return super.getFigureColor();
    }

    @Override
    public String getFigureName() {
        return super.getFigureName();
    }

    @Override
    public void moveFigure(Figure[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        String name;
        Scanner a = new Scanner(System.in);
        if (this.getFigureColor().equals(Color.isWhiteFigure.getColor())) {
            boolean rightFigure = false;
            if (putRow == 7) {
                chessBoard[putRow][putColumn] = this;
                chessBoard[takeRow][takeColumn] = null;
                do {
                    System.out.println("Choose figure");
                    name = a.nextLine();
                    if (name.equalsIgnoreCase("Knight")) {
                        chessBoard[7][putColumn] = new Knight(Color.isWhiteFigure, FigureName.whiteKnight);
                        rightFigure = true;
                    } else if (name.equalsIgnoreCase("Bishop")) {
                        if ((7 + putColumn) % 2 == 0)
                            chessBoard[7][putColumn] = new Bishop(Color.isWhiteFigure, FigureName.whiteWhiteBishop);
                        else
                            chessBoard[7][putColumn] = new Bishop(Color.isWhiteFigure, FigureName.whiteBlackBishop);
                        rightFigure = true;
                    } else if (name.equalsIgnoreCase("Rook")) {
                        chessBoard[7][putColumn] = new Rook(Color.isWhiteFigure, FigureName.whiteRook);
                        rightFigure = true;
                    } else if (name.equalsIgnoreCase("Queen")) {
                        chessBoard[7][putColumn] = new Queen(Color.isWhiteFigure, FigureName.whiteQueen);
                        rightFigure = true;
                    } else
                        System.out.println("Invalid Figure");
                } while (!rightFigure);
            } else {
                chessBoard[putRow][putColumn] = this;
                chessBoard[takeRow][takeColumn] = null;
            }
        } else {
            boolean rightFigure = false;
            if (putRow == 0) {
                chessBoard[putRow][putColumn] = this;
                chessBoard[takeRow][takeColumn] = null;
                do {
                    System.out.println("Choose figure");
                    name = a.nextLine();
                    if (name.equalsIgnoreCase("Knight")) {
                        chessBoard[0][putColumn] = new Knight(Color.isBlackFigure, FigureName.blackKnight);
                        rightFigure = true;
                    } else if (name.equalsIgnoreCase("Bishop")) {
                        if (putColumn % 2 == 0)
                            chessBoard[0][putColumn] = new Bishop(Color.isBlackFigure, FigureName.blackWhiteBishop);
                        else
                            chessBoard[0][putColumn] = new Bishop(Color.isBlackFigure, FigureName.blackBlackBishop);
                        rightFigure = true;
                    } else if (name.equalsIgnoreCase("Rook")) {
                        chessBoard[0][putColumn] = new Rook(Color.isBlackFigure, FigureName.blackRook);
                        rightFigure = true;
                    } else if (name.equalsIgnoreCase("Queen")) {
                        chessBoard[0][putColumn] = new Queen(Color.isBlackFigure, FigureName.blackQueen);
                        rightFigure = true;
                    } else
                        System.out.println("Invalid figure");
                } while (!rightFigure);
            } else {
                chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                chessBoard[takeRow][takeColumn] = null;
            }
        }
    }

    @Override
    public boolean checkMove(Figure[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (takeRow == putRow && takeColumn == putColumn)
            return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
        King king;
        if (this.getFigureColor().equals(Color.isWhiteFigure.getColor())) {
            king = new King(Color.isWhiteFigure, FigureName.whiteKing);
            if (takeRow == 1 && putRow == 3 && takeColumn == putColumn) {
                if (chessBoard[putRow][putColumn] == null && chessBoard[putRow - 1][putColumn] == null) {
                    chessBoard[putRow][putColumn] = this;
                    chessBoard[takeRow][takeColumn] = null;
                    if (king.kingChecked(chessBoard, Color.isWhiteFigure)) {
                        System.out.println("\n" + "P1, Please Be Observant And Check Your King's Position...");
                        chessBoard[takeRow][takeColumn] = this;
                        chessBoard[putRow][putColumn] = null;
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                    chessBoard[takeRow][takeColumn] = this;
                    chessBoard[putRow][putColumn] = null;
                    return true;
                }
            } else if (takeRow - putRow == -1) {
                if (takeColumn == putColumn && chessBoard[putRow][putColumn] == null) {
                    chessBoard[putRow][putColumn] = this;
                    chessBoard[takeRow][takeColumn] = null;
                    if (king.kingChecked(chessBoard, Color.isWhiteFigure)) {
                        System.out.println("\n" + "P1, Please Be Observant And Check Your King's Position...");
                        chessBoard[takeRow][takeColumn] = this;
                        chessBoard[putRow][putColumn] = null;
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                    chessBoard[takeRow][takeColumn] = this;
                    chessBoard[putRow][putColumn] = null;
                    return true;
                } else if (chessBoard[putRow][putColumn] != null) {
                    if (chessBoard[putRow][putColumn].getFigureColor().equals(Color.isBlackFigure.getColor()) && (takeColumn - putColumn == -1 || takeColumn - putColumn == 1)) {
                        Figure save = chessBoard[putRow][putColumn];
                        chessBoard[putRow][putColumn] = this;
                        chessBoard[takeRow][takeColumn] = null;
                        if (king.kingChecked(chessBoard, Color.isWhiteFigure)) {
                            System.out.println("\n" + "P1, Please Be Observant And Check Your King's Position...");
                            chessBoard[takeRow][takeColumn] = this;
                            chessBoard[putRow][putColumn] = save;
                            return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                        }
                        chessBoard[takeRow][takeColumn] = this;
                        chessBoard[putRow][putColumn] = save;
                        return true;
                    }
                }
            }
        } else {
            king = new King(Color.isBlackFigure, FigureName.blackKing);
            if (takeRow == 6 && putRow == 4 && takeColumn == putColumn) {
                if (chessBoard[putRow][putColumn] == null && chessBoard[putRow + 1][putColumn] == null) {
                    chessBoard[putRow][putColumn] = this;
                    chessBoard[takeRow][takeColumn] = null;
                    if (king.kingChecked(chessBoard, Color.isBlackFigure)) {
                        System.out.println("\n" + "P2, Please Be Observant And Check Your King's Position...");
                        chessBoard[takeRow][takeColumn] = this;
                        chessBoard[putRow][putColumn] = null;
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                    chessBoard[takeRow][takeColumn] = this;
                    chessBoard[putRow][putColumn] = null;
                    return true;
                }
            } else if (takeRow - putRow == 1) {
                if (takeColumn == putColumn && chessBoard[putRow][putColumn] == null) {
                    chessBoard[putRow][putColumn] = this;
                    chessBoard[takeRow][takeColumn] = null;
                    if (king.kingChecked(chessBoard, Color.isBlackFigure)) {
                        System.out.println("\n" + "P2, Please Be Observant And Check Your King's Position...");
                        chessBoard[takeRow][takeColumn] = this;
                        chessBoard[putRow][putColumn] = null;
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                    chessBoard[takeRow][takeColumn] = this;
                    chessBoard[putRow][putColumn] = null;
                    return true;
                } else if (chessBoard[putRow][putColumn] != null) {
                    if (chessBoard[putRow][putColumn].getFigureColor().equals(Color.isWhiteFigure.getColor()) && (takeColumn - putColumn == -1 || takeColumn - putColumn == 1)) {
                        Figure save = chessBoard[putRow][putColumn];
                        chessBoard[putRow][putColumn] = this;
                        chessBoard[takeRow][takeColumn] = null;
                        if (king.kingChecked(chessBoard, Color.isBlackFigure)) {
                            System.out.println("\n" + "P2, Please Be Observant And Check Your King's Position...");
                            chessBoard[takeRow][takeColumn] = this;
                            chessBoard[putRow][putColumn] = save;
                            return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                        }
                        chessBoard[takeRow][takeColumn] = this;
                        chessBoard[putRow][putColumn] = save;
                        return true;
                    }
                }
            }
        }
        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
    }

    @Override
    public boolean noValidMoves(Figure[][] chessBoard, Color color) {
        if (color.getColor().equals(Color.isWhiteFigure.getColor())) {
            for (int i = 0; i < chessBoard.length; i++) {
                for (int j = 0; j < chessBoard[i].length; j++) {
                    if (chessBoard[i][j] instanceof Pawn && chessBoard[i][j].getFigureColor().equals(Color.isWhiteFigure.getColor())) {
                        try {
                            if (checkMove(chessBoard, i, j, i + 1, j)) {
                                return false;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (checkMove(chessBoard, i, j, i + 2, j)) {
                                return false;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (checkMove(chessBoard, i, j, i + 1, j + 1)) {
                                return false;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (checkMove(chessBoard, i, j, i + 1, j - 1)) {
                                return false;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                    }
                }
            }
        } else {
            for (int i = chessBoard.length - 1; i >= 0; i--) {
                for (int j = 0; j < chessBoard[i].length; j++) {
                    if (chessBoard[i][j] instanceof Pawn && chessBoard[i][j].getFigureColor().equals(Color.isBlackFigure.getColor())) {
                        try {
                            if (checkMove(chessBoard, i, j, i - 1, j)) {
                                return false;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (checkMove(chessBoard, i, j, i - 2, j)) {
                                return false;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (checkMove(chessBoard, i, j, i - 1, j + 1)) {
                                return false;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (checkMove(chessBoard, i, j, i - 1, j - 1)) {
                                return false;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                    }
                }
            }
        }
        return super.noValidMoves(chessBoard, color);
    }
}



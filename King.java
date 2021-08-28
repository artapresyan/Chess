package com.company;

public class King extends Figure {
    King(Color figureColor,FigureName figureName){
        super(figureColor,figureName);
    }
    @Override
    public String getFigureColor() {
        return super.getFigureColor();
    }
    @Override
    public String getFigureName() {
        return super.getFigureName();
    }
    private boolean wkIsMoved = false;
    private boolean bkIsMoved = false;
    @Override
    void moveFigure(Figure[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (getFigureColor().equals(Color.isWhiteFigure.getColor())) {
            if (putRow == 0 && takeRow == 0 && takeColumn - putColumn == 2 && chessBoard[0][0] instanceof Rook &&
                    chessBoard[0][0].getFigureColor().equals(Color.isWhiteFigure.getColor()) && ((Rook)chessBoard[0][0]).wrIsMoved()) {
                chessBoard[0][putColumn] = chessBoard[0][takeColumn];
                chessBoard[0][takeColumn] = null;
                chessBoard[0][putColumn + 1] = chessBoard[0][0];
                chessBoard[0][0] = null;
            } else if (putRow == 0 && takeRow == 0 && takeColumn - putColumn == -2 && chessBoard[0][7] instanceof Rook &&
                    chessBoard[0][7].getFigureColor().equals(Color.isWhiteFigure.getColor()) && ((Rook)chessBoard[0][7]).wrIsMoved()) {
                chessBoard[0][putColumn] = chessBoard[0][takeColumn];
                chessBoard[0][takeColumn] = null;
                chessBoard[0][putColumn - 1] = chessBoard[0][7];
                chessBoard[0][7] = null;
            } else {
                wkIsMoved = true;
                chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                chessBoard[takeRow][takeColumn] = null;
            }
        }else {
            if (putRow == 7 && takeRow == 7 && takeColumn - putColumn == 2 && chessBoard[7][0] instanceof Rook &&
                    chessBoard[7][0].getFigureColor().equals(Color.isBlackFigure.getColor()) && ((Rook)chessBoard[7][0]).brIsMoved()) {
                chessBoard[7][putColumn] = chessBoard[7][takeColumn];
                chessBoard[7][takeColumn] = null;
                chessBoard[7][putColumn + 1] = chessBoard[7][0];
                chessBoard[7][0] = null;
            } else if (putRow == 7 && takeRow == 7 && takeColumn - putColumn == -2 && chessBoard[7][7] instanceof Rook &&
                    chessBoard[7][7].getFigureColor().equals(Color.isBlackFigure.getColor()) && ((Rook)chessBoard[7][7]).brIsMoved()) {
                chessBoard[7][putColumn] = chessBoard[7][takeColumn];
                chessBoard[7][takeColumn] = null;
                chessBoard[7][putColumn - 1] = chessBoard[7][7];
                chessBoard[7][7] = null;
            } else {
                bkIsMoved = true;
                chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                chessBoard[takeRow][takeColumn] = null;
            }
        }
    }
    @Override
    boolean checkMove(Figure[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (takeRow == putRow && takeColumn == putColumn)
            return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
        int j=takeColumn;
        if (getFigureColor().equals(Color.isWhiteFigure.getColor())) {
            if (!wkIsMoved && !KingChecked(chessBoard)) {
                if (putRow == 0 && takeRow == 0 && takeColumn - putColumn == 2 && chessBoard[0][0] instanceof Rook &&
                        chessBoard[0][0].getFigureColor().equals(Color.isWhiteFigure.getColor()) && ((Rook)chessBoard[0][0]).wrIsMoved()) {
                    while (j > 2) {
                        j--;
                        if (chessBoard[0][takeColumn] != null)
                            return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                    chessBoard[0][putColumn + 1] = chessBoard[0][takeColumn];
                    chessBoard[0][takeColumn] = null;
                    if (KingChecked(chessBoard)) {
                        System.out.println("\n" + "P1, Please Be Observant And Check Your King's Position...");
                        chessBoard[0][takeColumn] = new King(Color.isWhiteFigure,FigureName.whiteKing);
                        chessBoard[0][putColumn + 1] = null;
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                    chessBoard[0][putColumn] = chessBoard[0][putColumn + 1];
                    chessBoard[0][putColumn + 1] = null;
                    if (KingChecked(chessBoard)) {
                        System.out.println("\n" + "P1, Please Be Observant And Check Your King's Position...");
                        chessBoard[0][takeColumn] = new King(Color.isWhiteFigure,FigureName.whiteKing);
                        chessBoard[0][putColumn] = null;
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                    chessBoard[0][takeColumn] = new King(Color.isWhiteFigure,FigureName.whiteKing);
                    chessBoard[0][putColumn] = null;
                    return true;
                } else if (putRow == 0 && takeRow == 0 && takeColumn - putColumn == -2 && chessBoard[0][7] instanceof Rook &&
                        chessBoard[0][7].getFigureColor().equals(Color.isWhiteFigure.getColor()) && ((Rook)chessBoard[0][7]).wrIsMoved()) {
                    while (j < 7) {
                        j++;
                        if (chessBoard[0][takeColumn] != null)
                            return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                    chessBoard[0][putColumn - 1] = chessBoard[takeRow][takeColumn];
                    chessBoard[takeRow][takeColumn] = null;
                    if (KingChecked(chessBoard)) {
                        System.out.println("\n" + "P1, Please Be Observant And Check Your King's Position...");
                        chessBoard[0][takeColumn] = new King(Color.isWhiteFigure,FigureName.whiteKing);
                        chessBoard[0][putColumn] = null;
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                    chessBoard[0][putColumn] = chessBoard[0][putColumn - 1];
                    chessBoard[0][putColumn - 1] = null;
                    if (KingChecked(chessBoard)) {
                        System.out.println("\n" + "P1, Please Be Observant And Check Your King's Position...");
                        chessBoard[0][takeColumn] = new King(Color.isWhiteFigure,FigureName.whiteKing);
                        chessBoard[0][putColumn] = null;
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                    chessBoard[0][takeColumn] = new King(Color.isWhiteFigure,FigureName.whiteKing);
                    chessBoard[0][putColumn] = null;
                    return true;
                }
            }
            if (takeRow - putRow == -1 || takeRow - putRow == 1 || takeRow == putRow) {
                if (takeColumn - putColumn == -1 || takeColumn - putColumn == 1 || takeColumn == putColumn) {
                    if (chessBoard[putRow][putColumn] == null) {
                        chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                        chessBoard[takeRow][takeColumn] = null;

                        if (KingChecked(chessBoard)) {
                            System.out.println("\n" + "P1, Please Be Observant And Check Your King's Position...");
                            chessBoard[takeRow][takeColumn] = new King(Color.isWhiteFigure,FigureName.whiteKing);
                            chessBoard[putRow][putColumn] = null;
                            return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                        }
                        chessBoard[takeRow][takeColumn] = new King(Color.isWhiteFigure,FigureName.whiteKing);
                        chessBoard[putRow][putColumn] = null;
                        return true;
                    } else if (chessBoard[putRow][putColumn].getFigureColor().equals(Color.isBlackFigure.getColor())) {
                        Figure save = chessBoard[putRow][putColumn];
                        chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                        chessBoard[takeRow][takeColumn] = null;

                        if (KingChecked(chessBoard)) {
                            System.out.println("\n" + "P1, Please Be Observant And Check Your King's Position...");
                            chessBoard[takeRow][takeColumn] = new King(Color.isWhiteFigure,FigureName.whiteKing);
                            chessBoard[putRow][putColumn] = save;
                            return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                        }
                        chessBoard[takeRow][takeColumn] = new King(Color.isWhiteFigure,FigureName.whiteKing);
                        chessBoard[putRow][putColumn] = save;
                        return true;
                    }
                }
            }
        }else {
            if (!bkIsMoved && !KingChecked(chessBoard)) {
                if (putRow == 7 && takeRow == 7 && takeColumn - putColumn == 2 && chessBoard[7][0] instanceof Rook &&
                        chessBoard[7][0].getFigureColor().equals(Color.isBlackFigure.getColor()) && ((Rook)chessBoard[7][0]).brIsMoved()) {
                    while (takeColumn > 2) {
                        takeColumn--;
                        if (chessBoard[7][takeColumn] != null)
                            return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                    chessBoard[7][putColumn + 1] = chessBoard[7][takeColumn];
                    chessBoard[7][takeColumn] = null;
                    if (p2KingChecked(chessBoard)) {
                        System.out.println("\n"+"P2, Please Be Observant And Check Your King's Position...");
                        chessBoard[7][takeColumn] = new King(Color.isBlackFigure,FigureName.blackKing);
                        chessBoard[7][putColumn + 1] = null;
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                    chessBoard[7][putColumn] = chessBoard[7][putColumn + 1];
                    chessBoard[7][putColumn + 1] = null;
                    if (KingChecked(chessBoard)) {
                        System.out.println("\n"+"P2, Please Be Observant And Check Your King's Position...");
                        chessBoard[7][takeColumn] = new King(Color.isBlackFigure,FigureName.blackKing);
                        chessBoard[7][putColumn] = null;
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                    chessBoard[7][takeColumn] = new King(Color.isBlackFigure,FigureName.blackKing);
                    chessBoard[7][putColumn] = null;
                    return true;
                } else if (putRow == 7 && takeRow == 7 && takeColumn - putColumn == -2 && chessBoard[7][7] instanceof Rook &&
                        chessBoard[7][7].getFigureColor().equals(Color.isBlackFigure.getColor()) && ((Rook)chessBoard[7][7]).brIsMoved()) {
                    while (takeColumn < 7) {
                        takeColumn++;
                        if (chessBoard[7][takeColumn] != null)
                            return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                    chessBoard[7][putColumn - 1] = chessBoard[takeRow][takeColumn];
                    chessBoard[takeRow][takeColumn] = null;
                    if (KingChecked(chessBoard)) {
                        System.out.println("\n"+"P2, Please Be Observant And Check Your King's Position...");
                        chessBoard[7][takeColumn] = new King(Color.isBlackFigure,FigureName.blackKing);
                        chessBoard[7][putColumn] = null;
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                    chessBoard[7][putColumn] = chessBoard[7][putColumn - 1];
                    chessBoard[7][putColumn - 1] = null;
                    if (KingChecked(chessBoard)) {
                        System.out.println("\n"+"P2, Please Be Observant And Check Your King's Position...");
                        chessBoard[7][takeColumn] = new King(Color.isBlackFigure,FigureName.blackKing);
                        chessBoard[7][putColumn] = null;
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                    chessBoard[7][takeColumn] = new King(Color.isBlackFigure,FigureName.blackKing);
                    chessBoard[7][putColumn] = null;
                    return true;
                }
            }
            if (takeRow - putRow == -1 || takeRow - putRow == 1 || takeRow == putRow) {
                if (takeColumn - putColumn == -1 || takeColumn - putColumn == 1 || takeColumn == putColumn) {
                    if (chessBoard[putRow][putColumn] == null || chessBoard[putRow][putColumn].toString().charAt(0) == 'w') {
                        Figure save = chessBoard[putRow][putColumn];
                        chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                        chessBoard[takeRow][takeColumn] = null;
                        if (KingChecked(chessBoard)) {
                            System.out.println("\n"+"P2, Please Be Observant And Check Your King's Position...");
                            chessBoard[putRow][putColumn] = save;
                            chessBoard[takeRow][takeColumn] = new King(Color.isBlackFigure,FigureName.blackKing);
                            return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                        }
                        chessBoard[putRow][putColumn] = save;
                        chessBoard[takeRow][takeColumn] = new King(Color.isBlackFigure,FigureName.blackKing);
                        return true;
                    }
                }
            }
        }
        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
    }

    boolean kingChecked(Figure[][] chessBoard,Color color) {
        int i,j;
        if (color.getColor().equals(Color.isWhiteFigure.getColor())) {
            i = -1;
            while (i < chessBoard.length - 1) {
                i++;
                j = -1;
                while (j < chessBoard[i].length - 1) {
                    j++;
                    if (chessBoard[i][j] instanceof King && chessBoard[i][j].getFigureColor().equals(Color.isWhiteFigure.getColor())) {
                        int row = i;
                        int column = j;
                        try {
                            if (chessBoard[row + 1][column + 1] instanceof Pawn && chessBoard[row+1][column+1].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row + 1][column - 1] instanceof Pawn && chessBoard[row+1][column-1].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row + 1][column + 2] instanceof Knight && chessBoard[row+1][column+2].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row + 1][column - 2] instanceof Knight && chessBoard[row+1][column-2].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row + 2][column + 1] instanceof Knight && chessBoard[row+2][column+1].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row + 2][column - 1]instanceof Knight && chessBoard[row+2][column-1].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row - 1][column + 2] instanceof Knight && chessBoard[row-1][column+2].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row - 1][column - 2] instanceof Knight && chessBoard[row-1][column-2].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row - 2][column + 1] instanceof Knight && chessBoard[row-2][column+1].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row - 2][column - 1] instanceof Knight && chessBoard[row-2][column-1].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row + 1][column + 1] instanceof King && chessBoard[row+1][column+1].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row + 1][column] instanceof King && chessBoard[row+1][column].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row + 1][column - 1] instanceof King && chessBoard[row+1][column-1].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row][column - 1] instanceof King && chessBoard[row][column-1].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row - 1][column - 1] instanceof King && chessBoard[row-1][column-1].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row - 1][column]instanceof King && chessBoard[row-1][column].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row - 1][column + 1] instanceof King && chessBoard[row-1][column+1].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row][column + 1] instanceof King && chessBoard[row][column+1].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            do {
                                row++;
                                column++;
                                if (chessBoard[row][column] instanceof Bishop && chessBoard[row][column].getFigureColor().equals(Color.isBlackFigure.getColor()) ||
                                        chessBoard[row][column] instanceof Queen && chessBoard[row][column].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                    return true;
                            } while (chessBoard[row][column] == null);
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        row = i;
                        column = j;

                        try {
                            do {
                                row--;
                                column--;
                                if (chessBoard[row][column] instanceof Bishop && chessBoard[row][column].getFigureColor().equals(Color.isBlackFigure.getColor()) ||
                                        chessBoard[row][column] instanceof Queen && chessBoard[row][column].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                    return true;
                            } while (chessBoard[row][column] == null);
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        row = i;
                        column = j;

                        try {
                            do {
                                row--;
                                column++;
                                if (chessBoard[row][column] instanceof Bishop && chessBoard[row][column].getFigureColor().equals(Color.isBlackFigure.getColor()) ||
                                        chessBoard[row][column] instanceof Queen && chessBoard[row][column].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                    return true;
                            } while (chessBoard[row][column] == null);
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        row = i;
                        column = j;

                        try {
                            do {
                                row++;
                                column--;
                                if (chessBoard[row][column] instanceof Bishop && chessBoard[row][column].getFigureColor().equals(Color.isBlackFigure.getColor()) ||
                                        chessBoard[row][column] instanceof Queen && chessBoard[row][column].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                    return true;
                            } while (chessBoard[row][column] == null);
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        row = i;
                        column = j;

                        try {
                            do {
                                row++;
                                if (chessBoard[row][column] instanceof Rook && chessBoard[row][column].getFigureColor().equals(Color.isBlackFigure.getColor()) ||
                                        chessBoard[row][column] instanceof Queen && chessBoard[row][column].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                    return true;
                            } while (chessBoard[row][column] == null);
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        row = i;

                        try {
                            do {
                                row--;
                                if (chessBoard[row][column] instanceof Rook && chessBoard[row][column].getFigureColor().equals(Color.isBlackFigure.getColor()) ||
                                        chessBoard[row][column] instanceof Queen && chessBoard[row][column].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                    return true;
                            } while (chessBoard[row][column] == null);
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        row = i;

                        try {
                            do {
                                column++;
                                if (chessBoard[row][column] instanceof Rook && chessBoard[row][column].getFigureColor().equals(Color.isBlackFigure.getColor()) ||
                                        chessBoard[row][column] instanceof Queen && chessBoard[row][column].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                    return true;
                            } while (chessBoard[row][column] == null);
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        column = j;

                        try {
                            do {
                                column--;
                                if (chessBoard[row][column] instanceof Rook && chessBoard[row][column].getFigureColor().equals(Color.isBlackFigure.getColor()) ||
                                        chessBoard[row][column] instanceof Queen && chessBoard[row][column].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                    return true;
                            } while (chessBoard[row][column] == null);
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        return false;
                    }
                }
            }
        }else {
            i = 8;
            while (i > 0) {
                i--;
                j = -1;
                while (j < chessBoard[i].length-1) {
                    j++;
                    if (chessBoard[i][j] instanceof King && chessBoard[i][j].getFigureColor().equals(Color.isBlackFigure.getColor())) {
                        int row = i;
                        int column = j;
                        try {
                            if (chessBoard[row - 1][column - 1] instanceof Pawn && chessBoard[row-1][column-1].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row - 1][column + 1] instanceof Pawn && chessBoard[row-1][column+1].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row + 1][column + 2] instanceof Knight && chessBoard[row+1][column+2].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row + 1][column - 2] instanceof Knight && chessBoard[row+1][column-2].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row + 2][column + 1] instanceof Knight && chessBoard[row+2][column+1].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row + 2][column - 1] instanceof Knight && chessBoard[row+2][column-1].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row - 1][column + 2] instanceof Knight && chessBoard[row-1][column+2].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row - 1][column - 2] instanceof Knight && chessBoard[row-1][column-2].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row - 2][column + 1] instanceof Knight && chessBoard[row-2][column+1].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row - 2][column - 1] instanceof Knight && chessBoard[row-2][column-1].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row + 1][column + 1] instanceof King && chessBoard[row+1][column+1].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row + 1][column] instanceof King && chessBoard[row+1][column].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row + 1][column - 1] instanceof King && chessBoard[row+1][column-1].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row][column - 1] instanceof King && chessBoard[row][column-1].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row - 1][column - 1] instanceof King && chessBoard[row-1][column-1].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row - 1][column] instanceof King && chessBoard[row-1][column].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row - 1][column + 1] instanceof King && chessBoard[row-1][column+1].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row][column + 1] instanceof King && chessBoard[row][column+1].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            do {
                                row++;
                                column++;
                                if (chessBoard[row][column] instanceof Bishop && chessBoard[row][column].getFigureColor().equals(Color.isWhiteFigure.getColor()) ||
                                        chessBoard[row][column] instanceof Queen && chessBoard[row][column].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                    return true;
                            } while (chessBoard[row][column] == null);
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        row = i;
                        column = j;

                        try {
                            do {
                                row++;
                                if (chessBoard[row][column] instanceof Rook && chessBoard[row][column].getFigureColor().equals(Color.isWhiteFigure.getColor()) ||
                                        chessBoard[row][column] instanceof Queen && chessBoard[row][column].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                    return true;

                            } while (chessBoard[row][column] == null);
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        row = i;

                        try {
                            do {
                                row--;
                                column--;
                                if (chessBoard[row][column] instanceof Bishop && chessBoard[row][column].getFigureColor().equals(Color.isWhiteFigure.getColor()) ||
                                        chessBoard[row][column] instanceof Queen && chessBoard[row][column].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                    return true;
                            } while (chessBoard[row][column] == null);
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        row = i;
                        column = j;

                        try {
                            do {
                                row--;
                                if (chessBoard[row][column] instanceof Rook && chessBoard[row][column].getFigureColor().equals(Color.isWhiteFigure.getColor()) ||
                                        chessBoard[row][column] instanceof Queen && chessBoard[row][column].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                    return true;
                            } while (chessBoard[row][column] == null);
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        row = i;

                        try {
                            do {
                                column++;
                                if (chessBoard[row][column] instanceof Rook && chessBoard[row][column].getFigureColor().equals(Color.isWhiteFigure.getColor()) ||
                                        chessBoard[row][column] instanceof Queen && chessBoard[row][column].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                    return true;
                            } while (chessBoard[row][column] == null);
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        column = j;

                        try {
                            do {
                                column--;
                                if (chessBoard[row][column] instanceof Rook && chessBoard[row][column].getFigureColor().equals(Color.isWhiteFigure.getColor()) ||
                                        chessBoard[row][column] instanceof Queen && chessBoard[row][column].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                    return true;
                            } while (chessBoard[row][column] == null);
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        column = j;

                        try {
                            do {
                                row--;
                                column++;
                                if (chessBoard[row][column] instanceof Bishop && chessBoard[row][column].getFigureColor().equals(Color.isWhiteFigure.getColor()) ||
                                        chessBoard[row][column] instanceof Queen && chessBoard[row][column].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                    return true;
                            } while (chessBoard[row][column] == null);
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        row = i;
                        column = j;

                        try {
                            do {
                                row++;
                                column--;
                                if (chessBoard[row][column] instanceof Bishop && chessBoard[row][column].getFigureColor().equals(Color.isWhiteFigure.getColor()) ||
                                        chessBoard[row][column] instanceof Queen && chessBoard[row][column].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                    return true;
                            } while (chessBoard[row][column] == null);
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        return false;
                    }
                }
            }
        }
        return false;
    }
    boolean p1NoMoves(Object[][] chessBoard) {
        Object mover;
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                if ((chessBoard[i][j] == "w.K")) {
                    try {
                        mover = chessBoard[i + 1][j];
                        if (mover == null || mover.toString().charAt(0) == 'b') {
                            chessBoard[i + 1][j] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p1KingChecked(chessBoard)) {
                                chessBoard[i][j] = p1whiteFigure();
                                chessBoard[i + 1][j] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p1whiteFigure();
                        chessBoard[i + 1][j] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        mover = chessBoard[i + 1][j - 1];
                        if (mover == null || mover.toString().charAt(0) == 'b') {
                            chessBoard[i + 1][j - 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p1KingChecked(chessBoard)) {
                                chessBoard[i][j] = p1whiteFigure();
                                chessBoard[i + 1][j - 1] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p1whiteFigure();
                        chessBoard[i + 1][j - 1] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        mover = chessBoard[i + 1][j + 1];
                        if (mover == null || mover.toString().charAt(0) == 'b') {
                            chessBoard[i + 1][j + 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p1KingChecked(chessBoard)) {
                                chessBoard[i][j] = p1whiteFigure();
                                chessBoard[i + 1][j + 1] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p1whiteFigure();
                        chessBoard[i + 1][j + 1] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        mover = chessBoard[i][j - 1];
                        if (mover == null || mover.toString().charAt(0) == 'b') {
                            chessBoard[i][j - 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p1KingChecked(chessBoard)) {
                                chessBoard[i][j] = p1whiteFigure();
                                chessBoard[i][j - 1] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p1whiteFigure();
                        chessBoard[i][j - 1] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        mover = chessBoard[i][j + 1];
                        if (mover == null || mover.toString().charAt(0) == 'b') {
                            chessBoard[i][j + 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p1KingChecked(chessBoard)) {
                                chessBoard[i][j] = p1whiteFigure();
                                chessBoard[i][j + 1] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p1whiteFigure();
                        chessBoard[i][j + 1] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        mover = chessBoard[i - 1][j - 1];
                        if (mover == null || mover.toString().charAt(0) == 'b') {
                            chessBoard[i - 1][j - 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p1KingChecked(chessBoard)) {
                                chessBoard[i][j] = p1whiteFigure();
                                chessBoard[i - 1][j - 1] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p1whiteFigure();
                        chessBoard[i - 1][j - 1] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        mover = chessBoard[i - 1][j];
                        if (mover == null || mover.toString().charAt(0) == 'b') {
                            chessBoard[i - 1][j] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p1KingChecked(chessBoard)) {
                                chessBoard[i][j] = p1whiteFigure();
                                chessBoard[i - 1][j] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p1whiteFigure();
                        chessBoard[i - 1][j] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        mover = chessBoard[i - 1][j + 1];
                        if (mover == null || mover.toString().charAt(0) == 'b') {
                            chessBoard[i - 1][j + 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p1KingChecked(chessBoard)) {
                                chessBoard[i][j] = p1whiteFigure();
                                chessBoard[i - 1][j + 1] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p1whiteFigure();
                        chessBoard[i - 1][j + 1] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    return super.p1NoMoves(chessBoard);
                }
            }
        }
        return false;
    }

    boolean p2NoMoves(Object[][] chessBoard) {
        Object mover;
        for (int i = chessBoard.length - 1; i >= 0; i--) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                if ((chessBoard[i][j] == "b.K")) {
                    try {
                        mover = chessBoard[i + 1][j];
                        if (mover == null || mover.toString().charAt(0) == 'w') {
                            chessBoard[i + 1][j] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p2KingChecked(chessBoard)) {
                                chessBoard[i][j] = p2blackFigure();
                                chessBoard[i + 1][j] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p2blackFigure();
                        chessBoard[i + 1][j] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        mover = chessBoard[i + 1][j - 1];
                        if (mover == null || mover.toString().charAt(0) == 'w') {
                            chessBoard[i + 1][j - 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p2KingChecked(chessBoard)) {
                                chessBoard[i][j] = p2blackFigure();
                                chessBoard[i + 1][j - 1] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p2blackFigure();
                        chessBoard[i + 1][j - 1] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        mover = chessBoard[i + 1][j + 1];
                        if (mover == null || mover.toString().charAt(0) == 'w') {
                            chessBoard[i + 1][j + 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p2KingChecked(chessBoard)) {
                                chessBoard[i][j] = p2blackFigure();
                                chessBoard[i + 1][j + 1] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p2blackFigure();
                        chessBoard[i + 1][j + 1] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        mover = chessBoard[i][j - 1];
                        if (mover == null || mover.toString().charAt(0) == 'w') {
                            chessBoard[i][j - 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p2KingChecked(chessBoard)) {
                                chessBoard[i][j] = p2blackFigure();
                                chessBoard[i][j - 1] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p2blackFigure();
                        chessBoard[i][j - 1] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        mover = chessBoard[i][j + 1];
                        if (mover == null || mover.toString().charAt(0) == 'w') {
                            chessBoard[i][j + 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p2KingChecked(chessBoard)) {
                                chessBoard[i][j] = p2blackFigure();
                                chessBoard[i][j + 1] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p2blackFigure();
                        chessBoard[i][j + 1] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        mover = chessBoard[i - 1][j - 1];
                        if (mover == null || mover.toString().charAt(0) == 'w') {
                            chessBoard[i - 1][j - 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p2KingChecked(chessBoard)) {
                                chessBoard[i][j] = p2blackFigure();
                                chessBoard[i - 1][j - 1] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p2blackFigure();
                        chessBoard[i - 1][j - 1] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        mover = chessBoard[i - 1][j];
                        if (mover == null || mover.toString().charAt(0) == 'w') {
                            chessBoard[i - 1][j] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p2KingChecked(chessBoard)) {
                                chessBoard[i][j] = p2blackFigure();
                                chessBoard[i - 1][j] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p2blackFigure();
                        chessBoard[i - 1][j] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        mover = chessBoard[i - 1][j + 1];
                        if (mover == null || mover.toString().charAt(0) == 'w') {
                            chessBoard[i - 1][j + 1] = chessBoard[i][j];
                            chessBoard[i][j] = null;
                            if (!p2KingChecked(chessBoard)) {
                                chessBoard[i][j] = p2blackFigure();
                                chessBoard[i - 1][j + 1] = mover;
                                return false;
                            }
                        }
                        chessBoard[i][j] = p2blackFigure();
                        chessBoard[i - 1][j + 1] = mover;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    return super.p1NoMoves(chessBoard);
                }
            }
        }
        return false;
    }

    boolean p1Mated(Object[][] chessBoard) {
        Figure rook = new Rook();
        Figure knight = new Knight();
        Figure bishop = new Bishop();
        Figure queen = new Queen();
        Figure pawn = new Pawn();
        if (p1KingChecked(chessBoard) && p1NoMoves(chessBoard)) {
            return !rook.p1CoverCheck(chessBoard) && !bishop.p1CoverCheck(chessBoard) && !queen.p1CoverCheck(chessBoard) && !knight.p1CoverCheck(chessBoard) && !pawn.p1CoverCheck(chessBoard);
        }
        return false;
    }

    boolean p2Mated(Object[][] chessBoard) {
        Figure rook = new Rook();
        Figure knight = new Knight();
        Figure bishop = new Bishop();
        Figure queen = new Queen();
        Figure pawn = new Pawn();
        if (p2KingChecked(chessBoard) && p2NoMoves(chessBoard)) {
            return !rook.p2CoverCheck(chessBoard) && !bishop.p2CoverCheck(chessBoard) && !queen.p2CoverCheck(chessBoard) && !knight.p2CoverCheck(chessBoard) && !pawn.p2CoverCheck(chessBoard);
        }
        return false;
    }

    boolean p1StaleMate(Object[][] chessBoard) {
        Figure rook = new Rook();
        Figure knight = new Knight();
        Figure bishop = new Bishop();
        Figure queen = new Queen();
        Figure pawn = new Pawn();
        if (!p1KingChecked(chessBoard) && p1NoMoves(chessBoard))
            return rook.p1NoMoves(chessBoard) && bishop.p1NoMoves(chessBoard) && knight.p1NoMoves(chessBoard) && pawn.p1NoMoves(chessBoard) && queen.p1NoMoves(chessBoard);
        return false;
    }

    boolean p2StaleMate(Object[][] chessBoard) {
        Figure rook = new Rook();
        Figure knight = new Knight();
        Figure bishop = new Bishop();
        Figure queen = new Queen();
        Figure pawn = new Pawn();
        if (!p2KingChecked(chessBoard) && p2NoMoves(chessBoard))
            return rook.p2NoMoves(chessBoard) && bishop.p2NoMoves(chessBoard) && knight.p2NoMoves(chessBoard) && pawn.p2NoMoves(chessBoard) && queen.p2NoMoves(chessBoard);
        return false;
    }
}

package com.company;

public class King extends Figure {

    private boolean wkIsMoved = false;
    private boolean bkIsMoved = false;

    King(Color figureColor, FigureName figureName) {
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
    void moveFigure(Figure[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (this.getFigureColor().equals(Color.isWhiteFigure.getColor())) {
            if (putRow == 0 && takeRow == 0 && takeColumn - putColumn == 2 && chessBoard[0][0] instanceof Rook &&
                    chessBoard[0][0].getFigureColor().equals(Color.isWhiteFigure.getColor()) && !((Rook) chessBoard[0][0]).wrIsMoved()) {
                chessBoard[0][putColumn] = this;
                chessBoard[0][takeColumn] = null;
                chessBoard[0][putColumn + 1] = chessBoard[0][0];
                chessBoard[0][0] = null;
            } else if (putRow == 0 && takeRow == 0 && takeColumn - putColumn == -2 && chessBoard[0][7] instanceof Rook &&
                    chessBoard[0][7].getFigureColor().equals(Color.isWhiteFigure.getColor()) && !((Rook) chessBoard[0][7]).wrIsMoved()) {
                chessBoard[0][putColumn] = this;
                chessBoard[0][takeColumn] = null;
                chessBoard[0][putColumn - 1] = chessBoard[0][7];
                chessBoard[0][7] = null;
            } else {
                wkIsMoved = true;
                chessBoard[putRow][putColumn] = this;
                chessBoard[takeRow][takeColumn] = null;
            }
        } else {
            if (putRow == 7 && takeRow == 7 && takeColumn - putColumn == 2 && chessBoard[7][0] instanceof Rook &&
                    chessBoard[7][0].getFigureColor().equals(Color.isBlackFigure.getColor()) && !((Rook) chessBoard[7][0]).brIsMoved()) {
                chessBoard[7][putColumn] = this;
                chessBoard[7][takeColumn] = null;
                chessBoard[7][putColumn + 1] = chessBoard[7][0];
                chessBoard[7][0] = null;
            } else if (putRow == 7 && takeRow == 7 && takeColumn - putColumn == -2 && chessBoard[7][7] instanceof Rook &&
                    chessBoard[7][7].getFigureColor().equals(Color.isBlackFigure.getColor()) && !((Rook) chessBoard[7][7]).brIsMoved()) {
                chessBoard[7][putColumn] = this;
                chessBoard[7][takeColumn] = null;
                chessBoard[7][putColumn - 1] = chessBoard[7][7];
                chessBoard[7][7] = null;
            } else {
                bkIsMoved = true;
                chessBoard[putRow][putColumn] = this;
                chessBoard[takeRow][takeColumn] = null;
            }
        }
    }

    @Override
    boolean checkMove(Figure[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (takeRow == putRow && takeColumn == putColumn)
            return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
        int j = takeColumn;
        boolean rowCheck = takeRow - putRow == -1 || takeRow - putRow == 1 || takeRow == putRow;
        boolean columnCheck = takeColumn - putColumn == -1 || takeColumn - putColumn == 1 || takeColumn == putColumn;
        if (this.getFigureColor().equals(Color.isWhiteFigure.getColor())) {
            if (!wkIsMoved && !kingChecked(chessBoard, Color.isWhiteFigure)) {
                if (putRow == 0 && takeRow == 0 && takeColumn - putColumn == 2 && chessBoard[0][0] instanceof Rook &&
                        chessBoard[0][0].getFigureColor().equals(Color.isWhiteFigure.getColor()) && !((Rook) chessBoard[0][0]).wrIsMoved()) {
                    while (j > 2) {
                        j--;
                        if (chessBoard[0][j] != null)
                            return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                    chessBoard[0][putColumn + 1] = this;
                    chessBoard[0][takeColumn] = null;
                    if (kingChecked(chessBoard, Color.isWhiteFigure)) {
                        System.out.println("\n" + "P1, Please Be Observant And Check Your King's Position...");
                        chessBoard[0][takeColumn] = this;
                        chessBoard[0][putColumn + 1] = null;
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                    chessBoard[0][putColumn] = this;
                    chessBoard[0][putColumn + 1] = null;
                    if (kingChecked(chessBoard, Color.isWhiteFigure)) {
                        System.out.println("\n" + "P1, Please Be Observant And Check Your King's Position...");
                        chessBoard[0][takeColumn] = this;
                        chessBoard[0][putColumn] = null;
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                    chessBoard[0][takeColumn] = this;
                    chessBoard[0][putColumn] = null;
                    return true;
                } else if (putRow == 0 && takeRow == 0 && takeColumn - putColumn == -2 && chessBoard[0][7] instanceof Rook &&
                        chessBoard[0][7].getFigureColor().equals(Color.isWhiteFigure.getColor()) && !((Rook) chessBoard[0][7]).wrIsMoved()) {
                    while (j < 7) {
                        j++;
                        if (chessBoard[0][j] != null)
                            return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                    chessBoard[0][putColumn - 1] = this;
                    chessBoard[takeRow][takeColumn] = null;
                    if (kingChecked(chessBoard, Color.isWhiteFigure)) {
                        System.out.println("\n" + "P1, Please Be Observant And Check Your King's Position...");
                        chessBoard[0][takeColumn] = this;
                        chessBoard[0][putColumn] = null;
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                    chessBoard[0][putColumn] = this;
                    chessBoard[0][putColumn - 1] = null;
                    if (kingChecked(chessBoard, Color.isWhiteFigure)) {
                        System.out.println("\n" + "P1, Please Be Observant And Check Your King's Position...");
                        chessBoard[0][takeColumn] = this;
                        chessBoard[0][putColumn] = null;
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                    chessBoard[0][takeColumn] = this;
                    chessBoard[0][putColumn] = null;
                    return true;
                }
            }
            if (rowCheck) {
                if (columnCheck) {
                    if (chessBoard[putRow][putColumn] == null) {
                        chessBoard[putRow][putColumn] = this;
                        chessBoard[takeRow][takeColumn] = null;

                        if (kingChecked(chessBoard, Color.isWhiteFigure)) {
                            System.out.println("\n" + "P1, Please Be Observant And Check Your King's Position...");
                            chessBoard[takeRow][takeColumn] = this;
                            chessBoard[putRow][putColumn] = null;
                            return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                        }
                        chessBoard[takeRow][takeColumn] = this;
                        chessBoard[putRow][putColumn] = null;
                        return true;
                    } else if (chessBoard[putRow][putColumn].getFigureColor().equals(Color.isBlackFigure.getColor())) {
                        Figure save = chessBoard[putRow][putColumn];
                        chessBoard[putRow][putColumn] = this;
                        chessBoard[takeRow][takeColumn] = null;

                        if (kingChecked(chessBoard, Color.isWhiteFigure)) {
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
            if (!bkIsMoved && !kingChecked(chessBoard, Color.isBlackFigure)) {
                if (putRow == 7 && takeRow == 7 && takeColumn - putColumn == 2 && chessBoard[7][0] instanceof Rook &&
                        chessBoard[7][0].getFigureColor().equals(Color.isBlackFigure.getColor()) && !((Rook) chessBoard[7][0]).brIsMoved()) {
                    while (j > 2) {
                        j--;
                        if (chessBoard[7][j] != null)
                            return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                    chessBoard[7][putColumn + 1] = this;
                    chessBoard[7][takeColumn] = null;
                    if (kingChecked(chessBoard, Color.isBlackFigure)) {
                        System.out.println("\n" + "P2, Please Be Observant And Check Your King's Position...");
                        chessBoard[7][takeColumn] = this;
                        chessBoard[7][putColumn + 1] = null;
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                    chessBoard[7][putColumn] = this;
                    chessBoard[7][putColumn + 1] = null;
                    if (kingChecked(chessBoard, Color.isBlackFigure)) {
                        System.out.println("\n" + "P2, Please Be Observant And Check Your King's Position...");
                        chessBoard[7][takeColumn] = this;
                        chessBoard[7][putColumn] = null;
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                    chessBoard[7][takeColumn] = this;
                    chessBoard[7][putColumn] = null;
                    return true;
                } else if (putRow == 7 && takeRow == 7 && takeColumn - putColumn == -2 && chessBoard[7][7] instanceof Rook &&
                        chessBoard[7][7].getFigureColor().equals(Color.isBlackFigure.getColor()) && !((Rook) chessBoard[7][7]).brIsMoved()) {
                    while (j < 7) {
                        j++;
                        if (chessBoard[7][j] != null)
                            return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                    chessBoard[7][putColumn - 1] = this;
                    chessBoard[takeRow][takeColumn] = null;
                    if (kingChecked(chessBoard, Color.isBlackFigure)) {
                        System.out.println("\n" + "P2, Please Be Observant And Check Your King's Position...");
                        chessBoard[7][takeColumn] = this;
                        chessBoard[7][putColumn] = null;
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                    chessBoard[7][putColumn] = this;
                    chessBoard[7][putColumn - 1] = null;
                    if (kingChecked(chessBoard, Color.isBlackFigure)) {
                        System.out.println("\n" + "P2, Please Be Observant And Check Your King's Position...");
                        chessBoard[7][takeColumn] = this;
                        chessBoard[7][putColumn] = null;
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                    chessBoard[7][takeColumn] = this;
                    chessBoard[7][putColumn] = null;
                    return true;
                }
            }
            if (rowCheck) {
                if (columnCheck) {
                    if (chessBoard[putRow][putColumn] == null) {
                        chessBoard[putRow][putColumn] = this;
                        chessBoard[takeRow][takeColumn] = null;
                        if (kingChecked(chessBoard, Color.isBlackFigure)) {
                            System.out.println("\n" + "P2, Please Be Observant And Check Your King's Position...");
                            chessBoard[putRow][putColumn] = null;
                            chessBoard[takeRow][takeColumn] = this;
                            return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                        }
                        chessBoard[putRow][putColumn] = null;
                        chessBoard[takeRow][takeColumn] = this;
                        return true;
                    }else if (chessBoard[putRow][putColumn].getFigureColor().equals(Color.isWhiteFigure.getColor())){
                        Figure save = chessBoard[putRow][putColumn];
                        chessBoard[putRow][putColumn] = this;
                        chessBoard[takeRow][takeColumn] = null;
                        if (kingChecked(chessBoard, Color.isBlackFigure)) {
                            System.out.println("\n" + "P2, Please Be Observant And Check Your King's Position...");
                            chessBoard[putRow][putColumn] = save;
                            chessBoard[takeRow][takeColumn] = this;
                            return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                        }
                        chessBoard[putRow][putColumn] = save;
                        chessBoard[takeRow][takeColumn] = this;
                        return true;
                    }
                }
            }
        }
        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
    }

    @Override
    boolean validMoves(Figure[][] chessBoard, Color color) {
        Figure save;
        if (color.getColor().equals(Color.isWhiteFigure.getColor())) {
            for (int i = 0; i < chessBoard.length; i++) {
                for (int j = 0; j < chessBoard[i].length; j++) {
                    if ((chessBoard[i][j] instanceof King && chessBoard[i][j].getFigureColor().equals(Color.isWhiteFigure.getColor()))) {
                        try {
                            save = chessBoard[i + 1][j];
                            if (save == null || save.getFigureColor().equals(Color.isBlackFigure.getColor())) {
                                chessBoard[i + 1][j] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!kingChecked(chessBoard, Color.isWhiteFigure)) {
                                    chessBoard[i][j] = new King(Color.isWhiteFigure, FigureName.whiteKing);
                                    chessBoard[i + 1][j] = save;
                                    return super.validMoves(chessBoard,color);
                                }
                            }
                            chessBoard[i][j] = new King(Color.isWhiteFigure, FigureName.whiteKing);
                            chessBoard[i + 1][j] = save;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            save = chessBoard[i + 1][j - 1];
                            if (save == null || save.getFigureColor().equals(Color.isBlackFigure.getColor())) {
                                chessBoard[i + 1][j - 1] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!kingChecked(chessBoard, Color.isWhiteFigure)) {
                                    chessBoard[i][j] = new King(Color.isWhiteFigure, FigureName.whiteKing);
                                    chessBoard[i + 1][j - 1] = save;
                                    return super.validMoves(chessBoard,color);
                                }
                            }
                            chessBoard[i][j] = new King(Color.isWhiteFigure, FigureName.whiteKing);
                            chessBoard[i + 1][j - 1] = save;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            save = chessBoard[i + 1][j + 1];
                            if (save == null || save.getFigureColor().equals(Color.isBlackFigure.getColor())) {
                                chessBoard[i + 1][j + 1] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!kingChecked(chessBoard, Color.isWhiteFigure)) {
                                    chessBoard[i][j] = new King(Color.isWhiteFigure, FigureName.whiteKing);
                                    chessBoard[i + 1][j + 1] = save;
                                    return super.validMoves(chessBoard,color);
                                }
                            }
                            chessBoard[i][j] = new King(Color.isWhiteFigure, FigureName.whiteKing);
                            chessBoard[i + 1][j + 1] = save;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            save = chessBoard[i][j - 1];
                            if (save == null || save.getFigureColor().equals(Color.isBlackFigure.getColor())) {
                                chessBoard[i][j - 1] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!kingChecked(chessBoard, Color.isWhiteFigure)) {
                                    chessBoard[i][j] = new King(Color.isWhiteFigure, FigureName.whiteKing);
                                    chessBoard[i][j - 1] = save;
                                    return super.validMoves(chessBoard,color);
                                }
                            }
                            chessBoard[i][j] = new King(Color.isWhiteFigure, FigureName.whiteKing);
                            chessBoard[i][j - 1] = save;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            save = chessBoard[i][j + 1];
                            if (save == null || save.getFigureColor().equals(Color.isBlackFigure.getColor())) {
                                chessBoard[i][j + 1] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!kingChecked(chessBoard, Color.isWhiteFigure)) {
                                    chessBoard[i][j] = new King(Color.isWhiteFigure, FigureName.whiteKing);
                                    chessBoard[i][j + 1] = save;
                                    return super.validMoves(chessBoard,color);
                                }
                            }
                            chessBoard[i][j] = new King(Color.isWhiteFigure, FigureName.whiteKing);
                            chessBoard[i][j + 1] = save;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            save = chessBoard[i - 1][j - 1];
                            if (save == null || save.getFigureColor().equals(Color.isBlackFigure.getColor())) {
                                chessBoard[i - 1][j - 1] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!kingChecked(chessBoard, Color.isWhiteFigure)) {
                                    chessBoard[i][j] = new King(Color.isWhiteFigure, FigureName.whiteKing);
                                    chessBoard[i - 1][j - 1] = save;
                                    return super.validMoves(chessBoard,color);
                                }
                            }
                            chessBoard[i][j] = new King(Color.isWhiteFigure, FigureName.whiteKing);
                            chessBoard[i - 1][j - 1] = save;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            save = chessBoard[i - 1][j];
                            if (save == null || save.getFigureColor().equals(Color.isBlackFigure.getColor())) {
                                chessBoard[i - 1][j] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!kingChecked(chessBoard, Color.isWhiteFigure)) {
                                    chessBoard[i][j] = new King(Color.isWhiteFigure, FigureName.whiteKing);
                                    chessBoard[i - 1][j] = save;
                                    return super.validMoves(chessBoard,color);
                                }
                            }
                            chessBoard[i][j] = new King(Color.isWhiteFigure, FigureName.whiteKing);
                            chessBoard[i - 1][j] = save;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            save = chessBoard[i - 1][j + 1];
                            if (save == null || save.getFigureColor().equals(Color.isBlackFigure.getColor())) {
                                chessBoard[i - 1][j + 1] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!kingChecked(chessBoard, Color.isWhiteFigure)) {
                                    chessBoard[i][j] = new King(Color.isWhiteFigure, FigureName.whiteKing);
                                    chessBoard[i - 1][j + 1] = save;
                                    return super.validMoves(chessBoard,color);
                                }
                            }
                            chessBoard[i][j] = new King(Color.isWhiteFigure, FigureName.whiteKing);
                            chessBoard[i - 1][j + 1] = save;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        return true;
                    }
                }
            }
        } else {
            for (int i = chessBoard.length - 1; i >= 0; i--) {
                for (int j = 0; j < chessBoard[i].length; j++) {
                    if ((chessBoard[i][j] instanceof King && chessBoard[i][j].getFigureColor().equals(Color.isBlackFigure.getColor()))) {
                        try {
                            save = chessBoard[i + 1][j];
                            if (save == null || save.getFigureColor().equals(Color.isWhiteFigure.getColor())) {
                                chessBoard[i + 1][j] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!kingChecked(chessBoard, Color.isBlackFigure)) {
                                    chessBoard[i][j] = new King(Color.isBlackFigure, FigureName.blackKing);
                                    chessBoard[i + 1][j] = save;
                                    return super.validMoves(chessBoard,color);
                                }
                            }
                            chessBoard[i][j] = new King(Color.isBlackFigure, FigureName.blackKing);
                            chessBoard[i + 1][j] = save;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            save = chessBoard[i + 1][j - 1];
                            if (save == null || save.getFigureColor().equals(Color.isWhiteFigure.getColor())) {
                                chessBoard[i + 1][j - 1] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!kingChecked(chessBoard, Color.isBlackFigure)) {
                                    chessBoard[i][j] = new King(Color.isBlackFigure, FigureName.blackKing);
                                    chessBoard[i + 1][j - 1] = save;
                                    return super.validMoves(chessBoard,color);
                                }
                            }
                            chessBoard[i][j] = new King(Color.isBlackFigure, FigureName.blackKing);
                            chessBoard[i + 1][j - 1] = save;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            save = chessBoard[i + 1][j + 1];
                            if (save == null || save.getFigureColor().equals(Color.isWhiteFigure.getColor())) {
                                chessBoard[i + 1][j + 1] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!kingChecked(chessBoard, Color.isBlackFigure)) {
                                    chessBoard[i][j] = new King(Color.isBlackFigure, FigureName.blackKing);
                                    chessBoard[i + 1][j + 1] = save;
                                    return super.validMoves(chessBoard,color);
                                }
                            }
                            chessBoard[i][j] = new King(Color.isBlackFigure, FigureName.blackKing);
                            chessBoard[i + 1][j + 1] = save;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            save = chessBoard[i][j - 1];
                            if (save == null || save.getFigureColor().equals(Color.isWhiteFigure.getColor())) {
                                chessBoard[i][j - 1] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!kingChecked(chessBoard, Color.isBlackFigure)) {
                                    chessBoard[i][j] = new King(Color.isBlackFigure, FigureName.blackKing);
                                    chessBoard[i][j - 1] = save;
                                    return super.validMoves(chessBoard,color);
                                }
                            }
                            chessBoard[i][j] = new King(Color.isBlackFigure, FigureName.blackKing);
                            chessBoard[i][j - 1] = save;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            save = chessBoard[i][j + 1];
                            if (save == null || save.getFigureColor().equals(Color.isWhiteFigure.getColor())) {
                                chessBoard[i][j + 1] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!kingChecked(chessBoard, Color.isBlackFigure)) {
                                    chessBoard[i][j] = new King(Color.isBlackFigure, FigureName.blackKing);
                                    chessBoard[i][j + 1] = save;
                                    return super.validMoves(chessBoard,color);
                                }
                            }
                            chessBoard[i][j] = new King(Color.isBlackFigure, FigureName.blackKing);
                            chessBoard[i][j + 1] = save;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            save = chessBoard[i - 1][j - 1];
                            if (save == null || save.getFigureColor().equals(Color.isWhiteFigure.getColor())) {
                                chessBoard[i - 1][j - 1] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!kingChecked(chessBoard, Color.isBlackFigure)) {
                                    chessBoard[i][j] = new King(Color.isBlackFigure, FigureName.blackKing);
                                    chessBoard[i - 1][j - 1] = save;
                                    return super.validMoves(chessBoard,color);
                                }
                            }
                            chessBoard[i][j] = new King(Color.isBlackFigure, FigureName.blackKing);
                            chessBoard[i - 1][j - 1] = save;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            save = chessBoard[i - 1][j];
                            if (save == null || save.getFigureColor().equals(Color.isWhiteFigure.getColor())) {
                                chessBoard[i - 1][j] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!kingChecked(chessBoard, Color.isBlackFigure)) {
                                    chessBoard[i][j] = new King(Color.isBlackFigure, FigureName.blackKing);
                                    chessBoard[i - 1][j] = save;
                                    return super.validMoves(chessBoard,color);
                                }
                            }
                            chessBoard[i][j] = new King(Color.isBlackFigure, FigureName.blackKing);
                            chessBoard[i - 1][j] = save;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            save = chessBoard[i - 1][j + 1];
                            if (save == null || save.getFigureColor().equals(Color.isWhiteFigure.getColor())) {
                                chessBoard[i - 1][j + 1] = chessBoard[i][j];
                                chessBoard[i][j] = null;
                                if (!kingChecked(chessBoard, Color.isBlackFigure)) {
                                    chessBoard[i][j] = new King(Color.isBlackFigure, FigureName.blackKing);
                                    chessBoard[i - 1][j + 1] = save;
                                    return super.validMoves(chessBoard,color);
                                }
                            }
                            chessBoard[i][j] = new King(Color.isBlackFigure, FigureName.blackKing);
                            chessBoard[i - 1][j + 1] = save;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        return true;
                    }
                }
            }
        }
        return super.validMoves(chessBoard,color);
    }

    boolean kingChecked(Figure[][] chessBoard, Color color) {
        int i, j;
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
                            if (chessBoard[row + 1][column + 1] instanceof Pawn && chessBoard[row + 1][column + 1].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row + 1][column - 1] instanceof Pawn && chessBoard[row + 1][column - 1].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row + 1][column + 2] instanceof Knight && chessBoard[row + 1][column + 2].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row + 1][column - 2] instanceof Knight && chessBoard[row + 1][column - 2].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row + 2][column + 1] instanceof Knight && chessBoard[row + 2][column + 1].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row + 2][column - 1] instanceof Knight && chessBoard[row + 2][column - 1].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row - 1][column + 2] instanceof Knight && chessBoard[row - 1][column + 2].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row - 1][column - 2] instanceof Knight && chessBoard[row - 1][column - 2].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row - 2][column + 1] instanceof Knight && chessBoard[row - 2][column + 1].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row - 2][column - 1] instanceof Knight && chessBoard[row - 2][column - 1].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row + 1][column + 1] instanceof King && chessBoard[row + 1][column + 1].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row + 1][column] instanceof King && chessBoard[row + 1][column].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row + 1][column - 1] instanceof King && chessBoard[row + 1][column - 1].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row][column - 1] instanceof King && chessBoard[row][column - 1].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row - 1][column - 1] instanceof King && chessBoard[row - 1][column - 1].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row - 1][column] instanceof King && chessBoard[row - 1][column].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row - 1][column + 1] instanceof King && chessBoard[row - 1][column + 1].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row][column + 1] instanceof King && chessBoard[row][column + 1].getFigureColor().equals(Color.isBlackFigure.getColor()))
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
        } else {
            i = 8;
            while (i > 0) {
                i--;
                j = -1;
                while (j < chessBoard[i].length - 1) {
                    j++;
                    if (chessBoard[i][j] instanceof King && chessBoard[i][j].getFigureColor().equals(Color.isBlackFigure.getColor())) {
                        int row = i;
                        int column = j;
                        try {
                            if (chessBoard[row - 1][column - 1] instanceof Pawn && chessBoard[row - 1][column - 1].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row - 1][column + 1] instanceof Pawn && chessBoard[row - 1][column + 1].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row + 1][column + 2] instanceof Knight && chessBoard[row + 1][column + 2].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row + 1][column - 2] instanceof Knight && chessBoard[row + 1][column - 2].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row + 2][column + 1] instanceof Knight && chessBoard[row + 2][column + 1].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row + 2][column - 1] instanceof Knight && chessBoard[row + 2][column - 1].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row - 1][column + 2] instanceof Knight && chessBoard[row - 1][column + 2].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row - 1][column - 2] instanceof Knight && chessBoard[row - 1][column - 2].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row - 2][column + 1] instanceof Knight && chessBoard[row - 2][column + 1].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row - 2][column - 1] instanceof Knight && chessBoard[row - 2][column - 1].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row + 1][column + 1] instanceof King && chessBoard[row + 1][column + 1].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row + 1][column] instanceof King && chessBoard[row + 1][column].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row + 1][column - 1] instanceof King && chessBoard[row + 1][column - 1].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row][column - 1] instanceof King && chessBoard[row][column - 1].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row - 1][column - 1] instanceof King && chessBoard[row - 1][column - 1].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row - 1][column] instanceof King && chessBoard[row - 1][column].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row - 1][column + 1] instanceof King && chessBoard[row - 1][column + 1].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return true;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[row][column + 1] instanceof King && chessBoard[row][column + 1].getFigureColor().equals(Color.isWhiteFigure.getColor()))
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

    boolean mated(Figure[][] chessBoard, Color color) {
        Figure rook;
        Figure knight;
        Figure bishop;
        Figure queen;
        Figure pawn;
        if (color.getColor().equals(Color.isWhiteFigure.getColor())) {
            rook = new Rook(Color.isWhiteFigure, FigureName.whiteRook);
            knight = new Knight(Color.isWhiteFigure, FigureName.whiteKnight);
            bishop = new Bishop(Color.isWhiteFigure, FigureName.whiteWhiteBishop);
            queen = new Queen(Color.isWhiteFigure, FigureName.whiteQueen);
            pawn = new Pawn(Color.isWhiteFigure, FigureName.whitePawn);
            if (kingChecked(chessBoard, Color.isWhiteFigure) && validMoves(chessBoard, Color.isWhiteFigure)) {
                return !rook.validMoves(chessBoard, Color.isWhiteFigure) && !bishop.validMoves(chessBoard, Color.isWhiteFigure) &&
                        !queen.validMoves(chessBoard, Color.isWhiteFigure) && !knight.validMoves(chessBoard, Color.isWhiteFigure) &&
                        !pawn.validMoves(chessBoard, Color.isWhiteFigure);
            }
        } else {
            rook = new Rook(Color.isBlackFigure, FigureName.blackRook);
            knight = new Knight(Color.isBlackFigure, FigureName.blackKnight);
            bishop = new Bishop(Color.isBlackFigure, FigureName.blackBlackBishop);
            queen = new Queen(Color.isBlackFigure, FigureName.blackQueen);
            pawn = new Pawn(Color.isBlackFigure, FigureName.blackPawn);
            if (kingChecked(chessBoard, Color.isBlackFigure) && validMoves(chessBoard, Color.isBlackFigure)) {
                return !rook.validMoves(chessBoard, Color.isBlackFigure) && !bishop.validMoves(chessBoard, Color.isBlackFigure) &&
                        !queen.validMoves(chessBoard, Color.isBlackFigure) && !knight.validMoves(chessBoard, Color.isBlackFigure) &&
                        !pawn.validMoves(chessBoard, Color.isBlackFigure);
            }
        }
        return false;
    }

    boolean staleMate(Figure[][] chessBoard, Color color) {
        Figure rook;
        Figure knight;
        Figure bishop;
        Figure queen;
        Figure pawn;
        if (color.getColor().equals(Color.isWhiteFigure.getColor())) {
            rook = new Rook(Color.isWhiteFigure, FigureName.whiteRook);
            knight = new Knight(Color.isWhiteFigure, FigureName.whiteKnight);
            bishop = new Bishop(Color.isWhiteFigure, FigureName.whiteWhiteBishop);
            queen = new Queen(Color.isWhiteFigure, FigureName.whiteQueen);
            pawn = new Pawn(Color.isWhiteFigure, FigureName.whitePawn);
            if (!kingChecked(chessBoard, Color.isWhiteFigure) && validMoves(chessBoard, Color.isWhiteFigure)) {
                return !rook.validMoves(chessBoard, Color.isWhiteFigure) && !bishop.validMoves(chessBoard, Color.isWhiteFigure) &&
                        !queen.validMoves(chessBoard, Color.isWhiteFigure) && !knight.validMoves(chessBoard, Color.isWhiteFigure) &&
                        !pawn.validMoves(chessBoard, Color.isWhiteFigure);
            }
        } else {
            rook = new Rook(Color.isBlackFigure, FigureName.blackRook);
            knight = new Knight(Color.isBlackFigure, FigureName.blackKnight);
            bishop = new Bishop(Color.isBlackFigure, FigureName.blackBlackBishop);
            queen = new Queen(Color.isBlackFigure, FigureName.blackQueen);
            pawn = new Pawn(Color.isBlackFigure, FigureName.blackPawn);
            if (!kingChecked(chessBoard, Color.isBlackFigure) && validMoves(chessBoard, Color.isBlackFigure)) {
                return !rook.validMoves(chessBoard, Color.isBlackFigure) && !bishop.validMoves(chessBoard, Color.isBlackFigure) &&
                        !queen.validMoves(chessBoard, Color.isBlackFigure) && !knight.validMoves(chessBoard, Color.isBlackFigure) &&
                        !pawn.validMoves(chessBoard, Color.isBlackFigure);
            }
        }
        return false;
    }
}

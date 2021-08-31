package com.company;

public class Knight extends Figure {
    Knight(Color figureColor, FigureName figureName) {
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
        chessBoard[putRow][putColumn] = this;
        chessBoard[takeRow][takeColumn] = null;
    }

    @Override
    boolean checkMove(Figure[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (takeRow == putRow && takeColumn == putColumn)
            return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
        King king;
        if (this.getFigureColor().equals(Color.isWhiteFigure.getColor())) {
            king = new King(Color.isWhiteFigure, FigureName.whiteKing);
            if (putRow - takeRow == 2 || putRow - takeRow == -2) {
                if (putColumn - takeColumn == 1 || putColumn - takeColumn == -1) {
                    if (chessBoard[putRow][putColumn] == null) {
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
                    } else if (chessBoard[putRow][putColumn].getFigureColor().equals(Color.isBlackFigure.getColor())) {
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
            } else if (putRow - takeRow == 1 || putRow - takeRow == -1) {
                if (putColumn - takeColumn == 2 || putColumn - takeColumn == -2) {
                    if (chessBoard[putRow][putColumn] == null) {
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
                    } else if (chessBoard[putRow][putColumn].getFigureColor().equals(Color.isBlackFigure.getColor())) {
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
            if (putRow - takeRow == 2 || putRow - takeRow == -2) {
                if (putColumn - takeColumn == 1 || putColumn - takeColumn == -1) {
                    if (chessBoard[putRow][putColumn] == null) {
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
                    } else if (chessBoard[putRow][putColumn].getFigureColor().equals(Color.isWhiteFigure.getColor())) {
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
            } else if (putRow - takeRow == 1 || putRow - takeRow == -1) {
                if (putColumn - takeColumn == 2 || putColumn - takeColumn == -2) {
                    if (chessBoard[putRow][putColumn] == null) {
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
                    } else if (chessBoard[putRow][putColumn].getFigureColor().equals(Color.isWhiteFigure.getColor())) {
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
    boolean validMoves(Figure[][] chessBoard, Color color) {
        if (color.getColor().equals(Color.isWhiteFigure.getColor())) {
            for (int i = 0; i < chessBoard.length; i++) {
                for (int j = 0; j < chessBoard[i].length; j++) {
                    if ((chessBoard[i][j] instanceof Knight && chessBoard[i][j].getFigureColor().equals(Color.isWhiteFigure.getColor()))) {
                        try {
                            if (checkMove(chessBoard, i, j, i - 2, j + 1)) {
                                return true;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (checkMove(chessBoard, i, j, i - 2, j - 1)) {
                                return true;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (checkMove(chessBoard, i, j, i - 1, j - 2)) {
                                return true;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (checkMove(chessBoard, i, j, i + 1, j - 2)) {
                                return true;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (checkMove(chessBoard, i, j, i + 2, j - 1)) {
                                return true;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (checkMove(chessBoard, i, j, i + 2, j - 1)) {
                                return true;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (checkMove(chessBoard, i, j, i + 1, j + 2)) {
                                return true;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (checkMove(chessBoard, i, j, i - 1, j + 2)) {
                                return true;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                    }
                }
            }
        } else {
            for (int i = chessBoard.length - 1; i >= 0; i--) {
                for (int j = 0; j < chessBoard[i].length; j++) {
                    if ((chessBoard[i][j] instanceof Knight && chessBoard[i][j].getFigureColor().equals(Color.isBlackFigure.getColor()))) {
                        try {
                            if (checkMove(chessBoard, i, j, i - 2, j + 1)) {
                                return true;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (checkMove(chessBoard, i, j, i - 2, j - 1)) {
                                return true;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (checkMove(chessBoard, i, j, i - 1, j - 2)) {
                                return true;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (checkMove(chessBoard, i, j, i + 1, j - 2)) {
                                return true;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (checkMove(chessBoard, i, j, i + 2, j - 1)) {
                                return true;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (checkMove(chessBoard, i, j, i + 2, j - 1)) {
                                return true;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (checkMove(chessBoard, i, j, i + 1, j + 2)) {
                                return true;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (checkMove(chessBoard, i, j, i - 1, j + 2)) {
                                return true;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                    }
                }
            }
        }
        return super.validMoves(chessBoard, color);
    }
}

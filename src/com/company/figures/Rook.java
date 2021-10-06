package com.company.figures;

import com.company.enum_class.Color;
import com.company.enum_class.FigureName;

public class Rook extends Figure {
    private boolean wrIsMoved = false;
    private boolean brIsMoved = false;

    public boolean wrIsMoved() {
        return !wrIsMoved;
    }

    public boolean brIsMoved() {
        return !brIsMoved;
    }

    public Rook(Color figureColor, FigureName figureName) {
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
        if (!wrIsMoved && this.getFigureColor().equals(Color.isWhiteFigure.getColor()))
            wrIsMoved = true;
        else if (!brIsMoved && this.getFigureColor().equals(Color.isBlackFigure.getColor()))
            brIsMoved = true;
        chessBoard[putRow][putColumn] = this;
        chessBoard[takeRow][takeColumn] = null;
    }

    @Override
    public boolean checkMove(Figure[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (takeRow == putRow && takeColumn == putColumn)
            return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
        int i = takeRow;
        int j = takeColumn;
        King king;
        if (this.getFigureColor().equals(Color.isWhiteFigure.getColor())) {
            king = new King(Color.isWhiteFigure, FigureName.whiteKing);
            if (takeRow == putRow) {
                if (putColumn > takeColumn) {
                    while (takeColumn < putColumn - 1) {
                        takeColumn++;
                        if (chessBoard[putRow][takeColumn] != null)
                            return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                } else {
                    while (takeColumn > putColumn + 1) {
                        takeColumn--;
                        if (chessBoard[putRow][takeColumn] != null)
                            return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                }
            } else if (takeColumn == putColumn) {
                if (putRow > takeRow) {
                    while (takeRow < putRow - 1) {
                        takeRow++;
                        if (chessBoard[takeRow][putColumn] != null)
                            return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }

                } else {
                    while (takeRow > putRow + 1) {
                        takeRow--;
                        if (chessBoard[takeRow][putColumn] != null)
                            return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                }
            }
            if (chessBoard[putRow][putColumn] == null) {
                Figure save = chessBoard[putRow][putColumn];
                chessBoard[putRow][putColumn] = this;
                chessBoard[i][j] = null;

                if (king.kingChecked(chessBoard, Color.isWhiteFigure)) {
                    System.out.println("\n" + "P1, Please Be Observant And Check Your King's Position...");
                    chessBoard[i][j] = this;
                    chessBoard[putRow][putColumn] = save;
                    return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
                chessBoard[i][j] = this;
                chessBoard[putRow][putColumn] = save;
                return true;
            } else if (chessBoard[putRow][putColumn].getFigureColor().equals(Color.isBlackFigure.getColor())) {
                Figure save = chessBoard[putRow][putColumn];
                chessBoard[putRow][putColumn] = this;
                chessBoard[i][j] = null;

                if (king.kingChecked(chessBoard, Color.isWhiteFigure)) {
                    System.out.println("\n" + "P1, Please Be Observant And Check Your King's Position...");
                    chessBoard[i][j] = this;
                    chessBoard[putRow][putColumn] = save;
                    return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
                chessBoard[i][j] = this;
                chessBoard[putRow][putColumn] = save;
                return true;
            }
        } else {
            king = new King(Color.isBlackFigure, FigureName.blackKing);
            if (takeRow == putRow) {
                if (putColumn > takeColumn) {
                    while (takeColumn < putColumn - 1) {
                        takeColumn++;
                        if (chessBoard[putRow][takeColumn] != null)
                            return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                } else {
                    while (takeColumn > putColumn + 1) {
                        takeColumn--;
                        if (chessBoard[putRow][takeColumn] != null)
                            return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                }
            } else if (takeColumn == putColumn) {
                if (putRow > takeRow) {
                    while (takeRow < putRow - 1) {
                        takeRow++;
                        if (chessBoard[takeRow][putColumn] != null)
                            return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                } else {
                    while (takeRow > putRow + 1) {
                        takeRow--;
                        if (chessBoard[takeRow][putColumn] != null)
                            return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                }
            }
            if (chessBoard[putRow][putColumn] == null) {
                chessBoard[putRow][putColumn] = this;
                chessBoard[i][j] = null;
                if (king.kingChecked(chessBoard, Color.isBlackFigure)) {
                    System.out.println("\n" + "P2, Please Be Observant And Check Your King's Position...");
                    chessBoard[i][j] = this;
                    chessBoard[putRow][putColumn] = null;
                    return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
                chessBoard[i][j] = this;
                chessBoard[putRow][putColumn] = null;
                return true;
            } else if (chessBoard[putRow][putColumn].getFigureColor().equals(Color.isWhiteFigure.getColor())) {
                Figure save = chessBoard[putRow][putColumn];
                chessBoard[putRow][putColumn] = this;
                chessBoard[i][j] = null;

                if (king.kingChecked(chessBoard, Color.isBlackFigure)) {
                    System.out.println("\n" + "P2, Please Be Observant And Check Your King's Position...");
                    chessBoard[i][j] = this;
                    chessBoard[putRow][putColumn] = save;
                    return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
                chessBoard[i][j] = this;
                chessBoard[putRow][putColumn] = save;
                return true;
            }
        }
        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
    }

    @Override
    public boolean noValidMoves(Figure[][] chessBoard, Color color) {
        if (color.getColor().equals(Color.isWhiteFigure.getColor())) {
            for (int i = 0; i < chessBoard.length; i++) {
                for (int j = 0; j < chessBoard[i].length; j++) {
                    if (chessBoard[i][j] instanceof Rook && chessBoard[i][j].getFigureColor().equals(Color.isWhiteFigure.getColor())) {
                        return !checking(Color.isWhiteFigure, true, true, chessBoard, i, j) &&
                                !checking(Color.isWhiteFigure, true, false, chessBoard, i, j) &&
                                !checking(Color.isWhiteFigure, false, true, chessBoard, i, j) &&
                                !checking(Color.isWhiteFigure, false, false, chessBoard, i, j);
                    }
                }
            }
        } else {
            for (int i = chessBoard.length - 1; i >= 0; i--) {
                for (int j = 0; j < chessBoard[i].length; j++) {
                    if (chessBoard[i][j] instanceof Rook && chessBoard[i][j].getFigureColor().equals(Color.isBlackFigure.getColor())) {
                        return !checking(Color.isBlackFigure, true, true, chessBoard, i, j) &&
                                !checking(Color.isBlackFigure, true, false, chessBoard, i, j) &&
                                !checking(Color.isBlackFigure, false, true, chessBoard, i, j) &&
                                !checking(Color.isBlackFigure, false, false, chessBoard, i, j);
                    }
                }
            }
        }
        return super.noValidMoves(chessBoard, color);
    }

    public boolean checking(Color figureColor, boolean line, boolean toDo, Figure[][] chessBoard, int i, int j) {
        // line is true means row, toDoo is true means ++
        King king;
        if (figureColor.getColor().equals(Color.isBlackFigure.getColor())) {
            king = new King(Color.isBlackFigure, FigureName.blackKing);
            Figure save;
            if (line) {
                if (toDo) {
                    try {
                        int row = i;
                        while (row < chessBoard.length - 1) {
                            row++;
                            save = chessBoard[row][j];
                            if (chessBoard[row][j] == null) {
                                chessBoard[row][j] = this;
                                chessBoard[i][j] = null;
                                if (!king.kingChecked(chessBoard, Color.isBlackFigure)) {
                                    chessBoard[i][j] = this;
                                    chessBoard[row][j] = save;
                                    return true;
                                } else {
                                    chessBoard[i][j] = this;
                                    chessBoard[row][j] = save;
                                }
                            } else if (chessBoard[row][j].getFigureColor().equals(Color.isWhiteFigure.getColor())) {
                                chessBoard[row][j] = this;
                                chessBoard[i][j] = null;
                                if (!king.kingChecked(chessBoard, Color.isBlackFigure)) {
                                    chessBoard[i][j] = this;
                                    chessBoard[row][j] = save;
                                    return true;
                                }
                                chessBoard[i][j] = this;
                                chessBoard[row][j] = save;
                                break;
                            } else
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                } else {
                    try {
                        int row = i;
                        while (row > 0) {
                            row--;
                            save = chessBoard[row][j];
                            if (chessBoard[row][j] == null) {
                                chessBoard[row][j] = this;
                                chessBoard[i][j] = null;
                                if (!king.kingChecked(chessBoard, Color.isBlackFigure)) {
                                    chessBoard[i][j] = this;
                                    chessBoard[row][j] = save;
                                    return true;
                                } else {
                                    chessBoard[i][j] = this;
                                    chessBoard[row][j] = save;
                                }
                            } else if (chessBoard[row][j].getFigureColor().equals(Color.isWhiteFigure.getColor())) {
                                chessBoard[row][j] = this;
                                chessBoard[i][j] = null;
                                if (!king.kingChecked(chessBoard, Color.isBlackFigure)) {
                                    chessBoard[i][j] = this;
                                    chessBoard[row][j] = save;
                                    return true;
                                }
                                chessBoard[i][j] = this;
                                chessBoard[row][j] = save;
                                break;
                            } else
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                }
            } else {
                if (toDo) {
                    try {
                        int column = j;
                        while (column < chessBoard.length - 1) {
                            column++;
                            save = chessBoard[i][column];
                            if (chessBoard[i][column] == null) {
                                chessBoard[i][column] = this;
                                chessBoard[i][j] = null;
                                if (!king.kingChecked(chessBoard, Color.isBlackFigure)) {
                                    chessBoard[i][j] = this;
                                    chessBoard[i][column] = save;
                                    return true;
                                } else {
                                    chessBoard[i][j] = this;
                                    chessBoard[i][column] = save;
                                }
                            } else if (chessBoard[i][column].getFigureColor().equals(Color.isWhiteFigure.getColor())) {
                                chessBoard[i][column] = this;
                                chessBoard[i][j] = null;
                                if (!king.kingChecked(chessBoard, Color.isBlackFigure)) {
                                    chessBoard[i][j] = this;
                                    chessBoard[i][column] = save;
                                    return true;
                                }
                                chessBoard[i][j] = this;
                                chessBoard[i][column] = save;
                                break;
                            } else
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                } else {
                    try {
                        int column = j;
                        while (column > 0) {
                            column--;
                            save = chessBoard[i][column];
                            if (chessBoard[i][column] == null) {
                                chessBoard[i][column] = this;
                                chessBoard[i][j] = null;
                                if (!king.kingChecked(chessBoard, Color.isBlackFigure)) {
                                    chessBoard[i][j] = this;
                                    chessBoard[i][column] = save;
                                    return true;
                                } else {
                                    chessBoard[i][j] = this;
                                    chessBoard[i][column] = save;
                                }
                            } else if (chessBoard[i][column].getFigureColor().equals(Color.isWhiteFigure.getColor())) {
                                chessBoard[i][column] = this;
                                chessBoard[i][j] = null;
                                if (!king.kingChecked(chessBoard, Color.isBlackFigure)) {
                                    chessBoard[i][j] = this;
                                    chessBoard[i][column] = save;
                                    return true;
                                }
                                chessBoard[i][j] = this;
                                chessBoard[i][column] = save;
                                break;
                            } else
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                }
            }
        } else {
            king = new King(Color.isWhiteFigure, FigureName.whiteKing);
            Figure save;
            if (line) {
                if (toDo) {
                    try {
                        int row = i;
                        while (row < chessBoard.length - 1) {
                            row++;
                            save = chessBoard[row][j];
                            if (chessBoard[row][j] == null) {
                                chessBoard[row][j] = this;
                                chessBoard[i][j] = null;
                                if (!king.kingChecked(chessBoard, Color.isWhiteFigure)) {
                                    chessBoard[i][j] = this;
                                    chessBoard[row][j] = save;
                                    return true;
                                } else {
                                    chessBoard[i][j] = this;
                                    chessBoard[row][j] = save;
                                }
                            } else if (chessBoard[row][j].getFigureColor().equals(Color.isBlackFigure.getColor())) {
                                chessBoard[row][j] = this;
                                chessBoard[i][j] = null;
                                if (!king.kingChecked(chessBoard, Color.isWhiteFigure)) {
                                    chessBoard[i][j] = this;
                                    chessBoard[row][j] = save;
                                    return true;
                                }
                                chessBoard[i][j] = this;
                                chessBoard[row][j] = save;
                                break;
                            } else
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                } else {
                    try {
                        int row = i;
                        while (row > 0) {
                            row--;
                            save = chessBoard[row][j];
                            if (chessBoard[row][j] == null) {
                                chessBoard[row][j] = this;
                                chessBoard[i][j] = null;
                                if (!king.kingChecked(chessBoard, Color.isWhiteFigure)) {
                                    chessBoard[i][j] = this;
                                    chessBoard[row][j] = save;
                                    return true;
                                } else {
                                    chessBoard[i][j] = this;
                                    chessBoard[row][j] = save;
                                }
                            } else if (chessBoard[row][j].getFigureColor().equals(Color.isBlackFigure.getColor())) {
                                chessBoard[row][j] = this;
                                chessBoard[i][j] = null;
                                if (!king.kingChecked(chessBoard, Color.isWhiteFigure)) {
                                    chessBoard[i][j] = this;
                                    chessBoard[row][j] = save;
                                    return true;
                                }
                                chessBoard[i][j] = this;
                                chessBoard[row][j] = save;
                                break;
                            } else
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                }
            } else {
                if (toDo) {
                    try {
                        int column = j;
                        while (column < chessBoard.length - 1) {
                            column++;
                            save = chessBoard[i][column];
                            if (chessBoard[i][column] == null) {
                                chessBoard[i][column] = this;
                                chessBoard[i][j] = null;
                                if (!king.kingChecked(chessBoard, Color.isWhiteFigure)) {
                                    chessBoard[i][j] = this;
                                    chessBoard[i][column] = save;
                                    return true;
                                } else {
                                    chessBoard[i][j] = this;
                                    chessBoard[i][column] = save;
                                }
                            } else if (chessBoard[i][column].getFigureColor().equals(Color.isBlackFigure.getColor())) {
                                chessBoard[i][column] = this;
                                chessBoard[i][j] = null;
                                if (!king.kingChecked(chessBoard, Color.isWhiteFigure)) {
                                    chessBoard[i][j] = this;
                                    chessBoard[i][column] = save;
                                    return true;
                                }
                                chessBoard[i][j] = this;
                                chessBoard[i][column] = save;
                                break;
                            } else
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                } else {
                    try {
                        int column = j;
                        while (column > 0) {
                            column--;
                            save = chessBoard[i][column];
                            if (chessBoard[i][column] == null) {
                                chessBoard[i][column] = this;
                                chessBoard[i][j] = null;
                                if (!king.kingChecked(chessBoard, Color.isWhiteFigure)) {
                                    chessBoard[i][j] = this;
                                    chessBoard[i][column] = save;
                                    return true;
                                } else {
                                    chessBoard[i][j] = this;
                                    chessBoard[i][column] = save;
                                }
                            } else if (chessBoard[i][column].getFigureColor().equals(Color.isBlackFigure.getColor())) {
                                chessBoard[i][column] = this;
                                chessBoard[i][j] = null;
                                if (!king.kingChecked(chessBoard, Color.isWhiteFigure)) {
                                    chessBoard[i][j] = this;
                                    chessBoard[i][column] = save;
                                    return true;
                                }
                                chessBoard[i][j] = this;
                                chessBoard[i][column] = save;
                                break;
                            } else
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                }
            }
        }
        return false;
    }
}
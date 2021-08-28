package com.company;

public class Bishop extends Figure {
    Bishop(Color figureColor, FigureName figureName) {
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
        chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
        chessBoard[takeRow][takeColumn] = null;
    }
    @Override
    boolean checkMove(Figure[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (takeRow == putRow && takeColumn == putColumn)
            return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
        King king;
        if (chessBoard[takeRow][takeColumn].getFigureColor().equals(Color.isWhiteFigure.getColor())) {
            king = new King(Color.isWhiteFigure, FigureName.whiteKing);
            int i = takeRow;
            int j = takeColumn;
            if (putRow > takeRow && putColumn > takeColumn) {
                while (takeRow < putRow - 1 && takeColumn < putColumn - 1) {
                    takeRow++;
                    takeColumn++;
                    if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
            } else if (putRow > takeRow && putColumn < takeColumn) {
                while (takeRow < putRow - 1 && takeColumn > putColumn + 1) {
                    takeRow++;
                    takeColumn--;
                    if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
            } else if (putRow < takeRow && putColumn < takeColumn) {
                while (takeRow > putRow + 1 && takeColumn > putColumn + 1) {
                    takeRow--;
                    takeColumn--;
                    if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
            } else if (putRow < takeRow && putColumn > takeColumn) {
                while (takeRow > putRow + 1 && takeColumn < putColumn - 1) {
                    takeRow--;
                    takeColumn++;
                    if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
            }
            if (chessBoard[putRow][putColumn] == null) {
                chessBoard[putRow][putColumn] = chessBoard[i][j];
                chessBoard[i][j] = null;
                if (king.KingChecked(chessBoard)) {
                    System.out.println("\n" + "P1, Please Be Observant And Check Your King's Position...");
                    if ((i + j) % 2 == 0)
                        chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteWhiteBishop);
                    else
                        chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteBlackBishop);
                    chessBoard[putRow][putColumn] = null;
                    return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
                if ((i + j) % 2 == 0)
                    chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteWhiteBishop);
                else
                    chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteBlackBishop);
                chessBoard[putRow][putColumn] = null;
                return true;
            } else if (chessBoard[putRow][putColumn].getFigureColor().equals(Color.isBlackFigure.getColor())) {
                Figure save = chessBoard[putRow][putColumn];
                chessBoard[putRow][putColumn] = chessBoard[i][j];
                chessBoard[i][j] = null;

                if (king.KingChecked(chessBoard)) {
                    System.out.println("\n" + "P1, Please Be Observant And Check Your King's Position...");
                    if ((i + j) % 2 == 0)
                        chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteWhiteBishop);
                    else
                        chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteBlackBishop);
                    chessBoard[putRow][putColumn] = save;
                    return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
                if ((i + j) % 2 == 0)
                    chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteWhiteBishop);
                else
                    chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteBlackBishop);
                chessBoard[putRow][putColumn] = save;
                return true;
            }
        } else {
            king = new King(Color.isBlackFigure, FigureName.blackKing);
            int i = takeRow;
            int j = takeColumn;
            if (putRow > takeRow && putColumn > takeColumn) {
                while (takeRow < putRow - 1 && takeColumn < putColumn - 1) {
                    takeRow++;
                    takeColumn++;
                    if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
            } else if (putRow > takeRow && putColumn < takeColumn) {
                while (takeRow < putRow - 1 && takeColumn > putColumn + 1) {
                    takeRow++;
                    takeColumn--;
                    if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
            } else if (putRow < takeRow && putColumn < takeColumn) {
                while (takeRow > putRow + 1 && takeColumn > putColumn + 1) {
                    takeRow--;
                    takeColumn--;
                    if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
            } else if (putRow < takeRow && putColumn > takeColumn) {
                while (takeRow > putRow + 1 && takeColumn < putColumn - 1) {
                    takeRow--;
                    takeColumn++;
                    if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
            }
            if (chessBoard[putRow][putColumn] == null) {
                chessBoard[putRow][putColumn] = chessBoard[i][j];
                chessBoard[i][j] = null;

                if (king.KingChecked(chessBoard)) {
                    System.out.println("\n" + "P2, Please Be Observant And Check Your King's Position...");
                    if ((i + j) % 2 == 0)
                        chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackWhiteBishop);
                    else
                        chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackBlackBishop);
                    chessBoard[putRow][putColumn] = null;
                    return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
                if ((i + j) % 2 == 0)
                    chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackWhiteBishop);
                else
                    chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackBlackBishop);
                chessBoard[putRow][putColumn] = null;
                return true;
            } else if (chessBoard[putRow][putColumn].getFigureColor().equals(Color.isWhiteFigure.getColor())) {
                Figure save = chessBoard[putRow][putColumn];
                chessBoard[putRow][putColumn] = chessBoard[i][j];
                chessBoard[i][j] = null;

                if (king.KingChecked(chessBoard)) {
                    System.out.println("\n" + "P2, Please Be Observant And Check Your King's Position...");
                    if ((i + j) % 2 == 0)
                        chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackWhiteBishop);
                    else
                        chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackBlackBishop);
                    chessBoard[putRow][putColumn] = save;
                    return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
                if ((i + j) % 2 == 0)
                    chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackWhiteBishop);
                else
                    chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackBlackBishop);
                chessBoard[putRow][putColumn] = save;
                return true;
            }
        }
        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
    }
    @Override
    boolean noMoves(Figure[][] chessBoard, Color color) {
        if (color.getColor().equals(Color.isWhiteFigure.getColor())) {
            for (int i = 0; i < chessBoard.length; i++) {
                for (int j = 0; j < chessBoard[i].length; j++) {
                    if (chessBoard[i][j] instanceof Bishop && chessBoard[i][j].getFigureColor().equals(Color.isWhiteFigure.getColor())) {
                        try {
                            if (chessBoard[i + 1][j - 1] == null || chessBoard[i + 1][j].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return false;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[i + 1][j + 1] == null || chessBoard[i - 1][j].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return false;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[i - 1][j + 1] == null || chessBoard[i][j - 1].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return false;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[i - 1][j - 1] == null || chessBoard[i][j - 1].getFigureColor().equals(Color.isBlackFigure.getColor()))
                                return false;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                    }
                }
            }
        } else {
            for (int i = chessBoard.length - 1; i >= 0; i--) {
                for (int j = 0; j < chessBoard[i].length; j++) {
                    if (chessBoard[i][j] instanceof Bishop && chessBoard[i][j].getFigureColor().equals(Color.isBlackFigure.getColor())) {
                        try {
                            if (chessBoard[i + 1][j - 1] == null || chessBoard[i + 1][j].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return false;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[i + 1][j + 1] == null || chessBoard[i - 1][j].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return false;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[i - 1][j + 1] == null || chessBoard[i][j - 1].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return false;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (chessBoard[i - 1][j - 1] == null || chessBoard[i][j - 1].getFigureColor().equals(Color.isWhiteFigure.getColor()))
                                return false;
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                    }
                }
            }
        }
        return super.noMoves(chessBoard, color);
    }
    @Override
    boolean coverCheck(Figure[][] chessBoard, Color color) {
        King king;
        if (color.getColor().equals(Color.isWhiteFigure.getColor())) {
            king = new King(Color.isWhiteFigure, FigureName.whiteKing);
            Figure save;
            for (int i = 0; i < chessBoard.length; i++) {
                for (int j = 0; j < chessBoard[i].length; j++) {
                    if (chessBoard[i][j] instanceof Bishop && chessBoard[i][j].getFigureColor().equals(Color.isWhiteFigure.getColor())) {
                        try {
                            int row = i;
                            int column = j;
                            while (true) {
                                row++;
                                column++;
                                save = chessBoard[row][column];
                                if (chessBoard[row][column] == null) {
                                    chessBoard[row][column] = chessBoard[i][j];
                                    chessBoard[i][j] = null;
                                    if (!king.KingChecked(chessBoard)) {
                                        if ((i + j) % 2 == 0)
                                            chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteWhiteBishop);
                                        else
                                            chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteBlackBishop);
                                        chessBoard[row][column] = save;
                                        return true;
                                    } else {
                                        if ((i + j) % 2 == 0)
                                            chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteWhiteBishop);
                                        else
                                            chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteBlackBishop);
                                        chessBoard[row][column] = save;
                                    }
                                } else if (chessBoard[row][column].getFigureColor().equals(Color.isBlackFigure.getColor())) {
                                    chessBoard[row][column] = chessBoard[i][j];
                                    chessBoard[i][j] = null;
                                    if (!king.KingChecked(chessBoard)) {
                                        if ((i + j) % 2 == 0)
                                            chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteWhiteBishop);
                                        else
                                            chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteBlackBishop);
                                        chessBoard[row][column] = save;
                                        return true;
                                    }
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteWhiteBishop);
                                    else
                                        chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteBlackBishop);
                                    chessBoard[row][column] = save;
                                    break;
                                } else
                                    break;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            int row = i;
                            int column = j;
                            while (true) {
                                row++;
                                column--;
                                save = chessBoard[row][column];
                                if (chessBoard[row][column] == null) {
                                    chessBoard[row][column] = chessBoard[i][j];
                                    chessBoard[i][j] = null;
                                    if (!king.KingChecked(chessBoard)) {
                                        if ((i + j) % 2 == 0)
                                            chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteWhiteBishop);
                                        else
                                            chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteBlackBishop);
                                        chessBoard[row][column] = save;
                                        return true;
                                    } else {
                                        if ((i + j) % 2 == 0)
                                            chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteWhiteBishop);
                                        else
                                            chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteBlackBishop);
                                        chessBoard[row][column] = save;
                                    }
                                } else if (chessBoard[row][column].getFigureColor().equals(Color.isBlackFigure.getColor())) {
                                    chessBoard[row][column] = chessBoard[i][j];
                                    chessBoard[i][j] = null;
                                    if (!king.KingChecked(chessBoard)) {
                                        if ((i + j) % 2 == 0)
                                            chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteWhiteBishop);
                                        else
                                            chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteBlackBishop);
                                        chessBoard[row][column] = save;
                                        return true;
                                    }
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteWhiteBishop);
                                    else
                                        chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteBlackBishop);
                                    chessBoard[row][column] = save;
                                    break;
                                } else
                                    break;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            int row = i;
                            int column = j;
                            while (true) {
                                row--;
                                column++;
                                save = chessBoard[row][column];
                                if (chessBoard[row][column] == null) {
                                    chessBoard[row][column] = chessBoard[i][j];
                                    chessBoard[i][j] = null;
                                    if (!king.KingChecked(chessBoard)) {
                                        if ((i + j) % 2 == 0)
                                            chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteWhiteBishop);
                                        else
                                            chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteBlackBishop);
                                        chessBoard[row][column] = save;
                                        return true;
                                    } else {
                                        if ((i + j) % 2 == 0)
                                            chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteWhiteBishop);
                                        else
                                            chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteBlackBishop);
                                        chessBoard[row][column] = save;
                                    }
                                } else if (chessBoard[row][column].getFigureColor().equals(Color.isBlackFigure.getColor())) {
                                    chessBoard[row][column] = chessBoard[i][j];
                                    chessBoard[i][j] = null;
                                    if (!king.KingChecked(chessBoard)) {
                                        if ((i + j) % 2 == 0)
                                            chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteWhiteBishop);
                                        else
                                            chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteBlackBishop);
                                        chessBoard[row][column] = save;
                                        return true;
                                    }
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteWhiteBishop);
                                    else
                                        chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteBlackBishop);
                                    chessBoard[row][column] = save;
                                    break;
                                } else
                                    break;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            int row = i;
                            int column = j;
                            while (true) {
                                row--;
                                column--;
                                save = chessBoard[row][column];
                                if (chessBoard[row][column] == null) {
                                    chessBoard[row][column] = chessBoard[i][j];
                                    chessBoard[i][j] = null;
                                    if (!king.KingChecked(chessBoard)) {
                                        if ((i + j) % 2 == 0)
                                            chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteWhiteBishop);
                                        else
                                            chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteBlackBishop);
                                        chessBoard[row][column] = save;
                                        return true;
                                    } else {
                                        if ((i + j) % 2 == 0)
                                            chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteWhiteBishop);
                                        else
                                            chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteBlackBishop);
                                        chessBoard[row][column] = save;
                                    }
                                } else if (chessBoard[row][column].getFigureColor().equals(Color.isBlackFigure.getColor())) {
                                    chessBoard[row][column] = chessBoard[i][j];
                                    chessBoard[i][j] = null;
                                    if (!king.KingChecked(chessBoard)) {
                                        if ((i + j) % 2 == 0)
                                            chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteWhiteBishop);
                                        else
                                            chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteBlackBishop);
                                        chessBoard[row][column] = save;
                                        return true;
                                    }
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteWhiteBishop);
                                    else
                                        chessBoard[i][j] = new Bishop(Color.isWhiteFigure, FigureName.whiteBlackBishop);
                                    chessBoard[row][column] = save;
                                    break;
                                } else
                                    break;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                    }
                }
            }
        } else {
            king = new King(Color.isBlackFigure, FigureName.blackKing);
            Figure save;
            for (int i = chessBoard.length - 1; i >= 0; i--) {
                for (int j = 0; j < chessBoard[i].length; j++) {
                    if (chessBoard[i][j] instanceof Bishop && chessBoard[i][j].getFigureColor().equals(Color.isBlackFigure.getColor())) {
                        try {
                            int row = i;
                            int column = j;
                            while (true) {
                                row++;
                                column++;
                                save = chessBoard[row][column];
                                if (chessBoard[row][column] == null) {
                                    chessBoard[row][column] = chessBoard[i][j];
                                    chessBoard[i][j] = null;
                                    if (!king.KingChecked(chessBoard)) {
                                        if ((i + j) % 2 == 0)
                                            chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackWhiteBishop);
                                        else
                                            chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackBlackBishop);
                                        chessBoard[row][column] = save;
                                        return true;
                                    } else {
                                        if ((i + j) % 2 == 0)
                                            chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackWhiteBishop);
                                        else
                                            chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackBlackBishop);
                                        chessBoard[row][column] = save;
                                    }
                                } else if (chessBoard[row][column].getFigureColor().equals(Color.isWhiteFigure.getColor())) {
                                    chessBoard[row][column] = chessBoard[i][j];
                                    chessBoard[i][j] = null;
                                    if (!king.KingChecked(chessBoard)) {
                                        if ((i + j) % 2 == 0)
                                            chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackWhiteBishop);
                                        else
                                            chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackBlackBishop);
                                        chessBoard[row][column] = save;
                                        return true;
                                    }
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackWhiteBishop);
                                    else
                                        chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackBlackBishop);
                                    chessBoard[row][column] = save;
                                    break;
                                } else
                                    break;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            int row = i;
                            int column = j;
                            while (true) {
                                row++;
                                column--;
                                save = chessBoard[row][column];
                                if (chessBoard[row][column] == null) {
                                    chessBoard[row][column] = chessBoard[i][j];
                                    chessBoard[i][j] = null;
                                    if (!king.KingChecked(chessBoard)) {
                                        if ((i + j) % 2 == 0)
                                            chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackWhiteBishop);
                                        else
                                            chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackBlackBishop);
                                        chessBoard[row][column] = save;
                                        return true;
                                    } else {
                                        if ((i + j) % 2 == 0)
                                            chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackWhiteBishop);
                                        else
                                            chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackBlackBishop);
                                        chessBoard[row][column] = save;
                                    }
                                } else if (chessBoard[row][column].getFigureColor().equals(Color.isWhiteFigure.getColor())) {
                                    chessBoard[row][column] = chessBoard[i][j];
                                    chessBoard[i][j] = null;
                                    if (!king.KingChecked(chessBoard)) {
                                        if ((i + j) % 2 == 0)
                                            chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackWhiteBishop);
                                        else
                                            chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackBlackBishop);
                                        chessBoard[row][column] = save;
                                        return true;
                                    }
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackWhiteBishop);
                                    else
                                        chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackBlackBishop);
                                    chessBoard[row][column] = save;
                                    break;
                                } else
                                    break;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            int row = i;
                            int column = j;
                            while (true) {
                                row--;
                                column++;
                                save = chessBoard[row][column];
                                if (chessBoard[row][column] == null) {
                                    chessBoard[row][column] = chessBoard[i][j];
                                    chessBoard[i][j] = null;
                                    if (!king.KingChecked(chessBoard)) {
                                        if ((i + j) % 2 == 0)
                                            chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackWhiteBishop);
                                        else
                                            chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackBlackBishop);
                                        chessBoard[row][column] = save;
                                        return true;
                                    } else {
                                        if ((i + j) % 2 == 0)
                                            chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackWhiteBishop);
                                        else
                                            chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackBlackBishop);
                                        chessBoard[row][column] = save;
                                    }
                                } else if (chessBoard[row][column].getFigureColor().equals(Color.isWhiteFigure.getColor())) {
                                    chessBoard[row][column] = chessBoard[i][j];
                                    chessBoard[i][j] = null;
                                    if (!king.KingChecked(chessBoard)) {
                                        if ((i + j) % 2 == 0)
                                            chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackWhiteBishop);
                                        else
                                            chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackBlackBishop);
                                        chessBoard[row][column] = save;
                                        return true;
                                    }
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackWhiteBishop);
                                    else
                                        chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackBlackBishop);
                                    chessBoard[row][column] = save;
                                    break;
                                } else
                                    break;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                        try {
                            int row = i;
                            int column = j;
                            while (true) {
                                row--;
                                column--;
                                save = chessBoard[row][column];
                                if (chessBoard[row][column] == null) {
                                    chessBoard[row][column] = chessBoard[i][j];
                                    chessBoard[i][j] = null;
                                    if (!king.KingChecked(chessBoard)) {
                                        if ((i + j) % 2 == 0)
                                            chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackWhiteBishop);
                                        else
                                            chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackBlackBishop);
                                        chessBoard[row][column] = save;
                                        return true;
                                    } else {
                                        if ((i + j) % 2 == 0)
                                            chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackWhiteBishop);
                                        else
                                            chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackBlackBishop);
                                        chessBoard[row][column] = save;
                                    }
                                } else if (chessBoard[row][column].getFigureColor().equals(Color.isWhiteFigure.getColor())) {
                                    chessBoard[row][column] = chessBoard[i][j];
                                    chessBoard[i][j] = null;
                                    if (!king.KingChecked(chessBoard)) {
                                        if ((i + j) % 2 == 0)
                                            chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackWhiteBishop);
                                        else
                                            chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackBlackBishop);
                                        chessBoard[row][column] = save;
                                        return true;
                                    }
                                    if ((i + j) % 2 == 0)
                                        chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackWhiteBishop);
                                    else
                                        chessBoard[i][j] = new Bishop(Color.isBlackFigure, FigureName.blackBlackBishop);
                                    chessBoard[row][column] = save;
                                    break;
                                } else
                                    break;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                    }
                }
            }
        }
        return super.coverCheck(chessBoard,color);
    }
}

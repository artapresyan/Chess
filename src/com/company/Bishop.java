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
            int i = takeRow;
            int j = takeColumn;
            if (putRow > takeRow && putColumn > takeColumn) {
                while (takeRow < putRow - 1 && takeColumn < putColumn - 1) {
                    takeRow++;
                    takeColumn++;
                    if (chessBoard[takeRow][takeColumn] != null || (takeRow == putRow-1 && takeColumn != putColumn-1) || (takeRow != putRow-1 && takeColumn == putColumn-1))
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
            } else if (putRow > takeRow && putColumn < takeColumn) {
                while (takeRow < putRow - 1 && takeColumn > putColumn + 1) {
                    takeRow++;
                    takeColumn--;
                    if (chessBoard[takeRow][takeColumn] != null || (takeRow == putRow-1 && takeColumn != putColumn+1) || (takeRow != putRow-1 && takeColumn == putColumn+1))
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
            } else if (putRow < takeRow && putColumn < takeColumn) {
                while (takeRow > putRow + 1 && takeColumn > putColumn + 1) {
                    takeRow--;
                    takeColumn--;
                    if (chessBoard[takeRow][takeColumn] != null || (takeRow == putRow+1 && takeColumn != putColumn+1) || (takeRow != putRow+1 && takeColumn == putColumn+1))
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
            } else if (putRow < takeRow && putColumn > takeColumn) {
                while (takeRow > putRow + 1 && takeColumn < putColumn - 1) {
                    takeRow--;
                    takeColumn++;
                    if (chessBoard[takeRow][takeColumn] != null || (takeRow == putRow+1 && takeColumn != putColumn-1) || (takeRow != putRow+1 && takeColumn == putColumn-1))
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
            }
            if (chessBoard[putRow][putColumn] == null) {
                chessBoard[putRow][putColumn] = this;
                chessBoard[i][j] = null;
                if (king.kingChecked(chessBoard, Color.isWhiteFigure)) {
                    System.out.println("\n" + "P1, Please Be Observant And Check Your King's Position...");
                    chessBoard[i][j] = this;
                    chessBoard[putRow][putColumn] = null;
                    return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
                chessBoard[i][j] = this;
                chessBoard[putRow][putColumn] = null;
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
            int i = takeRow;
            int j = takeColumn;
            if (putRow > takeRow && putColumn > takeColumn) {
                while (takeRow < putRow - 1 && takeColumn < putColumn - 1) {
                    takeRow++;
                    takeColumn++;
                    if (chessBoard[takeRow][takeColumn] != null || (takeRow == putRow-1 && takeColumn != putColumn-1) || (takeRow != putRow-1 && takeColumn == putColumn-1))
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
            } else if (putRow > takeRow && putColumn < takeColumn) {
                while (takeRow < putRow - 1 && takeColumn > putColumn + 1) {
                    takeRow++;
                    takeColumn--;
                    if (chessBoard[takeRow][takeColumn] != null || (takeRow == putRow-1 && takeColumn != putColumn+1) || (takeRow != putRow-1 && takeColumn == putColumn+1))
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
            } else if (putRow < takeRow && putColumn < takeColumn) {
                while (takeRow > putRow + 1 && takeColumn > putColumn + 1) {
                    takeRow--;
                    takeColumn--;
                    if (chessBoard[takeRow][takeColumn] != null || (takeRow == putRow+1 && takeColumn != putColumn+1) || (takeRow != putRow+1 && takeColumn == putColumn+1))
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
            } else if (putRow < takeRow && putColumn > takeColumn) {
                while (takeRow > putRow + 1 && takeColumn < putColumn - 1) {
                    takeRow--;
                    takeColumn++;
                    if (chessBoard[takeRow][takeColumn] != null || (takeRow == putRow+1 && takeColumn != putColumn-1) || (takeRow != putRow+1 && takeColumn == putColumn-1))
                        return super.checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
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
    boolean noValidMoves(Figure[][] chessBoard, Color color) {
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
                                    chessBoard[row][column] = this;
                                    chessBoard[i][j] = null;
                                    if (!(king.kingChecked(chessBoard, Color.isWhiteFigure))) {
                                        chessBoard[i][j] = this;
                                        chessBoard[row][column] = save;
                                        return false;
                                    } else {
                                        chessBoard[i][j] = this;
                                        chessBoard[row][column] = save;
                                    }
                                } else if (chessBoard[row][column].getFigureColor().equals(Color.isBlackFigure.getColor())) {
                                    chessBoard[row][column] = this;
                                    chessBoard[i][j] = null;
                                    if (!(king.kingChecked(chessBoard, Color.isWhiteFigure))) {
                                        chessBoard[i][j] = this;
                                        chessBoard[row][column] = save;
                                        return false;
                                    }
                                    chessBoard[i][j] = this;
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
                                    chessBoard[row][column] = this;
                                    chessBoard[i][j] = null;
                                    if (!(king.kingChecked(chessBoard, Color.isWhiteFigure))) {
                                        chessBoard[i][j] = this;
                                        chessBoard[row][column] = save;
                                        return false;
                                    } else {
                                        chessBoard[i][j] = this;
                                        chessBoard[row][column] = save;
                                    }
                                } else if (chessBoard[row][column].getFigureColor().equals(Color.isBlackFigure.getColor())) {
                                    chessBoard[row][column] = this;
                                    chessBoard[i][j] = null;
                                    if (!(king.kingChecked(chessBoard, Color.isWhiteFigure))) {
                                        chessBoard[i][j] = this;
                                        chessBoard[row][column] = save;
                                        return false;
                                    }
                                    chessBoard[i][j] = this;
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
                                    chessBoard[row][column] = this;
                                    chessBoard[i][j] = null;
                                    if (!(king.kingChecked(chessBoard, Color.isWhiteFigure))) {
                                        chessBoard[i][j] = this;
                                        chessBoard[row][column] = save;
                                        return false;
                                    } else {
                                        chessBoard[i][j] = this;
                                        chessBoard[row][column] = save;
                                    }
                                } else if (chessBoard[row][column].getFigureColor().equals(Color.isBlackFigure.getColor())) {
                                    chessBoard[row][column] = this;
                                    chessBoard[i][j] = null;
                                    if (!(king.kingChecked(chessBoard, Color.isWhiteFigure))) {
                                        chessBoard[i][j] = this;
                                        chessBoard[row][column] = save;
                                        return false;
                                    }
                                    chessBoard[i][j] = this;
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
                                    chessBoard[row][column] = this;
                                    chessBoard[i][j] = null;
                                    if (!(king.kingChecked(chessBoard, Color.isWhiteFigure))) {
                                        chessBoard[i][j] = this;
                                        chessBoard[row][column] = save;
                                        return false;
                                    } else {
                                        chessBoard[i][j] = this;
                                        chessBoard[row][column] = save;
                                    }
                                } else if (chessBoard[row][column].getFigureColor().equals(Color.isBlackFigure.getColor())) {
                                    chessBoard[row][column] = this;
                                    chessBoard[i][j] = null;
                                    if (!(king.kingChecked(chessBoard, Color.isWhiteFigure))) {
                                        chessBoard[i][j] = this;
                                        chessBoard[row][column] = save;
                                        return false;
                                    }
                                    chessBoard[i][j] = this;
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
                                    chessBoard[row][column] = this;
                                    chessBoard[i][j] = null;
                                    if (!(king.kingChecked(chessBoard, Color.isBlackFigure))) {
                                        chessBoard[i][j] = this;
                                        chessBoard[row][column] = save;
                                        return false;
                                    } else {
                                        chessBoard[i][j] = this;
                                        chessBoard[row][column] = save;
                                    }
                                } else if (chessBoard[row][column].getFigureColor().equals(Color.isWhiteFigure.getColor())) {
                                    chessBoard[row][column] = this;
                                    chessBoard[i][j] = null;
                                    if (!(king.kingChecked(chessBoard, Color.isBlackFigure))) {
                                        chessBoard[i][j] = this;
                                        chessBoard[row][column] = save;
                                        return false;
                                    }
                                    chessBoard[i][j] = this;
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
                                    chessBoard[row][column] = this;
                                    chessBoard[i][j] = null;
                                    if (!(king.kingChecked(chessBoard, Color.isBlackFigure))) {
                                        chessBoard[i][j] = this;
                                        chessBoard[row][column] = save;
                                        return false;
                                    } else {
                                        chessBoard[i][j] = this;
                                        chessBoard[row][column] = save;
                                    }
                                } else if (chessBoard[row][column].getFigureColor().equals(Color.isWhiteFigure.getColor())) {
                                    chessBoard[row][column] = this;
                                    chessBoard[i][j] = null;
                                    if (!(king.kingChecked(chessBoard, Color.isBlackFigure))) {
                                        chessBoard[i][j] = this;
                                        chessBoard[row][column] = save;
                                        return false;
                                    }
                                    chessBoard[i][j] = this;
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
                                    chessBoard[row][column] = this;
                                    chessBoard[i][j] = null;
                                    if (!(king.kingChecked(chessBoard, Color.isBlackFigure))) {
                                        chessBoard[i][j] = this;
                                        chessBoard[row][column] = save;
                                        return false;
                                    } else {
                                        chessBoard[i][j] = this;
                                        chessBoard[row][column] = save;
                                    }
                                } else if (chessBoard[row][column].getFigureColor().equals(Color.isWhiteFigure.getColor())) {
                                    chessBoard[row][column] = this;
                                    chessBoard[i][j] = null;
                                    if (!(king.kingChecked(chessBoard, Color.isBlackFigure))) {
                                        chessBoard[i][j] = this;
                                        chessBoard[row][column] = save;
                                        return false;
                                    }
                                    chessBoard[i][j] = this;
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
                                    chessBoard[row][column] = this;
                                    chessBoard[i][j] = null;
                                    if (!(king.kingChecked(chessBoard, Color.isBlackFigure))) {
                                        chessBoard[i][j] = this;
                                        chessBoard[row][column] = save;
                                        return false;
                                    } else {
                                        chessBoard[i][j] = this;
                                        chessBoard[row][column] = save;
                                    }
                                } else if (chessBoard[row][column].getFigureColor().equals(Color.isWhiteFigure.getColor())) {
                                    chessBoard[row][column] = this;
                                    chessBoard[i][j] = null;
                                    if (!(king.kingChecked(chessBoard, Color.isBlackFigure))) {
                                        chessBoard[i][j] = this;
                                        chessBoard[row][column] = save;
                                        return false;
                                    }
                                    chessBoard[i][j] = this;
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
        return super.noValidMoves(chessBoard, color);
    }
}

package com.company;

import java.util.Scanner;

public class Pawn extends Figure {
    private final Object p1figureName = "w.P";
    private final Object p2figureName = "b.P";
    private String name;
    Scanner a = new Scanner(System.in);

    public Object p1whiteFigure() {
        return p1figureName;
    }

    public Object p2blackFigure() {
        return p2figureName;
    }

    void p1moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        Figure rook = new Rook();
        Figure knight = new Knight();
        Figure bishop = new Bishop();
        Figure queen = new Queen();
        boolean rightFigure = false;
        if (putRow == 7) {
            chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
            chessBoard[takeRow][takeColumn] = null;
            do {
                System.out.println("Choose figure");
                name = a.nextLine();
                if (name.equalsIgnoreCase("Knight")) {
                    chessBoard[7][putColumn] = knight.p1whiteFigure();
                    rightFigure = true;
                } else if (name.equalsIgnoreCase("Bishop")) {
                    if ((7 + putColumn) % 2 == 0)
                        chessBoard[7][putColumn] = bishop.p1whiteFigure();
                    else
                        chessBoard[7][putColumn] = bishop.p1blackFigure();
                    rightFigure = true;
                } else if (name.equalsIgnoreCase("Rook")) {
                    chessBoard[7][putColumn] = rook.p1whiteFigure();
                    rightFigure = true;
                } else if (name.equalsIgnoreCase("Queen")) {
                    chessBoard[7][putColumn] = queen.p1whiteFigure();
                    rightFigure = true;
                } else
                    System.out.println("Invalid Figure");
            } while (!rightFigure);
        } else {
            chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
            chessBoard[takeRow][takeColumn] = null;
        }
    }

    void p2moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        Figure rook = new Rook();
        Figure knight = new Knight();
        Figure bishop = new Bishop();
        Figure queen = new Queen();
        boolean rightFigure=false;
        if (putRow == 0) {
            chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
            chessBoard[takeRow][takeColumn] = null;
            do {
                System.out.println("Choose figure");
                name = a.nextLine();
                if (name.equalsIgnoreCase("Knight")){
                    chessBoard[0][putColumn] = knight.p2blackFigure();
                    rightFigure = true;
                }
                else if (name.equalsIgnoreCase("Bishop")) {
                    if (putColumn % 2 == 0)
                        chessBoard[0][putColumn] = bishop.p2whiteFigure();
                    else
                        chessBoard[0][putColumn] = bishop.p2blackFigure();
                    rightFigure = true;
                } else if (name.equalsIgnoreCase("Rook")){
                    chessBoard[0][putColumn] = rook.p2blackFigure();
                    rightFigure = true;
                } else if (name.equalsIgnoreCase("Queen")) {
                    chessBoard[0][putColumn] = queen.p2blackFigure();
                    rightFigure = true;
                } else
                    System.out.println("Invalid figure");
            }while (!rightFigure);
        } else {
            chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
            chessBoard[takeRow][takeColumn] = null;
        }
    }

    boolean p1checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        King king = new King();
        if (chessBoard[takeRow][takeColumn] != p1whiteFigure() || takeRow == putRow && takeColumn == putColumn)
            return super.p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
        if (takeRow == 1 && putRow == 3 && takeColumn == putColumn) {
            if (chessBoard[putRow][putColumn] == null && chessBoard[putRow - 1][putColumn] == null) {
                Object mover = chessBoard[putRow][putColumn];
                chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                chessBoard[takeRow][takeColumn] = null;
                if (king.p1KingChecked(chessBoard)) {
                    System.out.println("\n"+"P1, Please Be Observant And Check Your King's Position...");
                    chessBoard[takeRow][takeColumn] = p1whiteFigure();
                    chessBoard[putRow][putColumn] = mover;
                    return super.p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
                chessBoard[takeRow][takeColumn] = p1whiteFigure();
                chessBoard[putRow][putColumn] = mover;
                return true;
            }
        } else if (takeRow - putRow == -1) {
            if (takeColumn == putColumn && chessBoard[putRow][putColumn] == null) {
                Object mover = chessBoard[putRow][putColumn];
                chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                chessBoard[takeRow][takeColumn] = null;
                if (king.p1KingChecked(chessBoard)) {
                    System.out.println("\n"+"P1, Please Be Observant And Check Your King's Position...");
                    chessBoard[takeRow][takeColumn] = p1whiteFigure();
                    chessBoard[putRow][putColumn] = mover;
                    return super.p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
                chessBoard[takeRow][takeColumn] = p1whiteFigure();
                chessBoard[putRow][putColumn] = mover;
                return true;
            } else if (chessBoard[putRow][putColumn] != null) {
                if (chessBoard[putRow][putColumn].toString().charAt(0) == 'b' && (takeColumn - putColumn == -1 || takeColumn - putColumn == 1)) {
                    Object mover = chessBoard[putRow][putColumn];
                    chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                    chessBoard[takeRow][takeColumn] = null;
                    if (king.p1KingChecked(chessBoard)) {
                        System.out.println("\n"+"P1, Please Be Observant And Check Your King's Position...");
                        chessBoard[takeRow][takeColumn] = p1whiteFigure();
                        chessBoard[putRow][putColumn] = mover;
                        return super.p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                    chessBoard[takeRow][takeColumn] = p1whiteFigure();
                    chessBoard[putRow][putColumn] = mover;
                    return true;
                }
            }
        }
        return super.p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
    }

    boolean p2checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        King king = new King();
        if (chessBoard[takeRow][takeColumn] != p2blackFigure() || takeRow == putRow && takeColumn == putColumn)
            return super.p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
        if (takeRow == 6 && putRow == 4 && takeColumn == putColumn) {
            if (chessBoard[putRow][putColumn] == null && chessBoard[putRow + 1][putColumn] == null) {
                Object mover = chessBoard[putRow][putColumn];
                chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                chessBoard[takeRow][takeColumn] = null;
                if (king.p2KingChecked(chessBoard)) {
                    System.out.println("\n"+"P2, Please Be Observant And Check Your King's Position...");
                    chessBoard[takeRow][takeColumn] = p2blackFigure();
                    chessBoard[putRow][putColumn] = mover;
                    return super.p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
                chessBoard[takeRow][takeColumn] = p2blackFigure();
                chessBoard[putRow][putColumn] = mover;
                return true;
            }
        } else if (takeRow - putRow == 1) {
            if (takeColumn == putColumn && chessBoard[putRow][putColumn] == null) {
                Object mover = chessBoard[putRow][putColumn];
                chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                chessBoard[takeRow][takeColumn] = null;
                if (king.p2KingChecked(chessBoard)) {
                    System.out.println("\n"+"P2, Please Be Observant And Check Your King's Position...");
                    chessBoard[takeRow][takeColumn] = p2blackFigure();
                    chessBoard[putRow][putColumn] = mover;
                    return super.p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                }
                chessBoard[takeRow][takeColumn] = p2blackFigure();
                chessBoard[putRow][putColumn] = mover;
                return true;
            } else if (chessBoard[putRow][putColumn] != null) {
                if (chessBoard[putRow][putColumn].toString().charAt(0) == 'w' && (takeColumn - putColumn == -1 || takeColumn - putColumn == 1)) {
                    Object mover = chessBoard[putRow][putColumn];
                    chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
                    chessBoard[takeRow][takeColumn] = null;
                    if (king.p2KingChecked(chessBoard)) {
                        System.out.println("\n"+"P2, Please Be Observant And Check Your King's Position...");
                        chessBoard[takeRow][takeColumn] = p2blackFigure();
                        chessBoard[putRow][putColumn] = mover;
                        return super.p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
                    }
                    chessBoard[takeRow][takeColumn] = p2blackFigure();
                    chessBoard[putRow][putColumn] = mover;
                    return true;
                }
            }
        }
        return super.p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn);
    }

    boolean p1NoMoves(Object[][] chessBoard) {
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                if (chessBoard[i][j] == "w.P") {
                    try {
                        if (p1checkMove(chessBoard, i, j, i + 1, j))
                            return false;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (p1checkMove(chessBoard, i, j, i + 1, j + 1))
                            return false;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (p1checkMove(chessBoard, i, j, i + 1, j - 1))
                            return false;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                }
            }
        }
        return super.p1NoMoves(chessBoard);
    }

    boolean p2NoMoves(Object[][] chessBoard) {
        for (int i = chessBoard.length - 1; i >= 0; i--) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                if (chessBoard[i][j] == "b.P") {
                    try {
                        if (p2checkMove(chessBoard, i, j, i + 1, j))
                            return false;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (p2checkMove(chessBoard, i, j, i + 1, j + 1))
                            return false;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (p2checkMove(chessBoard, i, j, i + 1, j - 1))
                            return false;
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                }
            }
        }
        return super.p2NoMoves(chessBoard);
    }

    boolean p1CoverCheck(Object[][] chessBoard) {
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                if (chessBoard[i][j] == "w.P") {
                    try {
                        if (p1checkMove(chessBoard, i, j, i + 1, j)) {
                            return true;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (p1checkMove(chessBoard, i, j, i + 2, j)) {
                            return true;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (p1checkMove(chessBoard, i, j, i + 1, j + 1)) {
                            return true;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (p1checkMove(chessBoard, i, j, i + 1, j - 1)) {
                            return true;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                }
            }
        }
        return super.p1CoverCheck(chessBoard);
    }

    boolean p2CoverCheck(Object[][] chessBoard) {
        for (int i = chessBoard.length - 1; i >= 0; i--) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                if (chessBoard[i][j] == "b.P") {
                    try {
                        if (p2checkMove(chessBoard, i, j, i - 1, j)) {
                            return true;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (p2checkMove(chessBoard, i, j, i - 2, j)) {
                            return true;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (p2checkMove(chessBoard, i, j, i - 1, j + 1)) {
                            return true;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (p2checkMove(chessBoard, i, j, i - 1, j - 1)) {
                            return true;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                }
            }
        }
        return super.p2CoverCheck(chessBoard);
    }
}


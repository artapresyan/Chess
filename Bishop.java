package com.company;

public class Bishop extends Figure{
    King king=new King();
    private final Object p1whiteFigureName="wwB";
    private final Object p1blackFigureName="wbB";
    private final Object p2whiteFigureName="bwB";
    private final Object p2blackFigureName="bbB";
    public Object p1whiteFigure() {
        return p1whiteFigureName;
    }
    public Object p1blackFigure() {
        return p1blackFigureName;
    }
    public Object p2whiteFigure() {
        return p2whiteFigureName;
    }
    public Object p2blackFigure() {
        return p2blackFigureName;
    }

    void p1moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
            chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
            chessBoard[takeRow][takeColumn]=null;
            for (int i = 1; i < chessBoard.length-1; i++) {
                for (int j = 1; j < chessBoard[1].length-1; j++) {
                    if (chessBoard[i][j] == king.p1whiteFigure() ) {
                        if (king.p1KingChecked(chessBoard, i, j)){
                            System.out.println("King checked, please be observant...");
                            if ((takeColumn + takeRow) % 2 == 0)
                                chessBoard[takeRow][takeColumn]=p1whiteFigure();
                            else
                                chessBoard[takeRow][takeColumn]=p1blackFigure();
                            chessBoard[putRow][putColumn]=null;
                        }
                        break;
                    }
                }
            }
        } else
            System.out.println("Invalid move");
    }
    void p2moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
            chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
            chessBoard[takeRow][takeColumn]=null;
            for (int i = 1; i < chessBoard.length-1; i++) {
                for (int j = 1; j < chessBoard[8].length-1; j++) {
                    if (chessBoard[i][j] == king.p2blackFigure() ) {
                        if (king.p2KingChecked(chessBoard, i, j)){
                            System.out.println("King checked, please be observant...");
                            if ((takeColumn + takeRow) % 2 == 0)
                                chessBoard[takeRow][takeColumn]=p2whiteFigure();
                            else
                                chessBoard[takeRow][takeColumn]=p2blackFigure();
                            chessBoard[putRow][putColumn]=null;
                        }
                        break;
                    }
                }
            }
        } else
            System.out.println("Invalid move");
    }

    boolean p1checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (chessBoard[takeRow][takeColumn]!=p1whiteFigure() && chessBoard[takeRow][takeColumn]!=p1blackFigure() || takeRow==putColumn && takeColumn==putColumn)
            return false;
        if (putRow>takeRow && putColumn>takeColumn){
            while(takeRow<putRow-1 && takeColumn<putColumn-1){
                takeRow++;
                takeColumn++;
                if (chessBoard[takeRow][takeColumn]!=null || takeRow==putRow && takeColumn!=putColumn || takeRow!=putRow && takeColumn==putColumn)
                    return false;
            }
        }else if (putRow>takeRow && putColumn<takeColumn) {
            while (takeRow < putRow - 1 && takeColumn > putColumn + 1) {
                takeRow++;
                takeColumn--;
                if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                    return false;
            }
        }else if (putRow<takeRow && putColumn<takeColumn){
            while (takeRow>putRow+1 && takeColumn>putColumn+1){
                takeRow--;
                takeColumn--;
                if (chessBoard[takeRow][takeColumn]!=null || takeRow==putRow && takeColumn!=putColumn || takeRow!=putRow && takeColumn==putColumn)
                    return false;
            }
        }else if (putRow<takeRow && putColumn>takeColumn){
            while (takeRow>putRow+1 && takeColumn<putColumn-1){
                takeRow--;
                takeColumn++;
                if (chessBoard[takeRow][takeColumn]!=null || takeRow==putRow && takeColumn!=putColumn || takeRow!=putRow && takeColumn==putColumn)
                    return false;
            }
        }
        if (chessBoard[putRow][putColumn] == null)
            return true;
        else
            return chessBoard[putRow][putColumn].toString().charAt(0) == 'b';
    }

    boolean p2checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (chessBoard[takeRow][takeColumn] != p2blackFigure() && chessBoard[takeRow][takeColumn] != p2whiteFigure() || takeRow==putColumn && takeColumn==putColumn)
            return false;
        if (putRow > takeRow && putColumn > takeColumn) {
            while (takeRow < putRow - 1 && takeColumn < putColumn - 1) {
                takeRow++;
                takeColumn++;
                if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                    return false;
            }
        } else if (putRow > takeRow && putColumn < takeColumn) {
            while (takeRow < putRow - 1 && takeColumn > putColumn + 1) {
                takeRow++;
                takeColumn--;
                if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                    return false;
            }
        } else if (putRow < takeRow && putColumn < takeColumn) {
            while (takeRow > putRow + 1 && takeColumn > putColumn + 1) {
                takeRow--;
                takeColumn--;
                if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                    return false;
            }
        } else if (putRow < takeRow && putColumn > takeColumn) {
            while (takeRow > putRow + 1 && takeColumn < putColumn - 1) {
                takeRow--;
                takeColumn++;
                if (chessBoard[takeRow][takeColumn] != null || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                    return false;
            }
        }
        if (chessBoard[putRow][putColumn] == null)
            return true;
        else
            return chessBoard[putRow][putColumn].toString().charAt(0) == 'w';
    }
}

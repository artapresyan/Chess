package com.company;

public class Bishop extends Figure{
    King king=new King();
    Object p1whiteFigureName="wwB";
    Object p1blackFigureName="wbB";
    Object p2whiteFigureName="bwB";
    Object p2blackFigureName="bbB";
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
    public Object p2figure() {
        return p2figureName;
    }
    void p1moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
            chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
            if ((takeColumn + takeRow) % 2 == 0)
                chessBoard[takeRow][takeColumn] = white;
            else
                chessBoard[takeRow][takeColumn] = black;
            for (int i = 1; i < chessBoard.length-1; i++) {
                for (int j = 1; j < chessBoard[1].length-1; j++) {
                    if (chessBoard[i][j] == king.p1whiteFigure() ) {
                        if (king.p1KingChecked(chessBoard, i, j)){
                            System.out.println("King checked, please be observant...");
                            if ((takeColumn + takeRow) % 2 == 0)
                                chessBoard[takeRow][takeColumn]=p1whiteFigure();
                            else
                                chessBoard[takeRow][takeColumn]=p1blackFigure();
                            if ((putColumn + putRow) % 2 == 0)
                                chessBoard[putRow][putColumn] = white;
                            else
                                chessBoard[putRow][putColumn] = black;
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
            if ((takeColumn + takeRow) % 2 == 0)
                chessBoard[takeRow][takeColumn] = white;
            else
                chessBoard[takeRow][takeColumn] = black;
            for (int i = 1; i < chessBoard.length-1; i++) {
                for (int j = 1; j < chessBoard[8].length-1; j++) {
                    if (chessBoard[i][j] == king.p2blackFigure() ) {
                        if (king.p2KingChecked(chessBoard, i, j)){
                            System.out.println("King checked, please be observant...");
                            if ((takeColumn + takeRow) % 2 == 0)
                                chessBoard[takeRow][takeColumn]=p2whiteFigure();
                            else
                                chessBoard[takeRow][takeColumn]=p2blackFigure();
                            if ((putColumn + putRow) % 2 == 0)
                                chessBoard[putRow][putColumn] = white;
                            else
                                chessBoard[putRow][putColumn] = black;
                        }
                        break;
                    }
                }
            }
        } else
            System.out.println("Invalid move");
    }

    boolean p1checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (chessBoard[takeRow][takeColumn]!=p1whiteFigure() && chessBoard[takeRow][takeColumn]!=p1blackFigure())
            return false;
        if (putRow>takeRow && putColumn>takeColumn){
            while(takeRow<putRow-1 && takeColumn<putColumn-1){
                takeRow++;
                takeColumn++;
                if (chessBoard[takeRow][takeColumn]!=white && chessBoard[takeRow][takeColumn]!=black || takeRow==putRow && takeColumn!=putColumn || takeRow!=putRow && takeColumn==putColumn)
                    return false;
            }
            if (chessBoard[putRow][putColumn].toString().charAt(0)=='b')
                return true;
            else if (chessBoard[putRow][putColumn]!=white && chessBoard[putRow][putColumn]!=black)
                return false;
            else
                return true;
        }else if (putRow>takeRow && putColumn<takeColumn){
            while (takeRow<putRow-1 && takeColumn>putColumn+1){
                takeRow++;
                takeColumn--;
                if (chessBoard[takeRow][takeColumn]!=white && chessBoard[takeRow][takeColumn]!=black|| takeRow==putRow && takeColumn!=putColumn || takeRow!=putRow && takeColumn==putColumn)
                    return false;
            }
            if (chessBoard[putRow][putColumn].toString().charAt(0)=='b')
                return true;
            else if (chessBoard[putRow][putColumn]!=white && chessBoard[putRow][putColumn]!=black)
                return false;
            else
                return true;
            }else if (putRow<takeRow && putColumn<takeColumn){
            while (takeRow>putRow+1 && takeColumn>putColumn+1){
                takeRow--;
                takeColumn--;
                if (chessBoard[takeRow][takeColumn]!=white && chessBoard[takeRow][takeColumn]!=black|| takeRow==putRow && takeColumn!=putColumn || takeRow!=putRow && takeColumn==putColumn)
                    return false;
            }
            if (chessBoard[putRow][putColumn].toString().charAt(0)=='b')
                return true;
            else if (chessBoard[putRow][putColumn]!=white && chessBoard[putRow][putColumn]!=black)
                return false;
            else
                return true;
        }else if (putRow<takeRow && putColumn>takeColumn){
            while (takeRow>putRow+1 && takeColumn<putColumn-1){
                takeRow--;
                takeColumn++;
                if (chessBoard[takeRow][takeColumn]!=white && chessBoard[takeRow][takeColumn]!=black|| takeRow==putRow && takeColumn!=putColumn || takeRow!=putRow && takeColumn==putColumn)
                    return false;
            }
            if (chessBoard[putRow][putColumn].toString().charAt(0)=='b')
                return true;
            else if (chessBoard[putRow][putColumn]!=white && chessBoard[putRow][putColumn]!=black)
                return false;
            else
                return true;
        }else
            return false;
    }

    boolean p2checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (chessBoard[takeRow][takeColumn] != p2blackFigure() && chessBoard[takeRow][takeColumn] != p2whiteFigure())
            return false;
        if (putRow > takeRow && putColumn > takeColumn) {
            while (takeRow < putRow - 1 && takeColumn < putColumn - 1) {
                takeRow++;
                takeColumn++;
                if (chessBoard[takeRow][takeColumn] != white && chessBoard[takeRow][takeColumn] != black || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                    return false;
            }
            if (chessBoard[putRow][putColumn].toString().charAt(0) == 'w')
                return true;
            else if (chessBoard[putRow][putColumn] != white && chessBoard[putRow][putColumn] != black)
                return false;
            else
                return true;
        } else if (putRow > takeRow && putColumn < takeColumn) {
            while (takeRow < putRow - 1 && takeColumn > putColumn + 1) {
                takeRow++;
                takeColumn--;
                if (chessBoard[takeRow][takeColumn] != white && chessBoard[takeRow][takeColumn] != black || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                    return false;
            }
            if (chessBoard[putRow][putColumn].toString().charAt(0) == 'w')
                return true;
            else if (chessBoard[putRow][putColumn] != white && chessBoard[putRow][putColumn] != black)
                return false;
            else
                return true;
        } else if (putRow < takeRow && putColumn < takeColumn) {
            while (takeRow > putRow + 1 && takeColumn > putColumn + 1) {
                takeRow--;
                takeColumn--;
                if (chessBoard[takeRow][takeColumn] != white && chessBoard[takeRow][takeColumn] != black || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                    return false;
            }
            if (chessBoard[putRow][putColumn].toString().charAt(0) == 'w')
                return true;
            else if (chessBoard[putRow][putColumn] != white && chessBoard[putRow][putColumn] != black)
                return false;
            else
                return true;
        } else if (putRow < takeRow && putColumn > takeColumn) {
            while (takeRow > putRow + 1 && takeColumn < putColumn - 1) {
                takeRow--;
                takeColumn++;
                if (chessBoard[takeRow][takeColumn] != white && chessBoard[takeRow][takeColumn] != black || takeRow == putRow && takeColumn != putColumn || takeRow != putRow && takeColumn == putColumn)
                    return false;
            }
            if (chessBoard[putRow][putColumn].toString().charAt(0) == 'w')
                return true;
            else if (chessBoard[putRow][putColumn] != white && chessBoard[putRow][putColumn] != black)
                return false;
            else
                return true;
        } else
            return false;
    }
}

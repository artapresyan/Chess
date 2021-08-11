package com.company;

public class Bishop extends Figure{
    public Object figure(Object figureName) {
        return figureName;
    }

    void p1moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (p1checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
            chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
            if ((takeColumn + takeRow) % 2 == 0)
                chessBoard[takeRow][takeColumn] = white;
            else
                chessBoard[takeRow][takeColumn] = black;
        } else {
            System.out.println("Invalid move");
        }
    }
    void p2moveFigure(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (p2checkMove(chessBoard, takeRow, takeColumn, putRow, putColumn)) {
            chessBoard[putRow][putColumn] = chessBoard[takeRow][takeColumn];
            if ((takeColumn + takeRow) % 2 == 0)
                chessBoard[takeRow][takeColumn] = white;
            else
                chessBoard[takeRow][takeColumn] = black;
        } else {
            System.out.println("Invalid move");
        }
    }

    boolean p1checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (!chessBoard[takeRow][takeColumn].toString().equals("wwB")&& !chessBoard[takeRow][takeColumn].toString().equals("wbB"))
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
        if (!chessBoard[takeRow][takeColumn].toString().equals("bbB") && !chessBoard[takeRow][takeColumn].toString().equals("bwB"))
            return false;
        if (putRow>takeRow && putColumn>takeColumn){
            while(takeRow<putRow-1 && takeColumn<putColumn-1){
                takeRow++;
                takeColumn++;
                if (chessBoard[takeRow][takeColumn]!=white && chessBoard[takeRow][takeColumn]!=black || takeRow==putRow && takeColumn!=putColumn || takeRow!=putRow && takeColumn==putColumn)
                    return false;
            }
            if (chessBoard[putRow][putColumn].toString().charAt(0)=='w')
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
            if (chessBoard[putRow][putColumn].toString().charAt(0)=='w')
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
            if (chessBoard[putRow][putColumn].toString().charAt(0)=='w')
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
            if (chessBoard[putRow][putColumn].toString().charAt(0)=='w')
                return true;
            else if (chessBoard[putRow][putColumn]!=white && chessBoard[putRow][putColumn]!=black)
                return false;
            else
                return true;
        }else
            return false;
    }
}

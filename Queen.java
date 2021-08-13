package com.company;

public class Queen extends Figure {
    King king=new King();
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
            for (int i = 0; i < chessBoard.length; i++) {
                for (int j = 0; j < chessBoard[0].length; j++) {
                    if (chessBoard[i][j] == "w.K" ) {
                        if (king.p1KingChecked(chessBoard, i, j)){
                            System.out.println("King checked, please be observant...");
                            chessBoard[takeRow][takeColumn]=figure("w.Q");
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
            for (int i = 0; i < chessBoard.length; i++) {
                for (int j = 0; j < chessBoard[0].length; j++) {
                    if (chessBoard[i][j] == "b.K" ) {
                        if (king.p1KingChecked(chessBoard, i, j)){
                            System.out.println("King checked, please be observant...");
                            chessBoard[takeRow][takeColumn]=figure("b.Q");
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
        if (!chessBoard[takeRow][takeColumn].toString().equals("w.Q"))
            return false;
        if(takeRow==putRow || takeColumn==putColumn) {
            if (putColumn>takeColumn) {
                while (takeColumn < putColumn - 1) {
                    takeColumn++;
                    if (chessBoard[putRow][takeColumn] != white && chessBoard[putRow][takeColumn] != black)
                        return false;
                }
                if (chessBoard[putRow][putColumn].toString().charAt(0) == 'b')
                    return true;
                else if (chessBoard[putRow][putColumn] != white && chessBoard[putRow][putColumn] != black)
                    return false;
                else
                    return true;
            }else if (putColumn<takeColumn){
                while (takeColumn > putColumn+1) {
                    takeColumn--;
                    if (chessBoard[putRow][takeColumn] != white && chessBoard[putRow][takeColumn] != black)
                        return false;
                }
                if (chessBoard[putRow][putColumn].toString().charAt(0)=='b')
                    return true;
                else if (chessBoard[putRow][putColumn]!=white && chessBoard[putRow][putColumn]!=black)
                    return false;
                else
                    return true;
            }else if (putRow > takeRow) {
                while (takeRow < putRow-1) {
                    takeRow++;
                    if (chessBoard[takeRow][putColumn] != white && chessBoard[takeRow][putColumn] != black)
                        return false;
                }
                if (chessBoard[putRow][putColumn].toString().charAt(0) == 'b')
                    return true;
                else if (chessBoard[putRow][putColumn] != white && chessBoard[putRow][putColumn] != black)
                    return false;
                else
                    return true;
            }else if (putRow<takeRow){
                while (takeRow > putRow+1) {
                    takeRow--;
                    if (chessBoard[takeRow][putColumn] != white && chessBoard[takeRow][putColumn] != black)
                        return false;
                }
                if (chessBoard[putRow][putColumn].toString().charAt(0) == 'b')
                    return true;
                else if (chessBoard[putRow][putColumn] != white && chessBoard[putRow][putColumn] != black)
                    return false;
                else
                    return true;
            }
        }else if (putRow>takeRow && putColumn>takeColumn){
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
        }
            return false;
    }
    boolean p2checkMove(Object[][] chessBoard, int takeRow, int takeColumn, int putRow, int putColumn) {
        if (!chessBoard[takeRow][takeColumn].toString().equals("b.Q"))
            return false;
        if(takeRow==putRow || takeColumn==putColumn) {
            if (putColumn>takeColumn) {
                while (takeColumn < putColumn - 1) {
                    takeColumn++;
                    if (chessBoard[putRow][takeColumn] != white && chessBoard[putRow][takeColumn] != black)
                        return false;
                }
                if (chessBoard[putRow][putColumn].toString().charAt(0) == 'w')
                    return true;
                else if (chessBoard[putRow][putColumn] != white && chessBoard[putRow][putColumn] != black)
                    return false;
                else
                    return true;
            }else if (putColumn<takeColumn){
                while (takeColumn > putColumn+1) {
                    takeColumn--;
                    if (chessBoard[putRow][takeColumn] != white && chessBoard[putRow][takeColumn] != black)
                        return false;
                }
                if (chessBoard[putRow][putColumn].toString().charAt(0)=='w')
                    return true;
                else if (chessBoard[putRow][putColumn]!=white && chessBoard[putRow][putColumn]!=black)
                    return false;
                else
                    return true;
            }else if (putRow > takeRow) {
                while (takeRow < putRow-1) {
                    takeRow++;
                    if (chessBoard[takeRow][putColumn] != white && chessBoard[takeRow][putColumn] != black)
                        return false;
                }
                if (chessBoard[putRow][putColumn].toString().charAt(0) == 'w')
                    return true;
                else if (chessBoard[putRow][putColumn] != white && chessBoard[putRow][putColumn] != black)
                    return false;
                else
                    return true;
            }else if (putRow<takeRow){
                while (takeRow > putRow+1) {
                    takeRow--;
                    if (chessBoard[takeRow][putColumn] != white && chessBoard[takeRow][putColumn] != black)
                        return false;
                }
                if (chessBoard[putRow][putColumn].toString().charAt(0) == 'w')
                    return true;
                else if (chessBoard[putRow][putColumn] != white && chessBoard[putRow][putColumn] != black)
                    return false;
                else
                    return true;
            }
        }else if (chessBoard[takeRow][takeColumn].toString().charAt(0)!='b')
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



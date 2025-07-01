package com.example.models;

import java.util.ArrayList;

import java.util.List;

import lombok.Getter;

@Getter
public class Board {
    private List<List<Cell>> cells = new ArrayList<>();
    int N;
    int rows,cols;
    public Board(int rows,int cols){
        N = rows * cols;
        this.rows = rows;
        this.cols = cols;
        for(int i=0;i<rows;i++){
            List<Cell> row = new ArrayList<>();
            for(int j=0;j<cols;j++){
                row.add(new Cell(i, j,Symbol.EMPTY));
            }
            cells.add(row);
        }
    }


    public int getBoardRows(){
        return rows;
    }

     public int getBoardCols(){
        return cols;
    }

    public boolean checkIfCellIsFilled(int positionX,int positionY){
         
         Cell curCell = cells.get(positionX).get(positionY);
         if(curCell.getSymbol()!=Symbol.EMPTY){
                return true;
        }
        return false;
    }

    public Cell fillCell(Cell cell){
       
       
            int x = cell.getPositionX();
            int y = cell.getPositionY();
           
            // Cell curCell = cells.get(x).get(y);
            
            // curCell.setSymbol(cell.getSymbol());
            this.cells.get(x).set(y, cell);
            return cell;

    }

   public void printBoard() {
    for (List<Cell> row : cells) {
        for (Cell cell : row) {
            if (cell.getSymbol() == Symbol.EMPTY) {
                System.out.print(" _ |");
            } else {
                System.out.print(" " + cell.getSymbol() + " |");
            }
        }
        System.out.println("\n-----------");
    }
}

    public boolean checkWinCondition(Cell cell){
        /** check all row */
      if(checkRows(cell)){
        return true;
      }
        /** fill this up */
       if(checkCols(cell)){
        return true;
       }

       if(checkDiagonals(cell)){
        return true;
       }

        if(checkDiagonalsReverse(cell)){
            return true;
        }

        return false;
    }


    private boolean checkDiagonalsReverse(Cell cell) {
       
        if(cell.getPositionX() + cell.getPositionY() != rows - 1){
            return false;
        }

        for(int j=0;j<rows;j++){
            if(cells.get(j).get(rows - 1 - j).getSymbol()!=cell.getSymbol()){
                return false;
            }
        }

        return true;

       
    }


    private boolean checkDiagonals(Cell cell) {
        
         if(cell.getPositionX()!=cell.getPositionY()){
            return false;
         }

         for(int i=0;i<rows;i++){
            if(cells.get(i).get(i).getSymbol()!= cell.getSymbol()){
                return false;
            }
         }

         return true;
    }


    private boolean checkCols(Cell cell) {
        
         int positionY = cell.getPositionY();
        /** check if current move made by player, row matches.. */
       
        for(int j=0;j<rows;j++){
            if(cells.get(j).get(positionY).getSymbol()!=cell.getSymbol()){
                return false;
            }
        }

        return true;
    }


    private boolean checkRows(Cell cell) {
        
          int positionX = cell.getPositionX();
        /** check if current move made by player, row matches.. */
        List<Cell> currentROw = cells.get(positionX);
        for(int j=0;j<currentROw.size();j++){
            if(currentROw.get(j).getSymbol()!=cell.getSymbol()){
                return false;
            }
        }

        return true;
    }
    
}

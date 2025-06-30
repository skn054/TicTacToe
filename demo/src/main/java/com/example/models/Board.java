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

    public Cell fillCell(Cell cell){
       
       
            int x = cell.getPositionX();
            int y = cell.getPositionY();
             /** check if cell already occupied */
            Cell curCell = cells.get(x).get(y);
            if(curCell.getSymbol()!=Symbol.EMPTY){
                return curCell;
            }
            curCell.setSymbol(cell.getSymbol());
            // this.cells.get(x).set(y, cell);
            return curCell;

    }

    public void printBoard(){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                Cell cell = cells.get(i).get(j);
                if(cell!=null){
                    System.out.print(cell.getSymbol()+" || ");
                }else{
                    System.out.print("--" +" || ");
                }
                
            }
            System.out.println("----------");
        }

         System.out.println("----------");
    }

    public boolean checkWinCondition(Cell cell){
        /** check all row */
        for(int i=0;i<rows;i++){
            List<Cell> row;
            row = cells.get(i);
            // if(row!=null){
                for(int j=0;j<row.size();j++){
                Cell currCell = row.get(j);
                if(currCell!=null && currCell.getSymbol() != cell.getSymbol()){
                    return false;
                }
            }
            // }
           
        }
        /** fill this up */
        for(int i=0;i<cols;i++){
            for(int j=0;j<rows;j++){
                List<Cell> cols = cells.get(j);
                // if(cols!=null){
                    Cell currCell = cols.get(i);
                    if(currCell!=null && currCell.getSymbol()!=cell.getSymbol()){
                    return false;
                }
                // }
                
            }
        }

        for(int i=0;i<cells.size();i++){
            List<Cell> row = cells.get(i);
            // if(row!=null){
                Cell currCell = row.get(i);
                if(currCell!=null && currCell.getSymbol() !=cell.getSymbol()){
                return false;
            }
            // }
            
        }

          for(int i=cells.size()-1;i>=0;i--){
             List<Cell> row = cells.get(i);
            // if(row!=null){
                Cell currCell = row.get(i);
                if(currCell!=null && currCell.getSymbol() !=cell.getSymbol()){
                return false;
            }
            // }
        }

        return true;
    }
    
}

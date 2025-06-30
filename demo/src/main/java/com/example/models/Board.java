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
                row.add(null);
            }
            cells.add(row);
        }
    }

    public void fillCell(Cell cell){
            int x = cell.getPositionX();
            int y = cell.getPositionY();

            
            this.cells.get(x).add(y, cell);

    }

    public boolean checkWinCondition(Symbol symbol){
        /** check all row */
        for(int i=0;i<rows;i++){
            List<Cell> row;
            row = cells.get(i);
            for(int j=0;j<row.size();j++){
                if(row.get(j).getSymbol() != symbol){
                    return false;
                }
            }
        }
        /** fill this up */
        for(int i=0;i<cols;i++){

        }

        for(int i=0;i<cells.size();i++){
            if(cells.get(i).get(i).getSymbol() !=symbol){
                return false;
            }
        }

          for(int i=cells.size()-1;i>=0;i--){
            if(cells.get(i).get(i).getSymbol() !=symbol){
                return false;
            }
        }

        return true;
    }
    
}

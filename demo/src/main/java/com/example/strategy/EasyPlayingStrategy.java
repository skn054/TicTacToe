package com.example.strategy;

import java.util.Random;

import com.example.models.Board;
import com.example.models.Cell;
import com.example.models.Symbol;

public class EasyPlayingStrategy implements PlayingStrategy {

    Random r = new Random();
    @Override
    public Cell play(Board board,Symbol symbol) {
        // TODO Auto-generated method stub
        
        int positionX = r.nextInt(board.getRows());
        int positionY = r.nextInt(board.getCols());
        if(board.checkIfCellIsFilled(positionX,positionY)){
            System.out.println("Cell already filled at position  "+ positionX +" "+ positionY);
            return play(board, symbol);
            
        }
        Cell cell  = board.fillCell(new Cell(positionX, positionY,symbol));
        return cell;
    }
    
}

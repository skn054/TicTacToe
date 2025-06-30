package com.example.strategy;

import java.util.Random;

import com.example.models.Board;
import com.example.models.Cell;
import com.example.models.Symbol;

public class EasyPlayingStrategy implements PlayingStrategy {

    @Override
    public Cell play(Board board,Symbol symbol) {
        // TODO Auto-generated method stub
        Random r = new Random();
        int positionX = r.nextInt(board.getRows());
        int positionY = r.nextInt(board.getCols());
        Cell cell  = board.fillCell(new Cell(positionX, positionY,symbol));
        return cell;
    }
    
}

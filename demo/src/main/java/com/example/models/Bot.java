package com.example.models;

import com.example.strategy.PlayingStrategy;

public class Bot implements Player{

    private PlayingStrategy playingStrategy;
    private Symbol symbol;
    
    public Bot(Symbol symbol , PlayingStrategy playingStrategy){
        this.symbol = symbol;
        this.playingStrategy = playingStrategy;
    }
    @Override
    public Cell makeMove(Board board) {
        // TODO Auto-generated method stub
        // board.fillCell(cell);
       Cell cell =  playingStrategy.play(board,symbol);
    //    cell.setSymbol(symbol);
       return cell;
        
    }
    @Override
    public Symbol getSymbol() {
        return this.symbol;
    }
    
}

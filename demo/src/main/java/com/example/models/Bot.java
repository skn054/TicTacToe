package com.example.models;

import com.example.strategy.PlayingStrategy;

public class Bot implements Player{

    private PlayingStrategy playingStrategy;
    @Override
    public void makeMove(Player player, Cell cell,Board board) {
        // TODO Auto-generated method stub
        board.fillCell(cell);
        
    }
    
}

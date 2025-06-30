package com.example.strategy;

import com.example.models.Board;
import com.example.models.Cell;
import com.example.models.Symbol;


public interface PlayingStrategy {

    public Cell play(Board board,Symbol symbol);
    
}

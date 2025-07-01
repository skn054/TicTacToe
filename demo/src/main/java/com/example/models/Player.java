package com.example.models;

public interface Player {
    
    public Cell makeMove(Board board);
    public Symbol getSymbol();
}

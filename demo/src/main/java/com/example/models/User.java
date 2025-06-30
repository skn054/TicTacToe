package com.example.models;

import lombok.Getter;

@Getter
public class User implements Player {

    private String name;
    private String email;
    private String user_id;
    private Symbol symbol;
    @Override
    public void makeMove(Player player, Cell cell,Board board) {
        // TODO Auto-generated method stub
        board.fillCell(cell);
        
    }

    
    
}

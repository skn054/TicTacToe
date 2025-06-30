package com.example.models;

import java.util.Scanner;

import lombok.Getter;

@Getter
public class User implements Player {

    private String name;
    private String email;
    private String user_id;
    private Symbol symbol;
    Scanner sc;

    public User(String name, Symbol symbol,Scanner sc){
        this.name = name;
        this.symbol = symbol;
        this.sc = sc;
    }

    @Override
    public Cell makeMove(Board board) {
        // TODO Auto-generated method stub

        
        
        int positionX = sc.nextInt();
        int positionY = sc.nextInt();
        Cell cell  = board.fillCell(new Cell(positionX, positionY, symbol));
        
        return cell;
            
           
       
        
    }

    
    
}

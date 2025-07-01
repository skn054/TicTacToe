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
    public Symbol getSymbol() {
        return this.symbol;
    }

    @Override
    public Cell makeMove(Board board) {
        // TODO Auto-generated method stub
      while (true) {
        int positionX = sc.nextInt();
        int positionY = sc.nextInt();
        
        if(positionX < 0 || positionX >= board.getRows() || positionY >= board.getCols() || positionY < 0){
            System.out.println("Invalid coordinates. Move is off the board. Please try again.");
            continue;
        }

        if(board.checkIfCellIsFilled(positionX,positionY)){
             System.out.println("Cell already filled. Please try again.");
             
        }else{
            Cell cell  = new Cell(positionX, positionY, symbol);
            return cell;

        }   
        
        
      }
        
        
        
            
           
       
        
    }

    
    
}

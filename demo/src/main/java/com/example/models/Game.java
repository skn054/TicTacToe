package com.example.models;

import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private List<Player> players;

    public Game(Board board,List<Player> players){
        this.board = board;
        this.players = players;
    }

    public void play(){
        Player player;
        int turn = 0;
        int count = 0;
       
        while(true){
            Cell cell ;
           player = players.get(turn);
           System.out.println("Before Move --------");
           board.printBoard();
       
            cell = player.makeMove(board);
            
            System.out.println("After Move --------");
            board.printBoard();
           if(board.checkWinCondition(cell)){
                System.out.println("Player "+turn + "won ");
                break;
           }
    

           count++;
          
           

            if(count == board.getN()){
                System.out.println("Match draw");
                break;
            }

            turn = (turn + 1) % players.size();
        
              
        }
        

    }

   
    
   
}

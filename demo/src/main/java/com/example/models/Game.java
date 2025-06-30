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
            
           player = players.get(turn);
           board.printBoard();
           Cell cell = player.makeMove(board);
           count++;
           if(board.checkWinCondition(cell)){
                System.out.println("Player "+turn + "won ");
                break;
           }

            if(count == board.getN()){
                System.out.println("Match draw");
                break;
            }

            turn = (turn + 1) % players.size();
        
              
        }
        

    }

   
    
   
}

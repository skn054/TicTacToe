package com.example;

import java.util.List;
import java.util.Scanner;

import com.example.models.Board;
import com.example.models.Cell;
import com.example.models.Player;

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
           System.out.println("Before Move --------");
           board.printBoard();
             System.out.println("Player " + player.getSymbol() + "'s turn."); 
       
            Cell proposedMove = player.makeMove(board);
            board.fillCell(proposedMove);
            
            System.out.println("Player " + player.getSymbol() + " made a move at (" + proposedMove.getPositionX() + ", " + proposedMove.getPositionY() + ")");
            board.printBoard();
           if(board.checkWinCondition(proposedMove)){
                 board.printBoard();
                System.out.println("PLAYER " + proposedMove.getSymbol() + " WON THE GAME!");
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

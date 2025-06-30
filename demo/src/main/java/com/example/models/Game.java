package com.example.models;

import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private List<Player> players;

    public void play(){
        Player player;
        int turn = 0;
        int count = 0;
        Scanner sc = new Scanner(System.in);
        while(true){
            int positionX = sc.nextInt();
            int positionY = sc.nextInt();
            Symbol curretnSymbol;
            count++;
            if(turn == 0){
                player = players.get(turn);
                curretnSymbol = Symbol.O;
                player.makeMove(player, new Cell(positionX,positionY,curretnSymbol), board);

            }else{
                player = players.get(turn);
                curretnSymbol = Symbol.X;
                player.makeMove(player,new Cell(positionX, positionY, curretnSymbol), board);
            }
            if(checkWinCondition(curretnSymbol)){
                break;
            }
            if(checkAllCellsFilled(count)){
                break;
            }
        }
        sc.close();

    }

    public boolean checkWinCondition(Symbol symbol){
        return board.checkWinCondition(symbol);
    }
    
    public boolean checkAllCellsFilled(int count){
        if(count == board.getN()){
            return true;
        }
        return false;

    }
}

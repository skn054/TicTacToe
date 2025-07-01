package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.models.Board;
import com.example.models.Bot;
import com.example.models.Player;
import com.example.models.Symbol;
import com.example.models.User;
import com.example.strategy.EasyPlayingStrategy;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!"); 

        try(Scanner sc = new Scanner(System.in)){
            Board board = new Board(3, 3);
         List<Player> players = new ArrayList<>();
          Player user = new User("human", Symbol.X,sc);
        Player bot = new Bot(Symbol.O, new EasyPlayingStrategy());
         players.add(user);
        players.add(bot);
         Game game = new Game(board, players);
         game.play();  
        }
         
    }
}
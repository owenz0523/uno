import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Game
{
    public static void main(String[] args)
    {
        boolean play = true;
        if (play == true)
        {
            startGame();
        }
    }

    public static void startGame()
    {
        ArrayList<Card> deck = makeDeck();
        ArrayList<Player> playerList = new ArrayList<Player>();
        playerList.add(new Player("Player1"));
        playerList.add(new Player("Player2"));
        for (Player p : playerList)
        {
            for (int i = 0; i < 7; i++)
            {
                p.addCard(deck.get(deck.size() - 1));
                deck.remove(deck.size() - 1);
                
            }
            System.out.println(p.getName() + "'s" + " hand: " + p.getHand());
        }

    }

    public static void startGame(ArrayList<Card> deck, ArrayList<Player> playerList)
    {
        ArrayList<Card> pile = new ArrayList<Card>();
        pile.add(deck.get(deck.size() - 1));
        System.out.println(pile.size() - 1);
        deck.remove(deck.size()-1);
        Scanner myObj = new Scanner(System.in);
        while (true)
        {
            for (int i = 0; i < playerList.size(); i++) 
            {
                Player player = playerList.get(i);
                System.out.println("Please input the position of the card you want to play");
                int cardPos = myObj.nextInt() - 1;
                Card playedCard = player.getHand().get(cardPos);
                if (playedCard.isPlayable(pile.get(pile.size() -1))) 
                {
                    pile.add(playedCard);
                    player.removeCard(cardPos);
                    if (playedCard.getType().equals("Reverse")) 
                    {
                        
                    } else if (playedCard.getType().equals("Skip")) {

                    } else if (playedCard.getType().equals("+2")) {
                        
                    } else if (playedCard.getType().equals("ChangeColor")) {
                        
                    } else {

                    }
                }
                
                if (player.checkWin()) {
                    return;
                }
            }
        }
    }

    public static ArrayList<Card> makeDeck()
    {
        ArrayList<Card> deck = new ArrayList<Card>();
        int[] number = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] color = {"B", "R", "G", "Y"};
        String[] powerUp = {"Reverse", "Skip", "+2"};
        String[] wildCard = {"ChangeColor", "+4"};
        
        for (int n : number)
        {
            for (String s: color)
            {
                if (n == 0)
                {
                    deck.add(new Card(n, s, "normal"));
                }
                else
                {
                    deck.add(new Card(n, s, "normal"));
                    deck.add(new Card(n, s, "normal"));
                }
            }
        }
        
        for (String s: color)
        {
            for (String p: powerUp)
            {
                deck.add(new Card(s, p));
                deck.add(new Card(s, p));
            }
        }
        
        for (String s: wildCard)
        {
            for (int i = 0; i < 4; i++)
            {
                deck.add(new Card(s));
            }
        }

        Collections.shuffle(deck);
        return deck;
    }
}

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.*;
import java.io.*;

public class Game extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    public void start(Stage stage)
    {
        ArrayList<Card> deck = makeDeck();
        for (Card c: deck)
        {
            System.out.println(c);
        }
    }

    public ArrayList<Card> makeDeck()
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

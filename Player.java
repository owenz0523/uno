import java.util.*;

public class Player 
{
    private ArrayList<Card> hand;
    private String name;

    public Player(String name)
    {
        hand = new ArrayList<Card>();
        this.name = name;
    }

    public void addCard(Card c)
    {
        hand.add(c);
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Card> getHand()
    {
        return hand;
    }

    public void removeCard(int pos)
    {
        hand.remove(pos);
    }

    public boolean checkWin()
    {
        if (hand.size()== 0) {
            System.out.println(name + " has won!");
            return true;
        }
        return false;
    }
}

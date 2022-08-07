import java.util.*;
public class Card {
    private int number;
    private String color;
    private String type;
    
    public Card(int num, String col, String type)
    {
        number = num;
        color = col;
        this.type = type;
    }

    public Card(String col, String type)
    {
        color = col;
        this.type = type;

    }

    public Card(String type)
    {
        this.type = type;
    }

    public boolean isPlayable(Card other)
    {
        if (color == other.getColor() || type == "add4" || type == "change" || number == other.getNumber())
        {
            return true;
        }
        return false;
    }
    
        public int getNumber()
    {
        return number;
    }
     
    public String getColor()
    {
        return color;
    }
    
    public String getType()
    {
        return type;
    }

    public String toString()
    {
        String s;
        if (type == "normal")
        {
            s = color + " " + number;
        }
        else if (type == "powerUp")
        {
            s = type + " " + color; 
        }
        else
        {
            s = type;
        }
        return s;
    }

}

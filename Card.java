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
        number = -1;
    }

    public Card(String type)
    {
        this.type = type;
        color = "black";
        number = -1;
    }

    public boolean isPlayable(Card other)
    {
        if (color == other.getColor() || type == "+4" || type == "ChangeColor" || number == other.getNumber())
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

    public void setColor(String color)
    {
        this.color = color;
    }

    public String toString()
    {
        String s;
        if (type == "normal")
        {
            s = color + " " + number;
        }
        else if (type == "Reverse" || type == "Skip" || type == "+2")
        {
            s = color + " " + type; 
        }
        else
        {
            s = type;
        }
        return s;
    }

}

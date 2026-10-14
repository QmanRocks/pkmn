
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class Player extends Trainer
{    
    private ArrayList<Item> backpack = new ArrayList<Item>();
    private int money;
    
    public Player(String n, ArrayList<Pokemon> p, ArrayList<Item> b)
    {
        super(n, p, 0, null);
        backpack = b;
    }
    
    public ArrayList<Item> getBackpack()
    {
        return backpack;
    }
    public int getMoney()
    {
        return money;
    }
    
    public void addItem(Item i)
    {
        backpack.add(i);
    }
    public void addMoney(int m)
    {
        money += m;
        System.out.println("Got $"+m+"!");
    }
    
    public void removeItem(int i)
    {
        backpack.remove(i);
    }
    public void spendMoney(int m)
    {
        money -= m;
    }
    
    public String toString()
    {
        String result = super.getName() + ": $"+getMoney() + ", "+super.getPokemon().size() + " Pokemon, "+super.getKOPokemon().size() +" KO Pokemon";
        return result;
    }
}

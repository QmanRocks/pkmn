
/**
 * Write a description of class Trainer here.
 *
 * @author (Quinton McCollum)
 * @version (v1.0)
 */
import java.util.ArrayList;
public class Trainer
{
    private String name;
    private ArrayList<Pokemon> pkmn;
    private ArrayList<Pokemon> koPkmn;
    private int reward;
    private String message;
    
    public Trainer(String n, ArrayList<Pokemon> p, int r, String m)
    {
        name = n;
        pkmn = p;
        reward = r;
        message = m;
        
        koPkmn = new ArrayList<Pokemon>();
    }
    
    public Trainer(Trainer t)
    {
        name = new String(t.getName());
        pkmn = new ArrayList<Pokemon>();
        for(Pokemon p : t.getPokemon())
        {
            pkmn.add(new Pokemon(p));
        }
        reward = t.getReward();
        message = new String(t.getMessage());
        
        koPkmn = new ArrayList<Pokemon>();
    }
    
    public String getName()
    {
        return name;
    }
    public ArrayList<Pokemon> getPokemon()
    {
        return pkmn;
    }
    public int getReward()
    {
        return reward;
    }
    public ArrayList<Pokemon> getKOPokemon()
    {
        return koPkmn;
    }
    public String getMessage()
    {
        return message;
    }
    
    public void setName(String n)
    {
        name = n;
    }
    public void setPokemon(int i, Pokemon p)
    {
        pkmn.set(i, p);
    }
    public void setPokemon(ArrayList<Pokemon> p)
    {
        pkmn = p;
    }
    
    public void koPokemon(Pokemon p)
    {
        koPkmn.add(pkmn.remove(pkmn.indexOf(p)));
    }
    public void addPokemon(Pokemon p)
    {
        pkmn.add(p);
    }
    public void addPokemon(Pokemon p, int i)
    {
        pkmn.add(i, p);
    }
    public void revPokemon(Pokemon p)
    {
        koPkmn.get(koPkmn.indexOf(p)).setAwake(true);
        pkmn.add(koPkmn.remove(koPkmn.indexOf(p)));
    }
    
    public void removePokemon(int i)
    {
        pkmn.remove(i);
    }
}

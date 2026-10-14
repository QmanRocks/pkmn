
/**
 * Write a description of class Route here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Arrays;
public class Route
{
    private ArrayList<Pokemon> wildPk;
    private ArrayList<Trainer> trainers;
    private Trainer gymLeader;
    
    public Route(ArrayList<Pokemon> pk, ArrayList<Trainer> t, Trainer gL)
    {
        wildPk = pk;
        trainers = t;
        gymLeader = gL;
    }
    
    public ArrayList<Pokemon> getPokemon()
    {
        return wildPk;
    }
    public ArrayList<Trainer> getTrainers()
    {
        return trainers;
    }
    public Trainer getGymLeader()
    {
        return new Trainer(gymLeader);
    }
    
    public Trainer randomTrainer()
    {
        return new Trainer(trainers.get((int)(Math.random() * trainers.size())));
    }
    public Pokemon randomPokemon()
    {
        return new Pokemon(wildPk.get((int)(Math.random() * wildPk.size())));
    }
}


/**
 * Write a description of class TrainerList here.
 *
 * @author (Quinton McCollum)
 * @version (v1.0)
 */
import java.util.ArrayList;
import java.util.Arrays;
public class TrainerList
{
    private static Trainer[] trainers =
    {
        new Trainer("Trainer Jimmy", fillPk(new int[]{0,0}), 10, "Hey, let's battle!"),//0
        new Trainer("Trainer Timmy", fillPk(new int[]{1, 0}), 10, "Wanna see who's the better trainer?"),//1
        new Trainer("Trainer Vinny", fillPk(new int[]{3,0}), 10, "Think fast! Let's battle!"),//2
        new Trainer("Trainer Lucy", fillPk(new int[]{4,0}), 10, "I'm gonna beat you!"),//3
        new Trainer("Trainer David", fillPk(new int[]{5,0}), 10, "Let's do this!"),//4
        new Trainer("Trainer Owen", fillPk(new int[]{6,0}), 10, "I've got this!"),//5
        
        new Trainer("Gym Leader Zach", fillPk(new int[]{0,1}, new int[]{2,2}), 20, "Let's make this quick."),//6
        
        new Trainer("Trainer Bob", fillPk(new int[]{17,2}), 15, "I've got you now!"),//7
        new Trainer("Trainer Greg", fillPk(new int[]{12,1}), 15, "We'll beat you!"),//8
        new Trainer("Trainer Mark", fillPk(new int[]{6,2}), 15, "My Pokemon are invincible!"),//9
        new Trainer("Trainer Anne", fillPk(new int[]{50,2}), 15, "I can beat all my friends in battle!"),//10
        new Trainer("Trainer Adam", fillPk(new int[]{32,1}), 15, "Here comes a beat-down!"),//11
        new Trainer("Trainer Nancy", fillPk(new int[]{48,2}), 15, "Let's duke it out!"),//12
        
        new Trainer("Gym Leader Andrew", fillPk(new int[]{20,2}, new int[]{18,2}), 25, "My Grass types will plant our victory!"),//13
        
        new Trainer("Trainer Rebecca", fillPk(new int[]{53,3}), 20, "Prepare for trouble!"),//14
        new Trainer("Trainer Billy", fillPk(new int[]{91,3}), 20, "Coming in hot!"),//15
        new Trainer("Trainer Steve", fillPk(new int[]{63,3}), 20, "I will win this!"),//16
        new Trainer("Trainer Gene", fillPk(new int[]{81,3}), 20, "Welcome to lose-town, population: you!"),//17
        new Trainer("Trainer Sasha", fillPk(new int[]{51,3}), 20, "I'm giving it my all!"),//18
        new Trainer("Trainer Mary", fillPk(new int[]{58,3}), 20, "I'll win this by a landslide!"),//19
        
        new Trainer("Gym Leader Jane", fillPk(new int[]{71,4}, new int[]{54,4}), 30, "Prepare for a mind-bending battle!"),//20
        
        new Trainer("Trainer Sarah", fillPk(new int[]{86,4}), 25, "Hope you like losing!"),//21
        new Trainer("Trainer Kai", fillPk(new int[]{94,4}), 25, "Sorry for the upcoming beatdown!"),//22
        new Trainer("Trainer Robin", fillPk(new int[]{79,4}), 25, "Here comes a haunting loss!"),//23
        new Trainer("Trainer Alex", fillPk(new int[]{73,4}), 25, "I came to win with flying colors!"),//24
        new Trainer("Trainer Harold", fillPk(new int[]{70,4}), 25, "This should be fun!"),//25
        new Trainer("Trainer Linus", fillPk(new int[]{47,4}), 25, "Prepare for a shocking loss!"),//26
        
        new Trainer("Gym Leader Sylvia", fillPk(new int[]{54,5}, new int[]{41,5}), 35, "Fall to the strength of my Pokemon."),//27
        
        new Trainer("Trainer Blaze", fillPk(new int[]{10,6}), 30, "Let's get this over with."),//28
        new Trainer("Trainer Krane", fillPk(new int[]{34,6}), 30, "You've made it too far."),//29
        new Trainer("Trainer Cindy", fillPk(new int[]{13,6}), 30, "The Champion title is mine."),//30
        new Trainer("Trainer Kelly", fillPk(new int[]{36,6}), 30, "May the best trainer win."),//31
        new Trainer("Trainer Jared", fillPk(new int[]{59,6}), 30, "There's no future where you win."),//32
        new Trainer("Trainer Ari", fillPk(new int[]{43,6}), 30, "Let this fight be a lesson."),//33
        
        new Trainer("Grand Champion Red", fillPk(new int[]{87,7}, new int[]{74,7}, new int[]{95,8}), 50, "So, you've made it. Prepare to be defeated!")//34
    };
    
    public static Trainer get(int i)
    {
        return trainers[i];
    }
    
    public static ArrayList<Pokemon> fillPk(int[] p1)
    {
        return new ArrayList<Pokemon>(Arrays.asList(new Pokemon(PokemonList.get(p1[0]),p1[1])));
    }
    public static ArrayList<Pokemon> fillPk(int[] p1, int[] p2)
    {
        return new ArrayList<Pokemon>(Arrays.asList(new Pokemon(PokemonList.get(p1[0]),p1[1]), new Pokemon(PokemonList.get(p2[0]), p2[1])));
    }
    public static ArrayList<Pokemon> fillPk(int[] p1, int[] p2, int[] p3)
    {
        return new ArrayList<Pokemon>(Arrays.asList(new Pokemon(PokemonList.get(p1[0]),p1[1]), new Pokemon(PokemonList.get(p2[0]), p2[1]), new Pokemon(PokemonList.get(p3[0]), p3[1])));
    }
    public static ArrayList<Pokemon> fillPk(int[] p1, int[] p2, int[] p3, int[] p4)
    {
        return new ArrayList<Pokemon>(Arrays.asList(new Pokemon(PokemonList.get(p1[0]),p1[1]), new Pokemon(PokemonList.get(p2[0]), p2[1]), new Pokemon(PokemonList.get(p3[0]), p3[1]), new Pokemon(PokemonList.get(p4[0]), p4[1])));
    }
}

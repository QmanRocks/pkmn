
/**
 * Write a description of class MoveList here.
 *
 * @author (Quinton McCollum)
 * @version (v1.0)
 */
public class MoveList
{
    private static Move[] moves = {
        new Move("Scratch", "Normal", Pokemon.normalValues, 5, 30),//0
        new Move("Bite", "Normal", Pokemon.normalValues, 7, 20),//1
        new Move("Quick Attack", "Normal", Pokemon.normalValues, 5, 25),//2
        
        new Move("Water Jet", "Water", Pokemon.waterValues, (int)(Math.random() * 3) + 6, 25),//3
        new Move("Surf", "Water", Pokemon.waterValues, (int)(Math.random() * 3) + 10, 15),//4
        
        new Move("Ember", "Fire", Pokemon.fireValues, (int)(Math.random() * 3) + 6, 25),//5
        new Move("Torch", "Fire", Pokemon.fireValues, (int)(Math.random() * 3) + 10, 15),//6
        
        new Move("Spark", "Electric", Pokemon.electricValues, (int)(Math.random() * 3) + 6, 25),//7
        new Move("Electron Beam", "Electric", Pokemon.electricValues, (int)(Math.random() * 3) + 10, 15),//8
        
        new Move("Jab", "Fighting", Pokemon.fightingValues, (int)(Math.random() * 3) + 6, 25),//9
        new Move("T-K-O", "Fighting", Pokemon.fightingValues, (int)(Math.random() * 3) + 10, 15),//10
        
        new Move("Web Shot", "Bug", Pokemon.bugValues, (int)(Math.random() * 3) + 6, 25),//11
        new Move("Sting", "Bug", Pokemon.bugValues, (int)(Math.random() * 3) + 10, 15),//12
        
        new Move("Pollen Rush", "Grass", Pokemon.grassValues, (int)(Math.random() * 3) + 6, 25),//13
        new Move("Petal Slash", "Grass", Pokemon.grassValues, (int)(Math.random() * 3) + 10, 15),//14
        
        new Move("Peck", "Flying", Pokemon.flyingValues, (int)(Math.random() * 3) + 6, 25),//15
        new Move("Aerial Ace", "Flying", Pokemon.flyingValues, (int)(Math.random() * 3) + 10, 15),//16
        
        new Move("Venom Spit", "Poison", Pokemon.poisonValues, (int)(Math.random() * 3) + 6, 25),//17
        new Move("Bile Bomb", "Poison", Pokemon.poisonValues, (int)(Math.random() * 3) + 10, 15),//18
        
        new Move("Tunnel", "Ground", Pokemon.groundValues, (int)(Math.random() * 3) + 6, 25),//19
        new Move("Earthquake", "Ground", Pokemon.groundValues, (int)(Math.random() * 3) + 10, 15),//20
        
        new Move("Kinesis", "Psychic", Pokemon.psychicValues, (int)(Math.random() * 3) + 6, 25),//21
        new Move("Mind Bend", "Psychic", Pokemon.psychicValues, (int)(Math.random() * 3) + 10, 15),//22
        
        new Move("Pebble Pelt", "Rock", Pokemon.rockValues, (int)(Math.random() * 3) + 6, 25),//23
        new Move("Boulder Roll", "Rock", Pokemon.rockValues, (int)(Math.random() * 3) + 10, 15),//24
        
        new Move("Snowfall", "Ice", Pokemon.iceValues, (int)(Math.random() * 3) + 6, 25),//25
        new Move("Ice Storm", "Ice", Pokemon.iceValues, (int)(Math.random() * 3) + 10, 15),//26
        
        new Move("Dragon's Tail", "Dragon", Pokemon.dragonValues, (int)(Math.random() * 3) + 6, 25),//27
        new Move("Outrage", "Dragon", Pokemon.dragonValues, (int)(Math.random() * 3) + 10, 15),//28
        
        new Move("Haunt", "Ghost", Pokemon.ghostValues, (int)(Math.random() * 3) + 6, 25),//29
        new Move("Poltergeist", "Ghost", Pokemon.ghostValues, (int)(Math.random() * 3) + 10, 15),//30
        
        new Move("Shadow Shock", "Dark", Pokemon.darkValues, (int)(Math.random() * 3) + 6, 25),//31
        new Move("Blackout", "Dark", Pokemon.darkValues, (int)(Math.random() * 3) + 10, 15),//32
        
        new Move("Rebar Shot", "Steel", Pokemon.steelValues, (int)(Math.random() * 3) + 6, 25),//33
        new Move("Piston Pummel", "Steel", Pokemon.steelValues, (int)(Math.random() * 3) + 10, 15),//34
        
        new Move("Pixie Dust", "Fairy", Pokemon.fairyValues, (int)(Math.random() * 3) + 6, 25),//35
        new Move("Love Beam", "Fairy", Pokemon.fairyValues, (int)(Math.random() * 3) + 10, 15),//36
        
        new Move("Fire Kick", "Fire", Pokemon.fireValues, (int)(Math.random() * 3) + 10, 15)//37
    };
    public static Move get(int i)
    {
        return moves[i];
    }
}

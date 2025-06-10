
/**
 * Write a description of class PokemonList here.
 *
 * @author (Quinton McCollum)
 * @version (v1.0)
 */
import java.util.ArrayList;
import java.util.Arrays;
public class PokemonList
{
    private static Pokemon[] pkmn = {
        //TODO
        /*
         * None!
         */
        
        
        //Done
        /*
         * Normal
         * Fire
         * Grass
         * Water
         * Fighting
         * Flying
         * Poison
         * Electric
         * Ground
         * Psychic
         * Rock
         * Ice
         * Bug
         * Dragon
         * Ghost
         * Dark
         * Steel
         * Fairy
         */
        
        //normals
        new Pokemon("Ratatta", "Normal", fillMoves(0,1), 72, 20, 10, 2, false),//0
        new Pokemon("Pidgey", "Flying", fillMoves(0,15), 56, 25, 12, 27, false),//1
        new Pokemon("Ratiate", "Normal", fillMoves(0,1,2), 97, 35, 15, -1, true),//2
        new Pokemon("Meowth", "Normal", fillMoves(0,1,2), 90, 25, 12, 29, false),//3
        new Pokemon("Eevee", "Normal", fillMoves(0,1,2), 55, 25, 12, 999, false),//4
        new Pokemon("Bidoof", "Normal", fillMoves(0,1), 31, 20, 10, 30, false),//5
        new Pokemon("Stantler", "Nomal", fillMoves(0,1), 85, 25, 12, 31, false),//6
        
        //fire
        new Pokemon("Flareon", "Fire", fillMoves(1,2,5,6), 65, 35, 16, -1, true),//7
        new Pokemon("Charmander", "Fire", fillMoves(0,5), 65, 25, 12, 9, true),//8
        new Pokemon("Charmeleon", "Fire", fillMoves(0,1,5), 80, 40, 14, 10, true),//9
        new Pokemon("Charizard", "Fire", fillMoves(0,1,5,6), 100, 55, 20, -1, true),//10
        new Pokemon("Scorbunny", "Fire", fillMoves(1,5), 69, 30, 12, 12, true),//11
        new Pokemon("Raboot", "Fire", fillMoves(1,2,5), 94, 40, 14, 13, true),//12
        new Pokemon("Cinderace", "Fire", fillMoves(1,2,5,37), 119, 50, 20, -1, true),//13
        
        //grass
        new Pokemon("Bulbasaur", "Grass", fillMoves(0,13), 45, 25, 12, 15, true),//14
        new Pokemon("Ivysaur", "Grass", fillMoves(0,1,13), 60, 40, 15, 16, true),//15
        new Pokemon("Venusaur", "Grass", fillMoves(0,1,13,14), 80, 55, 18, -1, true),//16
        new Pokemon("Oddish", "Grass", fillMoves(0), 30, 20, 10, 18, true),//17
        new Pokemon("Gloom", "Grass", fillMoves(0,13), 40, 30, 14, 19, true),//18
        new Pokemon("Vileplume", "Grass", fillMoves(0,13,17), 50, 45, 18, -1, true),//19
        new Pokemon("Leafeon", "Grass", fillMoves(0,1,2,14), 65, 35, 16, -1, true),//20
        
        //water
        new Pokemon("Vaporeon", "Water", fillMoves(0,1,2,4), 65, 35, 16, -1, true),//21
        new Pokemon("Squirtle", "Water", fillMoves(0,3), 43, 25, 12, 23, true),//22
        new Pokemon("Wartortle", "Water", fillMoves(0,1,3), 58, 40, 15, 24, true),//23
        new Pokemon("Blastoise", "Water", fillMoves(0,1,3,4), 78, 55, 20, -1, true),//24
        new Pokemon("Tentacool", "Water", fillMoves(0,1,3), 70, 30, 14, 26, true),//25
        new Pokemon("Tentacruel", "Water", fillMoves(0,1,3,4), 100, 45, 18, -1, true),//26
        
        //A couple mostly-normal Pokemon that I should've put at the start, small mistake on my part
        
        new Pokemon("Pidgeotto", "Flying", fillMoves(0,1,15), 71, 35, 16, 28, true),//27
        new Pokemon("Pidgeot", "Flying", fillMoves(0,1,15,16), 101, 50, 18, -1, true),//28
        new Pokemon("Persian", "Normal", fillMoves(0,1,2), 115, 40, 18, -1, true),//29
        new Pokemon("Bibarel", "Normal", fillMoves(0,1,3), 71, 30, 16, -1, true),//30
        new Pokemon("Wyrdeer", "Normal", fillMoves(0,1,21), 85, 40, 18, -1, true),//31
        
        //fighting
        new Pokemon("Machop", "Fighting", fillMoves(0,2), 35, 25, 14, 33, false),//32
        new Pokemon("Machoke", "Fighting", fillMoves(0,2,9), 45, 40, 18, 34, true),//33
        new Pokemon("Machamp", "Fighting", fillMoves(0,2,9,10), 55, 55, 22, -1, true),//34
        new Pokemon("Mankey", "Fighting", fillMoves(0,2), 70, 25, 16, 36, false),//35
        new Pokemon("Primeape", "Fighting", fillMoves(0,2,10), 95, 45, 20, -1, true),//36
        
        //flying
        //Pidgey was mixed in with the other types on accident :(
        new Pokemon("Zubat", "Flying", fillMoves(0,1), 55, 20, 12, 38, false),//37
        new Pokemon("Golbat", "Flying", fillMoves(0,1,15, 16), 90, 40, 18, -1, true),//38
        
        //poison
        new Pokemon("Nidoran", "Poison", fillMoves(1,2), 50, 25, 14, 40, false),//39
        new Pokemon("Nidorino", "Poison", fillMoves(1,2,17), 65, 35, 16, 41, true),//40
        new Pokemon("Nidoking", "Poison", fillMoves(1,2,17,18), 85, 50, 20, -1, true),//41
        new Pokemon("Grimer", "Poison", fillMoves(0,17), 25, 30, 16, 43, false),//42
        new Pokemon("Muk", "Poison", fillMoves(0,17,18), 50, 45, 18, -1, true),//43
        
        //Electric
        new Pokemon("Pikachu", "Electric", fillMoves(1,7), 90, 25, 14, 45, false),//44
        new Pokemon("Raichu", "Electric", fillMoves(1,7,8), 110, 40, 18, -1, true),//45
        new Pokemon("Magnemite", "Electric", fillMoves(2,7), 45, 20, 12, 47, false),//46
        new Pokemon("Magneton", "Electric", fillMoves(2,7,8), 70, 40, 18, -1, true),//47
        
        //Ground
        new Pokemon("Diglett", "Ground", fillMoves(0,19), 95, 20, 12, 49, false),//48
        new Pokemon("Dugtrio", "Ground", fillMoves(0,19,20), 120, 45, 20, -1, true),//49
        new Pokemon("Cubone", "Ground", fillMoves(1,2), 35, 25, 14, 51, false),//50
        new Pokemon("Marowak", "Ground", fillMoves(1,2,20), 45, 40, 18, -1, true),//51
        
        //Psychic
        new Pokemon("Abra", "Psychic", fillMoves(0,1), 90, 25, 14, 53, false),//52
        new Pokemon("Kadabra", "Psychic", fillMoves(0,1,21), 105, 40, 18, 54, true),//53
        new Pokemon("Alakazam", "Psychic", fillMoves(0,1,21,22), 120, 55, 22, -1, false),//54
        new Pokemon("Slowpoke", "Psychic", fillMoves(1,21), 15, 30, 16, 56, false),//55
        new Pokemon("Slowbro", "Psychic", fillMoves(1,21,22), 30, 45, 20, -1, true),//56
        
        //Rock
        new Pokemon("Geodude", "Rock", fillMoves(1,9), 20, 30, 16, 58, false),//57
        new Pokemon("Graveler", "Rock", fillMoves(1,9,23), 35, 45, 20, 59, true),//58
        new Pokemon("Golem", "Rock", fillMoves(1,9,23,24), 45, 55, 24, -1, true),//59
        new Pokemon("Onix", "Rock", fillMoves(0,1,23,24), 70, 50, 22, -1, false),//60
        
        //UGH I forgot an eeveelution, and it would be more work to fix the list and put it with Electric types
        new Pokemon("Jolteon", "Electric", fillMoves(0,1,2,8), 130, 35, 16, -1, true),//61
        
        //Ice
        new Pokemon("Glaceon", "Ice", fillMoves(0,1,2,26), 65, 35, 16, -1, true),//62
        new Pokemon("Jynx", "Ice", fillMoves(0,1,21,25), 95, 40, 18, -1, false),//63
        new Pokemon("Snorunt", "Ice", fillMoves(1,2,21), 50, 25, 14, 65, false),//64
        new Pokemon("Glalie", "Ice", fillMoves(1,2,21,25), 80, 40, 18, -1, true),//65
        
        //Bug
        new Pokemon("Weedle", "Bug", fillMoves(0,1), 50, 20, 10, 67, false),//66
        new Pokemon("Kakuna", "Bug", fillMoves(0,1,11), 35, 35, 16, 68, true),//67
        new Pokemon("Beedrill", "Bug", fillMoves(0,1,11,12), 75, 50, 20, -1, true),//68
        new Pokemon("Paras", "Bug", fillMoves(0,1,11), 25, 25, 14, 70, false),//69
        new Pokemon("Parasect", "Bug", fillMoves(0,1,11,12), 30, 40, 16, -1, true),//70
        
        //i forgot yet another eeveelution :(
        new Pokemon("Espeon", "Psychic", fillMoves(0,1,2,22), 110, 35, 16, -1, true),//71
        
        //Dragon
        //Only 1 evolution I can do
        new Pokemon("Dratini", "Dragon", fillMoves(0,1), 50, 30, 14, 73, false),//72
        new Pokemon("Dragonair", "Dragon", fillMoves(0,1,27), 70, 45, 18, 74, true),//73
        new Pokemon("Dragonite", "Dragon", fillMoves(0,1,27,28), 80, 55, 22, -1, true),//74
        
        //Ghost
        new Pokemon("Ghastly", "Ghost", fillMoves(0,29), 80, 25, 12, 76, false),//75
        new Pokemon("Haunter", "Ghost", fillMoves(0,1,29), 95, 35, 16, 77, true),//76
        new Pokemon("Gengar", "Ghost", fillMoves(0,1,29,30), 110, 50, 20, -1, true),//77
        new Pokemon("Misdreavus", "Ghost", fillMoves(0,1,29), 85, 30, 16, 79, false),//78
        new Pokemon("Mismagius", "Ghost", fillMoves(0,1,29,30), 105, 45, 18, -1, true),//79
        
        //Dark
        new Pokemon("Umbreon", "Dark", fillMoves(0,1,2,32), 65, 35, 16, -1, true),//80
        new Pokemon("Houndour", "Dark", fillMoves(1,2,31), 65, 35, 16, 82, false),//81
        new Pokemon("Houndoom", "Dark", fillMoves(1,2,31,32), 95, 45, 18, -1, true),//82
        new Pokemon("Sneasel", "Dark", fillMoves(0,9), 115, 35, 14, 84, false),//83
        new Pokemon("Weavile", "Dark", fillMoves(0,9,32), 125, 45, 18, -1, true),//84
        
        //Steel
        new Pokemon("Beldum", "Steel", fillMoves(0,33), 30, 30, 14, 86, false),//85
        new Pokemon("Metang", "Steel", fillMoves(0,33,21), 50, 40, 18, 87, true),//86
        new Pokemon("Metagross", "Steel", fillMoves(0,33,21,34), 70, 55, 24, -1, true),//87
        new Pokemon("Bronzor", "Steel", fillMoves(0,2,33), 25, 25, 12, 89, false),//88
        new Pokemon("Bronzong", "Steel", fillMoves(0,2,33,34), 35, 40, 16, -1, true),//89
        
        //Fairy
        new Pokemon("Ralts", "Fairy", fillMoves(0,35), 40, 30, 16, 91, false),//90
        new Pokemon("Kirlia", "Fairy", fillMoves(0,2,35), 55, 45, 18, 92, true),//91
        new Pokemon("Gardevoir", "Fairy", fillMoves(0,2,35,36), 80, 55, 22, -1, true),//92
        new Pokemon("Clefairy", "Fairy", fillMoves(0,1,35), 35, 25, 12, 94, false),//93
        new Pokemon("Clefable", "Fairy", fillMoves(0,1,35,36), 60, 40, 16, -1, true),//94
        
        new Pokemon("Mewtwo", "Psychic", fillMoves(21,22,10,28), 180, 60, 28, -1, false)//95
        
        //END :D
    };
        
    public static Pokemon get(int i)
    {
        return pkmn[i];
    }
    public static ArrayList<Move> fillMoves(int i)
    {
        return new ArrayList<Move>(Arrays.asList(new Move(MoveList.get(i))));
    }
    public static ArrayList<Move> fillMoves(int i, int j)
    {
        return new ArrayList<Move>(Arrays.asList(new Move(MoveList.get(i)), new Move(MoveList.get(j))));
    }
    public static ArrayList<Move> fillMoves(int i, int j, int k)
    {
        return new ArrayList<Move>(Arrays.asList(new Move(MoveList.get(i)), new Move(MoveList.get(j)), new Move(MoveList.get(k))));
    }
    public static ArrayList<Move> fillMoves(int i, int j, int k, int l)
    {
        return new ArrayList<Move>(Arrays.asList(new Move(MoveList.get(i)), new Move(MoveList.get(j)), new Move(MoveList.get(k)), new Move(MoveList.get(l))));
    }
}

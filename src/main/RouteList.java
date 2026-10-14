
/**
 * Write a description of class RouteList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Arrays;
public class RouteList
{
    private static Route[] routes = 
    {
        new Route(fillPk(new int[]{0,0 , 1,0 , 3,0 , 4,0 , 5,0 , 6,0}), fillTr(new int[]{0,1,2,3,4,5}), new Trainer(TrainerList.get(6))),//0
        new Route(fillPk(new int[]{17,1 , 11,1 , 6,1 , 32,1 , 48,1, 50,1}), fillTr(new int[]{7,8,9,10,11,12}), new Trainer(TrainerList.get(13))),//1
        new Route(fillPk(new int[]{52,2 , 55,2 , 46,2 , 44,2 , 35,2 , 90,2}), fillTr(new int[]{14,15,16,17,18,19}), new Trainer(TrainerList.get(20))),//2
        new Route(fillPk(new int[]{64,3 , 75,3 , 81,3 , 83,3 , 85,3 , 88,3}), fillTr(new int[]{21,22,23,24,25,26}), new Trainer(TrainerList.get(27))),//3
        new Route(fillPk(new int[]{93,4 , 25,4 , 37,4 , 39,4 , 42,4 , 60,4}), fillTr(new int[]{28,29,30,31,32,33}), new Trainer(TrainerList.get(34)))//4
    };
    
    public static Route get(int i)
    {
        return routes[i];
    }
    
    private static ArrayList<Pokemon> fillPk(int[] ls)
    {
        ArrayList<Pokemon> res = new ArrayList<Pokemon>();
        for(int i = 0; i < ls.length-2; i += 2)
        {
            res.add(new Pokemon(PokemonList.get(ls[i]), ls[i+1]));
        }
        return res;
    }
    private static ArrayList<Trainer> fillTr(int[] ls)
    {
        ArrayList<Trainer> res = new ArrayList<Trainer>();
        for(int i : ls)
        {
            res.add(new Trainer(TrainerList.get(i)));
        }
        return res;
    }
}

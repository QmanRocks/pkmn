
/**
 * Write a description of class Pokemon here.
 *
 * @author (Quinton McCollum)
 * @version (v1.0)
 */
import java.util.ArrayList;
import java.util.Arrays;
public class Pokemon
{
    public final static int[] eeveelutions = {7, 20, 21, 61, 62, 71, 80};
    
    public final static String[] normalValues = {"Rock0.5", "Ghost0", "Steel0.5"};
    public final static String[] fireValues = {"Fire0.5", "Water0.5", "Grass2", "Ice2", "Bug2", "Rock0.5", "Dragon0.5", "Steel2"};
    public final static String[] waterValues = {"Fire2", "Water0.5", "Grass0.5", "Ground2", "Rock2", "Dragon0.5"};
    public final static String[] electricValues = {"Water2", "Electric0.5", "Ground0", "Flying2", "Dragon0.5"};
    public final static String[] grassValues = {"Fire0.5", "Water2", "Grass0.5", "Poison0.5", "Ground2", "Flying0.5", "Bug0.5", "Rock2", "Dragon0.5", "Steel0.5"};
    public final static String[] iceValues = {"Fire0.5", "Water0.5", "Grass2", "Ice0.5", "Ground2", "Flying2", "Dragon2", "Steel0.5"};
    public final static String[] fightingValues = {"Normal2", "Ice2", "Poison0.5", "Flying0.5", "Psychic0.5", "Bug0.5", "Rock2", "Ghost0", "Dark2", "Steel2", "Fairy0.5"};
    public final static String[] poisonValues = {"Grass2", "Poison0.5", "Rock0.5", "Ghost0.5", "Steel0", "Fairy2"};
    public final static String[] groundValues = {"Fire2", "Electric2", "Grass0.5", "Poison2", "Flying0", "Bug0.5", "Rock2", "Steel2"};
    public final static String[] flyingValues = {"Electric0.5", "Grass2", "Fighting2", "Bug2", "Rock0.5", "Steel0.5"};
    public final static String[] psychicValues = {"Fighting2", "Poison2", "Psychic0.5", "Dark0", "Steel0.5"};
    public final static String[] bugValues = {"Fire0.5", "Grass2", "Fighting0.5", "Poison0.5", "Flying0.5", "Psychic2", "Ghost0.5", "Dark2", "Steel0.5", "Fairy0.5"};
    public final static String[] rockValues = {"Fire2", "Ice2", "Fighting0.5", "Ground0.5", "Flying2", "Bug2", "Steel0.5"};
    public final static String[] ghostValues = {"Normal0", "Psychic2", "Ghost2", "Dark0.5"};
    public final static String[] dragonValues = {"Dragon2", "Steel0.5", "Fairy0"};
    public final static String[] darkValues = {"Fighting0.5", "Psychic2", "Ghost2", "Dark0.5", "Fairy0.5"};
    public final static String[] steelValues = {"Fire0.5", "Water0.5", "Electric0.5", "Ice2", "Rock2", "Steel0.5", "Fairy2"};
    public final static String[] fairyValues = {"Fire0.5", "Fighting2", "Poison0.5", "Dragon2", "Dark2", "Steel0.5"};
    
    private String name;
    private String type;
    private ArrayList<Move> moves;
    private double speed;
    private int hitPoints;
    private boolean awake;
    private int xpGive;
    private int xp;
    private int level;
    private int maxHP;
    private int evolveIndex;
    private boolean isEvo;
    
    public Pokemon(String n, String t, ArrayList<Move> mv, double s, int hp, int xg, int ei, boolean is)
    {
        name = n;
        type = t;
        moves = mv;
        speed = s;
        hitPoints = hp;
        xpGive = xg;
        evolveIndex = ei;
        awake = true;
        xp = 0;
        level = 0;
        maxHP = hp;
        isEvo = is;
    }
    
    public Pokemon(Pokemon p)
    {
        name = new String(p.getName());
        type = new String(p.getType());
        moves = new ArrayList<Move>();
        for(Move m : p.getMoves())
        {
            moves.add(new Move(m));
        }
        speed = p.getSpeed();
        hitPoints = p.getHP();
        xpGive = p.getXPGive();
        evolveIndex = p.getEvIndex();
        isEvo = p.isEvolution();
        awake = true;
        xp = 0;
        level = p.getLevel();
        maxHP = p.getMaxHP();
    }
    
    public Pokemon(Pokemon p, int l)
    {
        name = new String(p.getName());
        type = new String(p.getType());
        moves = new ArrayList<Move>();
        for(Move m : p.getMoves())
        {
            moves.add(new Move(m));
        }
        speed = p.getSpeed();
        hitPoints = p.getHP() + l;
        xpGive = p.getXPGive() + (2*l);
        evolveIndex = p.getEvIndex();
        isEvo = p.isEvolution();
        awake = true;
        xp = 0;
        level = l;
        maxHP = p.getMaxHP() + l;
    }
    
    public String getName()
    {
        return name;
    }
    public String getType()
    {
        return type;
    }
    public ArrayList<Move> getMoves()
    {
        return moves;
    }
    public int getHP()
    {
        return hitPoints;
    }
    public double getSpeed()
    {
        return speed;
    }
    public boolean isAwake()
    {
        return awake;
    }
    public int getXPGive()
    {
        return xpGive;
    }
    public int getXP()
    {
        return xp;
    }
    public int getMaxHP()
    {
        return maxHP;
    }
    public int getLevel()
    {
        return level;
    }
    public int getEvIndex()
    {
        return evolveIndex;
    }
    public boolean isEvolution()
    {
        return isEvo;
    }
    
    public void setName(String n)
    {
        name = n;
    }
    public void setType(String t)
    {
        type = t;
    }
    public void setHP(int hp)
    {
        hitPoints = hp;
    }
    public void setSpeed(double sp)
    {
        speed = sp;
    }
    public void setAwake(boolean aw)
    {
        awake = aw;
    }
    public void setXP(int x)
    {
        xp = x;
    }
    public void setLevel(int l)
    {
        level = l;
    }
    public void setIsEvo(boolean is)
    {
        isEvo = is;
    }
    
    public int heal(int i)
    {
        int healAmount = Math.min(i, maxHP - hitPoints);
        hitPoints += healAmount;
        return healAmount;
    }
    
    public void addXP(int x)
    {
        xp += x;
        boolean lvUp = false;
        while(xp >= level*5)
        {
            lvUp = true;
            Game.wait(1000);
            xp -= level*5;
            
            hitPoints++;
            maxHP++;
            level++;
            
            if( evolveIndex > -1 )
            {
                if((level >= 10 && (!isEvo)) || (level >= 20 && isEvo))
                {
                    Game.evolve(this);
                    return;
                }            
            }
            
            System.out.println(name + " leveled up! Now level "+level+".");
            
        }
        Game.wait(1000);
        
        System.out.print(name + " gained ");
        if(lvUp)
            System.out.print(xp + " extra");
        else
            System.out.print(x);
        System.out.println(" XP");
        Game.wait(1000);
    }
    
    public String toString()
    {
        return name + ", HP: " + hitPoints + "/" + maxHP;
    }
    
    public Pokemon hurt(int damage)
    {
        hitPoints -= damage;
        if(hitPoints <= 0)
        {
            hitPoints = 0;
            awake = false;
            return this;
        }
        return null;
    }
    
    public void attack(int i, Pokemon p)
    {
        Move m = moves.get(i);
        if((Math.random() < .05))
        {
            System.out.println(this.getName() + " used "+m.getName()+", but it missed!");
        }
        else
        {
            double factor = 1;
            m.use();
            for(String t : m.getTypeValues())
            {
                if(t.indexOf(p.getType()) != -1 && factor == 1)
                {
                    factor = Double.parseDouble(t.substring(p.getType().length()));
                }
            }
            int damage = (int)((m.getDamage() + level)* factor);
            p.hurt(damage);
            System.out.print(this.getName() + " used " + m.getName() + "! Did " + damage + " damage. ");
            if(factor > 1)
            {
                System.out.print("It's super effective!");
            }
            else if(factor < 1)
            {
                System.out.print("It's not very effective...");
            }
            System.out.println();
        }
    }
    
    public int getBestMove(Pokemon p)
    {
        int i = 0;
        int count = 0;
        int maxDam = 0;
        boolean change = false;
        for(Move m : moves)
        {
            for(String t : m.getTypeValues())
            {
                if(t.indexOf(p.getType()) != 1)
                {
                    if(m.getDamage() > maxDam)
                    {
                        i = count;
                        change = true;
                    }
                }
            }
            count++;
        }
        if(!change)
        {
            return (int)(Math.random() * moves.size());
        }
        return i;
    }
}

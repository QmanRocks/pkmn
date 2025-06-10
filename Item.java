
/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{
    private int type;
    
    private final String[] names = {"Potion", "Revive", "Pokeball", "Super Potion"};
    private final String[] descs = {"Heals up to 20 HP of the selected Pokemon.",
                                    "Revives a downed Pokemon with half it's max HP.",
                                    "Tries to capture a wild Pokemon.",
                                    "Heals up to 50 HP of the selected Pokemon."
                                    };
    
    public Item(int i)
    {
        type = i;
    }
    
    public boolean use(Pokemon p)
    {
        //Potion
        if(type == 0)
        {
            int healAmount = p.heal(20);
            System.out.println("Used Potion on "+p.getName()+". Healed "+healAmount+" HP!");
            return true;
        }
        //Super Potion
        if(type == 3)
        {
            int healAmount = p.heal(50);
            System.out.println("Used Super Potion on "+p.getName()+". Healed "+healAmount+" HP!");
        }
        //Revive
        if(type == 1)
        {
            p.setAwake(true);
            p.setHP((int)((p.getMaxHP() / 2.0) +0.5));
            System.out.println("Revived "+p.getName() + "!");
            return true;
        }
        //Pokeball
        if(type == 2)
        {
            System.out.println("Using Pokeball on "+p.getName()+"...");
            Game.wait(1000);
            boolean fail = false;
            for(int i = 0; i < 3 && fail == false; i++)
            {
                if(Math.random() > 8.0/p.getHP())
                {
                    fail = true;
                }
                System.out.println("Blip...");
                Game.wait(1500);
            }
            if(fail)
            {
                System.out.println("They broke out!");
                return false;
            }
            else
            {
                System.out.println("Click! Caught "+p.getName()+"!");
                return true;
            }
        }
        return false;
    }
    
    public int getType()
    {
        return type;
    }
    public String getName()
    {
        return names[type];
    }
    public String getDesc()
    {
        return descs[type];
    }
}


/**
 * Write a description of class Move here.
 *
 * @author (Quinton McCollum)
 * @version (v1.0)
 */
public class Move
{
    private String name;
    private String type;
    private String[] typeValues;
    private int damage;
    private int uses;
    
    private int maxUses;
    
    public Move(String n, String t, String[] tv, int d, int u)
    {
        name = n;
        type = t;
        typeValues = tv;
        damage = d;
        uses = u;
        
        maxUses = u;
    }
    
    public Move(Move m)
    {
        name = new String(m.getName());
        type = new String(m.getType());
        typeValues = m.getTypeValues();
        damage = m.getDamage();
        uses = m.getUses();
        
        maxUses = m.getMaxUses();
    }
    
    public String getName()
    {
        return name;
    }
    public String getType()
    {
        return type;
    }
    public String[] getTypeValues()
    {
        return typeValues;
    }
    public int getDamage()
    {
        return damage;
    }
    public int getUses()
    {
        return uses;
    }
    public int getMaxUses()
    {
        return maxUses;
    }
    public void setUses(int u)
    {
        uses = u;
    }
    
    public void use()
    {
        this.uses--;
    }
    
    public void resetUses()
    {
        uses = maxUses;
    }
    
    public String toString()
    {
        return name + " \t" + type + " \t" + uses;
    }
}

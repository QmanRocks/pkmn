
/**
 * Write a description of class Game here.
 *
 * @author (Quinton McCollum)
 * @version (v1.0)
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class Game
{
    public static final Scanner console = new Scanner(System.in);
    public static Player player = new Player("Player", new ArrayList<Pokemon>(), new ArrayList<Item>());
    public static int route = 0;
    public static int maxRoute = 0;
    
    //Sets up the required variables, and calls the gameplay method in the end.
    public static void main(String[] args)
    {
        System.out.println("\t\t\tWelcome to the world of");
        displayTitle();
        
        System.out.println("1)Play\n2)Quit");
        int pq = retryInput(1,2);
        if(pq == 2)
        {
            clear();
            System.out.print("Goodbye!");
            return;
        }
        
        clear();
        System.out.print("What is your name?\nType: ");
        player.setName(console.next());
        clear();
        
        pickStarter();
        clear();
        
        System.out.println("To help you start, we're giving you");
        System.out.println("2 Pokeballs and 2 Potions");
        
        player.addItem(new Item(0));
        player.addItem(new Item(0));
        player.addItem(new Item(2));
        player.addItem(new Item(2));
        
        wait(2000);
        
        gameplay();
    }
    
    /**#
     * Battle: Takes the player and either a wild Pokemon or a Trainer, lets the player choose the next courses of action, then returns the winner of the battle.
     * @param p Player, gets and changes player information, and uses the player's first Pokemon
     * @param  op Pokemon, only passed if it's a wild Pokemon battle, null otherwise
     * @param t Trainer, only passed if it's a trainer battle, null otherwise
     * @return WinCondition, returns true if the player wins, else returns false.
     */
    public static boolean battle(Player p, Pokemon op, Trainer t)
    {
        //active pokemon is always first in the party
        Pokemon pl = p.getPokemon().get(0);
        
        //used for fleeing, must be init at start
        int escAtt = 0;
        
        //opponent's pokemon is again always first in the party
        if(t != null)
        {
            System.out.println(t.getName() + ": " + t.getMessage());
            wait(2000);
            op = t.getPokemon().get(0);
        }
        
        //Fighting
        while(pl.isAwake() && op.isAwake())
        {
            clearBattle(pl, op, t != null);
            System.out.println("What would you like to do?");
            System.out.println("(1)Move\n(2)Item\n(3)Switch\n(4)Flee");
            int choice = retryInput(1, 4);
            
            clearBattle(pl, op, t != null);
            
            //Creating the choices outside the if-statement, therefore they can be used outside of it
            int moveChoice = -1;
            int opIndex = (int)(Math.random() * op.getMoves().size());
            
            //if high enough level, it knows which move is best to use
            if(op.getLevel() >= 5)
            {
                opIndex = op.getBestMove(pl);
            }
            else
            {
                opIndex = (int)(Math.random()*op.getMoves().size());
            }
            
            //Move
            if(choice == 1)
            {
                //resets after the player's pokemon attacks
                escAtt = 0;
                
                System.out.println("Choose a move (type number): ");
                System.out.println("Name \t\tType");
                int count = 0;
                for(Move m : pl.getMoves())
                {
                    count++;
                    System.out.println(count + ") " + m);
                    
                }
                moveChoice = retryInput(1, count)-1;
                
                //Special case
                while(pl.getMoves().get(moveChoice).getUses() == 0)
                {
                    System.out.print("Error processing input, try again: ");
                    moveChoice = retryInput(0, pl.getMoves().size()-1)-1;
                }
            }
            
            //Item
            if(choice == 2)
            {
                clearBattle(pl, op, t != null);
                if(p.getBackpack().size() == 0)
                {
                    System.out.println("You have no items to use!");
                }
                else
                {
                    System.out.println("Choose an item:");
                    int count = 0;
                    for(Item i : p.getBackpack())
                    {
                        count++;
                        System.out.println(count + ")" + i.getName());
                        
                    }
                    int iChoice = retryInput(1, count)-1;

                    Item i = p.getBackpack().get(iChoice);
                    clearBattle(pl, op, t != null);
                    if(i.getType() == 0 || i.getType() == 3)
                    {
                        //Potions
                        System.out.println("Choose a Pokemon to heal: ");
                        int pCount = 0;
                        for(Pokemon pk : p.getPokemon())
                        {
                            pCount++;
                            System.out.println(pCount + ") " + pk);
                            
                        }
                        int pChoice = retryInput(1, pCount)-1;
                        
                        clearBattle(pl, op, t != null);
                        i.use(p.getPokemon().get(pChoice));
                        p.removeItem(iChoice);
                    }
                    //End Potions
                    else if(i.getType() == 1)
                    {
                        //Revive
                        System.out.println("Choose a Pokemon to Revive: ");
                        int pCount = 0;
                        for(Pokemon pk : p.getKOPokemon())
                        {
                            pCount++;
                            System.out.println(pCount + ")" + pk);
                        }
                        int pChoice = retryInput(1, pCount)-1;
                        
                        clearBattle(pl, op, t != null);
                        i.use(p.getKOPokemon().get(pChoice));
                        p.revPokemon(p.getKOPokemon().get(pChoice));
                        p.removeItem(iChoice);
                    }
                    //End Revive
                    else
                    {
                        //Pokeball
                        clearBattle(pl, op, t != null);
                        if(t != null)
                        {
                            System.out.println("You can't use a Pokeball\nin a Trainer Battle!");
                        }
                        else if(p.getPokemon().size() + p.getKOPokemon().size() >= 6)
                        {
                            System.out.println("Your party is full!");
                        }
                        else
                        {
                            player.removeItem(iChoice);
                            boolean caught = i.use(op);
                            if(caught)
                            {
                                Pokemon newP = new Pokemon(op);
                                op.setAwake(false);
                                nick(newP);
                                p.addPokemon(newP);
                            }
                        }
                        //End Pokeball
                    }
                }
                wait(1000);
            }
            //End Item
            
            //Switch
            if(choice == 3)
            {
                clearBattle(pl, op, t != null);
                if(p.getPokemon().size() <= 1)
                {
                    System.out.println("You have no Pokemon to switch in!");
                }
                else
                {
                    int curInd = p.getPokemon().indexOf(pl);
                    System.out.println("Choose a Pokemon to take "+pl.getName()+"'s place!");
                    int count = 0;
                    for(Pokemon pk : p.getPokemon())
                    {
                        count++;
                        if(count - 1 == curInd)
                            System.out.print("Current: ");
                        
                        System.out.println(count + ")" + pk);
                        
                    }
                    int newChoice = retryInput(1, p.getPokemon().size(), curInd+1)-1;
                    
                    System.out.println("Take a break, "+pl.getName()+"!");
                    pl = p.getPokemon().get(newChoice);
                    wait(1000);
                    System.out.println("Go, "+pl.getName()+"!");
                }
                wait(1000);
            }
            //End Switch
            
            //Flee
            if(choice == 4)
            {
                //Very annoying and complicated math based off gen I & II escape mechanics :/
                if(t == null)
                {
                    int escapeOdds = (int) Math.abs((pl.getSpeed() * 32) / (Math.abs((int)(op.getSpeed()/4)%256 + 1))) + (30 * escAtt);
                    int random = (int)(Math.random()*256);
                    if(escapeOdds > 255 || random < escapeOdds)
                    {
                        System.out.println("Fled successfully!");
                        wait(1000);
                        return true;
                    }
                    else
                    {
                        System.out.println("Couldn't get away!");
                        escAtt++;
                    }
                }
                else
                {
                    System.out.println("Can't flee a trainer battle!");
                }
                wait(1000);
            }
            //End flee
            
            //Move Handling
            if(op.isAwake())
            {
                if(moveChoice == -1)
                {
                    op.attack(opIndex, pl);
                    wait(1000);
                }
                else
                {
                    double plSpeed = pl.getSpeed();
                    double opSpeed = op.getSpeed();
                    
                    if(moveChoice != -1 && pl.getMoves().get(moveChoice).getName().equals("Quick Attack"))
                    {
                        plSpeed = 999;
                    }
                    if(op.getMoves().get(opIndex).getName().equals("Quick Attack"))
                    {
                        opSpeed = 998;
                    }
                    
                    if(plSpeed > opSpeed)
                    {
                        pl.attack(moveChoice, op);
                        if(op.isAwake())
                        {
                            wait(1000);
                            op.attack(opIndex, pl);
                        }
                    }
                    else
                    {
                        op.attack(opIndex, pl);
                        if(pl.isAwake())
                        {
                            wait(1000);
                            pl.attack(moveChoice, op);
                        }
                    }
                }
            }
            
            if(!pl.isAwake())
            {
                p.koPokemon(pl);
            }
            if(!op.isAwake() && t != null)
            {
                t.koPokemon(op);
            }
            
            wait(1000);
            clearBattle(pl, op, t != null);
            
            if(!pl.isAwake() && p.getPokemon().size() > 0)
            {
                System.out.println("Choose a Pokemon to take "+pl.getName()+"'s place!");
                int count = 0;
                for(Pokemon pk : p.getPokemon())
                {
                    count++;
                    System.out.println(count + ")" + pk);
                    
                }
                int newChoice = retryInput(1, p.getPokemon().size())-1;
                
                pl = p.getPokemon().get(newChoice);
            }
            
            if(!op.isAwake() && t != null && t.getPokemon().size() > 0)
            {
                op = t.getPokemon().get(0);
                System.out.println(t.getName() + " is sending out "+op.getName() + "!");
                wait(2000);
            }
        }
        //End Fighting
        
        
        if(pl.isAwake())
        {
            System.out.println("You Won!");
            wait(1000);
            
            if(t != null)
            {
                int totalX = 0;
                for(Pokemon pok : t.getKOPokemon())
                {
                    totalX += pok.getXPGive();
                }
                pl.addXP(totalX);
                
                clear();
                System.out.println(t.getName() + ": Aw, I lost.");
                wait(1500);
                player.addMoney(t.getReward());
                wait(1500);
            }
            else
            {
                pl.addXP(op.getXPGive());
            }
            
            return true;
        }
        else
        {
            System.out.println("You Lost.");
            return false;
        }
    }
    
    /**
     * Wait: takes a ms input, then waits that long
     * @param ms The millisecond value of how long to wait
     */
    public static void wait(int ms)
    {
        try {
          Thread.sleep(ms);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
    }
    /**
     * retryInput: takes the min and max input values, and only returns a user input between them.
     * @param min Int, the minimum input value
     * @param max Int, the maximum input value
     * @return choice Int, the input value from the user, loops until the input is between min and max
     */
    public static int retryInput(int min, int max)
    {
        int choice = console.nextInt();
        while(choice < min || choice > max)
        {
            System.out.print("Error processing input, try again: ");
            choice = console.nextInt();
        }
        return choice;
    }
    /**
     * retryInput: same as other, but doesn't allow the excluded int value to be entered.
     * @param min Int, min value
     * @param max Int, max value
     * @param ex Int, the input value that will be rejected
     * @return choice Int, input from the user between min and max, excludes ex
     */
    public static int retryInput(int min, int max, int ex)
    {
        int choice = console.nextInt();
        while(choice < min || choice > max || choice == ex)
        {
            System.out.print("Error processing input, try again: ");
            choice = console.nextInt();
        }
        return choice;
    }
    /**
     * retryInput: only allows "Y" or "N" to be entered, lower or upper-case
     * @return yn String, will only be "Y" or "N"
     */
    public static String retryInput()
    {
        String yn = console.next().toUpperCase();
        while(!(yn.equals("Y") || yn.equals("N")))
        {
            System.out.print("Error processing input, try again: ");
        }
        return yn;
    }
    /**
     * clearBattle: clears the screen, but puts you and the opponent's info on the top
     * @param p1 Pokemon, the Player's info
     * @param p2 Pokemon, the Opponent's info, either wild or trainer
     */
    public static void clearBattle(Pokemon p1, Pokemon p2, boolean trainer)
    {
        System.out.print("\033[H\033[2J");;
        System.out.println("You: "+p1);
        if(trainer)
            System.out.print("Opponent: ");
        else
            System.out.print("Wild Pokemon: ");
        System.out.println(p2);
    }
    /**
     * clear: clears the screen
     */
    public static void clear()
    {
        System.out.print("\033[H\033[2J");;
    }
    
    /**
     * displayTitle: displays the title in ASCII-art form
     */
    public static void displayTitle()
    {
        //Simply moving this to a new method in order to clean up main method
        System.out.println("                                  ,'\\");
        System.out.println("    _.----.        ____         ,'  _\\");
        System.out.println("_,-'       `.     |    |  /`.   \\,-'    |   \\  /   |   |    \\  |`.");
        System.out.println("\\      __    \\    '-.  | /   `.  ___    |    \\/    |   '-.   \\ |  |");
        System.out.println(" \\.    \\ \\   |  __  |  |/    ,','_  `.  |          | __  |    \\|  |");
        System.out.println("   \\    \\/   /,' _`.|      ,' / / / /   |          ,' _`.|     |  |");
        System.out.println("    \\     ,-'/  /   \\    ,'   | \\/ / ,`.|         /  /   \\  |     |");
        System.out.println("     \\    \\ |   \\_/  |   `-.  \\    `'  /|  |    ||   \\_/  | |\\    |");
        System.out.println("      \\    \\ \\      /       `-.`.___,-' |  |\\  /| \\      /  | |   |");
        System.out.println("       \\    \\ `.__,'|  |`-._    `|      |__| \\/ |  `.__,'|  | |   |");
        System.out.println("        \\_.-'       |__|    `-._ |              '-.|     '-.| |   |");
        System.out.println("                                `'                            '-._|");
    }
    
    /**
     * pickStarter: lets the player pick a starter, between Bulbasaur, Squirtle, and Charmander
     */
    public static void pickStarter()
    {
        boolean picked = false;
        while(!picked)
        {
            Pokemon[] ops = {null, new Pokemon(PokemonList.get(14)), new Pokemon(PokemonList.get(22)), new Pokemon(PokemonList.get(8))};
            System.out.println("Pick your starting Pokemon.\nThis will be your new buddy from Day 1!\n");
            System.out.println("1) Bulbasaur");
            System.out.println("2) Squirtle");
            System.out.println("3) Charmander\n");
            System.out.println("Choose one to learn more about it: ");
            int choice = retryInput(1, 3);
            if(choice == 1)
            {
                System.out.print("\033[H\033[2J");;
                System.out.println("Bulbasaur, a Grass Pokemon.\nStrong against Water, Ground, and Rock");
            }
            if(choice == 2)
            {
                System.out.print("\033[H\033[2J");;
                System.out.println("Squirtle, a Water Pokemon.\nStrong against Fire, Ground, and Rock");
            }
            if(choice == 3)
            {
                System.out.print("\033[H\033[2J");;
                System.out.println("Charmander, a Fire Pokemon.\nStrong against Grass, Bug, Ice, and Steel");
            }
            System.out.println("Choose this Pokemon?\n(Y)/(N)");
            String yn = retryInput();
            clear();
            if(yn.equals("Y"))
            {
                picked = true;
                System.out.println("You picked "+ops[choice].getName()+"!");
                nick(ops[choice]);
                player.addPokemon(ops[choice]);
            }
        }
    }
    
    /**
     * nick: lets the player nickname the given Pokemon
     * @param p Pokemon, the pokemon that will receive the nickname
     */
    public static void nick(Pokemon p)
    {
        System.out.println("Give it a new name? \n(Y)/(N)");
        String yn = retryInput();
        if(yn.equals("Y"))
        {
            System.out.println("Enter the new name for your "+p.getName()+": ");
            System.out.println("CANNOT INCLUDE SPACES");
            String name = console.next();
            while(name.length() == 0)
            {
                System.out.print("Error processing input, try again: ");
                name = console.next();
            }
            p.setName(name);
        }
    }
    
    public static void evolve(Pokemon p)
    {
        int newPInd = 0;
        
        //Special case for Eevee, as it has several different possible evolutions
        if(p.getEvIndex() == 999)
        {
            newPInd = Pokemon.eeveelutions[(int)(Math.random()*Pokemon.eeveelutions.length)];
        }
        else
        {
            newPInd = p.getEvIndex();
        }
        
        Pokemon newP = new Pokemon(PokemonList.get(newPInd), p.getLevel());
        System.out.println("Hm? "+p.getName()+" is evolving!");
        wait(1000);
        for(int i = 0; i < 2; i++)
        {
            System.out.println("...");
            wait(1000);
        }
        System.out.println(p.getName() + " evolved into "+newP.getName()+"!");
        
        nick(newP);

        player.setPokemon(player.getPokemon().indexOf(p), newP);
        clear();
    }
    
    public static void gameplay()
    {
        int choice = 0;
        boolean playing = true;
        boolean won = true;
        
        while(playing)
        {
            clear();
            System.out.println(player);
            System.out.println("Route "+(route+1));
            System.out.println("What would you like to do now?\n");
            System.out.println("1)Venture into the wild\n");
            System.out.println("2)Buy items in the PokeMart\n");
            System.out.println("3)Heal Pokemon at the Pokemon Center\n");
            if(route == maxRoute)
                System.out.println("4)Challenge the Gym Leader\n");
            else
                System.out.println("4)Go to next route\n");
            System.out.println("5)Change Party Order\n");
            System.out.println("6)Release a Pokemon back into the wild\n");
            if(route > 0)
                System.out.println("7)Go back to previous route\n");
            System.out.println("0)Quit");
            if(route > 0)
                choice = retryInput(0,7);
            else
                choice = retryInput(0,6);
            
            while(choice == 0)
            {
                System.out.println("Are you sure you want to quit? Your progress will NOT be saved.\n(Y)/(N)");
                String quitChoice = retryInput();
                if(quitChoice.equals("Y"))
                {
                    System.out.println("Goodbye!");
                    return;
                }
                else
                {
                    choice = -1;
                }
            }
            if(choice == 1)
            {
                clear();
                if(Math.random() > .5)
                {
                    won = battle(player, null, RouteList.get(route).randomTrainer());
                }
                else
                {
                    won = battle(player, RouteList.get(route).randomPokemon(), null);
                }
                if(!won)
                {
                    System.out.println(player.getName() + " ran to the nearest Pokemon Center and...");
                    wait(1500);
                    healPokemon();
                    System.out.println("Make sure you manage your Pokemon's HP well\nwith Potions and Super Potions.");
                    wait(2000);
                }
            }
            if(choice == 2)
            {
                buyItems();
            }
            if(choice == 3)
            {
                healPokemon();
            }
            if(choice == 4)
            {
                if(route == maxRoute)
                {
                    clear();
                    won = battle(player, null, RouteList.get(route).getGymLeader());
                    if(won)
                    {
                        if(RouteList.get(route).getGymLeader().getName().indexOf("Grand") != -1)
                        {
                            System.out.println("Congratulations! You beat the Grand Champion!\nYou are the new Champion!");
                            playing = false;
                        }
                        else
                        {
                            route++;
                            maxRoute++;
                            System.out.println("You beat the Gym Leader and moved onto the next route!");
                            wait(2000);
                        }
                    }
                    else
                    {
                        System.out.println(player.getName() + " ran to the nearest Pokemon Center and...");
                        wait(1500);
                        healPokemon();
                        System.out.println("Make sure you manage your Pokemon's HP well\nwith Potions and Super Potions.");
                        wait(2000);
                    }
                }
                else
                {
                    route++;
                    System.out.println("Moving to next route...");
                    wait(1000);
                    clear();
                }
            }
            if(choice == 5)
            {
                if(player.getPokemon().size() == 1)
                {
                    System.out.println("You don't have enough Pokemon for that!");
                    wait(1500);
                }
                else
                {
                    changeOrder();
                }
            }
            if(choice == 6)
            {
                release();
            }
            if(choice == 7)
            {
                System.out.println("Going back...");
                route--;
                wait(1000);
                clear();
            }
        }
    }
    
    public static void buyItems()
    {
        int choice = -1;
        while(choice != 0)
        {
            clear();
            System.out.println(player);
            System.out.println("Welcome to the PokeMart! Here's what we have for sale:");
            System.out.println("1) Potion: "+new Item(0).getDesc()+ " $5");
            System.out.println("2) Revive: "+new Item(1).getDesc()+ " $10");
            System.out.println("3) Pokeball: "+new Item(2).getDesc()+ " $5");
            System.out.println("4) Super Potion: "+new Item(3).getDesc()+ " $15");
            System.out.println("0) Back");
            
            choice = retryInput(0,4);
            if(choice != 0)
            {
                Item toGive = new Item(choice-1);
                if(player.getMoney() >= toGive.getCost())
                {
                    player.spendMoney(toGive.getCost());
                    player.addItem(toGive);
                    System.out.println("Bought "+toGive.getName() + "!");
                }
                else
                {
                    System.out.println("You don't have enough money!");
                }
                wait(1000);
            }
        }
    }
    
    public static void healPokemon()
    {
        clear();
        System.out.println("Welcome to the Pokemon Center!\nWe'll take your Pokemon for just a second...");
        for(int i = 0; i < 3; i++)
        {
            System.out.println("...");
            wait(1000);
        }
        for(int i = player.getKOPokemon().size()-1; i >= 0; i--)
        {
            player.revPokemon(player.getKOPokemon().get(i));
        }
        for(Pokemon p : player.getPokemon())
        {
            p.heal(p.getMaxHP());
            for(Move m : p.getMoves())
            {
                m.setUses(m.getMaxUses());
            }
        }
        System.out.println("Restored all Pokemon's HP and Moves!");
        wait(1000);
    }
    
    public static void changeOrder()
    {
        //Get Choices
        clear();
        System.out.println("Choose the first Pokemon to switch: ");
        int count = 0;
        for(Pokemon p : player.getPokemon())
        {
            count++;
            System.out.println(count + ")" + p);
            
        }
        int choice1 = retryInput(1,count)-1;
        
        clear();
        System.out.println("Choose the second Pokemon to switch with the first");
        count = 0;
        for(Pokemon p : player.getPokemon())
        {
            count++;
            if(count == choice1+1)
            {
                System.out.print(">");
            }
            System.out.println(count + ")" + p);
            
        }
        int choice2 = retryInput(1,count)-1;
        
        //Switch
        Pokemon temp1 = player.getPokemon().get(choice1);
        player.setPokemon(choice1, player.getPokemon().get(choice2));
        player.setPokemon(choice2, temp1);
        
        clear();
        System.out.println("Successfully switched Pokemon!");
        
        count = 0;
        for(Pokemon p : player.getPokemon())
        {
            count++;
            System.out.println(count + ")" + p);
        }
        wait(1500);
    }
    public static void release()
    {
        clear();
        int choice = -2;
        while(choice < -1)
        {
            int count = 0;
            System.out.println("Choose a Pokemon to release:");
            for(Pokemon p : player.getPokemon())
            {
                count++;
                System.out.println(count + ")" + p);
                
            }
            System.out.println("0)Cancel");
            choice = retryInput(0,count)-1;
            if(choice > 0)
            {
                System.out.println("Are you sure you want to release "+player.getPokemon().get(choice).getName()+"?");
                System.out.println("(Y)/(N)");
                String yn = retryInput();
                if(yn.equals("N"))
                {
                    choice = -2;
                }
                else
                {
                    player.removePokemon(choice);
                    System.out.println("Released the Pokemon. Goodbye "+player.getPokemon().get(choice).getName()+"!");
                }
            }
        }
    }
}

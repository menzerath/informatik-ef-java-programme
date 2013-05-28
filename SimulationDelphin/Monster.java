import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Monster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monster extends MyActor
{
 
    public Monster()
    {
    }

    /**
     * Der Delphin fuehrt eine Aktion aus.
     */
    public void act() 
    {
        bewegen();
        fressen();
    }

    /**
     * Der Delphin bewegt sich. 
     */
    private void bewegen()
    {
        move(20);
        int zufall = Greenfoot.getRandomNumber(5);
        if (zufall == 0){
            int winkel = Greenfoot.getRandomNumber(360);
            setRotation(winkel);
        }
    }

    /**
     * Der Delphin frisst, falls moeglich.
     */
    private void fressen()
    {
        Dolphin dol = (Dolphin)getOneReachableActor(Dolphin.class);
        if (dol != null)
        {
            World w = getWorld();
            w.removeObject(dol);
        }
    }
}

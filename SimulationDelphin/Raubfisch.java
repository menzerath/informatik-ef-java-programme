import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Raubfisch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Raubfisch extends MyActor
{

    private int alter;
    
    public Raubfisch() {
        alter = 0;
    }
    
    public void act()
    {
        bewegen();
        altern();
        fressen();
        vermehren();
        sterben();
    }
    
    private void bewegen() {
        move(20);
        int zufall = Greenfoot.getRandomNumber(5);
        if (zufall == 0){
            int winkel = Greenfoot.getRandomNumber(360);
            setRotation(winkel);
        }
    }
    
    private void altern() {
        alter++;
    }
    
    private void fressen()
    {
        Fish fisch = (Fish)getOneReachableActor(Fish.class);
        if (fisch != null)
        {
            World w = getWorld();
            w.removeObject(fisch);
        }
    }
    
    private void vermehren() {
        int zufall = Greenfoot.getRandomNumber(60);
        if (zufall == 0) {
            World w = getWorld();
            Raubfisch rFisch = new Raubfisch();
            w.addObject(rFisch, getX(), getY());
        }
    }
    
    private void sterben() {
        if (alter >= 100) // wenn Alter auf 100 gestiegen ist, stirbt der Delphin
        {
            World w = getWorld();
            w.removeObject(this);
        }
    }   
}

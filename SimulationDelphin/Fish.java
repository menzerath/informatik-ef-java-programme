import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fish  extends MyActor
{

    private int alter;
    
    public Fish() {
        alter = 0;
    }
    
    public void act()
    {
        bewegen();
        altern();
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
    
    private void vermehren() {
        int zufall = Greenfoot.getRandomNumber(69);
        if (zufall == 0) {
            World w = getWorld();
            Fish fish = new Fish();
            w.addObject(fish, getX(), getY());
        }
    }
    
    private void sterben() {
        if (alter >= 200) // wenn Alter auf 200 gestiegen ist, stirbt der Delphin
        {
            World w = getWorld();
            w.removeObject(this);
        }
    }
}

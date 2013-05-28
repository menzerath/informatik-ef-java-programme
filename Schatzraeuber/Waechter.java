import greenfoot.*;

/**
 * @author Marvin Menzerath und Janick Paulus
 * @version 1.0
 */
public class Waechter extends Person
{
    public void act() 
    {
        bewegen();
        fangen();
    }       

    private void bewegen()
    {
        if(Greenfoot.isKeyDown("d")){
            move('r');
        }
        if(Greenfoot.isKeyDown("a")){
            move('l');
        }
        if(Greenfoot.isKeyDown("w")){
            move('o');
        }
        if(Greenfoot.isKeyDown("s")){
            move('u');
        }
    }

    private void fangen()
    {
        World w = getWorld();
        w.removeObject(getOneIntersectingObject(Abenteurer.class));
    }
}
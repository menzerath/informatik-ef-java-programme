import greenfoot.*;

/**
 * @author Marvin Menzerath und Janick Paulus
 * @version 1.0
 */
public class Abenteurer extends Person
{
    public void act() 
    {
        bewegen();
        einsammeln();
    }    

    private void bewegen()
    {
        if(Greenfoot.isKeyDown("right")){
            move('r');
        }
        if(Greenfoot.isKeyDown("left")){
            move('l');
        }
        if(Greenfoot.isKeyDown("up")){
            move('o');
        }
        if(Greenfoot.isKeyDown("down")){
            move('u');
        }
    }

    private void einsammeln()
    {
        World w = getWorld();
        w.removeObject(getOneIntersectingObject(Schatz.class));
    }
}
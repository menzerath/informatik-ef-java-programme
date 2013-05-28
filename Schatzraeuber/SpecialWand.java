import greenfoot.*;

/**
 * @author Marvin Menzerath und Janick Paulus
 * @version 1.0
 */
public class SpecialWand extends Person
{
    public void act() 
    {
        bewegen();
        fangen();
        zermatschen(); //Janick, ich bitte dich!
    }    
    private void fangen()
    {
        World w = getWorld();
        w.removeObject(getOneIntersectingObject(Waechter.class));
    }
    private void zermatschen()
    {
        World w = getWorld();
        w.removeObject(getOneIntersectingObject(Abenteurer.class));
    }
    private void bewegen()
    {
         int mSp = Greenfoot.getRandomNumber (3);
        if(Greenfoot.isKeyDown("right")){
            if ( mSp == 0) {
                move ('l');
            }
            if ( mSp == 2) {
                move('r');
            }
        }
        if(Greenfoot.isKeyDown("left")){
            if ( mSp == 0) {
                move ('l');
            }
            if ( mSp == 2) {
                move ('r');
            }
        }
        if(Greenfoot.isKeyDown("up")){
            if ( mSp == 0) {
                move ('l');
            }
            if ( mSp == 2) {
                move ('r');
            }
        }
        if(Greenfoot.isKeyDown("down")){
            if ( mSp == 0) {
                move ('l');
            }
            if ( mSp == 2) {
                move ('r');
            }
        }
        if(Greenfoot.isKeyDown("d")){
            if ( mSp == 0) {
                move ('l');
            }
            if ( mSp == 2) {
                move ('r');
            }
        }
        if(Greenfoot.isKeyDown("a")){
            if ( mSp == 0) {
                move ('l');
            }
            if ( mSp == 2) {
                move ('r');
            }
        }
        if(Greenfoot.isKeyDown("w")){
            if ( mSp == 0) {
                move ('l');
            }
            if ( mSp == 2) {
                move ('r');
            }
        }
        if(Greenfoot.isKeyDown("s")){
            if ( mSp == 0) {
                move ('l');
            }
            if ( mSp == 2) {
                move ('r');
            }
        }
    
    }
}
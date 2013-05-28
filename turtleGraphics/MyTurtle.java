import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyTurtle  extends Turtle
{
    /**Im Konstruktor wird der Stift der Schildkröte automatisch 
       heruntergesetzt*/    

    public MyTurtle()
    {
        penDown();    
    }
    /**Die Methode move bewegt die Schildkroete um die   
     *  vorgegebene Distanz d
     */
    public void move(double d)
    {
        super.move(d);
        Greenfoot.delay(1);
    }
    /**Die Methode turn dreht die Schildkroete
     * um den Winkel d
     */
    
    public void turn(double d)
    {
        super.turn(d);
        Greenfoot.delay(1);
    }
}

import greenfoot.*;

/**
 * Ein Delphin.
 * 
 * @author Dr. Oliver Heidb&uuml;chel
 * @version 0.2 - 25.09.2010
 */
public class Dolphin  extends MyActor
{
    private int energie; // energie ist ein Attribut also eine Eigenschaft eines Delphins

    /**
     * Ein neuer Delphin wird erzeugt.
     * 
     * Im Konstruktor steht, was bei der Erzeugung eines Delphins geschieht.
     */
    public Dolphin()
    {
        energie = 75; // Der Delphin startet mit einer Energie von 50.
    }

    /**
     * Der Delphin fuehrt eine Aktion aus.
     */
    public void act() 
    {
        bewegen();
        vermehren();
        fressen();
        sterben();
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
        energie--; // jede Bewegung verringert die Energie um 1
    }

    /**
     * Der Delphin vermehrt sich falls moeglich.
     */
    private void vermehren()
    {
        int zufall = Greenfoot.getRandomNumber(105);
        if (zufall == 0) {
            World w = getWorld();
            Dolphin del = new Dolphin();
            w.addObject(del, getX(), getY());
        }
    }

    /**
     * Der Delphin frisst, falls moeglich.
     */
    private void fressen()
    {
        Fish fisch = (Fish)getOneReachableActor(Fish.class);
        if (fisch != null)
        {
            energie += 20;  // beim Fressen gewinnt der Delphin 20 Energieeinheiten
            World w = getWorld();
            w.removeObject(fisch);
        }
        
        Raubfisch rFisch = (Raubfisch)getOneReachableActor(Raubfisch.class);
        if (rFisch != null)
        {
            energie += 10;  // beim Fressen gewinnt der Delphin 10 Energieeinheiten
            World w = getWorld();
            w.removeObject(rFisch);
        }
    }

    /**
     * Der Delphin stirbt, falls er nicht mehr genug Energie hat.
     */
    private void sterben()
    {
        if (energie <= 0) // wenn die Energie auf 0 gefallen ist, stirbt der Delphin
        {
            World w = getWorld();
            w.removeObject(this);
        }
    }

}

import greenfoot.*;

/**
 * Diese Klasse modelliert eine Person.
 * 
 * @author Dr. Oliver Heidb&uuml;chel
 * @version 0.1 - 29.08.2010
 */
public abstract class Person extends Actor
{
    /**
     * @param richtung 'r' rechts, 
     *                 'l' links, 
     *                 'u' unten,
     *                 'o' oben
     */
    public void move(char richtung){
        int x = getX();
        int y = getY();

        if (richtung == 'r' && getOneObjectAtOffset(1, 0, Wand.class) == null){
            setLocation(x + 1, y);
        } else if (richtung == 'u' && getOneObjectAtOffset(0, 1, Wand.class) == null){
            setLocation(x, y + 1);
        } else if (richtung == 'l' && getOneObjectAtOffset(-1, 0, Wand.class) == null){
            setLocation(x - 1, y);
        } else if (richtung == 'o' && getOneObjectAtOffset(0, -1, Wand.class) == null){
            setLocation(x, y - 1);
        }
    }

}

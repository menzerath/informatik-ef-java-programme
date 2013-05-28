import greenfoot.*;
import java.util.List;
import java.lang.Class;

/**
 * Die KlasseMyWorld ist eine Unterklasse der Klasse World, die 
 * zus&auml;tzlich die M&ouml;glichkeit bietet, die Anzahl der Objekte einer 
 * Klasse zu bestimmen, die sich auf der Welt befinden.
 *
 * @author Dr. Oliver Heidb&uuml;chel - (post@oliver-heidbuechel.de)
 * @version 0.1 - 29.08.2010
 */
public abstract class MyWorld extends World
{

    /**
     * Konstructor fuer Objekte der Klasse Welt.
     * 
     * @param worldWidth die Breite der Welt in Zellen
     * @param worldHeight die H&ouml;he der Welt in Zellen
     * @param die Breite und H&ouml;he einer Zelle in Pixeln
     */
    public MyWorld(int worldWidth, int worldHeight, int cellSize)
    {    
        super(worldWidth, worldHeight, cellSize); 
    }
    
    /**
     * Die Methode z&auml;hlt die Objekte einer Klasse auf der Welt.
     * 
     * @param cls die Klasse, deren Objekte gez&auml;hlt werden sollen
     * @return die Anzahl der entsprechenden Objekte
     */
    public int count(Class cls){
        List list = getObjects(cls);
        int size = list.size();
        return size;
    }
    
    /**
     * Die Methode z&auml;hlt die Objekte einer Klasse in einer Zelle
     * der Welt.
     * 
     * @param x die x-Koordinate der Zelle
     * @param y die y-Koordinate der Zelle
     * @param cls die Klasse, deren Objekte gez&auml;hlt werden sollen
     * @return die Anzahl der entsprechenden Objekte
     */
    public int count(int x, int y, Class cls){
        List list = getObjectsAt(x, y, cls);
        int size = list.size();
        return size;        
    }
}


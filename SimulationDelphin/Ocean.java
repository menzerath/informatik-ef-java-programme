import greenfoot.*;

/**
 * Der Ozean mit Fischen und Delphinen.
 * 
 * @author
 * @version 
 */
public class Ocean extends World
{

    /**
     * KonstruKtor fuer Objekte der Klasse Ozean.
     * 
     */
    public Ocean()
    {    
        super(800, 500, 1);
        bevoelkere();
    }

    /**
     * Der Ozean wird bevoelkert.
     */
    private void bevoelkere()
    {
        for(int i=0; i<5; i++) {
           int x = Greenfoot.getRandomNumber(799); 
           int y = Greenfoot.getRandomNumber(499); 
           Dolphin del = new Dolphin();
           addObject(del, x, y);
        }
        
        for(int i=0; i<10; i++) {
           int x = Greenfoot.getRandomNumber(799); 
           int y = Greenfoot.getRandomNumber(499); 
           Fish fish = new Fish();
           addObject(fish, x, y);
        }
        
        for(int i=0; i<3; i++) {
           int x = Greenfoot.getRandomNumber(799); 
           int y = Greenfoot.getRandomNumber(499); 
           Raubfisch rFisch = new Raubfisch();
           addObject(rFisch, x, y);
        }
        
        int x = Greenfoot.getRandomNumber(799); 
        int y = Greenfoot.getRandomNumber(499); 
        Monster mon = new Monster();
        addObject(mon, x, y);
        
    }    
}

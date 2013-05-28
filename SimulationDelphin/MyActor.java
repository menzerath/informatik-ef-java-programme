import greenfoot.*;

/**
 * Akteure mit etwas mehr Faehigkeiten.
 * 
 * @author Dr. Oliver Heidb&uuml;chel
 * @version 0.1 - 25.09.2010
 */
public abstract class MyActor  extends Actor
{
    /**
     * Der MyActor bewegt sich in die aktuelle Richtung
     * 
     * @param distance Strecke, die er sich bewegt
     */
    public void move(int distance)
    {
        double xx = getX();
        double yy = getY();
        int direction = getRotation();
        
        if (direction < 90){
            double d = Math.toRadians(direction);
            double a = Math.sin(d) * distance;
            double b = Math.cos(d) * distance;
            xx += b;
            yy += a;
        }
        else if (direction < 180){
            double d = Math.toRadians(180 - direction);
            double a = Math.sin(d) * distance;
            double b = Math.cos(d) * distance;
            xx -= b;
            yy += a;
        }
        else if (direction < 270){
            double d = Math.toRadians(direction - 180);
            double a = Math.sin(d) * distance;
            double b = Math.cos(d) * distance;
            xx -= b;
            yy -= a;
        }
        else {
            double d = Math.toRadians(360 - direction);
            double a = Math.sin(d) * distance;
            double b = Math.cos(d) * distance;
            xx += b;
            yy -= a;
        }
        
        setLocation((int)xx, (int)yy);
    }
    
    /**
     * Es wird ein Akteur der angegebenen Klasse zurueckgegeben, 
     * der sich in einem Umkreis mit dem Radius 30 befindet.
     * 
     * @param cls die Klasse
     * @return der Akteur oder null, falls es keinen gibt
     */
    public Actor getOneReachableActor(Class cls)
    {
        java.util.List nachbarn = getObjectsInRange(30, cls);
        if (nachbarn.size() > 0){
            return (Actor)nachbarn.get(0);
        }
        else {
            return null;
        }
    }
}

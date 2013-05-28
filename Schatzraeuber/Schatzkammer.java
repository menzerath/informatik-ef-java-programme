import greenfoot.*;

/**
 * @author Marvin Menzerath und Janick Paulus
 * @version 1.0
 */
public class Schatzkammer extends MyWorld
{

    /**
     * Es wird eine Schatzkammer erzeugt.
     */
    public Schatzkammer()
    {    
        super(19, 19, 30);
        setzeWaechter();
        setzeAbenteurer();
        setzeWaende();
        setzeSchaetze();
    }

    public void act()
    {
        if (count(Schatz.class) < 3){
            Schlussbild sb = new Schlussbild();
            sb.setImage("abenteurerGewinnt.png");
            addObject(sb, 9, 9);
            Greenfoot.stop();
        }

        if (count(Abenteurer.class) == 0){
            Schlussbild sb = new Schlussbild();
            sb.setImage("waechterGewinnt.png");
            addObject(sb, 9, 9);
            Greenfoot.stop();
        }

        if (count(Waechter.class) == 0){
            Schlussbild sb = new Schlussbild();
            sb.setImage("abenteurerGewinnt.png");
            addObject(sb, 9, 9);
            Greenfoot.stop();
        }

    }

    public void setzeWaechter()
    {
        int xW = Greenfoot.getRandomNumber(19);
        Waechter waechter1 = new Waechter();
        addObject(waechter1, xW, 0);
    }

    public void setzeAbenteurer() {
        int xA = Greenfoot.getRandomNumber(19);
        Abenteurer abenteurer1 = new Abenteurer();
        addObject(abenteurer1, xA, 18);
    }

    public void setzeWaende() {
        for(int i=0; i<30; i++){
            int xWa = Greenfoot.getRandomNumber(19);
            int yWa = Greenfoot.getRandomNumber(18);
            if(yWa == 0 || yWa == 9){
                yWa = 1;
            }
            Wand wall = new Wand();
            addObject(wall, xWa, yWa);
        }
            SpecialWand SWand = new SpecialWand();
            addObject(SWand, 9, 9);
    }

    public void setzeSchaetze() {
        for(int i=0; i<30; i++){
            Schatz schatz = new Schatz();
            int xS = Greenfoot.getRandomNumber(19);
            int yS = Greenfoot.getRandomNumber(19);
            if (yS == 9) {
                yS = 1;
            }
            if (count(xS, yS, Wand.class) == 0){
                addObject(schatz, xS, yS);
            }
        }
    }
}
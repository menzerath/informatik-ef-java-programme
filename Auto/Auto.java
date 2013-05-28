/**
 * Das Auto!
 * von Janick und Marvin mit Niklas.
 * © 2012: JanMarNik
 */

public class Auto {

    //Attribute
    private int tempo;
    private int maxTempo;
    private boolean motorAn;
    private boolean lichtAn;
    private int verbrauch;
    private String marke;
    private int schaden;
    private boolean fahrtuechtig;
    
    //Konstruktor
    public Auto(String pMarke, int pMaxTempo, int pVerbrauch) {
        tempo = 0;
        maxTempo = pMaxTempo;
        motorAn = false;
        lichtAn = false;
        verbrauch = pVerbrauch;
        marke = pMarke;
        schaden = 0;
        fahrtuechtig = true;
    }
    
    //Methoden        
    public void motor() {
        if (fahrtuechtig == true) {
            if (motorAn == false) {
                motorAn = true;
            } else {
                tempo = 0;
                motorAn = false;
                lichtAn = false;
            }      
        }
        
    }
    
    public void licht() {
        if (fahrtuechtig == true) {
            if (lichtAn == false) {
                lichtAn = true;
            } else {
                lichtAn = false;
            }
        }
    }
    
    public void beschleunigen(int gz) {
        if (motorAn == true) {
            if ((tempo + gz) < (maxTempo + 1)){
                tempo = tempo + gz;
            }
        }
    }
    
    public void abbremsen(int ga) {
        if (motorAn == true) {
            if (tempo - ga >= 0){
                tempo = tempo - ga;
            }
        }
    }
    
    public void vollBremsen() {
        if (motorAn == true) {
            tempo = 0;
        }
    }

    public int getMaxTempo() {
        return maxTempo;
    }
    
    public int getTempo() {
        return tempo;
    }
    
    public void reh() {
        schaden = schaden + 25;
        if (tempo -25 >=0) {
            tempo = tempo-25;
        } else {
            tempo = 0;
        }   
        System.out.println("Du Mörder!");
        schadenCheck();
    }
    
    public void baum() {
        schaden = schaden + 50;
        if (tempo -200 >=0) {
            tempo = tempo-200;
        } else {
            tempo = 0;
        }
        System.out.println("Rettet die Bäume!");
        schadenCheck();
    }
    
   public void schlucht() {
        schaden = schaden + 100;
        tempo = 0;
        schadenCheck();
   }
    
   public void werkstatt() {
       schaden = 0;
       fahrtuechtig = true;
   }
    
   public void schadenCheck() {
       if (schaden >= 100) {
            schaden = 100;
            fahrtuechtig = false;
            motorAn = false;
            lichtAn = false;
            System.out.println("Du bist tot!");
       }
   }
}
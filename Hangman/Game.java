import java.util.*;
public class Game
{
    private String[] shownString;
    private String theWord;
    private int fehlversuche;
    private int charsInWord;

    public void newGame() {
        fehlversuche = 0;
        Wordlist wl = new Wordlist();
        theWord = wl.getRandomWord();
        charsInWord = theWord.length();
        shownString = new String[charsInWord];
        for(int i = 0; i < charsInWord; i++) {
            shownString[i] = "_";
        }
    }

    public void newConsoleGame() {
        newGame();
        System.out.println("Spiel gestartet!");
        System.out.println(gibOneLineAnzeige());
        System.out.println("Fehlversuche: " + fehlversuche + "/11"); 

        Scanner sc = new Scanner (System.in);
        while (true) {
            if (fehlversuche != 11) {
                String eingabe = sc.next();
                checkChar(eingabe.toUpperCase());
                System.out.println(gibOneLineAnzeige());
                if (checkIfSolved()) {
                    System.out.println("Du hast gewonnen! :)");
                    return;
                }
                System.out.println("Fehlversuche: " + fehlversuche + "/11");
            } else {
                System.out.println("Spiel beendet!");
                return;
            }
        }
    }

    public void checkChar(String buchstabe) {
        boolean vorhanden = false;
        if (buchstabe.length() == 1) {
            for (int i = 0; i < charsInWord; i++) {
                if (theWord.charAt(i) == buchstabe.charAt(0)) {
                    shownString[i] = buchstabe.toUpperCase();
                    vorhanden = true;
                } 
            }
            if (vorhanden == false){
                System.out.println("Leider nein. :p");
                fehlversuche++;
            }
        } else {
            System.out.println("Nur ein Buchstabe, du Mongo! Das gib nen Fehlversuch xD");
            fehlversuche++;
        }
    }
   public void checkCharGui(String buchstabe) {
        boolean vorhanden = false;
        if (buchstabe.length() == 1) {
            for (int i = 0; i < charsInWord; i++) {
                if (theWord.charAt(i) == buchstabe.charAt(0)) {
                    shownString[i] = buchstabe.toUpperCase();
                    vorhanden = true;
                } 
            }
            if (vorhanden == false){
                
                fehlversuche++;
            }
        } else {
            
            fehlversuche++;
        }
      }
    private String gibOneLineAnzeige() {
        String realShow = "";
        for(int k = 0; k < charsInWord; k++) {
            realShow = realShow + shownString[k];
            realShow = realShow + " ";
        }
        return realShow;
    }

    public boolean checkIfSolved() {
        for (int i = 0; i < charsInWord; i++) {
            if (!gibOneLineAnzeige().contains("_")) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    
    public String shownWord() {
        return gibOneLineAnzeige();
    }
    
    public int gibFehler() {
        return fehlversuche;
    }
    
    public String gibTheWord() {
        return theWord;
    }
    
    public void fail() {
        fehlversuche++;
    }
}
import java.util.*;
public class MyArray
{
    int zahlenliste[];

    public MyArray()
    {
        zahlenliste = new int[20];
        neuBelegen();
    }

    public void ausgabe(int von, int bis) {
        if (von >= 0 && von <=18 && bis >= 0 && bis <= 19 && bis > von) {
            for (int i = von; i <= bis; i++) {
                System.out.println(zahlenliste[i]);
            }
        } else {
            System.out.println("Ausgabe nicht erlaubt.");
        }
    }

    public void neuBelegen() {
        Random r = new Random();
        for (int i = 0; i <= 19; i++) {
            zahlenliste[i] = r.nextInt(100);
        }
    }

    public int maxZahl() {
        int maxZahl = 0;
        for (int i = 0; i <= 19; i++) {
            if (maxZahl < zahlenliste[i]) {
                maxZahl = zahlenliste[i];
            }
        }
        System.out.println("Maximaler Wert: " + maxZahl);
        return maxZahl;
    }

    public int mittelwert() {
        int mittelzahl = 0;
        for (int i = 0; i <= 19; i++) {
            mittelzahl = mittelzahl + zahlenliste[i];
        }
        int ergebnis = mittelzahl / 20;
        System.out.println("Mittelwert: " + ergebnis);
        return ergebnis;
    }

    public boolean exists(int zahl) {
        boolean exists = false;
        int pos = 0;
        for (int i = 0; i <= 19; i++) {
            if (zahlenliste[i] == zahl) {
                exists = true;
                pos = i;
            }
        }
        if (exists) {
            System.out.println("Zahl existiert an Position " + pos);
        } else {
            System.out.println("Zahl existiert nicht");
        }
        return exists;
    }

    public int minZahl(int k) {
        int minZahl = 99;
        for ( int c = k; c <= 19; c++) {
            if (minZahl > zahlenliste[c]) {
                minZahl = zahlenliste[c];
            }
        }
        System.out.println("Minimaler Wert: " + minZahl);
        return minZahl;
    }

    public void swapper(int erste, int zweite){
        int l = zahlenliste[erste];
        int y = zahlenliste[zweite];
        zahlenliste[zweite] = l;
        zahlenliste[erste] = y;
    }

    public void selsort() {
        int minzahl = 99;
        int x = 0;
        for (int i = 0; i <= 19; i++) {
            minzahl = 99;
            for (int k = i ; k <= 19; k++) {
                if (minzahl > zahlenliste[k]){
                    minzahl = zahlenliste[k];
                    x = k;
                }
            }
            swapper(i, x);
        }
        ausgabe(0,19);
    }

    public void bubblesort() {
        for (int i = 0; i <= 19; i++){
            for (int k = 0; k < 19; k++) {
                if (zahlenliste[k] > zahlenliste[k+1]){
                    swapper(k,k+1);    
                }
            }
        }
        ausgabe(0,19);
    }
}
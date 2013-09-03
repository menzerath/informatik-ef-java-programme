import java.util.*;

public class MineSweeper {
    private int[] bombenFelder;
    private int bombenVerteilt;
    private boolean gameRunning;
    private boolean[] aufgedeckt;
    private boolean guiGame;
    private GUI gui;

    public MineSweeper() {
        bombenVerteilt = 10;
    }

    public void neuesSpiel() {
        bombenVerteilen();
        aufgedeckt = new boolean[82];
        for (int i = 1; i < 82; i++) {
            aufgedeckt[i] = false;
        }
        guiGame = false;
        gameRunning = true;
        while (gameRunning) {
            Scanner sc = new Scanner(System.in);
            feldGeklickt(sc.nextInt());
        }
    }

    public void neuesSpielGUI(GUI gui) {
        bombenVerteilen();
        aufgedeckt = new boolean[82];
        for (int i = 1; i < 82; i++) {
            aufgedeckt[i] = false;
        }
        guiGame = true;
        this.gui = gui;
        gameRunning = true;
    }

    private void bombenVerteilen () {
        bombenFelder = new int[10];
        for (int i = 0; i < 10;) {
            Random r = new Random();
            int x = r.nextInt(80)+1;
            if (!bombeAufFeld(x)) {
                bombenFelder[i] = x;
                i++;
            }
        }
    }

    public boolean bombeAufFeld(int id) {
        for (int i = 0; i <10; i++) {
            if (bombenFelder[i] == id) {
                return true;
            }
        }
        return false;
    }

    private void feldGewaehlt (int id){
        feldAufgedeckt(id, true);
        if (bombenImUmfeld(id) == 0 && !bombeAufFeld(id)){
            if (id > 1 && !aufgedeckt[id-1] && id%9 != 1){
                feldGewaehlt(id-1);
            }
            if (id > 9){
                if(!aufgedeckt[id-9]){
                    feldGewaehlt(id-9);
                }
                if(id%9!=0){
                    if(!aufgedeckt[id-8]){
                        feldGewaehlt(id-8);
                    }
                }
            }
            if (id > 10){
                if(id%9!=1){
                    if(!aufgedeckt[id-10]){
                        feldGewaehlt(id-10);
                    }
                }
            }
            if (id < 81){
                if(!aufgedeckt[id+1] && id%9 != 0){
                    feldGewaehlt(id+1);
                }
            }
            if (id < 73){
                if(!aufgedeckt[id+9]){
                    feldGewaehlt(id+9);
                }
                if(id%9!=1){
                    if(!aufgedeckt[id+8]){
                        feldGewaehlt(id+8);
                    }
                }
                if (id < 72){
                    if(id%9!=0){
                        if(!aufgedeckt[id+10]){
                            feldGewaehlt(id+10);
                        }
                    }
                }
            }
        }
    }

    public String feldGeklickt(int id) {
        if (!gameRunning) {
            if (!guiGame) {
                System.out.println("Das Spiel wurde bereits beendet oder nie gestartet!");
            }
            return "";
        }
        if (id >= 1 && id <= 81) {
            if(!aufgedeckt[id]){
                if (bombeAufFeld(id)) {
                    gameRunning = false;
                    if (!guiGame) {
                        System.out.println("Du hast eine Bombe getroffen. Trottel.");
                    }
                    return "B";
                } else {
                    feldAufgedeckt(id, false);
                    if (!guiGame) {
                        System.out.println("Bomben im Umfeld: " + bombenImUmfeld(id));
                    }
                    if (bombenImUmfeld(id) == 0) {
                        feldGewaehlt(id);
                    }
                    return Integer.toString(bombenImUmfeld(id));
                }
            } else {
                if (!guiGame) {
                    System.out.println("Dieses Feld wurde bereits aufgedeckt!");
                }
                return "";
            }
        } else {
            if (!guiGame) {
                System.out.println("Nur Zahlen von 1 bis 81 sind zulässig!");
            }
            return "";
        }
    }

    public int bombenImUmfeld(int id) {
        int bombeInNaehe = 0;
        if (id > 1){
            if (bombeAufFeld(id -1) && id%9 != 1) {
                bombeInNaehe++;
            }
        }
        if (id > 9){
            if(bombeAufFeld(id-9)){
                bombeInNaehe++;
            }
            if(bombeAufFeld(id-8) && id %9 !=0) {
                bombeInNaehe++;
            }
        }
        if (id > 10){
            if(bombeAufFeld(id-10) && id%9 != 1) {
                bombeInNaehe++;
            }  
        }
        if (id < 81){
            if (bombeAufFeld(id +1) && id%9 != 0) {
                bombeInNaehe++;
            }
        }
        if (id < 73){
            if (bombeAufFeld(id+9)){
                bombeInNaehe++;
            }
            if (bombeAufFeld(id+8) && id%9 != 1) {
                bombeInNaehe++;
            }
        }
        if (id < 72){
            if (bombeAufFeld(id+10) && id%9 != 0) {
                bombeInNaehe++;
            }  
        }
        return bombeInNaehe;
    }

    private void feldAufgedeckt(int id, boolean guiMelden) {
        aufgedeckt[id] = true;
        if (guiGame && guiMelden) {
            gui.setFeld(id);
        }
    }
}
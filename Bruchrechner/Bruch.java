public class Bruch {
    private int zaehler;
    private int nenner;

    public Bruch(int pZaehler, int pNenner) {
        zaehler = pZaehler;
        nenner = pNenner;
    }

    public Bruch kuerzen() {
        return new Bruch(zaehler/ggt(zaehler,nenner), nenner/ggt(zaehler,nenner));
    }

    private int ggt(int zahl1, int zahl2) {
        while (zahl2 != 0) {
            if (zahl1 > zahl2) {
                zahl1 = zahl1 - zahl2;
            } else {
                zahl2 = zahl2 - zahl1;
            }
        }
        return zahl1;
    }

    public Bruch kehrwert() {
        return new Bruch(nenner, zaehler);
    }

    public Bruch addieren(Bruch pBruch) {
        return new Bruch((zaehler*pBruch.getNenner())+pBruch.getZaehler()*nenner, nenner*pBruch.getNenner());
    }

    public Bruch subtrahieren(Bruch pBruch) {
        return new Bruch((zaehler*pBruch.getNenner())-(pBruch.getZaehler()*nenner), nenner*pBruch.getNenner());
    }

    public Bruch multiplizieren(Bruch pBruch) {
        return new Bruch(zaehler*pBruch.getZaehler(), nenner*pBruch.getNenner());
    }

    public Bruch dividieren(Bruch pBruch) {        
        return multiplizieren(pBruch.kehrwert());
    }

    public int getZaehler() {
        return zaehler;
    }

    public int getNenner() {
        return nenner;
    }
}
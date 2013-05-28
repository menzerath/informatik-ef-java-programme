/**
 * Ein einfaches Bankkonto. Ohne Extra-Gebühren
 * 
 * @author Janick und Marvin
 * @version 1.0
 */
public class Bankkonto
{
    private String kontoInhaber;
    private double kontostand;
    private int kontonummer;
    private String bankName;
    public boolean erlaubeEinziehung;

    public Bankkonto(String pKontoInhaber, int pKontonummer, boolean pErlaubeEinziehung)
    {
        // initialise instance variables
        kontoInhaber = pKontoInhaber;
        kontonummer = pKontonummer;
        kontostand = 0;
        erlaubeEinziehung = pErlaubeEinziehung;
        bankName = "WeGotYaCash";
        System.out.println("Das ist Ihr neues Konto!");
    }

    public void einzahlen (double pBetrag)
    { 
        kontostand = kontostand + pBetrag;
    }

    public void abheben (double pBetrag)
    {
        if (kontostand-pBetrag >=0) {
            kontostand = kontostand - pBetrag;
        } else {
            System.out.println("Ihr Guthaben reicht nicht aus, um diesen Betrag abzuheben!"
                + "\nBitte zahlen Sie mehr Geld ein!");
        }
    }

    public double gibKontostand()
    {
        return kontostand;
    }

    public void überweisen(double pBetrag, Bankkonto pZielkonto, double kontoStand)
    {
        abheben(pBetrag);
        if ( pBetrag <= kontoStand )
        {
            pZielkonto.einzahlen(pBetrag);
        }
    }

    public void einziehen(double pBetrag, Bankkonto pZielkonto)
    {
        if (pZielkonto.erlaubeEinziehung == true){
            pZielkonto.abheben(pBetrag);
            einzahlen(pBetrag);
        } else {
            System.out.println("Das Zielkonto hat diesen Vorgang nicht erlaubt.");
        }
    }

    public void einziehenOnOff()
    {
        if (erlaubeEinziehung == true) {
            erlaubeEinziehung = false;
            System.out.println("Die Einziehung von Ihrem Konto wurde deaktiviert.");
        } else if (erlaubeEinziehung == false) {
            erlaubeEinziehung = true;
            System.out.println("Die Einziehung von Ihrem Konto wurde aktiviert.");
        }
    }
}
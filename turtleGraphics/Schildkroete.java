import greenfoot.*;
import java.lang.Math;

public class Schildkroete extends MyTurtle
{
    public void quadrat(double laenge)
    {
        nEck(4, laenge);
    }

    public void nEck(int ecken, double laenge)
    {
        for (int e = 0; e < ecken; e++)
        {
            move(laenge);
            turn(360/ecken);
        }
    }

    public void kreis(double radius) {
        for (int e = 0; e <= 359; e++)
        {
            double n = ((radius*2*Math.PI)/360);
            move(n);
            turn(1);
        }
    }   
    
    public void richtigerKreis(double r) {
        for (int e = 0; e <= 360; e++) {
            double n = (2*r*Math.tan(1/360*Math.PI));
            move(n);
            turn(1);
        }
    }
    
    public void stern (int laenge){
        for (int i=0; i<6; i++){
            turn(240);
            nEck(3,laenge);
            turn(60);
            move(laenge);
            turn(120);
        }
    }

    public void stern2 (int laenge){
        for (int i=0; i<5; i++){
            move(laenge);
            turn(144);
            move(laenge+(laenge/4*3));
        }
    }

    public void hausVomNikolaus(double laenge) {
        nEck(4, laenge);
        turn(300);
        nEck(3, laenge);
        turn(105);
        move(Math.sqrt((2*(laenge*laenge))));
        turn(135);
        move(laenge);
        turn(135);
        move(Math.sqrt((2*(laenge*laenge))));
        turn(135);
        move(laenge);
        turn(180);
    }

    public void haeuserVN(double laenge, int anzahl, double kleiner) {
        for (int i = 0; i<=anzahl; i++){
            if(laenge>=0){
                hausVomNikolaus(laenge);
                laenge = laenge - kleiner;
                move(laenge);
                turn(90);
            }
        }
    }

    public void spirale(double laenge, double weite, int ringe)
    {
        double z = 0; 
        for (int e = 0; e < ringe; e++)
        {
            move(laenge+z);
            z = weite + z;
            turn(90);
        }
    }

    public void muschel (int weite)
    {
        double a =0.001;
        for(int i=0; i<=weite;i++)
        {
            move(a);
            turn(2+a);
            a = a+0.001;
        }
    }
}
import greenfoot.*;
import java.lang.Math;

public class Schildkroete extends MyTurtle
{
    public void quadrat(double laenge)
    {
        for (int i = 0; i < 4; i++)
        {
            move(laenge);
            turn(90);
        }
    }

    public void pythagorasbaum(double grundlaenge, int n) {
        if (n == 0) {
            quadrat(grundlaenge);
        } else {
            quadrat(grundlaenge);
            move(grundlaenge);
            turn(315);
            double a = (grundlaenge/Math.sqrt(2));
            pythagorasbaum(a,n-1);
            turn(90);
            move(a);
            pythagorasbaum(a,n-1);
            turn(180);
            move(a);
            turn(315);
            move(grundlaenge);
            turn(180);
        }
    }

    public void pythagorasbaumU(double grundlaenge, int n, int winkel) {
        if (n == 0) {
            quadrat(grundlaenge);
        } else {
            quadrat(grundlaenge);
            move(grundlaenge);
            turn(-winkel);
            pythagorasbaumU(Math.cos(winkel*Math.PI/180)*grundlaenge,n-1, winkel);
            turn(90);
            move(Math.cos(winkel*Math.PI/180)*grundlaenge);
            pythagorasbaumU(Math.sin(winkel*Math.PI/180)*grundlaenge,n-1, winkel);
            turn(180);
            move(Math.cos(winkel*Math.PI/180)*grundlaenge);
            turn(-winkel);
            move(Math.cos(winkel*Math.PI/180)*grundlaenge);
            turn(180);
        }
    }

    public void schafgarbe(double grundlaenge, int n) {
        if (n != 0) {
            
        }
    }
    
    public void kochkurve(double grundlaenge, int n)
    {
        if (n == 0) {
            move(grundlaenge);
        } else {
            kochkurve(grundlaenge/3, n-1);
            turn(60);
            kochkurve(grundlaenge/3, n-1);
            turn(240);
            kochkurve(grundlaenge/3, n-1);
            turn(60);
            kochkurve(grundlaenge/3, n-1);
        }
    }

    public void schneeflocke (int ecken,double grundlaenge, int n)
    {
        for (int i = ecken; i >= 0; i--){
            kochkurve(grundlaenge,n);
            turn(360/ecken);
        }
    }

    public void fun() {
        pythagorasbaum(120.0, 7);
    }
}
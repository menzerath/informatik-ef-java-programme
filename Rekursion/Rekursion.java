public class Rekursion
{
    public int rFakultaet(int n)
    {
        if (n == 1) {
            return 1;
        } else {
            return (n*(rFakultaet(n-1)));
        }
    }

    public int iFakultaet(int n) {
        int x = 1;
        for(int i=1; i<=n; i++)
        {
            x = x*i;
        }
        return x;
    }

    public int rFibonacci(int n)
    {   
        if (n==1||n==2){
            return 1;
        } else {
            return (rFibonacci(n-1)+rFibonacci(n-2));
        }

    }

    public int iFibonacci (int n){
        int x = 0;
        int y = 1;
        int w = 0;
        for(int i = n; i>=2; i--)
        {
            w = x + y;
            x = y;
            y = w;
        }
        return w;
    }
    
    public int gibMAX_VALUE() {
        return Integer.MAX_VALUE;
    }
}
public class Array {
    int z[];
    public void init() {
        z = new int[]{1,3,5,7,9};
    }
    
    public void a (){
        init();
        for (int i = 0; i < 5; i++) {
            z[i] = i*i;
        }
        for (int i = 0; i <= 4; i++) {
            System.out.println("a) " + z[i]);
        }
        System.out.println(" ");
    }
    
    public void b (){
        init();
        for (int i = 0; i < 5; i++) {
            z[i] = i+2;
        }
        for (int i = 0; i <= 4; i++) {
            System.out.println("b) " + z[i]);
        }
        System.out.println(" ");
    }
    
    public void c (){
        init();
        for (int i = 0; i < 5; i++) {
            z[i] = z[i]+2;
        }
        for (int i = 0; i <= 4; i++) {
            System.out.println("c) " + z[i]);
        }
        System.out.println(" ");
    }
    
    public void d (){
        init();
        for (int i = 0; i < 5; i++) {
            z[i] = z.length;
        }
        for (int i = 0; i <= 4; i++) {
            System.out.println("d) " + z[i]);
        }
        System.out.println(" ");
    }
    
    public void e (){
        init();
        for (int i = 0; i < 5; i++) {
            z[i] = z[i]*2;
        }
        for (int i = 0; i <= 4; i++) {
            System.out.println("e) " + z[i]);
        }
        System.out.println(" ");
    }
    
    public void f (){
        init();
        for (int i = 0; i < 5; i++) {
            z[i] = z[i] % 3;
        }
        for (int i = 0; i <= 4; i++) {
            System.out.println("f) " + z[i]);
        }
        System.out.println(" ");
    }
    
    public void g (){
        init();
        for (int i = 1; i < 5; i++) {
            z[i] = z[i-1];
        }
        for (int i = 0; i <= 4; i++) {
            System.out.println("g) " + z[i]);
        }
        System.out.println(" ");
    }
    
    public void h (){
        init();
        for (int i = 3; i < 5; i++) {
            z[i] = z[i-1]*i;
        }
        for (int i = 0; i <= 4; i++) {
            System.out.println("h) " + z[i]);
        }
        System.out.println(" ");
    }
    
    public void i (){
        init();
        for (int i = 5; i < 5; i++) {
            z[i] = z[i]*5;
        }
        for (int i = 0; i <= 4; i++) {
            System.out.println("i) " + z[i]);
        }
        System.out.println(" ");
    }
    
    public void all() {
        System.out.println("Und hier kommen unsere tollen Ergebnisse:");
        System.out.println(" ");
        a();
        b();
        c();
        d();
        e();
        f();
        g();
        h();
        i();
        System.out.println("o.O");
    }
}
public class MyString
{
    public MyString()
    {
       
    }

    public String jederZweiteq(String text)
    {
        String ergebnis = "";
        int i = 0;
        while (i< text.length())
        {
            ergebnis =ergebnis + text.charAt(i);
            i = i+2;
        }
        System.out.println(ergebnis);
        return ergebnis;
    }

    public int zaehle(String text, char b)
    {
        int vorkommen = 0;
        int i = 0;
        while (i< text.length())
        {
            if (text.charAt(i) == b) {
                vorkommen++;
            }
            i++;
        }
        System.out.println("Das " + b + " kommt " + vorkommen + "mal vor.");
        return vorkommen;
    }
    
    public String schreibeRueckwaerts(String text)
    {
        String rueckwaerts = "";
        int i = text.length();
        while (i != 0)
        {
            rueckwaerts += text.charAt(i-1);
            i = i - 1;
        }
        System.out.println(rueckwaerts);
        return rueckwaerts;
    }
    
    public String textOhneLeerzeichen(String text)
    {
        text = text.replace(" ", "");
        System.out.println(text);
        return text;
    }
    
        public String textOhneVokale(String text)
    {
        text = text.replace("a", "");
        text = text.replace("e", "");
        text = text.replace("i", "");
        text = text.replace("o", "");
        text = text.replace("u", "");
        text = text.replace("ü", "");
        text = text.replace("ö", "");
        text = text.replace("ä", "");
        text = text.replace("A", "");
        text = text.replace("E", "");
        text = text.replace("I", "");
        text = text.replace("O", "");
        text = text.replace("U", "");
        text = text.replace("Ü", "");
        text = text.replace("Ö", "");
        text = text.replace("Ä", "");
        System.out.println(text);
        return text;
    }
    
        public String Blödsinn (String text)
    {
        String rueckwaerts = "";
        int i = text.length()-1;
        rueckwaerts += text.charAt(0);
        while (i != 1)
        {
            rueckwaerts += text.charAt(i-1);
            i = i - 1;
        }
        rueckwaerts += text.charAt(text.length()-1);
        System.out.println(rueckwaerts);
        return rueckwaerts;
    }
    
    //public String superblödsinn (String text)
    //{
        //String ergebnis ="";
        //String wort ="";
        //int i = 0;
        //for(i<text.length()){
            //if(text.charAt(i) != " "){
                
            //}
        //}
        
        
    //}
}

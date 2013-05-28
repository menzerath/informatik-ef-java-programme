import java.io.*;
import java.util.*;

public class Wordlist
{
    private List<String> content;
    public Wordlist() {
        File file = new File("woerterbuch.txt");
        content = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                content.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Datei \"woerterbuch.txt\" nicht gefunden.");
        }
    }
    
    public String getRandomWord() {
        Random rd = new Random();
        int rN = rd.nextInt(content.size());
        return content.get(rN).toUpperCase();
    }
}

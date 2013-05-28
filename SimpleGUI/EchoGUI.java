import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EchoGUI extends JFrame implements ActionListener// Ein "Fenster" erbt in Java von der Klasse JFrame. Diese 
{                                    // stellt einige Methoden bereit, die bei der Programmierung von 
    // graphischen Benutzeroberflächen sinnvoll sind.

    // 
    /**
     * Der Kontruktor ruft in der ersten Zeile mittles "super..." einen Konstruktor der Oberklasse auf.
     * 
     * Hier findet eine sogenannte "Überladung" des Konstruktors statt: Java erlaubt es allgemein, 
     * mehrere Methoden mit demselben Namen zu bezeichnen, aber in der Parameterliste zu unterscheiden. 
     * Beim Aufruf der Methode erkennt der Compiler die Methode anhand der eingegeben Parameter.
     * 
     * Anschließend wird mit der Methode setSize aus der Klasse 
     * 
     */

    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;

    public EchoGUI()
    {
        super("EchoGUI");
        setSize(375,225);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        label1 = new JLabel ("Eingabe");
        label1.setBounds(47,10,150,30);
        add(label1);

        label2 = new JLabel ("Echo");
        label2.setBounds(212,10,150,30);
        add(label2);

        textField1 = new JTextField();
        textField1.setBounds(47,40,100,20);
        add(textField1);

        textField2 = new JTextField();
        textField2.setBounds(212,40,100,20);
        textField2.setEnabled(false);
        add(textField2);

        button1 = new JButton("Gib' mir ein Echo!");
        button1.setBounds(107,75,150,30);
        button1.addActionListener(this);
        add(button1);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {

            if(textField1.getText().toLowerCase().equals("hallo")){
                textField2.setText("Guten Tag");
            }
            
            else{
                textField2.setText(textField1.getText());
            }
        }
    }
}
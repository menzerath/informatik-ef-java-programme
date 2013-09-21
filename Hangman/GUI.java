import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {

    private Game torsten;
    private JPanel contentPane;
    private JButton buttonNeuesSpiel;
    private JTextField txtBuchstabe;
    private JTextField txtWortLoesen; 
    private JButton buttonWort;
    private JButton buttonBuchstabe;
    private JLabel labelWord;
    private JLabel labelFehlversuche;
    private JLabel labelImg;

    public GUI()
    {
        super("Hangman");
        createGUI();
    }

    private void createGUI() {
        setFont(new Font("Arial", Font.PLAIN, 12));
        setResizable(false);
        setVisible(true);
        setTitle("Hangman - by Janick & Marvin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}
        setBounds(100, 100, 600, 242);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblHangmanBy = new JLabel("Hangman - by Janick & Marvin");
        lblHangmanBy.setFont(new Font("Arial", Font.PLAIN, 18));
        lblHangmanBy.setBounds(10, 11, 244, 22);
        contentPane.add(lblHangmanBy);

        buttonNeuesSpiel = new JButton("Neues Spiel");
        buttonNeuesSpiel.setBounds(278, 12, 124, 23);
        buttonNeuesSpiel.addActionListener(this);
        contentPane.add(buttonNeuesSpiel);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "L\u00F6sen", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(10, 106, 392, 99);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblDeinBuchstabe = new JLabel("Dein Buchstabe:");
        lblDeinBuchstabe.setFont(new Font("Arial", Font.PLAIN, 14));
        lblDeinBuchstabe.setBounds(10, 20, 130, 14);
        panel.add(lblDeinBuchstabe);

        JLabel lblDirektLsen = new JLabel("Direkt L\u00F6sen:");
        lblDirektLsen.setFont(new Font("Arial", Font.PLAIN, 14));
        lblDirektLsen.setBounds(10, 45, 89, 14);
        panel.add(lblDirektLsen);

        txtWortLoesen = new JTextField();
        txtWortLoesen.setEnabled(false);
        txtWortLoesen.setBounds(117, 43, 196, 20);
        panel.add(txtWortLoesen);
        txtWortLoesen.setColumns(10);

        txtBuchstabe = new JTextField();
        txtBuchstabe.setEnabled(false);
        txtBuchstabe.setBounds(293, 18, 20, 20);
        panel.add(txtBuchstabe);
        txtBuchstabe.setColumns(10);

        buttonWort = new JButton("OK");
        buttonWort.setEnabled(false);
        buttonWort.setBounds(326, 41, 54, 23);
        buttonWort.addActionListener(this);
        panel.add(buttonWort);

        buttonBuchstabe = new JButton("OK");
        buttonBuchstabe.setEnabled(false);
        buttonBuchstabe.setBounds(326, 16, 54, 23);
        buttonBuchstabe.addActionListener(this);
        panel.add(buttonBuchstabe);

        labelFehlversuche = new JLabel("Fehlversuche: 0 von 11");
        labelFehlversuche.setBounds(10, 71, 323, 22);
        panel.add(labelFehlversuche);
        labelFehlversuche.setFont(new Font("Arial", Font.PLAIN, 14));

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "Dein Wort", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setBounds(10, 44, 392, 50);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        labelWord = new JLabel("Bitte erst ein Spiel starten");
        labelWord.setHorizontalAlignment(SwingConstants.CENTER);
        labelWord.setFont(new Font("Arial", Font.PLAIN, 16));
        labelWord.setBounds(12, 12, 368, 31);
        panel_1.add(labelWord);

        labelImg = new JLabel("");
        labelImg.setIcon(new ImageIcon("hangman0.PNG"));
        labelImg.setBounds(410, 10, 180, 200);
        contentPane.add(labelImg);
    }

    public void failTheGame () {
        labelWord.setText("Lösung: " + torsten.gibTheWord());
        txtBuchstabe.setText("");
        buttonWort.setEnabled(false);
        buttonBuchstabe.setEnabled(false);
        txtBuchstabe.setEnabled(false);
        txtWortLoesen.setEnabled(false);
        labelFehlversuche.setText("Sie haben verloren." );
    }

    public void winTheGame () {
        labelWord.setText("Lösung: " + torsten.gibTheWord());
        txtBuchstabe.setText("");
        buttonWort.setEnabled(false);
        buttonBuchstabe.setEnabled(false);
        txtBuchstabe.setEnabled(false);
        txtWortLoesen.setEnabled(false);
        labelFehlversuche.setText("Sie haben gewonnen." );
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonNeuesSpiel) {
            buttonWort.setEnabled(true);
            buttonBuchstabe.setEnabled(true);
            txtBuchstabe.setEnabled(true);
            txtWortLoesen.setEnabled(true);
            torsten = new Game();
            torsten.newGame();
            labelFehlversuche.setText("Fehlversuche: 0 von 11");
            labelImg.setIcon(new ImageIcon("hangman0.PNG"));
            labelWord.setText(torsten.shownWord());
        }
        if (e.getSource() == buttonBuchstabe){
            torsten.checkCharGui(txtBuchstabe.getText().toUpperCase());
            labelWord.setText(torsten.shownWord());
            txtBuchstabe.setText("");
            labelFehlversuche.setText("Fehlversuche: " + torsten.gibFehler() + " von 11");
            setImage();
            if (torsten.checkIfSolved() == true) {
                winTheGame();
            }
            if (torsten.gibFehler() >= 11){
                failTheGame();
            }
        }
        if (e.getSource() == buttonWort){
            setImage();
            if( txtWortLoesen.getText().toUpperCase().equals(torsten.gibTheWord())){
                txtWortLoesen.setText("");
                winTheGame();
            }
            else{
                torsten.fail();
                labelFehlversuche.setText("Fehlversuche: " + torsten.gibFehler() + " von 11");
                txtWortLoesen.setText("");
                if (torsten.gibFehler() >= 11){
                    failTheGame();
                }
            }
        }
    }
    
    private void setImage() {
        labelImg.setIcon(new ImageIcon("hangman" + torsten.gibFehler() + ".PNG"));
    }
    public static void main(String[] args)
    {
        GUI gui1 = new GUI();
    }
}

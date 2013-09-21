import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class GUI extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JButton button_newGame;
    private JButton[] feld;
    private MineSweeper sweepie;
    private int bombenMarkiert = 0;
    private int feldMarkiert = 0;
    public GUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}
        setVisible(true);
        setTitle("MineSweeper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 519, 562);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblMinesweeperBy = new JLabel("MineSweeper - by Janick, Marvin & Andre");
        lblMinesweeperBy.setFont(new Font("Arial", Font.PLAIN, 16));
        lblMinesweeperBy.setBounds(10, 11, 290, 19);
        contentPane.add(lblMinesweeperBy);

        button_newGame = new JButton("Neues Spiel");
        button_newGame.addActionListener(this);
        button_newGame.setBounds(408, 11, 89, 23);
        contentPane.add(button_newGame);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Spielfeld", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(15, 41, 482, 478);
        contentPane.add(panel);
        panel.setLayout(null);

        feld = new JButton[82];
        for (int i = 1; i < 10; i++) {
            for (int k = 1; k < 10; k++){
                feld[(i-1)*9+k] = new JButton("");
                feld[(i-1)*9+k].setBounds(21+(k-1)*49, 21+(i-1)*49, 50, 50);
                feld[(i-1)*9+k].setFont(new Font("Arial", Font.BOLD, 18));
                feld[(i-1)*9+k].setEnabled(false);
                feld[(i-1)*9+k].addActionListener(this);
                feld[(i-1)*9+k].addMouseListener(new MouseAdapter() { 
                        public void mouseClicked(MouseEvent e) {
                            if (e.getButton() == 3) {
                                JButton b = (JButton) e.getSource();
                                if (b.isEnabled() && sweepie != null) {
                                    if (b.getText().equals("*")) {
                                        b.setText("");
                                        bombenMarkiert--;
                                        if (sweepie.bombeAufFeld(feldNummer(b))){
                                            feldMarkiert--;
                                        }
                                    } else if (b.getText().equals("") && bombenMarkiert != 10) {
                                        b.setText("*");
                                        bombenMarkiert++;
                                        if (sweepie.bombeAufFeld(feldNummer(b))){
                                            feldMarkiert++;
                                        }
                                    }

                                    if (feldMarkiert == 10) {
                                        for (int i = 1; i < 82; i++){
                                            feld[i].setText("");
                                            feld[i].setEnabled(false);
                                        }
                                        feld[21].setText("B");
                                        feld[22].setText("I");
                                        feld[23].setText("T");
                                        feld[24].setText("C");
                                        feld[25].setText("H");
                                        feld[30].setText("P");
                                        feld[31].setText("L");
                                        feld[32].setText("E");
                                        feld[33].setText("A");
                                        feld[34].setText("S");
                                        feld[35].setText("E");
                                    }
                                }
                            }
                        }
                    });
                panel.add(feld[(i-1)*9+k]);
            }
        }

        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button_newGame) {
            sweepie = new MineSweeper();
            sweepie.neuesSpielGUI(this);
            bombenMarkiert = 0;
            feldMarkiert = 0;

            for (int i = 1; i < 82; i++){
                feld[i].setEnabled(true);
                feld[i].setText("");
            }
        } else {
            JButton b = (JButton) e.getSource();
            if (!b.getText().equals("*")) {
                String meldung = sweepie.feldGeklickt(feldNummer(b));
                if (meldung.equals("B")) {
                    b.setText(meldung);
                    for (int i = 1; i < 82; i++){
                        feld[i].setEnabled(false);
                    }

                    for (int i = 1; i < 82; i++){
                        feld[i].setText("");
                    }
                    feld[19].setText("G");
                    feld[20].setText("A");
                    feld[21].setText("M");
                    feld[22].setText("E");
                    feld[23].setText("");
                    feld[24].setText("O");
                    feld[25].setText("V");
                    feld[26].setText("E");
                    feld[27].setText("R");
                } else {
                    b.setEnabled(false);
                    b.setText(meldung);
                }
            }
        }
    }

    public void setFeld(int id) {
        feld[id].setText(Integer.toString(sweepie.bombenImUmfeld(id)));
        feld[id].setEnabled(false);
    }

    public int feldNummer(JButton b) {
        for (int i = 1; i <= 82; i++) {
            if (feld[i] == b) {
                return i;    
            }
        }
        return 0;
    }
    public static void main(String[] args)
    {
        GUI gui1 = new GUI();
    }
}

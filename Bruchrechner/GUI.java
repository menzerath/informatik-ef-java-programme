import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class GUI extends JFrame implements ActionListener{
    private JPanel contentPane;
    private JTextField b1Z;
    private JTextField b1N;
    private JTextField b2Z;
    private JTextField b2N;
    private JTextField eZ;
    private JTextField eN;
    private JRadioButton opAdd;
    private JRadioButton opSub;
    private JRadioButton opMul;
    private JRadioButton opDiv;
    private JRadioButton opKeh;
    private JButton btnBerechnen;
    private JButton btnKuerzen;

    public GUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}
        setVisible(true);
        setResizable(false);
        setTitle("Bruchrechner - by Janick & Marvin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 567, 306);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblBruchrechnerBy = new JLabel("Bruchrechner - by Janick & Marvin");
        lblBruchrechnerBy.setFont(new Font("Arial", Font.PLAIN, 20));
        lblBruchrechnerBy.setBounds(10, 11, 326, 24);
        contentPane.add(lblBruchrechnerBy);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "1. Bruch", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(10, 46, 120, 155);
        contentPane.add(panel);
        panel.setLayout(null);

        b1Z = new JTextField();
        b1Z.setHorizontalAlignment(SwingConstants.CENTER);
        b1Z.setToolTipText("Z\u00E4hler des 1. Bruches");
        b1Z.setFont(new Font("Arial", Font.PLAIN, 20));
        b1Z.setBounds(10, 21, 100, 50);
        panel.add(b1Z);
        b1Z.setColumns(1);

        JSeparator separator = new JSeparator();
        separator.setBounds(10, 82, 100, 2);
        panel.add(separator);

        b1N = new JTextField();
        b1N.setToolTipText("Nenner des 1. Bruches");
        b1N.setHorizontalAlignment(SwingConstants.CENTER);
        b1N.setFont(new Font("Arial", Font.PLAIN, 20));
        b1N.setColumns(1);
        b1N.setBounds(10, 95, 100, 50);
        panel.add(b1N);

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "2. Bruch", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setBounds(270, 46, 120, 155);
        contentPane.add(panel_1);

        b2Z = new JTextField();
        b2Z.setToolTipText("Z\u00E4hler des 2. Bruches");
        b2Z.setHorizontalAlignment(SwingConstants.CENTER);
        b2Z.setFont(new Font("Arial", Font.PLAIN, 20));
        b2Z.setColumns(1);
        b2Z.setBounds(10, 21, 100, 50);
        panel_1.add(b2Z);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(10, 82, 100, 2);
        panel_1.add(separator_1);

        b2N = new JTextField();
        b2N.setToolTipText("Nenner des 2. Bruches");
        b2N.setHorizontalAlignment(SwingConstants.CENTER);
        b2N.setFont(new Font("Arial", Font.PLAIN, 20));
        b2N.setColumns(1);
        b2N.setBounds(10, 95, 100, 50);
        panel_1.add(b2N);

        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new TitledBorder(null, "Operation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_2.setBounds(140, 46, 120, 155);
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        opAdd = new JRadioButton("Addieren");
        opAdd.setBounds(16, 21, 98, 23);
        panel_2.add(opAdd);

        opSub = new JRadioButton("Subtrahieren");
        opSub.setBounds(16, 47, 98, 23);
        panel_2.add(opSub);

        opMul = new JRadioButton("Multiplizieren");
        opMul.setBounds(16, 73, 98, 23);
        panel_2.add(opMul);

        opDiv = new JRadioButton("Dividieren");
        opDiv.setBounds(16, 99, 98, 23);
        panel_2.add(opDiv);

        opKeh = new JRadioButton("Kehrwert");
        opKeh.setBounds(16, 125, 98, 23);
        panel_2.add(opKeh);

        ButtonGroup group = new ButtonGroup();
        group.add(opAdd);
        group.add(opSub);
        group.add(opMul);
        group.add(opDiv);
        group.add(opKeh);

        JLabel label = new JLabel("=");
        label.setFont(new Font("Arial", Font.PLAIN, 40));
        label.setBounds(400, 121, 23, 14);
        contentPane.add(label);

        JPanel panel_3 = new JPanel();
        panel_3.setLayout(null);
        panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ergebnis", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_3.setBounds(433, 46, 120, 155);
        contentPane.add(panel_3);

        eZ = new JTextField();
        eZ.setEditable(false);
        eZ.setToolTipText("Z\u00E4hler des Ergebnisses");
        eZ.setHorizontalAlignment(SwingConstants.CENTER);
        eZ.setFont(new Font("Arial", Font.PLAIN, 20));
        eZ.setColumns(1);
        eZ.setBounds(10, 21, 100, 50);
        panel_3.add(eZ);

        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(10, 82, 100, 2);
        panel_3.add(separator_2);

        eN = new JTextField();
        eN.setEditable(false);
        eN.setToolTipText("Nenner des Ergebnisses");
        eN.setHorizontalAlignment(SwingConstants.CENTER);
        eN.setFont(new Font("Arial", Font.PLAIN, 20));
        eN.setColumns(1);
        eN.setBounds(10, 95, 100, 50);
        panel_3.add(eN);

        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new TitledBorder(null, "Aktionen", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_4.setBounds(10, 212, 541, 58);
        contentPane.add(panel_4);
        panel_4.setLayout(null);

        btnBerechnen = new JButton("Berechnen");
        btnBerechnen.setBounds(10, 22, 89, 23);
        btnBerechnen.addActionListener(this);
        panel_4.add(btnBerechnen);

        btnKuerzen = new JButton("K\u00FCrzen");
        btnKuerzen.setBounds(442, 22, 89, 23);
        btnKuerzen.addActionListener(this);
        panel_4.add(btnKuerzen);
        
        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBerechnen) {
            calc();
        } else if (e.getSource() == btnKuerzen) {
            int i_eZ = 0;
            int i_eN = 0;
            if (eZ.getText().matches("[0-9]+") && eN.getText().matches("[0-9]+")) {
                i_eZ = Integer.parseInt(eZ.getText());
                i_eN = Integer.parseInt(eN.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Bitte berechnen Sie vor dem Kürzen einen Bruch.", "Kein Bruch vorhanden", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Bruch b1 = new Bruch(i_eZ, i_eN);
            Bruch b2 = b1.kuerzen();

            eZ.setText(String.valueOf(b2.getZaehler()));
            eN.setText(String.valueOf(b2.getNenner()));
        }
    }

    private void calc() {
        int i_b1Z = 0;
        int i_b1N = 0;
        int i_b2Z = 0;
        int i_b2N = 0;
         if (b1Z.getText().matches("[0-9]+") && b1N.getText().matches("[0-9]+") && b2Z.getText().matches("[0-9]+") && b2N.getText().matches("[0-9]+")) {
            i_b1Z = Integer.parseInt(b1Z.getText());
            i_b1N = Integer.parseInt(b1N.getText());
            i_b2Z = Integer.parseInt(b2Z.getText());
            i_b2N = Integer.parseInt(b2N.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Bitte geben Sie nur Zahlenwerte (keine Buchstaben oder Leerzeichen!) ein.", "Ungültige Zeichen", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Bruch b1 = new Bruch(i_b1Z, i_b1N);
        Bruch b2 = new Bruch(i_b2Z, i_b2N);
        Bruch bE = new Bruch(1, 1);
        
        if (opAdd.isSelected()) {
            bE = b1.addieren(b2);
        } else if (opSub.isSelected()) {
            bE = b1.subtrahieren(b2);
        } else if (opMul.isSelected()) {
            bE = b1.multiplizieren(b2);
        } else if (opDiv.isSelected()) {
            bE = b1.dividieren(b2);
        } else if (opKeh.isSelected()) {
            bE = b1.kehrwert();
        } else {
            JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Rechenoperation aus, damit der Vorgang fortgesetzt werden kann.", "Keine Operation gewählt!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        eZ.setText(String.valueOf(bE.getZaehler()));
        eN.setText(String.valueOf(bE.getNenner()));
    }
}
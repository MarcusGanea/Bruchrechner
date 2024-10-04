import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bruchrechner_GUI {
    private JPanel bruchrechnerGUI;
    private JTextField zaehler1TF;
    private JTextField zaehler2TF;
    private JTextField nenner1TF;
    private JTextField nenner2TF;
    private JButton CEBTN;
    private JButton enterBTN;
    private JComboBox<String> operatorCB;
    private JTextField ergebniszTF;
    private JTextField ergebnisnTF;

    public JPanel getBruchrechnerGUI() {
        return bruchrechnerGUI;
    }

    public Bruchrechner_GUI() {

        enterBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int zaehler1 = Integer.parseInt(zaehler1TF.getText());
                    int zaehler2 = Integer.parseInt(zaehler2TF.getText());
                    int nenner1 = Integer.parseInt(nenner1TF.getText());
                    int nenner2 = Integer.parseInt(nenner2TF.getText());

                    Bruch bruch1 = new Bruch(zaehler1, nenner1);
                    Bruch bruch2 = new Bruch(zaehler2, nenner2);

                    String operator = (String) operatorCB.getSelectedItem();
                    Bruch ergebnis = null;

                    switch (operator) {
                        case "+":
                            ergebnis = bruch1.addiere(bruch2);
                            break;
                        case "-":
                            ergebnis = bruch1.subtrahiere(bruch2);
                            break;
                        case "*":
                            ergebnis = bruch1.multipliziere(bruch2);
                            break;
                        case "/":
                            ergebnis = bruch1.dividiere(bruch2);
                            break;
                    }

                    ergebniszTF.setText(String.valueOf(ergebnis.getZaehler()));
                    ergebnisnTF.setText(String.valueOf(ergebnis.getNenner()));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Fehler: " + ex.getMessage());
                }
            }
        });
        CEBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zaehler1TF.setText("");
                zaehler2TF.setText("");
                nenner1TF.setText("");
                nenner2TF.setText("");
                ergebniszTF.setText("");
                ergebnisnTF.setText("");
            }
        });

    }

}
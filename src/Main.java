import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    public static void main(String[] args) {
        Bruchrechner_GUI gui = new Bruchrechner_GUI();
        JFrame frame = new JFrame("Bruchrechner");
        frame.setContentPane(gui.getBruchrechnerGUI());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
package SimpleCalculator;



import javax.swing.*;

public class SimpleCalculator extends JFrame {
    private JButton button1;
    private JTextField textField1;
    private JPanel panel1;

    public static void main(String[] args) {
        SimpleCalculator app = new SimpleCalculator();
        app.setContentPane(app.panel1);
        app.setSize(300, 400);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
        app.setTitle("Simple Calculator");
    }
}


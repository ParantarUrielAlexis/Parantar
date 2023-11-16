package LeapYear;

import javax.swing.*;

public class LeapYear extends JFrame {
    private JButton button1;
    private JTextField textField1;
    private JPanel panel1;

    public static void main(String[] args) {
        LeapYear app = new LeapYear();
        app.setContentPane(app.panel1);
        app.setSize(300, 400);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
        app.setTitle("Leap Year Checker");
    }
}

package LeapYear;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeapYearCheck extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JButton button1;

    public LeapYearCheck() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputYear = textField1.getText();
                try {
                    int year = Integer.parseInt(inputYear);
                    if (isLeapYear(year)) {
                        JOptionPane.showMessageDialog(LeapYearCheck.this, "Leap year");
                    } else {
                        JOptionPane.showMessageDialog(LeapYearCheck.this, "Not a leap year");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(LeapYearCheck.this, "Please enter a valid year.");
                }
            }
        });
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        LeapYearCheck app = new LeapYearCheck();
        app.setContentPane(app.panel1);
        app.setSize(300, 200);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
        app.setTitle("Leap Year Checker");
    }
}

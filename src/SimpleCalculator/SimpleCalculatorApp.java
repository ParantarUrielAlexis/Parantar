package SimpleCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculatorApp {

    private JTextField textField1;
    private JTextField textField2;
    private JComboBox<String> comboBox1;
    private JButton button1;
    private JLabel label1;
    private JLabel label2;
    private JLabel resultLabel;

    public SimpleCalculatorApp() {
        // Initialize components
        textField1 = new JTextField(10);
        textField2 = new JTextField(10);

        String[] operations = {"+", "-", "*", "/"};
        comboBox1 = new JComboBox<>(operations);

        button1 = new JButton("Calculate");
        resultLabel = new JLabel("Result: ");
        label1 = new JLabel("1st Number: ");
        label2 = new JLabel("2nd Number: ");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });

        // Set up the layout
        JPanel panel = new JPanel();
        panel.add(label1);
        panel.add(textField1);
        panel.add(comboBox1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(button1);
        panel.add(resultLabel);

        // Display the frame
        JFrame frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    private void calculate() {
        try {
            double num1 = Double.parseDouble(textField1.getText());
            double num2 = Double.parseDouble(textField2.getText());
            String operation = (String) comboBox1.getSelectedItem();

            int result = 0;

            switch (operation) {
                case "+":
                    result = (int) (num1 + num2);
                    break;
                case "-":
                    result = (int) (num1 - num2);
                    break;
                case "*":
                    result = (int) (num1 * num2);
                    break;
                case "/":
                    if (num2 != 0) {
                        result = (int) (num1 / num2);
                    } else {
                        resultLabel.setText("Result: Cannot divide by zero.");
                        return;
                    }
                    break;
            }

            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Result: Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SimpleCalculatorApp::new);
    }
}

package FoodOrderingSystem;

import javax.swing.*;

public class FoodSystem extends JFrame {
    private JButton button1;
    private JTextField textField1;
    private JPanel panel1;

    public static void main(String[] args) {
        FoodSystem app = new FoodSystem();
        app.setContentPane(app.panel1);
        app.setSize(600, 400);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
        app.setTitle("Food Ordering System");
    }
}

package FoodOrderingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodOrderSystem extends JFrame {

    private JCheckBox pizzaPhp100CheckBox;
    private JCheckBox burgerPhp80CheckBox;
    private JCheckBox friesPhp65CheckBox;
    private JCheckBox teaPhp50CheckBox;
    private JCheckBox sundaePhp40CheckBox;
    private JCheckBox softdrinksPhp55CheckBox;
    private JRadioButton noneRadioButton;
    private JRadioButton a5OffRadioButton;
    private JRadioButton a10OffRadioButton;
    private JRadioButton a15OffRadioButton;
    private JButton orderButton;
    private JLabel selectedFoodLabel;
    private JLabel discountLabel;

    public FoodOrderSystem() {
        // Initialize components
        pizzaPhp100CheckBox = new JCheckBox("Pizza - PHP 100");
        burgerPhp80CheckBox = new JCheckBox("Burger - PHP 80");
        friesPhp65CheckBox = new JCheckBox("Fries - PHP 65");
        teaPhp50CheckBox = new JCheckBox("Tea - PHP 50");
        sundaePhp40CheckBox = new JCheckBox("Sundae - PHP 40");
        softdrinksPhp55CheckBox = new JCheckBox("Soft Drinks - PHP 55");

        noneRadioButton = new JRadioButton("None");
        a5OffRadioButton = new JRadioButton("5% Off");
        a10OffRadioButton = new JRadioButton("10% Off");
        a15OffRadioButton = new JRadioButton("15% Off");

        ButtonGroup discountGroup = new ButtonGroup();
        discountGroup.add(noneRadioButton);
        discountGroup.add(a5OffRadioButton);
        discountGroup.add(a10OffRadioButton);
        discountGroup.add(a15OffRadioButton);

        orderButton = new JButton("Order");
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placeOrder();
            }
        });

        selectedFoodLabel = new JLabel("");
        discountLabel = new JLabel("");

        // Set up the layout
        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("Foods:"));
        panel.add(pizzaPhp100CheckBox);
        panel.add(new JLabel(""));
        panel.add(burgerPhp80CheckBox);
        panel.add(new JLabel(""));
        panel.add(friesPhp65CheckBox);
        panel.add(new JLabel(""));
        panel.add(teaPhp50CheckBox);
        panel.add(new JLabel(""));
        panel.add(sundaePhp40CheckBox);
        panel.add(new JLabel(""));
        panel.add(softdrinksPhp55CheckBox);

        panel.add(new JLabel("Discounts:"));
        panel.add(noneRadioButton);
        panel.add(new JLabel(""));
        panel.add(a5OffRadioButton);
        panel.add(new JLabel(""));
        panel.add(a10OffRadioButton);
        panel.add(new JLabel(""));
        panel.add(a15OffRadioButton);

        panel.add(new JLabel(""));
        panel.add(orderButton);
        panel.add(selectedFoodLabel);
        panel.add(discountLabel);

        // Display the frame
        JFrame frame = new JFrame("Food Ordering System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    private void placeOrder() {
        StringBuilder orderSummary = new StringBuilder();

        int discount = 0;
        if (a5OffRadioButton.isSelected()) {
            discount = 5;
        } else if (a10OffRadioButton.isSelected()) {
            discount = 10;
        } else if (a15OffRadioButton.isSelected()) {
            discount = 15;
        }

        double totalAmount = calculateTotalAmount() - discount;
        orderSummary.append("The total price is Php ").append(totalAmount);

        selectedFoodLabel.setText("");
        discountLabel.setText("Discount: " + discount + "%");

        JOptionPane.showMessageDialog(null, orderSummary.toString(), "Order Placed", JOptionPane.INFORMATION_MESSAGE);
    }

    private double calculateTotalAmount() {
        double totalAmount = 0;

        if (pizzaPhp100CheckBox.isSelected()) {
            totalAmount += 100;
        }
        if (burgerPhp80CheckBox.isSelected()) {
            totalAmount += 80;
        }
        if (friesPhp65CheckBox.isSelected()) {
            totalAmount += 65;
        }
        if (softdrinksPhp55CheckBox.isSelected()) {
            totalAmount += 55;
        }
        if (teaPhp50CheckBox.isSelected()) {
            totalAmount += 50;
        }
        if (sundaePhp40CheckBox.isSelected()) {
            totalAmount += 40;
        }

        return totalAmount;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FoodOrderSystem::new);
    }
}

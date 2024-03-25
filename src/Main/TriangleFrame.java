package Main;

import javax.swing.*;
import java.awt.*;

/**
 * Class for the triangle window.
 */
class TriangleFrame extends JInternalFrame {

    /**
     * Constructor for the triangle window class.
     */
    public TriangleFrame() {
        super("Трикутник", true, true, true, true);


        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Сторона 1:"));
        JTextField side1TextField = new JTextField();
        inputPanel.add(side1TextField);
        inputPanel.add(new JLabel("Сторона 2:"));
        JTextField side2TextField = new JTextField();
        inputPanel.add(side2TextField);
        inputPanel.add(new JLabel("Сторона 3:"));
        JTextField side3TextField = new JTextField();
        inputPanel.add(side3TextField);

        JButton calculateButton = getjButton(side1TextField, side2TextField, side3TextField);


        getContentPane().add(inputPanel, BorderLayout.CENTER);
        getContentPane().add(calculateButton, BorderLayout.SOUTH);

        pack();
    }

    /**
     * Method to get the calculate area button for the triangle.
     *
     * @param side1TextField text field for side 1
     * @param side2TextField text field for side 2
     * @param side3TextField text field for side 3
     * @return the calculate area button for the triangle
     */
    private static JButton getjButton(JTextField side1TextField, JTextField side2TextField, JTextField side3TextField) {
        JButton calculateButton = new JButton("Обчислити площу");
        calculateButton.addActionListener(e -> {
            try {
                double side1 = Double.parseDouble(side1TextField.getText());
                double side2 = Double.parseDouble(side2TextField.getText());
                double side3 = Double.parseDouble(side3TextField.getText());

                double semiperimeter = (side1 + side2 + side3) / 2;
                double area = Math.sqrt(semiperimeter * (semiperimeter - side1) * (semiperimeter - side2) * (semiperimeter - side3));
                if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
                    throw new IllegalArgumentException("Сторона повинна бути більше 0");
                }
                JOptionPane.showMessageDialog(null, "Площа трикутника: " + area);
            } catch (NumberFormatException error) {
                JOptionPane.showMessageDialog(null, "Введіть дійсне число");
            } catch (IllegalArgumentException error) {
                JOptionPane.showMessageDialog(null, error.getMessage());
            }

        });
        return calculateButton;
    }

}

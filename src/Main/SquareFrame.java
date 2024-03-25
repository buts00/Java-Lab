package Main;

import javax.swing.*;
import java.awt.*;

/**
 * Class for the square window.
 */
class SquareFrame extends JInternalFrame {
    /**
     * Constructor for the square window class.
     */
    public SquareFrame() {
        super("Квадрат", true, true, true, true);


        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(new JLabel("Сторона:"));
        JTextField sideTextField = new JTextField(10);
        inputPanel.add(sideTextField);


        JButton calculateButton = getjButton(sideTextField);


        getContentPane().add(inputPanel, BorderLayout.CENTER);
        getContentPane().add(calculateButton, BorderLayout.SOUTH);

        pack();
    }

    /**
     * Method to get the calculate area button for the square.
     *
     * @param sideTextField text field for the side of the square
     * @return the calculate area button for the square
     */
    private static JButton getjButton(JTextField sideTextField) {
        JButton calculateButton = new JButton("Обчислити площу");
        calculateButton.addActionListener(e -> {
            try {
                double side = Double.parseDouble(sideTextField.getText());
                double area = side * side;
                if (side <= 0) {
                    throw new IllegalArgumentException("Сторона повинна бути більше 0");
                }
                JOptionPane.showMessageDialog(null, "Площа квадрата: " + area);
            } catch (NumberFormatException error) {
                JOptionPane.showMessageDialog(null, "Введіть дійсне число");
            } catch (IllegalArgumentException error) {
                JOptionPane.showMessageDialog(null, error.getMessage());
            }

        });
        return calculateButton;
    }
}

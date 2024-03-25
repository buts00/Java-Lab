package Main;

import javax.swing.*;
import java.awt.*;

/**
 * Class for the circle window.
 */
class CircleFrame extends JInternalFrame {

    /**
     * Constructor for the circle window class.
     */
    public CircleFrame() {
        super("Коло", true, true, true, true);


        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(new JLabel("Радіус:"));
        JTextField radiusTextField = new JTextField(10);
        inputPanel.add(radiusTextField);


        JButton calculateButton = new JButton("Обчислити площу");
        calculateButton.addActionListener(e -> {
            try {
                double radius = Double.parseDouble(radiusTextField.getText());
                if (radius <= 0) {
                    throw new IllegalArgumentException("Радіус повинен бути більше 0");
                }

                double area = Math.PI * radius * radius;

                JOptionPane.showMessageDialog(null, "Площа кола: " + area);
            } catch (NumberFormatException error) {
                JOptionPane.showMessageDialog(null, "Введіть дійсне число");
            } catch (IllegalArgumentException error) {
                JOptionPane.showMessageDialog(null, error.getMessage());
            }
        });


        getContentPane().add(inputPanel, BorderLayout.CENTER);
        getContentPane().add(calculateButton, BorderLayout.SOUTH);

        pack();
    }


}

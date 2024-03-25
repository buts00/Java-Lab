package Main;

import javax.swing.*;
import java.awt.*;

/**
 * Frame for displaying information about the author.
 */
class AboutFrame extends JFrame {
    /**
     * Constructs an AboutFrame object.
     */
    public AboutFrame() {
        super("Про автора");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        JLabel authorLabel = new JLabel("Ім'я: Буц Андрій");
        JLabel contactLabel = new JLabel("Контакт: buts.andrii@student.uzhnu.edu.ua");
        getContentPane().add(authorLabel, BorderLayout.CENTER);
        getContentPane().add(contactLabel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }
}

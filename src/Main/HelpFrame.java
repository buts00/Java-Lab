package Main;

import javax.swing.*;
import java.awt.*;

/**
 * Frame for displaying help information about the program.
 */
class HelpFrame extends JFrame {

    /**
     * Constructs a HelpFrame object.
     */
    public HelpFrame() {
        super("Довідка");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        JTextArea helpText = new JTextArea();
        helpText.setText("""
                Довідка по програмі обчислення площі фігур:

                Трикутник: площа = Корінь(p * (p - a) * (p - b) * (p - c)), де
                  a, b, c - сторони трикутника
                  p - півпериметр (сума всіх сторін / 2)

                Квадрат: площа = сторона * сторона

                Коло: площа = PI * радіус * радіус""");
        helpText.setEditable(false);
        getContentPane().add(new JScrollPane(helpText), BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }
}

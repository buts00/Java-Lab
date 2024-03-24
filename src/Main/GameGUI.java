package Main;

import Players.Bot;
import Players.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * Graphical interface for the "Battle Game".
 */
public class GameGUI extends JFrame {
    private JLabel playerHealthLabel;
    private JLabel botHealthLabel;
    private JTextField playerHealthInput;
    private JTextField botHealthInput;
    private JButton startButton;

    private Player player;
    private Bot bot;

    /**
     * Displays the "About" dialog with information about the program and the author.
     */
    private void showAboutDialog() {
        String message = """
                Battle Game

                Ця програма представляє собою просту бойову гру, де гравець і бот атакують один одного,
                зменшуючи здоров'я. Гра триває, доки здоров'я одного з гравців стане менше або рівним нулю.

                Автор: Буц Андрій
                Дата: 24.03.2024
                """;

        JOptionPane.showMessageDialog(this, message, "About", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Constructor for the GameGUI class.
     * Sets the window title, size, minimum and maximum sizes, close operation, and location.
     * Creates the main panel, adds components, and displays the window.
     */
    public GameGUI() {
        setTitle("Battle Game");
        setSize(300, 200);
        setMinimumSize(new Dimension(300, 200));
        setMaximumSize(new Dimension(600, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        showAboutDialog();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        addComponents(panel);

        add(panel, BorderLayout.CENTER);
        addHealthPanel();

        setVisible(true);
    }

    /**
     * Adds components to the specified panel.
     *
     * @param panel The panel to which components will be added.
     */
    private void addComponents(JPanel panel) {
        panel.add(playerHealthInput = createTextField("Enter Player Health"));
        panel.add(botHealthInput = createTextField("Enter Bot Health"));

        startButton = new JButton("Start");
        startButton.addActionListener(e -> {
            if (validateInput()) {
                startGame();
            }
        });
        panel.add(startButton);
    }

    /**
     * Creates a text field with the specified default text.
     *
     * @param defaultText The default text to display in the text field.
     * @return The created text field.
     */
    private JTextField createTextField(String defaultText) {
        JTextField textField = new JTextField(defaultText);
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(defaultText)) {
                    textField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(defaultText);
                }
            }
        });
        return textField;
    }

    /**
     * Adds the health panel to the user interface.
     */
    private void addHealthPanel() {
        JPanel healthPanel = new JPanel();
        healthPanel.setLayout(new GridLayout(2, 2));

        playerHealthLabel = new JLabel("   Player Health:");
        healthPanel.add(playerHealthLabel);

        botHealthLabel = new JLabel("   Bot Health:");
        healthPanel.add(botHealthLabel);

        JButton playerAttackButton = new JButton("Attack Player");
        playerAttackButton.addActionListener(e -> {
            player.takeDamage(1);
            updateHealthLabels();
        });
        healthPanel.add(playerAttackButton);

        JButton botAttackButton = new JButton("Attack Bot");
        botAttackButton.addActionListener(e -> {
            bot.takeDamage(1);
            updateHealthLabels();
        });
        healthPanel.add(botAttackButton);

        add(healthPanel, BorderLayout.SOUTH);
    }

    /**
     * Validates the health input entered in the text field.
     *
     * @param textField The text field containing the health input.
     * @return True if the input is valid, false otherwise.
     */
    private boolean validateHealthInput(JTextField textField) {
        try {
            int health = Integer.parseInt(textField.getText());
            if (health <= 0) {
                JOptionPane.showMessageDialog(this, "Health must be a positive integer.");
                textField.setBorder(BorderFactory.createLineBorder(Color.RED));
                return false;
            }
            textField.setBorder(UIManager.getBorder("TextField.border"));
            return true;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid integer values for health.");
            textField.setBorder(BorderFactory.createLineBorder(Color.RED));
            return false;
        }
    }

    /**
     * Validates the overall input for player and bot health.
     *
     * @return True if both player and bot health inputs are valid, false otherwise.
     */
    private boolean validateInput() {
        boolean fl1 = validateHealthInput(playerHealthInput);
        boolean fl2 = validateHealthInput(botHealthInput);
        return fl1 && fl2;
    }

    /**
     * Starts the game with the specified player and bot health.
     */
    private void startGame() {
        int playerHealth = Integer.parseInt(playerHealthInput.getText());
        int botHealth = Integer.parseInt(botHealthInput.getText());

        player = new Player(playerHealth);
        playerHealthLabel.setText("Player Health: " + playerHealth);

        bot = new Bot(botHealth);
        botHealthLabel.setText("Bot Health: " + botHealth);

        startButton.setEnabled(false);
        playerHealthInput.setEnabled(false);
        botHealthInput.setEnabled(false);
    }

    /**
     * Updates the health labels for player and bot.
     */
    private void updateHealthLabels() {
        playerHealthLabel.setText("Player Health: " + player.getHealth());
        botHealthLabel.setText("Bot Health: " + bot.getHealth());

        if (player.getHealth() <= 0) {
            JOptionPane.showMessageDialog(this, "Game Over! Bot wins.");
            endGame();
        } else if (bot.getHealth() <= 0) {
            JOptionPane.showMessageDialog(this, "Game Over! Player wins.");
            endGame();
        }
    }


    /**
     * Ends the game, enabling input fields and resetting labels.
     */
    private void endGame() {
        startButton.setEnabled(true);
        playerHealthInput.setEnabled(true);
        botHealthInput.setEnabled(true);

        playerHealthInput.setText("Enter Player Health");
        botHealthInput.setText("Enter Bot Health");

        playerHealthLabel.setText("Player Health:");
        botHealthLabel.setText("Bot Health:");
    }

    /**
     * The main method that launches the GameGUI interface.
     *
     * @param args The command line arguments (not used).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameGUI::new);
    }
}

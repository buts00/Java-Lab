/**
 * The Main class is responsible for initializing the game, prompting the user to select weapons and armor for the player and the bot,
 * and managing the game loop where the player and bot take turns attacking or defending.
 */
package Main;

import Players.Bot;
import Players.Player;
import typeOfArmors.Armor;
import typeOfArmors.HeavyArmor;
import typeOfArmors.LightArmor;
import typeOfWeapons.Bow;
import typeOfWeapons.Sword;
import typeOfWeapons.Weapon;

import java.util.Scanner;

public class Main {

    /**
     * The class responsible for tracking and displaying game statistics.
     * This class is a private static inner class of the Main class.
     */
    private static class GameStats {
        public static void display() {
            System.out.println("Виводимо статистику гри...");

        }
    }

    /**
     * The main method of the program where the game is initialized and managed.
     *
     * @param args The command-line arguments passed to the program.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Weapon playerWeapon;
        Armor playerArmor;
        Weapon botWeapon;
        Armor botArmor;

        // Prompt the user to select weapons and armor for both the player and the bot
        do {
            System.out.println("Choose the player's weapon (sword/bow):");
            String playerWeaponChoice = scanner.nextLine();
            if (playerWeaponChoice.equals("sword")) {
                playerWeapon = new Sword();
            } else if (playerWeaponChoice.equals("bow")) {
                playerWeapon = new Bow();
            } else {
                System.out.println("Invalid input. Please enter 'sword' or 'bow'.");
                continue;
            }

            System.out.println("Choose the player's armor (light/heavy):");
            String playerArmorChoice = scanner.nextLine();
            if (playerArmorChoice.equals("light")) {
                playerArmor = new LightArmor();
            } else if (playerArmorChoice.equals("heavy")) {
                playerArmor = new HeavyArmor();
            } else {
                System.out.println("Invalid input. Please enter 'light' or 'heavy'.");
                continue;
            }


            System.out.println("Choose the bot's weapon (sword/bow):");
            String botWeaponChoice = scanner.nextLine();
            if (botWeaponChoice.equals("sword")) {
                botWeapon = new Sword();
            } else if (botWeaponChoice.equals("bow")) {
                botWeapon = new Bow();
            } else {
                System.out.println("Invalid input. Please enter 'sword' or 'bow'.");
                continue;
            }

            System.out.println("Choose the bot's armor (light/heavy):");
            String botArmorChoice = scanner.nextLine();
            if (botArmorChoice.equals("light")) {
                botArmor = new LightArmor();
            } else if (botArmorChoice.equals("heavy")) {
                botArmor = new HeavyArmor();
            } else {
                System.out.println("Invalid input. Please enter 'light' or 'heavy'.");
                continue;
            }
            break;
        } while (true);

        // Initialize the player and the bot with the chosen weapons and armor
        Player player = new Player(playerWeapon, playerArmor);
        Bot bot = new Bot(botWeapon, botArmor);

        // Start the game
        System.out.println("The game has started!");

        // Game loop where the player and the bot take turns attacking or defending
        while (true) {
            System.out.println("Enter a command (attack/defend/exit):");
            String command = scanner.nextLine();

            switch (command) {
                case "attack" -> {
                    player.attack();
                    bot.attack();
                }
                case "defend" -> {
                    player.defend();
                    bot.defend();
                }
                case "exit" -> {
                    class GameOverMessage {
                        void display() {
                            System.out.println("Гра закінчена. Дякую за гру!");
                        }
                    }

                    GameOverMessage message = new GameOverMessage();
                    message.display();
                    GameStats.display();
                    System.exit(0);
                }
                default -> System.out.println("Невідома команда.");
            }
        }
    }
}

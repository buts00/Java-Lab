package Main;

import javax.swing.*;
import java.awt.*;

/**
 * Main class of the program for calculating the area of geometric figures.
 */
public class Main {

    /**
     * Entry point of the program.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        JFrame mainFrame = new JFrame("Обчислення площі геометричних фігур");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JDesktopPane desktopPane = new JDesktopPane();
        mainFrame.getContentPane().add(desktopPane);

        JMenuBar menuBar = new JMenuBar();
        JMenu figuresMenu = new JMenu("Фігури");
        menuBar.add(figuresMenu);

        JMenu helpMenu = new JMenu("Допомога");
        menuBar.add(helpMenu);

        JMenuItem helpMenuItem = new JMenuItem("Довідка");
        helpMenu.add(helpMenuItem);
        helpMenuItem.addActionListener(e -> new HelpFrame().setVisible(true));

        JMenuItem aboutMenuItem = new JMenuItem("Про автора");
        helpMenu.add(aboutMenuItem);
        aboutMenuItem.addActionListener(e -> new AboutFrame().setVisible(true));


        JMenuItem triangleMenuItem = new JMenuItem("Трикутник");
        figuresMenu.add(triangleMenuItem);
        triangleMenuItem.addActionListener(e -> {
            JInternalFrame triangleFrame = new TriangleFrame();
            desktopPane.add(triangleFrame);
            triangleFrame.setVisible(true);
        });

        JMenuItem squareMenuItem = new JMenuItem("Квадрат");
        figuresMenu.add(squareMenuItem);
        squareMenuItem.addActionListener(e -> {
            JInternalFrame squareFrame = new SquareFrame();
            desktopPane.add(squareFrame);
            squareFrame.setVisible(true);
        });

        JMenuItem circleMenuItem = new JMenuItem("Коло");
        figuresMenu.add(circleMenuItem);
        circleMenuItem.addActionListener(e -> {
            JInternalFrame circleFrame = new CircleFrame();
            desktopPane.add(circleFrame);
            circleFrame.setVisible(true);
        });


        mainFrame.setJMenuBar(menuBar);


        mainFrame.setSize(400, 300);
        mainFrame.setMinimumSize(new Dimension(400, 300));
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
}



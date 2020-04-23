package Sierpinsky1;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * Programmet ritar ut Sierpińskis triangel
 */
public class Main {

    private JPanel mainPanel;
    private TriangelPanel triangelPanel;

    private void createUIComponents() {
        //En rityta initieras
        mainPanel = new TriangelPanel();
        triangelPanel = (TriangelPanel) mainPanel;
        //Ett popupfönster frågar användaren hur stor delay det ska vara mellan animationer
        int delay = Integer.parseInt(JOptionPane.showInputDialog(mainPanel, "Ange animationshastighet i ms. Ange 0 för att stänga av animationer", "Animationshastighet", JOptionPane.QUESTION_MESSAGE));
        //Om användaren vill ha delay animeras triangeln
        if (delay > 0) {
            Timer timer = new Timer(delay, e -> {
                //Antalet prickar som ska ritas ut blir större varje steg
                triangelPanel.trianglar.iterations++;
                //Ritytan ritas om
                triangelPanel.repaint();
            });
            timer.start();
            //Annars ritas den ut direkt
        } else {
            //Antalet prickar som ritas ut är satt till max och sedan ritas de ut.
            triangelPanel.trianglar.iterations = 1000000;
            triangelPanel.repaint();
        }
    }

    public static void main(String[] args) {
        //Skapa ditt fönster
        String namn = "Triangel";
        JFrame frame = new JFrame(namn);
        //Tala om att du vill kunna stänga ditt förnster med krysset i högra hörnet
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Ange storleken på ditt fönster och att det ska vara fast
        frame.setSize(500, 600);
        frame.setResizable(false);
        //Positionera ditt fönster i mitten av skärmen
        frame.setLocationRelativeTo(null);

        //Skapa en instans av din den här klassen som hanterar din panel
        Main myForm = new Main();
        //Lägg in din panel i programfönstret
        frame.setContentPane(myForm.mainPanel);
        //Visa programfönstret på skärmen
        frame.setVisible(true);
    }
}

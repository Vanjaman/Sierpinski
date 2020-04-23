package Sierpinsky1;

import java.awt.*;

/**
 * Klassen hanterar ritytan
 */
public class TriangelPanel extends javax.swing.JPanel {
    Trianglar trianglar = new Trianglar();

    @Override
    public void paintComponent(Graphics grafik) {
        super.paintComponent(grafik);
        //Den gråa triangeln ritas ut
        grafik.fillPolygon(trianglar.xBas, trianglar.yBas, 3);
        grafik.setColor(Color.WHITE);
        //Varje punkt ritas ut en i taget
        for (int i = 0; i < (trianglar.iterations + 1); i++) {
            grafik.fillOval((int) trianglar.x[i], (int) trianglar.y[i], 2, 2);
        }
        //Om animationer är på kommer ett streck visa vart de senaste två prickarna befinner sig
        if (trianglar.iterations < 100000) {
            grafik.drawLine((int) trianglar.x[trianglar.iterations], (int) trianglar.y[trianglar.iterations], (int) trianglar.x[trianglar.iterations - 1], (int) trianglar.y[trianglar.iterations - 1]);
        }
    }
}

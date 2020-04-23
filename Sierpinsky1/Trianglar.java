package Sierpinsky1;

import java.util.Random;

/**
 * Klassen skapar koordinater för alla objekt som ritas ut
 */
class Trianglar {
    int[] xBas = new int[3];
    int[] yBas = new int[3];

    int iterations = 1;
    double[] x = new double[10000000];
    double[] y = new double[10000000];

    Trianglar() {
        //Den gråa triangeln i bakgrunden

        int sidlängdBas = 480;
        xBas[1] = xBas[0] + sidlängdBas;
        xBas[2] = (xBas[1] + xBas[0]) / 2;
        yBas[2] = 50;
        int höjdBas = (int) (sidlängdBas * Math.sqrt(3) / 2);
        yBas[0] = yBas[2] + höjdBas;
        yBas[1] = yBas[0];

        //Här skapar jag en tärning och sätter koordinaterna för den första punkten som ett av hörnen i bastriangeln
        Random r = new Random();
        x[0] = xBas[2];
        y[0] = yBas[2];
        //Här skapas ett stort antal punkter där en tärning beskriver åt vilket hörn nästa punkt ska röra sig
        for (int j = 1; j < 1000000; j++) {
            int tärningskast = r.nextInt(3);
            if (tärningskast == 0) {
                x[j] = x[j - 1] / 2.0;
                y[j] = (yBas[0] + y[j - 1]) / 2.0;
            } else if (tärningskast == 1) {
                x[j] = (xBas[1] + x[j - 1]) / 2.0;
                y[j] = (yBas[1] + y[j - 1]) / 2.0;
            } else {
                x[j] = (xBas[2] + x[j - 1]) / 2.0;
                y[j] = (yBas[2] + y[j - 1]) / 2.0;
            }
        }
    }
}

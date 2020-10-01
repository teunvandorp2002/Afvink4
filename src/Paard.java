/*
 * Paard class
 *
 * @author Martijn van der Bruggen
 * (c) Hogeschool van Arnhem en Nijmegen
 * @version alpha release
 */

import java.awt.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Paard {

    private int x, paardNummer; //te lezen als x en y positie
    private static int aantal = 0;  //totaal aantal paarden
    private String naam;  //naam van het paard
    private Color kleur;  //kleur van de streep/paard
    private Image plaatje;
    //Random random = new Random();



    /** Constructor voor Paard, overloaded en zonder images
     en een default kleur */
    Paard(String naam) {
        this.naam = naam;
        this.kleur = new Color((int)(Math.random() * 0x1000000));
        this.x = 0;
        this.paardNummer = ++aantal;
    }

    /* Constructor voor Paard overloaded*/
    Paard(String naam, Color kleur, Image plaatje) {
        this (naam);
        this.kleur = kleur;
        this.plaatje = plaatje;
    }

    public String getNaam() {
        return this.naam;
    }

    public int getAfstand() {
        return this.x;
    }

    public void addAfstand() {
        this.x += ThreadLocalRandom.current().nextInt(0, 11);
    }

    public int getPaardNummer() {
        return this.paardNummer;
    }

    public Color getKleur() {
        return this.kleur;
    }

    public Image getImage() {
        return this.plaatje;
    }

    public void clearAfstand() {
        this.x = 0;
    }

}
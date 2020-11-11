import java.awt.*;

/**
 * Subklassen Saab95 ärver metoder och instansvariabler från superklassen Car
 */

public class Saab95 extends Car {

    /**
     * Instansvariabel unik för en Saab95
     */

    private boolean turboOn;

    /**
     * Saab:s konstruktor
     */

    public Saab95() {
        super(2, Color.red, "Saab95", 125, 0, 0, 0, 0);
        turboOn = false;
    }

    /**
     * Metod för att sätta på turbon
     */

    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Metod för att stänga av turbon
     */
    public void setTurboOff() {
        turboOn = false;
    }

    /**
     * Skriver över speedFactor-metoden i Car med det som gäller för en Saab
     * @return
     */
    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}

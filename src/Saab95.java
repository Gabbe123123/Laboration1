import java.awt.*;

/**
 * Subklassen Saab95 ärver metoder och instansvariabler från superklassen Car
 */

public class Saab95 extends Vehicle {

    /**
     * Instansvariabel unik för en Saab95
     */

    private boolean turboOn;

    /**
     * Saab:s konstruktor
     */

    public Saab95() {
        super(2, Color.red, "Saab95", 125.0, 0, 0, 0, 0,1.5,1);
        turboOn = false;
    }

    /**
     * Metod för att sätta på turbon
     */

    public void setTurboOn() {
        turboOn = true;

    }

    /**
     *
     * @return turboOn, alltså ifall turbo är på eller inte
     */

    public boolean getTurbo() {
        return turboOn;
    }

    /**
     * Metod för att stänga av turbon
     */

    public void setTurboOff() {
        turboOn = false;
    }

    /**
     * Skriver över speedFactor-metoden i Car med det som gäller för en Saab
     *
     * @return speedFactor
     */

    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}

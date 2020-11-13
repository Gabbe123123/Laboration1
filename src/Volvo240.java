import java.awt.*;

/**
 * Subklassen Volvo240 ärver metoder och instansvariabler från superklassen Car
 */

public class Volvo240 extends Car { //Inherits from Car class

    /**
     * Instansvariabel unik för en Saab95
     */

    private final static double trimFactor = 1.25; //Unique for Volvo240

    /**
     * Volvos konstruktor
     */

    public Volvo240() {
        super(4, Color.black, "Volvo240", 100, 0, 0, 0, 0);
    }

    /**
     * Skriver över speedFactor-metoden i Car med det som gäller för en Volvo
     *
     * @return speedFactor
     */

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }


}

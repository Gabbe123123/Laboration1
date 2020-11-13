import org.junit.*;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class Test {

    Saab95 saab;
    Volvo240 volvo;


    public void init() {
        saab = new Saab95();
        volvo = new Volvo240();
    }

    @org.junit.Test
    public void getTurbo() {
        init();
        assertEquals(false, saab.getTurbo());

    }

    @org.junit.Test
    public void getNrDoors() {
        init();
        assertEquals(4, volvo.getNrDoors());
        assertEquals(2, saab.getNrDoors());
    }

    @org.junit.Test
    public void getEnginePower() {
        init();
        assertEquals(125, saab.getEnginePower(), 0);

    }

    @org.junit.Test
    public void getStartingSpeed() {
        init();
        assertEquals(0, saab.getCurrentSpeed(), 0);
    }

    @org.junit.Test
    public void getIncrementedSpeed() {
        init();
        saab.incrementSpeed(1);
        assertEquals(1.25, saab.getCurrentSpeed(), 0);
    }

    @org.junit.Test
    public void getIncrementedSpeedWithTurboOn() {
        init();
        saab.setTurboOn();
        saab.incrementSpeed(1);
        assertEquals(1.625, saab.getCurrentSpeed(), 0);
    }

    @org.junit.Test
    public void turnLeft() {
        init();
        saab.turnLeft();
        saab.getAngle();
        assertEquals(90, saab.getAngle(), 0);
    }

    @org.junit.Test
    public void turnRight() {
        init();
        saab.turnRight();
        saab.getAngle();
        assertEquals(-90, saab.getAngle(), 0);
    }

    @org.junit.Test
    public void stopEngine() {
        init();
        saab.setCurrentSpeed(1);
        saab.stopEngine();
        assertEquals(0, saab.getCurrentSpeed(), 0);
    }

    @org.junit.Test
    public void getXcoordinateAfterMove() {
        init();
        saab.setCurrentSpeed(1);
        saab.move(1);
        assertEquals(1, saab.getXCoordinate(), 0);

    }

    @org.junit.Test
    public void getYcoordinateAfterMove() {
        init();
        saab.setCurrentSpeed(1);
        saab.move(10);
        assertEquals(0, saab.getYCoordinate(), 0);

    }

    @org.junit.Test
    public void TryBreakWithSpeed() {
        init();
        saab.setCurrentSpeed(1);
        saab.brake(1);
        assertEquals(0.25, saab.getCurrentSpeed(), 0);
    }

    @org.junit.Test
    public void TryGasWithNoInitialSpeed() {
        init();
        saab.gas(1);
        assertEquals(1.25, saab.getCurrentSpeed(), 0);
    }

    @org.junit.Test
    public void getAngleAfterTurn() {
        init();
        saab.turnLeft();
        assertEquals(90, saab.getAngle(), 0);
    }

}

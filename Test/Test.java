import org.junit.*;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class Test {

    Saab95 saab;
    Volvo240 volvo;

    @BeforeEach
    public void init(){
        saab=new Saab95();
        volvo=new Volvo240();
    }

    @org.junit.Test
    public void getTurbo(){
        init();
        assertEquals(false, saab.getTurbo());

    }

    @org.junit.Test
    public void getNrDoors(){
        init();
        assertEquals(2, saab.getNrDoors());
    }

    @org.junit.Test
    public void getEnginePower(){
        init();
        assertEquals(125, saab.getEnginePower());

}
    @org.junit.Test
    public void getStartingSpeed(){
        init();
        assertEquals(0,saab.getCurrentSpeed());
}

    @org.junit.Test
    public void getIncrementedSpeed(){
        init();
        saab.incrementSpeed(1);
        assertEquals(0.125, saab.getCurrentSpeed());
    }

    @org.junit.Test
    public void getIncrementedSpeedWithTurboOn(){
        init();
         saab.setTurboOn();
         saab.incrementSpeed(1);
         assertEquals(1.625, saab.getCurrentSpeed());
    }
}

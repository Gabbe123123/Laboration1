import java.awt.*;

/**
 * Class Scania which inherits from Vehicle and implements the interface tiltable
 */

public class Scania extends Vehicle implements Tiltable {


    private double platformAngle; //The angle of the platform


    /**
     * Constructor for a Scania
     */

    public Scania() {
        super(2, Color.white, "Scania", 770, 0, 0, 0, 0, 5, 1.5);
        platformAngle = 0;
    }

    /**
     * Speedfactor for a Scania
     * @return 0, because a Scania has no speed factor
     */

    @Override
    public double speedFactor() {
        return 0;
    }

    /**
     * Method to tilt platform, if platform angle is more than 0, the car stops.
     * Platform angle can only be changed if current speed is 0.
     * If someone tries to set a negative angle, the angle sets at 0.
     * If someone tries to set an angle > 70, the angle sets at max value 70.
     * @param changePlatformAngle, value to change angle with
     */

    @Override
    public void tilt(double changePlatformAngle) {
        if (platformAngle > 0) {
            setCurrentSpeed(0);
        }
        if (getCurrentSpeed() == 0) {

            if ((platformAngle + changePlatformAngle) <= 0) {
                platformAngle = 0;
                if ((platformAngle + changePlatformAngle) >= 70)
                    platformAngle = 70;
                else
                    platformAngle += changePlatformAngle;

            }
        }
    }

    /**
     * Method to move a car for a certain time period, makes sure car cannot move if the platform has an angle
     * @param time, the time of the movement in seconds
     */

@Override
    public void move(double time) {
    double x=0;
    double y=0;

if (platformAngle!=0){
    setCurrentSpeed(0);
}

    else {
        x += getCurrentSpeed() * Math.cos((Math.toDegrees(getAngle()))) * time;
        y += getCurrentSpeed() * Math.sin((Math.toDegrees(getAngle()))) * time;

        setXCoordinate(x);
        setYCoordinate(y);
    }
}
public static void main(String[]args){

        CarShop<Saab95> carShop= new CarShop<>(5);
        Saab95 s= new Saab95();
        Saab95 s2= new Saab95();
        Volvo240 v= new Volvo240();
        carShop.storeCar(s);
       carShop.storeCar(s2);
        carShop.collectCar(s);


        }
}

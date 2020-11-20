import java.awt.*;
import java.util.ArrayList;

/**
 * Class car transport which inherits from super class vehicle
 */

public class CarTransport extends Vehicle  {
    private int maxNumber; //Maximum number of cars the shop can hold

    private boolean platformUp; //Answers if the platform is uplifted or not

    ArrayList<Vehicle> loadedCars=new ArrayList<>(maxNumber); //ArrayList which stores the cars in the shop

    /**
     * Constructor for a car transport
     * @param maxNumber, maximum number of cars the shop can hold
     */

    public CarTransport(int maxNumber) {
        super(2, Color.white, "LastbilX", 770, 0, 0, 0, 0,7,2);
        this.platformUp=true;
        this.maxNumber=maxNumber;
    }

    /**
     * Method to set platform upright
     */

    public void setPlatformUp() {
        platformUp = true;
    }

    /**
     * Method to set platform downright, if platform is set down the car stops, cannot set platform down if car moves
     */

    public void setPlatformDown() {
        setCurrentSpeed(0);
        platformUp = false;


    }

    /**
     *Method to keep track of the state of the platform
     * @return platformUp, the state of the platform, either true (platform is up) or false (platform is down)
     */

    public boolean getPlatformUp() {
        return platformUp;
    }

    /**
     * Method to load a car onto the platform, cannot load itself onto platform and has to meet requirements for length and width.
     * Can only load car onto platform if the platform is not full and the car is not already loaded onto platform.
     * If user tries to load a car, the platform is automatically set down.
     * @param car, the car to be loaded
     */

    public void loadCar(Vehicle car) {
        //if (!(car instanceof TruckTransport)), bryter ofta mot OCP, nackdel: lägger till annan lastbil och måste ändra här i if-sats {
        if (!car.equals(this) && car.getLength()<=2 && car.getWidth()<=1) { //Följer bättre OCP
            if ((loadedCars.size() >= maxNumber)) {
                //Kan ej lägga till då det bara får plats 5 bilar
            }

            if (loadedCars.contains(car)) {
                // Kan ej lägga till då bilen redan finns
            }

            if (!loadedCars.contains(car) && (loadedCars.size() >= maxNumber)) {
                setPlatformDown();
                if (Math.pow(Math.pow(((car.getXCoordinate())-(this.getXCoordinate())),2)+Math.pow((car.getYCoordinate())-(this.getYCoordinate()),2),0.5)<3)
                {
                    loadedCars.add(car);
                }


            }
        }
    }

    /**
     * Method to release car from platform, can only release car if a car is stored, guarantees that the platform is down before removing car
     */

    public void releaseCar() {
        if(loadedCars.size()>0) {
            setPlatformDown();
            loadedCars.remove(loadedCars.get(loadedCars.size() - 1));

        }
    }

    /**
     * Speedfactor for a car transport
     * @return 0, because a car transport has no speed factor
     */

    @Override
    public double speedFactor() {
        return 0;
    }

    /**
     * Move method for a car transport
     * @param time, the time which the car moves. Sets same position for the car transport as for the cars in
     */

    @Override
    public void move(double time) {
        double x = 0;
        double y = 0;


            if (getPlatformUp() == false) {
                this.setCurrentSpeed(0);

                for (Vehicle loadedCar:loadedCars) {
                    loadedCar.setCurrentSpeed(0);
                }
            } else {

                this.move(time);

                for (Vehicle loadedCar:loadedCars) {
                    loadedCar.setXCoordinate(x);
                    loadedCar.setXCoordinate(y);
                }

            }
        }





}

import java.awt.*;
import java.util.ArrayList;

public class CarTransport extends Vehicle  {
    private int maxNumber;
    //Ner platformup är false kan den lasta på bilar, annars går det ej.
    private boolean platformUp;
    ArrayList<Vehicle> loadedCars=new ArrayList<>(maxNumber);

    /**
     *
     * @param maxNumber, maximum number of spots on platform
     */

    CarTransport(int maxNumber) {
        super(2, Color.white, "LastbilX", 770, 0, 0, 0, 0,7,2);
        //Ska ej kunna lasta på bilar till en början
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
     * Method to set platform downright
     */

    public void setPlatformDown() {
        setCurrentSpeed(0);
        platformUp = false;


    }

    /**
     *
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
        //if (!(car instanceof TruckTransport)) {
        if (!car.equals(this) && car.getLength()<=2 && car.getWidth()<=1) {
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
    public void releaseCar() {
        if(loadedCars.size()>0) {
            setPlatformDown();
            loadedCars.remove(loadedCars.get(loadedCars.size() - 1));

        }
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

    @Override
    public double speedFactor() {
        return 0;
    }




}

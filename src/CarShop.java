import java.awt.*;
import java.util.ArrayList;

/**
 * Generic class, upper bound vehicle, can create CarShop of subtypes to vehicle
 * @param <A>, type parameter A, can be any car brand
 */

public class CarShop<A extends Vehicle> { //Begränsning: har bara vehicle, kanske borde ha subclass car och truck, eller via interfaces

    private A carBrand; //The brand of the car

    int maxNumber; //Maximum number of cars the shop can hold

    ArrayList<A> carsInShop = new ArrayList<>(maxNumber); //ArrayList which stores the cars in the shop

    /**
     *Constructor for the car shop
     * @param maxNumber, maximum number of cars the shop can hold
     */

    public CarShop(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    /**
     * Method to store car in shop
     * @param car, the car that we want to load
     */

    public void storeCar(A car) {
        if (carsInShop.size() < maxNumber)
            carsInShop.add(car);
    }

    /**
     * Method to collect car from the shop, prints out the model name of the collected car
     * @param car, the car to be collected
     */

    public void collectCar(A car) {
        carsInShop.remove(car);
        System.out.println("The car collected is of model: "+ car.getModelName());

    }
}


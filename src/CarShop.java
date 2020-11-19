import java.awt.*;
import java.util.ArrayList;


public class CarShop<A extends Vehicle> {

    private A carBrand;

    int maxNumber;

    ArrayList<A> carsInShop = new ArrayList<>(maxNumber);

    CarShop(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public CarShop(A carBrand) {
        this.carBrand = carBrand;
    }

    public void loadCar(A car) {
        if (carsInShop.size() < maxNumber)
            carsInShop.add(car);
    }

    @Override
    public String toString() {
        return carsInShop.toString();
    }

    public String collectCar(A car) {
        carsInShop.remove(car);
        return "The car collected is of model: "+ car.getModelName();

    }
}


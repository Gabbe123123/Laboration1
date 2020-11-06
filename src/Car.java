import java.awt.*; //interface ärvs aldrig ifrån, kan implimentera interface i flera klasser

abstract class Car {
     protected int nrDoors; // Number of doors on the car
     protected double enginePower; // Engine power of the car
     protected double currentSpeed; // The current speed of the car
     protected Color color; // Color of the car
     protected String modelName; // The car model name
     protected int xCoordinate;
     protected int yCoordinate;

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){return enginePower; }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    protected void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public double speedFactor(){
        return enginePower;
    }

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}

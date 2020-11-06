import java.awt.*; //interface ärvs aldrig ifrån, kan implimentera interface i flera klasser
//vinkel, +-90 grader, fyra riktningar i enum

abstract class Car implements Movable { //private, men lösa via
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private int xCoordinate;
    private int yCoordinate;

    public Car(int nrDoors, Color color, String modelName, double enginePower, double currentSpeed, int xCoordinate, int yCoordinate) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.modelName = modelName;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        stopEngine();


    }


    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    protected void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public double speedFactor() {
        return enginePower;
    }

    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    // TODO fix this method according to lab pm
    public void gas(double amount) {
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount) {
        decrementSpeed(amount);
    }

    //Implementera metoder, gäller alla --> här, annars i subklasser
    public void move(){}

}

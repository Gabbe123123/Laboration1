import java.awt.*;

/**
 * Abstrakt superklass Car som implementerar interfacet Movable
 */

abstract class Car implements Movable{
    private int nrDoors; //Number of doors
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double xCoordinate; //The car's xCoordinate
    private double yCoordinate; //The car's yCoordinate
    private double angle; //The direction of the car

    /**
     * Konstruktor, en bils tillstånd definieras av dessa parametrar
     * @param nrDoors
     * @param color
     * @param modelName
     * @param enginePower
     * @param currentSpeed
     * @param xCoordinate
     * @param yCoordinate
     * @param angle
     */

    public Car(int nrDoors, Color color, String modelName, double enginePower, double currentSpeed, int xCoordinate, int yCoordinate, double angle) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.modelName = modelName;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.angle=angle;
        stopEngine();

//Constructor

    }

    /**
     * Metod för att få antalet dörrar hos bil
     * @return
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * Metod för att få engine power hos bil
     * @return
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * Metod för att få current speed hos bil, ska bara få vara mellan 0 och engine speed
     * har därför villkor där ifall current speed är negativt så sätts currentspeed till absolutbeloppet
     * vi tänker att man vill acceptera negativa värden och att de anger riktningen
     * tänker utifrån koordinatsystem, med såväl positiv som negativ x- och y-axel
     * @return
     */

    public double getCurrentSpeed() {
        if(currentSpeed<0 && Math.abs(currentSpeed)<enginePower) {
            currentSpeed=Math.abs(currentSpeed);
            return currentSpeed;
        }
        if(Math.abs(currentSpeed)>enginePower){
            currentSpeed=enginePower;
        }
        return currentSpeed;
    }

    /**
     * Metod för att få färg hos bil
     * @return
     */
    public Color getColor() {
        return color;
    }

    /**
     * Metod för att bestämma färg hos bil
     * @param clr
     */
    protected void setColor(Color clr) {
        color = clr;
    }

    /**
     * Metod för att starta bil
     */
    public void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * Metod för att stanna bil
     */
    public void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * Abstrakt metod, som overrideas i subklasserna
     * @return
     */
    public abstract double speedFactor();

    /**
     * Hur ska man göra här?
     * @param amount
     */

    public  void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount) {

        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    /**
     * Metod för att bilen ska gasa, gasar bara om värdena ligger i intervall [0,1]
     * @param amount
     */
    public void gas(double amount) {
        if(amount>=0 && amount<=1){
            incrementSpeed(amount);
        }
    }

    /**
     * Metod för att bilen ska bromsa, bromsar bara om värdena ligger i intervall [0,1]
     * @param amount
     */

    public void brake(double amount) {
   if(amount>=0 && amount<=1){
            decrementSpeed(amount);
        }

    }

    /**
     * Metod för förflyttning av bil, tar in en parameter time, alltså hur länge man rör sig i viss riktning
     * x-koordinaten är cosinus för vinkeln som man förflyttar sig i
     * y-koordinaten är sinus för vinkeln som man förflyttar sig i
     * @param time
     */
    public void move(double time){
        xCoordinate+=currentSpeed*Math.cos((Math.toDegrees(angle)))*time;
        yCoordinate+=currentSpeed*Math.sin((Math.toDegrees(angle)))*time;
    }

    /**
     * En vänstersväng innebär att vinkeln för bilen uppdateras 90 grader, bilarnas konstruktorer sätter
     * startvinkeln till 0
     */
    public void turnLeft(){
        angle+=90;
    }

    /**
     * En högersväng innebär att vinkeln för bilen uppdateras -90 grader, bilarnas konstruktorer sätter
     *  startvinkeln till 0
     */
    public void turnRight(){
        angle+=-90;

    }

}

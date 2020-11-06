import java.awt.*;
public class Saab95 extends Car{

    private boolean turboOn; //Objekt flesta private attribut, inte modifiera av misstag
    
    public Saab95(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
	    turboOn = false;
        modelName = "Saab95";
        stopEngine();
        xCoordinate=0;
        yCoordinate=0;
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
@Override
    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

@Override
    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
    
    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

    public static void main(String[] args){
        Saab95 s1 = new Saab95();
        System.out.println(s1.yCoordinate);
    }
}

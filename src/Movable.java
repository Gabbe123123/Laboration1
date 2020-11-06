public interface Movements {
    public abstract void move();

    public abstract void turnLeft();

    public abstract void turnRight();
}

public class Movable implements Movements {

    public void move() {
        if(turnLeft();){
            xCoordinate-=getCurrentSpeed();
                  else if(turnRight();)   {
                xCoordinate+=getCurrentSpeed();
                     else
                yCoordinate+=getCurrentSpeed();
            }
        }
    }


    public void turnLeft() {}

    public void turnRight() {}


}

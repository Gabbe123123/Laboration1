/**
 * Detta är vårt interface som implementeras i Car och som sen ärvs i subklasserna
 */

public interface Movable {
    /**
     * Abstrakt metod som speicificeras i Car, behöver parametern time för förflyttning beror av tiden
     */
    void move(double time);

    /**
     * Abstrakt metod som speicificeras i Car
     */
    void turnLeft();

    /**
     * Abstrakt metod som speicificeras i Car
     */

    void turnRight();

}

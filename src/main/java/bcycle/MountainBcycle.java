package bcycle;

public class MountainBcycle extends Bcycle{

    @Override
    public int speedUp(int increment) {
        initialSpeed = super.initialSpeed + increment;
        return initialSpeed;
    }

    @Override
    public int speedDown(int decrement) {
         initialSpeed = initialSpeed - decrement;
        return initialSpeed;
    }
}

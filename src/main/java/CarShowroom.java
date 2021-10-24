import java.util.ArrayList;

public class CarShowroom {

    private int numberOfCars;

    private CarShowroom(){
        numberOfCars = 0;
    };

    private static class Holder {
        public static final CarShowroom сarShowroom = new CarShowroom();
    }

    public static CarShowroom get()  {
        return Holder.сarShowroom;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public void addOneCar() {
        ++numberOfCars;
    }

    public boolean substractOneCar() {
        if (numberOfCars == 0)
            return false;

        --numberOfCars;
        return true;
    }

}

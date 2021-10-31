import java.util.Random;

public class Supplier extends Thread implements Runnable{
    public Supplier(String brand) {
        super(String.format("Производитель %s", brand));
    }

    @Override
    public void run() {
        Random random = new Random();
        final int timeOut = 1000 + random.nextInt(1000);
        String currentName = super.getName();
        CarShowroom carShowroom = CarShowroom.get();

        CarShowroom.sleep(timeOut);

        carShowroom.addOneCar(currentName, timeOut);
    }

}

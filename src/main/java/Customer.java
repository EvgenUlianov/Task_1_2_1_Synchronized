import java.util.Random;

public class Customer  extends Thread implements Runnable{
    public Customer(int number) {
        super(String.format("Покупатель %d", number));
    }

    @Override
    public void run() {
        Random random = new Random();
        final int timeOut = 500 + random.nextInt(1000);
        String currentName = super.getName();
        CarShowroom carShowroom = CarShowroom.get();

        CarShowroom.sleep(timeOut);

        System.out.printf("%s зашел в автосалон.\n", currentName);
        carShowroom.subtractOneCar(currentName, timeOut);
    }

}

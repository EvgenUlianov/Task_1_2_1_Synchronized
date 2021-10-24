import java.util.Random;

public class Customer  extends Thread implements Runnable{
    public Customer(int number) {
        super(String.format("Покупатель %d", number));
    }

    @Override
    public void run() {
//        final int timeOut15 = 15_000;
        Random random = new Random();
        final int timeOut = 500 + random.nextInt(1000);
        String currentName = super.getName();
        CarShowroom carShowroom = CarShowroom.get();

        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%s зашел в автосалон.\n", currentName);
        while (true) {
            boolean successful = false;
            synchronized (carShowroom) {
                if(carShowroom.getNumberOfCars() != 0){
                    carShowroom.substractOneCar();
                    successful = true;
                }
                if (!successful) {
                    System.out.println("Машин нет");
                    try {
                        carShowroom.wait();
                    } catch (InterruptedException e) {
//                    e.printStackTrace();
                    }
                }
            }
            if (successful) {
                System.out.printf("%s уехал на новеньком авто.\n", currentName);
                return;
            }
        }
    }

}

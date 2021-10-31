public class CarShowroom {

    private int numberOfCars;
    private static final boolean NEED_PRINT_STACK_TRACE_WHEN_SLEEP = false;

    private CarShowroom(){
        numberOfCars = 0;
    }

    private static class Holder {
        public static final CarShowroom carShowroom = new CarShowroom();
    }

    public static CarShowroom get()  {
        return Holder.carShowroom;
    }

    public synchronized void addOneCar(String currentName, int timeOut) {
        sleep(timeOut);
        ++numberOfCars;
        notify();
        System.out.printf("%s произвел автомобиль. В салоне теперь %d машин.\n", currentName, numberOfCars);
    }

    public synchronized void subtractOneCar(String currentName,int timeOut) {
        try {
            while (numberOfCars == 0){
                System.out.println("Машин нет");
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sleep(timeOut);
        --numberOfCars;
        System.out.printf("%s уехал на новеньком авто. В салоне теперь %d машин.\n", currentName, numberOfCars);
    }

    public static void sleep(int timeOut) {
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            if (NEED_PRINT_STACK_TRACE_WHEN_SLEEP)
                e.printStackTrace();
        }
    }
}

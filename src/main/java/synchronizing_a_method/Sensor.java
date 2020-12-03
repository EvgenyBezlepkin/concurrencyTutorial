package synchronizing_a_method;

import java.util.concurrent.TimeUnit;

public class Sensor implements Runnable{

    private final ParkingStats parkingStats;

    public Sensor(ParkingStats parkingStats) {
        this.parkingStats = parkingStats;
    }


    public void run() {
        for (int i = 0; i < 10; i++) {
            parkingStats.carComeIn(Auto.Car);
            parkingStats.carComeIn(Auto.Car);

            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            parkingStats.carComeIn(Auto.Moto);

            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            parkingStats.carGoOut(Auto.Car);
            parkingStats.carGoOut(Auto.Car);
            parkingStats.carGoOut(Auto.Moto);
        }
    }
}

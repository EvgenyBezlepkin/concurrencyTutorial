package synchronizing_a_method;

import java.time.LocalTime;

public class App {
    public static void main(String[] args) throws InterruptedException {

        ParkingCash parkingCash = new ParkingCash();
        ParkingStats parkingStats = new ParkingStats(parkingCash);

        int procs = 2 * Runtime.getRuntime().availableProcessors(); // 8
        int start = LocalTime.now().getNano();

        Thread threads[] = new Thread[procs];
        for (int i = 0; i < procs; i++) {
            Sensor sensor = new Sensor(parkingStats);
            Thread t = new Thread(sensor);
            t.start();
            threads[i] = t;

            // remedial options
            //t.join(); // каждый следующий ждет завершения предыдущего, однопоточный режим // ~8 sec
            // synchronization methods carComeIn, carGoOut // 25000 nanosec
            // atomic long for numberCars,numberMotos // 20000 nanosec
        }

        for (int i = 0; i < procs; i++) {
            threads[i].join();
        }

        int end = LocalTime.now().getNano();

        System.out.println("time " + (end-start) / 1000);

        System.out.println(parkingStats.numberCars);
        System.out.println(parkingStats.numberMotos);

        parkingCash.close();
    }

}

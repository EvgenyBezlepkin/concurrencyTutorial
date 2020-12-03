package synchronizing_a_method;

import java.util.concurrent.atomic.AtomicLong;

public class ParkingStats {

    // this class requires to handle race condition
    // first var - using synchronization in methods carComeIn, carGoOut
    // second var - using Atomic class for numberCars, numberMotos

    AtomicLong numberCars = new AtomicLong();
    AtomicLong numberMotos = new AtomicLong();
    private final ParkingCash cash;

    public ParkingStats(ParkingCash cash) {
        this.cash = cash;
    }

    //public synchronized void carComeIn(Auto auto) {
    public synchronized void carComeIn(Auto auto) {
        switch (auto){
            case Car:numberCars.incrementAndGet();
            break;
            case Moto:numberMotos.incrementAndGet();
            break;
        }
    }

    //public synchronized void carGoOut(Auto auto) {
    public synchronized void carGoOut(Auto auto) {
        switch (auto){
            case Car:numberCars.decrementAndGet();
            cash.vehiclePay(Auto.Car.getI());
                break;
            case Moto:numberMotos.decrementAndGet();
            cash.vehiclePay(Auto.Moto.getI());
                break;
        }
    }
}

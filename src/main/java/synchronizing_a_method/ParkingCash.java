package synchronizing_a_method;

public class ParkingCash {

    private long cash;

    public ParkingCash() {
        this.cash = 0;
    }

    public void vehiclePay(int cost) {
        cash += cost;
    }

    public void close() {
        System.out.println("The total amount is " + cash);
        cash = 0;
    }

}

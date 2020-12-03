package synchronizing_a_method;

public enum Auto {

    Car(2),
    Moto(2);

    private int i;

    Auto(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}

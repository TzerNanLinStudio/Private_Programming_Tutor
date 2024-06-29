package person;

public class Manager extends Person {
    private double stockPercentage;

    public Manager() {
        super();
        stockPercentage =  Double.MIN_VALUE;
    }

    public Manager(String id, String name, int[] birthday, String gender) {
        super(id, name, birthday, gender);
        stockPercentage = 100.0;
    }
}

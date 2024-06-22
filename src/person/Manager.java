package person;

import java.time.LocalDate;

public class Manager extends Person {

    private double stockPercentage;

    public Manager() {
        super();
        stockPercentage = 100.0;
    }

    public Manager(String id, String name, LocalDate birthday, String gender) {
        super(id, name, birthday, gender);
        stockPercentage = 100.0;
    }

}

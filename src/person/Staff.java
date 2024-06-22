package person;

import java.time.LocalDate;

public class Staff extends Person {

    private int salary;

    public Staff() {
        super();
        salary = 40000;
    }

    public Staff(String id, String name, LocalDate birthday, String gender) {
        super(id, name, birthday, gender);
        salary = 40000;
    }

}

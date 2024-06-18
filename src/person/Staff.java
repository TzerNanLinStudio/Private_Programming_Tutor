package person;

import java.time.LocalDate;

public class Staff extends Person {
    public Staff(String id, String name, LocalDate birthday, String gender) {
        super(id, name, birthday, gender);
    }
}

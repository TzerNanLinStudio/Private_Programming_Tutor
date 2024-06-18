package person;

import java.time.LocalDate;

public class Client extends Person{
    public Client(String id, String name, LocalDate birthday, String gender) {
        super(id, name, birthday, gender);
    }
}

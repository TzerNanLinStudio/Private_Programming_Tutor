package person;

import static java.lang.Math.*;

public class Staff extends Person {
    private int salary;

    public Staff() {
        super();
        salary = Integer.MIN_VALUE;
    }

    public Staff(String id, String name, int[] birthday, String gender) {
        super(id, name, birthday, gender);
        salary = 40000 +  (int)(20000.0 * random());
    }
}

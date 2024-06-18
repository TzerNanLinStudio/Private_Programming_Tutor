package shop;

import person.*;

import java.util.ArrayList;
import java.time.LocalDate;

public abstract class Shop {
    protected Manager manager;

    protected ArrayList<Staff> staffList;

    public Shop(Manager manager) {
        this.manager = manager;

        staffList = new ArrayList<>();
        staffList.add(new Staff("1234", "Jenny", LocalDate.of(1999, 10, 12), "Female"));
        staffList.add(new Staff("12345678", "Curry", LocalDate.of(1995, 5, 5), "Male"));
    }

    public abstract void runSystem();
}

package person;

import java.time.LocalDate;

public class Person {
    protected String id;
    protected String name;
    protected LocalDate birthday;
    protected String gender;

    public Person(String id, String name, LocalDate birthday, String gender) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID='" + id + '\'' +
                ", Name='" + name + '\'' +
                ", Birthday=" + birthday +
                ", Gender='" + gender + '\'' +
                '}';
    }
}

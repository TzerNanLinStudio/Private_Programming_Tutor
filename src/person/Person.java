package person;

public class Person {
    protected String id;
    protected String name;
    protected int[] birthday; // [0]是年, [1]是月, [2]是日
    protected String gender; // todo 改成enum???

    public Person() {
        this.id = "unknown";
        this.name = "unknown";
        this.birthday = new int[]{9999, 9, 9};
        this.gender = "unknown";
    }

    public Person(String id, String name, int[] birthday, String gender) {
        if (birthday.length != 3) {
            throw new IllegalArgumentException("Birthday array must have exactly 3 elements (year, month, day)");
        }

        if (!(gender.compareTo("Female") == 0 || gender.compareTo("Male") == 0)) {
            throw new IllegalArgumentException("Gender must be 'Female' or 'Male'");
        }

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

    public int[] getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return  "ID=" + id +
                ", Name=" + name +
                ", Birthday=" + birthday[0] + "/" + birthday[1] + "/" + birthday[2] +
                ", Gender=" + gender;
    }
}

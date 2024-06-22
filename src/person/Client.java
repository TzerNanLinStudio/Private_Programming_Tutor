package person;

import biology.animal.Animal;

import java.time.LocalDate;
import java.util.ArrayList;

public class Client extends Person{
    private int balance;
    private ArrayList<Animal> petList;

    public Client() {
        super();
        balance = 1000000;
        petList = new ArrayList<>();
    }

    public Client(String id, String name, LocalDate birthday, String gender) {
        super(id, name, birthday, gender);
        balance = 1000000;
        petList = new ArrayList<>();
    }

    public boolean pay(int amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }

        return false;
    }

    public void addPet(Animal newPet) {
        petList.add(newPet);
    }

    @Override
    public String toString() {
        String str = "";

        str += super.toString() + ", balance=" + balance + "\n";

        for (int i = 0; i < petList.size(); i++) {
            str += "Pet " + i + " is { " + petList.get(i).toString() + " }\n";
        }

        return str;
    }
}

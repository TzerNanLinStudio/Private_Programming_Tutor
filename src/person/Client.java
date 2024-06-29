package person;

import biology.animal.Animal;

import java.time.LocalDate;
import java.util.ArrayList;

import static java.lang.Math.*;

public class Client extends Person{
    private int balance;
    private ArrayList<Animal> petList;

    public Client() {
        super();
        balance = Integer.MIN_VALUE;;
        petList = new ArrayList<>();
    }

    public Client(String id, String name, int[] birthday, String gender) {
        super(id, name, birthday, gender);
        balance = (int)(1000000.0 * random());
        petList = new ArrayList<>();
    }

    public boolean pay(int amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        else {
            System.out.println(getName() + "的存款不足!");
            return false;
        }
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

package biology.animal.mammal;

import biology.animal.Pet;

import static java.lang.Math.*;

public class Dog extends Mammal implements Pet {
    public final static String CATEGORY = "Dog";

    public Dog(){
        super();
    }

    public Dog(String name, int age, double weight){
        super(name, age, weight);
    }

    public void eat(int gram) {
        if (gram > 1000)
            weight += 0.5;
    }

    public void play(int minute) {
        if (minute > 60)
            weight -= 0.3;
    }

    public boolean checkHealth() {
        if (random() > 0.05)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "Category=" + CATEGORY + ", " + super.toString();
    }
}

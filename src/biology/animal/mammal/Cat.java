package biology.animal.mammal;

import biology.animal.Pet;

import static java.lang.Math.random;

public class Cat extends Mammal implements Pet{
    public final static String CATEGORY = "Cat";

    public Cat(){
        super();
    }

    public Cat(String name, int age, double weight){
        super(name, age, weight);
    }

    public void eat(int gram) {
        if (gram > 500)
            weight += 0.1;
    }

    public void play(int minute) {
        if (minute > 90)
            weight -= 0.1;
    }

    public boolean checkHealth() {
        if (random() > 0.1)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "Category=" + CATEGORY + ", " + super.toString();
    }
}

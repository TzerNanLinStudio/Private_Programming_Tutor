package biology.animal.mammal;

import biology.animal.Pet;

public class Lion extends Mammal {

    public final static String CATEGORY = "Lion";

    public Lion(){
        super();
    }

    public Lion(String name, int age, double weight){
        super(name, age, weight);
    }

    public void eat(int gram) {
        if (gram > 5000)
            weight += 2.5;
    }

    @Override
    public String toString() {
        return "Category=" + CATEGORY + ", " + super.toString();
    }
}

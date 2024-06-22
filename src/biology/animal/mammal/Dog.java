package biology.animal.mammal;

import biology.animal.Pet;

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
            weight += 0.2;
    }

    public void play() {

    }

    public boolean checkHealth() {
        System.out.println("檢乘結果為健康");
        return true;
    }

    @Override
    public String toString() {
        return "Category=" + CATEGORY + ", " + super.toString();
    }

}

package biology.animal.mammal;

import biology.animal.Pet;

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

    public void play() {
        System.out.println("正在玩樂");
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

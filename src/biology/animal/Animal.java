package biology.animal;

public abstract class Animal {
    protected String name;

    protected int age;

    protected double weight;

    public Animal() {
        this.name = "unknown";
        this.age = Integer.MIN_VALUE;
        this.weight = Double.MIN_VALUE;
    }

    public Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public abstract void eat(int gram);

    public void sleep(int minute) {
        System.out.println("正在睡覺");
    }

    @Override
    public String toString() {
        return  "Name=" + name +
                ", Age=" + age +
                ", Weight=" + weight;
    }
}

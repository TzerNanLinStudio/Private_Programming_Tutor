package biology.animal;

import java.util.Scanner;

public abstract class Animal {
    public String name;

    public int age;

    public int weight;

    public Animal() {
        userInputVariable();
    }

    public Animal(String _name, int _age, int _weight) {
        name = _name;
        age = _age;
        weight = _weight;
    }

    public void eat(int g) {
        weight += g;
    }

    public void exercise(int minute) {
        weight -= (minute / 60);
    }

    public void showInformation() {
        System.out.println("=====動物的資訊=====");
        System.out.println("名子:" + name);

        if (age >= 0)
            System.out.println("年齡:" + age);
        else
            System.out.println("年齡未知");

        System.out.println("體重(kg):" + ((double) (weight) / 1000.0));
    }

    private void userInputVariable() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("輸入名稱:");
        name = scanner.next();

        System.out.print("輸入年齡:");
        age = scanner.nextInt();

        System.out.print("輸入體重(g):");
        weight = scanner.nextInt();
    }
}

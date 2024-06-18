package shop;

import biology.animal.*;
import biology.animal.mammal.*;
import biology.animal.bird.*;
import person.*;

import java.util.Scanner;

import java.util.ArrayList;

public class PetShop extends Shop {
    protected ArrayList<Animal> petList;

    private int petCapacity;

    public PetShop(Manager manager, int petCapacity) {
        super(manager);

        this.petCapacity = petCapacity;

        petList = new ArrayList<>();

        petList.add(new Cat("A", 5, 5000)); // test code
    }

    public void runSystem(){
        System.out.println("歡迎來到寵物系統");
        System.out.println("老闆資訊:" + manager.toString());
        System.out.println("員工資訊:");
        for (int i = 0; i < staffList.size(); i++) {
            System.out.println(staffList.get(i).toString());
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("系統是否繼續運行(0為結束，其餘整數為繼續):");

        while (true){
            System.out.print("系統是否繼續運行(0為結束，其餘整數為繼續):");
            int isKeepRunning = scanner.nextInt();
            if (isKeepRunning == 0) {
                System.out.println("寵物系統結束");
                break;
            }

            System.out.print("是否添加新的動物到系統中(0為不需要，1是貓咪，2是狗):");
            int input_value_01 = scanner.nextInt();
            switch (input_value_01) {
                case 0:
                    break;
                case 1:
                    petList.add(new biology.animal.mammal.Cat()); // 建立貓咪物件
                    break;
                case 2:
                    petList.add(new biology.animal.mammal.Dog()); // 建立狗狗物件
                    break;
            }

            for (Animal item : petList) {
                item.showInformation();
            }
        }
    }
}

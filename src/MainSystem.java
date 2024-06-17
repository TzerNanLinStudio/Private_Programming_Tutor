import biology.animal.*;
//import biology.animal.mammal.*;

import java.util.Scanner;

public class MainSystem {
        public static void main(String[] args) {
        System.out.println("歡迎來到寵物系統");

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.print("系統是否繼續運行(0為結束，其餘整數為繼續):");
            int isKeepRunning = scanner.nextInt();
            if (isKeepRunning == 0) {
                System.out.println("寵物系統結束");
                break;
            }

            System.out.print("是否添加新的動物到系統中(0為不需要，1是貓咪，2是狗):");
            Animal newAnimal;
            int input_value_01 = scanner.nextInt();
            switch (input_value_01) {
                case 0:
                    break;
                case 1:
                    newAnimal = new biology.animal.mammal.Cat(); // 建立貓咪物件
                    newAnimal.showInformation();
                    break;
                case 2:
                    newAnimal = new biology.animal.mammal.Dog(); // 建立狗狗物件
                    newAnimal.showInformation();
                    break;
            }
        }
    }
}
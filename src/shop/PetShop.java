package shop;

import biology.animal.*;
import biology.animal.mammal.*;
import person.*;

import java.util.ArrayList;

public class PetShop extends Shop {
    protected ArrayList<Animal> petList;
    private int petCapacity;

    public PetShop(Manager manager, int petCapacity) {
        super(manager);

        this.petList = new ArrayList<>();
        this.petCapacity = petCapacity;

    }

    public void addPet() {
        System.out.print("輸入物種[1.貓 2.狗]: ");
        int category = scanner.nextInt();

        System.out.print("輸入名稱:");
        String name = scanner.next();

        System.out.print("輸入年齡:");
        int age = scanner.nextInt();

        System.out.print("輸入體重:");
        double weight = scanner.nextDouble();

        Animal newPet = null;
        switch (category) {
            case 1:
                newPet = new Cat(name, age, weight);
                break;
            case 2:
                newPet = new Dog(name, age, weight);
                break;
            default:
                System.out.println("Error");
                break;
        }
        petList.add(newPet);
    }

    public void addPet(Animal newPet) {
        petList.add(newPet);
    }

    public void deletePet(String name) {
        for (int i = 0; i < petList.size(); i++) {
            if (name.equals(petList.get(i).getName())) {
                petList.remove(i);
                break;
            }
        }
    }

    public void runSystem(){
        MainLoop: while (true){
            System.out.print("\n請登陸寵物店系統\n請輸入ID: ");
            String id = scanner.next();

            switch (VerifyID(id)) {
                case User.Manager:
                    System.out.println("Manager登錄!");
                    boolean openFlag = managerDoSomething();
                    if (!openFlag) break MainLoop;
                    break;
                case User.Staff:
                    System.out.println("Staff登錄!");
                    staffDoSomething(id);
                    break;
                case User.Client:
                    System.out.println("Client登錄!");
                    clientDoSomething(id);
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        }
    }

    private User VerifyID(String id) {
        if (id.equals(manager.getId()))
            return User.Manager;

        for (Staff staff : staffList)
            if (id.equals(staff.getId()))
                return User.Staff;

        return User.Client;
    }

    private boolean managerDoSomething() {
        boolean openSystemFlag = true;
        boolean useSystemFlag = true;

        while (useSystemFlag) {
            System.out.print("操作選項[1. 查看目錄 2. 招聘員工 3. 開除員工 4. 增加寵物 5. 登出系統 6. 關閉系統]: ");

            switch (scanner.nextInt()) {
                case 1:
                    System.out.println(toString());
                    break;
                case 2:
                    System.out.println("招聘員工");
                    break;
                case 3:
                    System.out.println("刪除員工");
                    break;
                case 4:
                    addPet();
                    break;
                case 5:
                    useSystemFlag = false;
                    break;
                case 6:
                    useSystemFlag = false;
                    openSystemFlag = false;
                    break;
                default:
                    System.out.println("無效選項");
                    break;
            }
        }

        return openSystemFlag;
    }

    private void staffDoSomething(String id) {
        boolean useSystemFlag = true;

        while (useSystemFlag) {
            System.out.print("操作選項[1. 查看目錄 2. 餵食寵物 3. 登出系統]: ");

            switch (scanner.nextInt()) {
                case 1:
                    System.out.println(toString());
                    break;
                case 2:
                    for (Animal pet : petList) {
                        System.out.print("餵食" + pet.getName() + "多少公克飼料: ");
                        pet.eat(scanner.nextInt());
                    }
                    break;
                case 3:
                    useSystemFlag = false;
                    break;
                default:
                    System.out.println("無效選項");
                    break;
            }
        }
    }

    private void clientDoSomething(String id) {
        boolean useSystemFlag = true;
        Client client = new Client();

        while (useSystemFlag) {
            System.out.print("操作選項[1. 查看商店寵物目錄 2. 查看自己狀態 3. 購買寵物 4. 登出系統]: ");

            switch (scanner.nextInt()) {
                case 1:
                    for (int i = 0; i < petList.size(); i++) {
                        System.out.println("No. " + i + " : " + petList.get(i).toString());
                    }
                    break;
                case 2:
                    System.out.println(client.toString());
                    break;
                case 3:
                    System.out.print("輸入期望購買的寵物名稱: ");
                    String name = scanner.next();

                    for (Animal pet : petList) {
                        if (name.equals(pet.getName())) {
                            client.pay(20000);
                            client.addPet(pet);
                            deletePet(name);
                            break;
                        }
                    }
                    break;
                case 4:
                    useSystemFlag = false;
                    break;
                default:
                    System.out.println("無效選項");
                    break;
            }
        }
    }

    @Override
    public String toString() {
        String str = "";

        str += super.toString();

        for (int i = 0; i < petList.size(); i++) {
            str += "Pet " + i + " is { " + petList.get(i).toString() + " }\n";
        }

        return str;
    }
}

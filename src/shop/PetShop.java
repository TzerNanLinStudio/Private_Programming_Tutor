package shop;

import biology.animal.*;
import biology.animal.mammal.*;
import person.*;

import java.util.ArrayList;
import java.util.HashMap;

public class PetShop extends Shop {
    private int petCapacity;
    protected ArrayList<Animal> petList;
    private HashMap<Animal, Integer> petPrice;

    public PetShop(Manager manager, int petCapacity) {
        super(manager);

        this.petCapacity = petCapacity;
        this.petList = new ArrayList<>();
        this.petPrice = new HashMap<>();
    }

    public void addPet() {
        if (petList.size() < petCapacity) {
            System.out.print("輸入物種[1.貓 2.狗]: ");
            int category = scanner.nextInt();

            System.out.print("輸入名稱:");
            String name = scanner.next();

            System.out.print("輸入年齡:");
            int age = scanner.nextInt();

            System.out.print("輸入體重:");
            double weight = scanner.nextDouble();

            System.out.print("輸入售價:");
            int price = scanner.nextInt();

            Animal pet = null;
            switch (category) {
                case 1:
                    pet = new Cat(name, age, weight);
                    break;
                case 2:
                    pet = new Dog(name, age, weight);
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
            addPet(pet, price);
        } else {
            System.out.println("寵物商店空間已滿，無法新增寵物");
        }
    }

    public void addPet(Animal pet, int price) {
        if (petList.size() < petCapacity){
            petList.add(pet);
            petPrice.put(pet, price);
        }
        else {
            System.out.println("寵物商店空間已滿，無法新增寵物");
        }
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
            System.out.print("\n請登陸寵物商店系統\n請輸入ID: ");
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
                    System.out.println("無效選項");
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
            try {
                System.out.print("操作選項[1.查看目錄 2.招聘員工 3.開除員工 4.新增寵物 5.登出系統 6.關閉系統]: ");

                switch (scanner.nextInt()) {
                    case 1:
                        System.out.println(toString());
                        break;
                    case 2:
                        System.out.println("輸入新進員工的資訊: ");
                        addStaff();
                        break;
                    case 3:
                        System.out.print("輸入離職員工的ID: ");
                        deleteStaff(scanner.next());
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
            catch (Exception ex) {
                System.out.println("例外狀態! 資訊: " + ex.getMessage());
                System.out.println("系統刷新，請重新再輸入。");
                scanner.nextLine(); // 清空输入缓冲区
            }
        }

        return openSystemFlag;
    }

    private void staffDoSomething(String id) {
        boolean useSystemFlag = true;

        while (useSystemFlag) {
            try {
                System.out.print("操作選項[1.查看目錄 2.寵物餵食 3.寵物放風 4.寵物健檢 5.登出系統]: ");

                switch (scanner.nextInt()) {
                    case 1:
                        System.out.println(toString());
                        break;
                    case 2:
                        for (Animal pet : petList) {
                            System.out.print(pet.getName() + "的餵食飼料公克數: ");
                            pet.eat(scanner.nextInt());
                        }
                        break;
                    case 3:
                        for (Animal pet : petList) {
                            System.out.print(pet.getName() + "的放風時間分鐘數: ");
                            ((Pet)pet).play(scanner.nextInt());
                        }
                        break;
                    case 4:
                        for (Animal pet : petList) {
                            System.out.println(pet.getName() + "是否健康: " + (((Pet)pet).checkHealth() ? "是" : "否"));
                        }
                        break;
                    case 5:
                        useSystemFlag = false;
                        break;
                    default:
                        System.out.println("無效選項");
                        break;
                }
            }
            catch (Exception ex) {
                System.out.println("例外狀態! 資訊: " + ex.getMessage());
                System.out.println("系統刷新，請重新再輸入。");
                scanner.nextLine(); // 清空输入缓冲区
            }
        }
    }

    private void clientDoSomething(String id) {
        boolean useSystemFlag = true;
        Client client = createClient();

        while (useSystemFlag) {
            try {
                System.out.print("操作選項[1.查看商店目錄 2.查看個人資訊 3.購買寵物 4.登出系統]: ");

                switch (scanner.nextInt()) {
                    case 1:
                        for (int i = 0; i < petList.size(); i++) {
                            System.out.println("No." + i + " : " + petList.get(i).toString() + ", Price=" + petPrice.get(petList.get(i)) + " }");
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
                                if (client.pay(petPrice.get(pet))){
                                    System.out.println("交易成功!");
                                    client.addPet(pet);
                                    deletePet(name);
                                }
                                else {
                                    System.out.println("交易失敗!");
                                }
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
            catch (Exception ex) {
                System.out.println("例外狀態! 資訊: " + ex.getMessage());
                System.out.println("系統刷新，請重新再輸入。");
                scanner.nextLine(); // 清空输入缓冲区
            }
        }
    }

    @Override
    public String toString() {
        String str = "";

        str += super.toString();

        for (int i = 0; i < petList.size(); i++) {
            str += "Pet " + i + " is { " + petList.get(i).toString() + ", Price=" + petPrice.get(petList.get(i)) + " }\n";
        }

        return str;
    }
}

package shop;

import biology.animal.Animal;
import person.*;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

public abstract class Shop {
    protected Manager manager;
    protected ArrayList<Staff> staffList;
    protected Scanner scanner;

    public Shop(Manager manager) {
        this.manager = manager;
        this.staffList = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public boolean addStaff() {
        System.out.print("輸入ID: ");
        String id = scanner.next();

        System.out.print("輸入姓名:");
        String name = scanner.next();

        System.out.print("輸入出生年:");
        int year = scanner.nextInt();

        System.out.print("輸入出生月:");
        int month = scanner.nextInt();

        System.out.print("輸入出生日:");
        int day = scanner.nextInt();

        System.out.print("輸入性別:");
        String gender = scanner.next();

        return addStaff( new Staff(id, name, LocalDate.of(year, month, day), gender));
    }

    public boolean addStaff(Staff newStaff) {
        for (Staff staff : staffList) {
            if (newStaff.getId().equals(staff.getId())) {
                System.out.println("ID重複!添加員工失敗!");
                return false;
            }
        }

        staffList.add(newStaff);
        return true;
    }

    public boolean deleteStaff(String id) {
        for (int i = 0; i < staffList.size(); i++) {
            if (id.equals(staffList.get(i).getId())) {
                staffList.remove(i);
                return true;
            }
        }

        System.out.println("員工名冊沒有對應ID!刪除員工失敗!");
        return false;
    }

    public abstract void runSystem();

    @Override
    public String toString() {
        String str = "";

        str += "Manager is { " + manager.toString() + " }\n";

        for (int i = 0; i < staffList.size(); i++) {
            str += "Staff " + i + " is { " + staffList.get(i).toString() + " }\n";
        }

        return str;
    }
}

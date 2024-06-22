import biology.animal.mammal.*;
import person.*;
import shop.*;

import java.time.LocalDate;

public class Main {
        public static void main(String[] args) {
            PetShop petShop = new PetShop(new Manager("001", "Alice", LocalDate.of(1990, 1, 1), "Female"), 100);

            petShop.addStaff(new Staff("001", "Jenny", LocalDate.of(1999, 10, 12), "Female"));
            petShop.addStaff(new Staff("002", "Curry", LocalDate.of(1995, 5, 5), "Male"));

            petShop.addPet(new Cat("Kitty", 1, 1.5));
            petShop.addPet(new Dog("Den", 3, 9.5));
            petShop.addPet(new Cat("圓圓", 5, 4.0));

            petShop.runSystem();
    }
}
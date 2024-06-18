import person.*;
import shop.*;

import java.time.LocalDate;

public class Main {
        public static void main(String[] args) {
            Manager manager = new Manager("123456", "Alice", LocalDate.of(1990, 1, 1), "Female");

            PetShop petShop = new PetShop(manager, 100);

            petShop.runSystem();
    }
}
import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("+-----------------------------------------------+");
            System.out.println("|                 Lottery Menu                  |");
            System.out.println("|               Select an Option                |");
            System.out.println("+-----------------------------------------------+");
            System.out.println("|  1. Purchase a ticket                         |");
            System.out.println("|  2. Exit the Program                          |");
            System.out.println("+-----------------------------------------------+");

            int userInput = scanner.nextInt();
            scanner.nextLine();

            switch (userInput) {
                case 1 -> Lottery.purchaseTicket();
                case 2 -> System.exit(0);
                default -> System.out.println("Please enter a valid number");
            }
        }
        
    }
}

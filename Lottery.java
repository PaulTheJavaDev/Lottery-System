import java.util.*;

public class Lottery {

    static final int ticketPrice = 10;
    static int accountMoney = 100;
    static int lotteryMoney = 1000;

    static int[] winningNumbers = Lottery.generateWinningNumbers();

    static Scanner scanner = new Scanner(System.in);

    public static int[] generateWinningNumbers() {
        Random random = new Random();

        while (true) {
            int[] numbers = random.ints(6, 1, 50).toArray();

            // Check for duplicates
            Set<Integer> uniqueNumbers = new HashSet<>(); //first time using HashSet <3
            boolean hasDuplicates = Arrays.stream(numbers)
                    .anyMatch(n -> !uniqueNumbers.add(n));

            //continues with the code (main method) if the user doesn't have any duplicate numbers
            if (!hasDuplicates) {
                System.out.println("Winning Numbers: " + Arrays.toString(numbers));
                return numbers;
            }
        }
    }

    public static void checkUserNumbers(int[] winningNumbers) {
        System.out.println("Enter 6 unique numbers between 1 and 50:");

        //HasSet creation:
        //A HashSet is a collection of items where every item is unique, and it is found in the java.util package
        Set<Integer> userNumbers = new HashSet<>();

        while (userNumbers.size() < 6) {
            try {
                System.out.print("Enter number " + (userNumbers.size() + 1) + ": ");
                int number = Integer.parseInt(scanner.nextLine());

                //checks if the number from the user is a valid number (1-50)
                if (number < 1 || number > 50) {
                    System.out.println("Please enter a number between 1 and 50.");
                } else if (!userNumbers.add(number)) { //checks if the HashSet doesn't add the number, then it's a duplicate
                    System.out.println("You already entered that number. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        System.out.println("Your Numbers: " + userNumbers);

        // Check how many numbers match
        long matchingCount = userNumbers.stream()
                .filter(num -> Arrays.stream(winningNumbers).anyMatch(w -> w == num))
                .count();

        if (matchingCount == 6) {
            System.out.println("Congratulations you won the Jackpot!");
            //add the lotteryMoney to the user
        } else {
            System.out.println("You matched " + matchingCount + " numbers!");
        }
        int wonMoney = (int) (lotteryMoney * matchingCount / 2);
        accountMoney += wonMoney;
        System.out.printf("\nYou gained %d€!", wonMoney);
    }

    public static void purchaseTicket() {
        while (true) {
            System.out.println("How many tickets would you like to purchase?");
            int userTickets = scanner.nextInt();

            //check if the user has the valid amount of money
            if (userTickets * ticketPrice > accountMoney) {
                System.out.println("You don't have this much money!");
            } else { //purchases the ticket
                accountMoney = (userTickets * ticketPrice);
                break; //exits the loop and makes the statement reachable
            }
        }
        checkUserNumbers(winningNumbers);
    }
}

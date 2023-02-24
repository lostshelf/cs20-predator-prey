import java.util.Random;
import java.util.Scanner;

public class Main {
    // Edit these!
    public static final int CATCH_CHANCE = 50;
    public static final int WOLF_BREED_TIME = 20;
    public static final int WOLF_BREED_AMOUNT = 1;
    public static final int RABBIT_BREED_TIME = 5;
    public static final int RABBIT_BREED_AMOUNT = 3;
    public static final int MAX_RABBITS = 50_000;

    // Do NOT modify the following
    public static Random rand = new Random();
    public static Scanner scan = new Scanner(System.in);

    // Starting amount of animals
    static int rabbits = 0;
    static int wolves = 0;
    public static void main(String[] args) {
        System.out.println("How many rabbits are there?: ");
        rabbits = scan.nextInt();
        scan.nextLine();

        System.out.println("How many wolves are there?: ");
        wolves = scan.nextInt();
        scan.nextLine();

        startGame();
    }

    public static void startGame() {
        int day = 1;

        while (wolves > 0 && rabbits > 0) {
            wolvesHunt();

            if ((day % RABBIT_BREED_TIME) == 0) {
                rabbitsBreed();
            }

            if ((day % WOLF_BREED_TIME) == 0) {
                wolvesBreed();
            }

            if (rabbits > MAX_RABBITS) {
                rabbits /= 2;
            }

            System.out.printf("Wolves: %d | Rabbits: %d%n", wolves, rabbits);
            day++;
        }

        System.out.printf("The biosphere survived %d days.%n", day);
    }

    public static void wolvesHunt() {
        if (rabbits <= 0)
            wolves = 0;

        for (int i = 0; i < wolves; i++)
            if (rand.nextInt(100 / CATCH_CHANCE) == 0)
                wolves--;
            else
                rabbits--;
    }

    public static void rabbitsBreed() {
        rabbits += Math.floor((float) rabbits / 2) * RABBIT_BREED_AMOUNT;
    }

    public static void wolvesBreed() {
        wolves += Math.floor((float) wolves / 2) * WOLF_BREED_AMOUNT;
    }
}
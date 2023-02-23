import java.util.Random;

public class Main {
    // Edit these!
    public static final int CATCH_CHANCE = 50;
    public static final int WOLF_BREED_TIME = 20;
    public static final int RABBIT_BREED_TIME = 5;
    public static final int MAX_RABBITS = 50_000;
    public static final int START_WOLVES = 75;
    public static final int START_RABBITS = 100;

    // Do NOT modify these
    public static Random rand = new Random();

    static int rabbits = START_RABBITS;
    static int wolves = START_WOLVES;
    public static void main(String[] args) {
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
        rabbits += Math.floor((float) rabbits / 2) * 3;
    }

    public static void wolvesBreed() {
        wolves += Math.floor((float) wolves / 2);
    }
}
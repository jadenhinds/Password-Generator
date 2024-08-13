import java.util.*;

public class Settings {
    static final String Uppers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String Lowers = "abcdefghijklmnopqrstuvwxyz";
    static final String Numbers = "1234567890";
    static final String Symbols = "!@#$%^&*()-_=+\\/~?";

    static Scanner scanner = new Scanner(System.in); // Initialize Scanner

    static String[] createAlphabet(boolean hasUppers, boolean hasLowers, boolean hasNumbers, boolean hasSymbols) {
        ArrayList<String> Alphabet = new ArrayList<String>();
        if (hasUppers) {
            Alphabet.add(Uppers);
        }
        if (hasLowers) {
            Alphabet.add(Lowers);
        }
        if (hasNumbers) {
            Alphabet.add(Numbers);
        }
        if (hasSymbols) {
            Alphabet.add(Symbols);
        }

        // Add conditions for hasLowers, hasNumbers, and hasSymbols here
        return Alphabet.toArray(new String[0]);
    }

    // Records what alphabet is required for the password
    private static Boolean hasType(String type){
        System.out.println("Do you want to include " + type + "? (true/false)");
        while (!scanner.hasNextBoolean()) {
            System.out.println("Enter true/false!");
            scanner.next(); // this is important!
        }
        return scanner.nextBoolean();
    }

    public static int passLength(String MinOrMax) {
        int number;
        do {
            System.out.println("What is the " + MinOrMax + "? length of the password?");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a positive number!");
                scanner.next(); // this is important!
            }
            number = scanner.nextInt();
        } while (number <= 1);
        return number;
    }

    public static String[] Alphabet() {
        return createAlphabet(hasType("upper case letters"), hasType("lower case letters"), hasType("numbers"), hasType("symbols"));
    }
}
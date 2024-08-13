import java.util.*;

public class Settings {
    static final String Uppers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String Lowers = "abcdefghijklmnopqrstuvwxyz";
    static final String Numbers = "1234567890";
    static final String Symbols = "!@#$%^&*()-_=+\\/~?";
    public static boolean hasUppers = false;
    public static boolean hasLowers = false;
    public static boolean hasNumbers = false;
    public static boolean hasSymbols = false;
    public String[] alphabet;
    public int minLength;
    public int maxLength;
    static Scanner scanner = new Scanner(System.in); // Initialize Scanner

    public Settings(){
        alphabet = Alphabet();
        minLength = passLength("minimum", 1, 100, "Please enter a integer between 1 and 100: ");
        maxLength = passLength("maximum", minLength,100, "Please enter a between " + minLength + " and 100: ");

    }
    static String[] createAlphabet(boolean hasUppers, boolean hasLowers, boolean hasNumbers, boolean hasSymbols) {
        ArrayList<String> Alphabet = new ArrayList<String>();
        if (hasUppers) {
            Alphabet.add(Uppers);
            Settings.hasUppers = true;
        }
        if (hasLowers) {
            Alphabet.add(Lowers);
            Settings.hasLowers = true;
        }
        if (hasNumbers) {
            Alphabet.add(Numbers);
            Settings.hasNumbers = true;
        }
        if (hasSymbols) {
            Alphabet.add(Symbols);
            Settings.hasSymbols = true;
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

    public static int passLength(String MinOrMax, int requiredMin, int requiredMax, String errorMessage) {
        int number;
        System.out.println("What is the " + MinOrMax + " length of the password?");
        do {
            while (!scanner.hasNextInt()) {
                System.out.println(errorMessage);
                scanner.next(); // this is important!
            }
            number = scanner.nextInt();
        } while (number <= requiredMin || number >= requiredMax);
        return number;
    }

    public static String[] Alphabet() {
        return createAlphabet(hasType("upper case letters"), hasType("lower case letters"), hasType("numbers"), hasType("symbols"));
    }
}
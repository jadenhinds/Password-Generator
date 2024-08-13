import java.util.*;

public class Settings {
    static final String Uppers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String Lowers = "abcdefghijklmnopqrstuvwxyz";
    static final String Numbers = "1234567890";
    static final String Symbols = "!@#$%^&*()-_=+\\/~?";
    static List<String> charList = new ArrayList<String>();

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
        return scanner.nextBoolean();
    }

    public static int passLength(String MinOrMax) {
        System.out.println("What is the " + MinOrMax + "? length of the password?");
        return scanner.nextInt();
    }

    public static String[] Alphabet() {
        return createAlphabet(hasType("upper case letters"), hasType("lower case letters"), hasType("numbers"), hasType("symbols"));
    }
}

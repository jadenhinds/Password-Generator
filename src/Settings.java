import java.util.*;

public class Settings {
    static final String Uppers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String Lowers = "abcdefghijklmnopqrstuvwxyz";
    static final String Numbers = "1234567890";
    static final String Symbols = "!@#$%^&*()-_=+\\/~?";
    static List<String> charList = new ArrayList<String>();

    static Scanner scanner = new Scanner(System.in); // Initialize Scanner

    static List<String> createAlphabet(boolean hasUppers, boolean hasLowers, boolean hasNumbers, boolean hasSymbols) {
        if (hasType("upper case letters")) {
            charList.add(Uppers);
        }
        if (hasType("lower case letters")) {
            charList.add(Lowers);
        }
        if (hasType("numbers")) {
            charList.add(Numbers);
        }
        if (hasType("symbols")) {
            charList.add(Symbols);
        }

        // Add conditions for hasLowers, hasNumbers, and hasSymbols here
        System.out.println(Arrays.toString(charList.toArray(new String[0])));
        System.out.println(charList.toString());
        return charList;
    }

    // Records what alphabet is required for the password
    static Boolean hasType(String type){
        System.out.println("Do you want to include " + type + "? (true/false)");
        boolean TrueOrFalse = scanner.nextBoolean();

        scanner.close();

        return TrueOrFalse;
    }

    static int passLength(String MinOrMax) {
        System.out.println("What is the " + MinOrMax + "? length of the password?");
        int length = scanner.nextInt();

        scanner.close();

        return length;
    }
 }

import java.util.*;

public class Settings {
    static final String Uppers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String Lowers = "abcdefghijklmnopqrstuvwxyz";
    static final String Numbers = "1234567890";
    static final String Symbols = "!@#$%^&*()-_=+\\/~?";
    static List<String> charList = new ArrayList<String>();

    static Scanner scanner = new Scanner(System.in); // Initialize Scanner

    static List<String> createAlphabet(boolean hasUppers, boolean hasLowers, boolean hasNumbers, boolean hasSymbols) {
        if (hasUppers) {
            charList.add(Uppers);
        }
        if (hasLowers) {
            charList.add(Lowers);
        }
        if (hasNumbers) {
            charList.add(Numbers);
        }
        if (hasSymbols) {
            charList.add(Symbols);
        }

        // Add conditions for hasLowers, hasNumbers, and hasSymbols here
        System.out.println(Arrays.toString(charList.toArray(new String[0])));
        System.out.println(charList.toString());
        return charList;
    }

    // Records what alphabet is required for the password
    boolean hasType(String type){
        System.out.println(STR."Do you want to include \{type}? (true/false)");
        return scanner.nextBoolean();
    }

    static int[] passLength() {
        int minPassLength;
        int maxPassLength;

        // Records what alphabet is required for the password
        System.out.println("What is the minimum length of the password?");
        minPassLength = scanner.nextBigInteger().intValue();
        System.out.println("What is the maximum length of the password?");
        maxPassLength = scanner.nextBigInteger().intValue();

        scanner.close();

        return new int[]{minPassLength, maxPassLength};
    }
}

import java.util.*;

public class Settings {
    static final String Uppers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String Lowers = "abcdefghijklmnopqrstuvwxyz";
    static final String Numbers = "1234567890";
    static final String Symbols = "!@#$%^&*()-_=+\\/~?";
    static List<String> charList = new ArrayList<String>();

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

    static boolean[] alphabetSettings() {
        Scanner scanner = new Scanner(System.in); // Initilize Scanner

        // Records what alphabet is required for the password
        System.out.println("Do you want to include uppercase letters? (true/false)");
        boolean hasUpper = scanner.nextBoolean();
        System.out.println("Do you want to include lowercase letters? (true/false)");
        boolean hasLower = scanner.nextBoolean();
        System.out.println("Do you want to include numbers? (true/false)");
        boolean hasNumbers = scanner.nextBoolean();
        System.out.println("Do you want to include symbols? (true/false)");
        boolean hasSymbols = scanner.nextBoolean();

        scanner.close();

        return new boolean[] {hasUpper, hasLower, hasNumbers, hasSymbols};
    }
}

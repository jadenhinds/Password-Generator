import java.util.*;

public class Settings {
    final static String Uppers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final static String Lowers = "abcdefghijklmnopqrstuvwxyz";
    final static String Numbers = "1234567890";
    final static String Symbols = "!@#$%^&*()-_=+\\/~?";
    public static boolean hasUppers = false;
    public static boolean hasLowers = false;
    public static boolean hasNumbers = false;
    public static boolean hasSymbols = false;
    public String[] alphabet;
    public int minLength;
    public int maxLength;
    static Scanner scanner = new Scanner(System.in); // Initialize Scanner
    public static boolean mode;

    public Settings(){
        alphabet = Alphabet();
        minLength = passLength("minimum", 4, 100, "Please enter a integer between 1 and 100: ");
        maxLength = passLength("maximum", minLength,100, "Please enter a between " + minLength + " and 100: ");

    }
    public static String[] createAlphabet(boolean hasUppers, boolean hasLowers, boolean hasNumbers, boolean hasSymbols) {
        ArrayList<String> Alphabet = new ArrayList<>();
        if (hasUppers) {
            Alphabet.add(Uppers);
            Settings.hasUppers = true;
        }
        else if (hasLowers) {
            Alphabet.add(Lowers);
            Settings.hasLowers = true;
        }
        else if (hasNumbers) {
            Alphabet.add(Numbers);
            Settings.hasNumbers = true;
        }
        else if (hasSymbols) {
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
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number >= requiredMin && number < requiredMax) { // <-- from "requiredMin" to "requiredMax".
                    return number;
                }
            } else {

                scanner.next();
            }
            System.out.println(errorMessage);
        }
        return requiredMax;
    }

    private void mode() {
        System.out.println("Select Mode: \n Generate New Password (1) \n Validate Password Strength (2)");
        while (!scanner.hasNextBoolean()) {
            System.out.println("Enter 0/1");
            scanner.next(); // this is important!
        }

        mode = scanner.nextBoolean();

        if (mode) {
            PassGenerator.newPassword();
        }
        else {

        }
    }
    public static String[] Alphabet() {
        return createAlphabet(hasType("upper case letters"), hasType("lower case letters"), hasType("numbers"), hasType("symbols"));
    }
}
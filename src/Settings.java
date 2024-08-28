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
    public static String[] alphabet;
    public static int minLength;
    public static int maxLength;
    static Scanner scanner = new Scanner(System.in); // Initialize Scanner
    public static boolean mode;

    public Settings(){
        System.out.println("Select Mode: \n Generate New Password (True) \n Validate Password Strength (False)");
        while (!scanner.hasNextBoolean()) {
            System.out.println("Enter 0/1");
            scanner.next(); // this is important!
        }

        mode = scanner.nextBoolean();

        if (mode) {

            System.out.println("Your password is " + Validate.checkPassword(PassGenerator.newPassword()));
        }
        else {
            new Validate();
        }

    }


    public static String[] createAlphabet(boolean hasUppers, boolean hasLowers, boolean hasNumbers, boolean hasSymbols) {
        ArrayList<String> Alphabet = new ArrayList<>();

        while (!(hasUppers || hasLowers || hasNumbers || hasSymbols)) {
                hasUppers = hasType("upper case letters");
                hasLowers = hasType("lower case letters");
                hasNumbers = hasType("numbers");
                hasSymbols = hasType("symbols");
            }


        if (hasUppers) {
            Alphabet.add(Uppers);
        }
        if (hasLowers) {
            Alphabet.add(Lowers);
        }if (hasNumbers) {
            Alphabet.add(Numbers);
        } if (hasSymbols){
            Alphabet.add(Symbols);
        }
        // Add conditions for hasLowers, hasNumbers, and hasSymbols here
        return Alphabet.toArray(new String[0]);
    }

    // Records what alphabet is required for the password
    private static Boolean hasType(String type){
        System.out.println(STR."Do you want to include \{type}? (true/false)");
        while (!scanner.hasNextBoolean()) {
            System.out.println("Enter true/false!");
            scanner.next(); // this is important!
        }
        return scanner.nextBoolean();
    }

    public static int passLength(String MinOrMax, int requiredMin, int requiredMax, String errorMessage) {
        int number;
        System.out.println(STR."What is the \{MinOrMax} length of the password?");
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

    protected static void mode() {
        alphabet = Alphabet();
        minLength = passLength("minimum", 4, 100, "Please enter a integer between "+ 4+ " and " + 100 + ": ");
        maxLength = passLength("maximum", minLength,100, "Please enter a between " + minLength + " and " + 100 + ": ");
    }
    public static String[] Alphabet() {
        return createAlphabet(Settings.hasUppers, Settings.hasLowers, Settings.hasNumbers, Settings.hasSymbols);
    }
}
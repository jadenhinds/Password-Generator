import java.util.Scanner;

public class Validate {
    private static final String Uppers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String Lowers = "abcdefghijklmnopqrstuvwxyz";
    private static final String Numbers = "1234567890";
    private static final String Symbols = "!@#$%^&*()-_=+\\/~?";

    public static boolean hasUppers = false    ;
    public static boolean hasLowers = false;
    public static boolean hasNumbers = false;
    public static boolean hasSymbols = false;

    public static int passLength = 0;
    public static String quality;
    static Scanner scannerv = new Scanner(System.in); // Initialize Scanner

    public Validate() {
        System.out.println("What password do you want to validate?");
        while (!scannerv.hasNextLine()) {
            scannerv.next(); // this is important!
        }
        System.out.println(STR."Your password is \{checkPassword(scannerv.nextLine())}");
    }

    public static void count(String Pass)  {
        for (int i = 0; i < Pass.length(); i++) {
                if (Uppers.contains(Character.toString(Pass.charAt(i)))) {
                    hasUppers = true;
                }

                else if (Lowers.contains(Character.toString(Pass.charAt(i)))) {
                    hasLowers = true;
                }

                else if (Numbers.contains(Character.toString(Pass.charAt(i)))) {
                    hasNumbers = true;
                }

                else if (Symbols.contains(Character.toString(Pass.charAt(i)))) {
                    hasSymbols = true;
                }
           passLength = Pass.length();
        }

    }

    public static String checkPassword(String Pass) {
        count(Pass);

        if (hasUppers && hasLowers && hasNumbers && hasSymbols && passLength >= 16) {
            quality = "strong";
        }
        else if (!hasUppers || !hasLowers || !hasNumbers || !hasSymbols || passLength <= 8) {
            quality =  "very weak";
        }
        else {
            quality =  "weak";
        }
        return quality;
    }

}

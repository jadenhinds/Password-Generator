import java.util.*;
//j

public class PassGenerator {

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
    static String makePass(String[] alphabet, int minNum, int maxNum) {
        StringBuilder password = new StringBuilder();
        // create instance of Random class
        Random rand = new Random();

        int Length = rand.nextInt(minNum, maxNum);
        for (int i = 0; i < Length; i++) {
            password.append(pickChar(alphabet));
        }
        System.out.println(password);
        return password.toString();
    }

    static char pickChar(String[] alphas){
        // create instance of Random class
        Random rand = new Random();

        // Generate random integers in range 0 to 999
        int rand_int1 = rand.nextInt(0, alphas.length);
        String alphaType = String.valueOf(alphas[rand_int1]);

        int rand_int2 = rand.nextInt(0, alphaType.length());
        char inLetter = alphaType.charAt(rand_int2);

        return inLetter;
    }


    public static void main(String[] args) {
        // Your main method implementation here
        PassGenerator generator = new PassGenerator();

        boolean[] mode = alphabetSettings();

        String[] alphas = createAlphabet(mode[0],mode[1],mode[2],mode[3]).toArray(new String[0]);

        makePass(alphas,7,9 );

    }
} // This closing brace was missing

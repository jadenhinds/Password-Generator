import java.util.*;
//

public class PassGenerator {

    static char pickChar(String[] alphas){
        // create instance of Random class
        char inLetter;
        int rand_int1;
        int rand_int2;
        String alphaType;

        Random rand = new Random();

        // Generate random integers in range 0 to 999
        rand_int1 = rand.nextInt(0, alphas.length);
        alphaType = String.valueOf(alphas[rand_int1]);

        rand_int2 = rand.nextInt(0, alphaType.length());

        inLetter = alphaType.charAt(rand_int2);

        return inLetter;
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

    static String newPassword() {

        boolean[] mode = Settings.alphabetSettings();

        String[] alphas = Settings.createAlphabet(mode[0], mode[1], mode[2], mode[3]).toArray(new String[0]);

        return PassGenerator.makePass(alphas, 7, 9);
    }

} // This closing brace was missing

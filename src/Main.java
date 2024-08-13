public static void main(String[] args) {
    // Your main method implementation here
    PassGenerator generator = new PassGenerator();

    boolean[] mode = Settings.alphabetSettings();

    String[] alphas = Settings.createAlphabet(mode[0],mode[1],mode[2],mode[3]).toArray(new String[0]);

    PassGenerator.makePass(alphas,7,9 );

}
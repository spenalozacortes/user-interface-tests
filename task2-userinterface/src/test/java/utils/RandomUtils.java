package utils;

import java.util.Random;

public class RandomUtils {

    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final int length = 10;

    public static int getRandomInt(int range) {
        Random random = new Random();
        return random.nextInt(range);
    }

    public static String generateRandomPassword(String email) {
        StringBuilder password = new StringBuilder();
        String emailLetter = String.valueOf(email.charAt(getRandomInt(email.length())));

        password.append(UPPER_CASE.charAt(getRandomInt(UPPER_CASE.length())));
        password.append(DIGITS.charAt(getRandomInt(DIGITS.length())));

        for (int i = 2; i < length; i++) {
            int charType = getRandomInt(3);
            switch (charType) {
                case 0:
                    password.append(LOWER_CASE.charAt(getRandomInt(LOWER_CASE.length())));
                    break;
                case 1:
                    password.append(UPPER_CASE.charAt(getRandomInt(UPPER_CASE.length())));
                    break;
                case 2:
                    password.append(DIGITS.charAt(getRandomInt(DIGITS.length())));
                    break;
            }
        }

        return password.toString().concat(emailLetter);
    }

    public static String generateRandomEmail() {
        StringBuilder randomString = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char randomChar = LETTERS.charAt(getRandomInt(LETTERS.length()));
            randomString.append(randomChar);
        }

        return randomString.toString();
    }
}

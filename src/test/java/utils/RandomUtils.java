package utils;

import java.util.Random;

public class RandomUtils {
    private static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";

    public static int getRandomInt(int range) {
        Random random = new Random();
        return random.nextInt(range);
    }

    public static String generateRandomString(int length) {
        StringBuilder randomString = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char randomChar = LETTERS.charAt(getRandomInt(LETTERS.length()));
            randomString.append(randomChar);
        }

        return randomString.toString();
    }

    public static String generateRandomPassword(int passwordLength, String email) {
        StringBuilder password = new StringBuilder();

        password.append(email.charAt(getRandomInt(email.length())));
        password.append(Character.toUpperCase(LETTERS.charAt(getRandomInt(LETTERS.length()))));
        password.append(DIGITS.charAt(getRandomInt(DIGITS.length())));
        password.append(generateRandomString(passwordLength - password.length()));

        return password.toString();
    }
}

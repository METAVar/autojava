import java.util.Random;

public class RandomEmailGenerator {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = LOWERCASE.toUpperCase();
    private static final String NUMBERS = "0123456789";
    private static final String HYPHENS = "-";
    private static final String UNDERSCORES = "_";
    private static final String PERIODS = ".";
    private static final String[] EXTENSIONS = {"com", "net", "org"};
    
    private static final Random random = new Random();

    public static void main(String[] args) {
        String email = generateRandomEmail();
        System.out.println(email);
    }

    private static String generateRandomEmail() {
        String name = generateRandomString(LOWERCASE + UPPERCASE + NUMBERS + HYPHENS, 1, 10) + 
                      "." + 
                      generateRandomString(LOWERCASE + UPPERCASE + NUMBERS + HYPHENS + UNDERSCORES + PERIODS, 1, 10);
        String domain = generateRandomString(LOWERCASE + UPPERCASE + NUMBERS + HYPHENS, 1, 10) +
                        "." +
                        generateRandomString(LOWERCASE + UPPERCASE + NUMBERS + HYPHENS, 1, 10);
        String extension = EXTENSIONS[random.nextInt(EXTENSIONS.length)];
        return name + "@" + domain + "." + extension;
    }

    private static String generateRandomString(String characters, int minLength, int maxLength) {
        int length = minLength + random.nextInt(maxLength - minLength + 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }
}

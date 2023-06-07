package mk.ukim.finki.napredno.auditoriski.aud2.refactor;

public class StringUtils {
    public static String concatenate(String str1, String str2) {
        return str1 + str2;
    }
    public static String capitalizeFirstLetter(String str){
        if (str == null || str.isEmpty())
            return str;
        return capitalizeFirstLetterInternal(str);
    }

    private static String capitalizeFirstLetterInternal(String str) {
        char firstChar = str.charAt(0);
        char capitalizedChar = Character.toUpperCase(firstChar);
        return capitalizedChar + str.substring(1);
    }
    public static void main(String[] args) {
        // Test concatenate method
        String str1 = "Hello";
        String str2 = "World";
        String concatenated = StringUtils.concatenate(str1, str2);
        System.out.println("Concatenated string: " + concatenated);

        // Test capitalizeFirstLetter method
        String inputString = "openai";
        String capitalized = StringUtils.capitalizeFirstLetter(inputString);
        System.out.println("Capitalized string: " + capitalized);
    }
}

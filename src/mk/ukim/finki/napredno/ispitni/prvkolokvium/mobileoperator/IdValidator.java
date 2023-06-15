package mk.ukim.finki.napredno.ispitni.prvkolokvium.mobileoperator;

public class IdValidator {
    public static boolean isValid(String id, int length) {
        return id.length() == length && id.chars().allMatch(Character::isDigit);
    }
}

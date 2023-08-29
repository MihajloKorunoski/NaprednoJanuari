package mk.ukim.finki.napredno.labs.romannumbers;

class RomanConverter {

    private static final int[] values = {
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4, 1
    };

    private static final String[] numerals = {
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV", "I"
    };

    public static String toRoman(int n) {

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length && n > 0; i++){
            while (n >= values[i]){
                n -=values[i];
                result.append(numerals[i]);
            }
        }

        return result.toString();
    }
}

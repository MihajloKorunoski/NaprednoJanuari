package mk.ukim.finki.napredno.auditoriski.aud2.prefix;

import java.util.stream.IntStream;

public class StringPrefix
{
    public static boolean isPrefix(String first, String second){
        if(first.length() > second.length()){
            return false;
        }
        return IntStream.range(0, first.length())
                .allMatch(i -> first.charAt(i) == second.charAt(i));
    }
    public static void testIsPrefix(String first, String second) {
        boolean isPrefix = isPrefix(first, second);

        System.out.println("Is \"" + first + "\" a prefix of \"" + second + "\"? " + isPrefix);
    }
    public static void main(String[] args) {
        testIsPrefix("hello", "helloworld"); // true
        testIsPrefix("world", "helloworld"); // false
        testIsPrefix("abc", "abcdef"); // true
        testIsPrefix("xyz", "abc"); // false
        testIsPrefix("programming", "programmers"); // true
        testIsPrefix("java", "javascript"); // false
        testIsPrefix("", "test"); // true
        testIsPrefix("test", ""); // false
        testIsPrefix("", ""); // true
    }
}
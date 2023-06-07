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
    public static void main(String[] args)
    {
        System.out.println(StringPrefix.isPrefix("test", "testing"));
        System.out.println(isPrefix("test", "apple"));
        System.out.println(isPrefix("test", "tesla")); //test
    }
}
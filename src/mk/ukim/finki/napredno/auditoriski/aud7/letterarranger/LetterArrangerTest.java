package mk.ukim.finki.napredno.auditoriski.aud7.letterarranger;

import java.util.Scanner;

public class LetterArrangerTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(LetterArranger.arrangeSentence(sc.nextLine()));
    }
}

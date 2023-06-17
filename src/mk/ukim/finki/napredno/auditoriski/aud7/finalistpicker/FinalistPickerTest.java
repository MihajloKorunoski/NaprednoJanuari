package mk.ukim.finki.napredno.auditoriski.aud7.finalistpicker;

import java.util.Scanner;

public class FinalistPickerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int finalists = sc.nextInt();
        int prizes = sc.nextInt();
        int solveMethod = sc.nextInt();

        FinalistPicker fp = new FinalistPicker(finalists,solveMethod);

        try {
            System.out.println(fp.pick(prizes));
        } catch (InvalidArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}

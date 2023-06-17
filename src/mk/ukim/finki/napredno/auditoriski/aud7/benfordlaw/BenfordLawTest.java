package mk.ukim.finki.napredno.auditoriski.aud7.benfordlaw;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BenfordLawTest {
    public static void main(String[] args) {
        BenfordLaw benfordLaw = new BenfordLaw();

        try {
            benfordLaw.readData(new FileInputStream("C:\\Users\\mihaj\\Desktop\\Programi\\NaprednoJanuari" +
                    "\\src\\mk\\ukim\\finki\\napredno\\auditoriski\\aud7\\benfordlaw\\Numbers"));
            benfordLaw.conduct();
            System.out.println(benfordLaw);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

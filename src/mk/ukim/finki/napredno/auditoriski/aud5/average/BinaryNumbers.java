package mk.ukim.finki.napredno.auditoriski.aud5.average;

import java.io.*;
import java.util.Random;

public class BinaryNumbers {

    public static final String FILE_NAME = "C:\\Users\\mihaj\\OneDrive\\Desktop\\Projects" +
            "\\NaprednoJanuari\\src\\mk\\ukim\\finki\\napredno" +
            "\\auditoriski\\aud5\\average\\numbers.dat";

    public static void main(String[] args) {
        generateFile(1000);
        System.out.println("Average: " + average());
    }

    private static double average() {
        int count = 0;
        double sum = 0;

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_NAME));
            try{
                while (true){
                    int number = objectInputStream.readInt();
                    sum += number;
                    ++count;
                }
            } catch (EOFException e){
                System.out.println("End of file was reached");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sum / count;
    }

    private static void generateFile(int n) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            Random random = new Random();

            for (int i = 0; i < n; i++) {
                int nextRandom = random.nextInt(1000);
                objectOutputStream.writeInt(nextRandom);
            }
            objectOutputStream.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

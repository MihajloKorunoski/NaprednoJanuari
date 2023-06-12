package mk.ukim.finki.napredno.auditoriski.aud5.wordcounter;

import java.io.*;
import java.util.Scanner;

public class WordCountTest {
    public static void readWithDataScanner(InputStream inputStream) {
        int lines = 0, words = 0, chars = 0;
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            ++lines;
            words += line.split("\\s+").length;
            chars += line.length();
        }

        System.out.printf("Lines: %d\nWords: %d\nChars: %d\n\n", lines, words, chars);
    }

    public static void readDataWithBufferedReader(InputStream inputStream) throws IOException {
        int lines = 0, words = 0, chars = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            ++lines;
            words += line.split("\\s+").length;
            chars += line.length();
        }

        System.out.printf("Lines: %d\nWords: %d\nChars: %d\n\n", lines, words, chars);
    }

    public static void readDataWithBufferedReaderAndMapReduce(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        LineCounter result = bufferedReader.lines()
                .map(LineCounter::new)
                .reduce(new LineCounter(0, 0, 0),
                        LineCounter::sum);
        System.out.println(result);
    }

    public static void readDataWithBufferedReaderAndMapReduce2(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        LineCounter result = bufferedReader.lines()
                .map(line -> new LineCounter(line))
                .reduce(
                        new LineCounter(0, 0, 0),
                        (left, right) -> left.sum(right)
                );
        System.out.println(result);
    }

    public static void readDataWithBufferedReaderAndConsumer(InputStream inputStream){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        LineConsumer lineConsumer = new LineConsumer();
        bufferedReader.lines().forEach(lineConsumer);
        System.out.println(lineConsumer);
    }
    public static void main(String[] args) {
        File file = new File("C:\\Users\\mihaj\\OneDrive\\Desktop" +
                "\\Projects\\NaprednoJanuari\\src\\mk\\ukim\\finki\\napredno" +
                "\\auditoriski\\aud5\\files\\text");

        try {
            readWithDataScanner(new FileInputStream(file));
            readDataWithBufferedReader(new FileInputStream(file));
            readDataWithBufferedReaderAndMapReduce(new FileInputStream(file));
            readDataWithBufferedReaderAndConsumer(new FileInputStream(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

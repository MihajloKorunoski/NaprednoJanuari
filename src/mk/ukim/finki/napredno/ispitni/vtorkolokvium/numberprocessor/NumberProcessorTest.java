package mk.ukim.finki.napredno.ispitni.vtorkolokvium.numberprocessor;

public class NumberProcessorTest {

    public static void main(String[] args) {


        NumberProcessor numberProcessor = new NumberProcessor();

        numberProcessor.readRows(System.in);

        numberProcessor.printMaxFromRows(System.out);


    }
}

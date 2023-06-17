package mk.ukim.finki.napredno.auditoriski.aud7.benfordlaw;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class BenfordLaw {
    private List<Integer> numbers;
    private Counter counter;

    public BenfordLaw() {
        numbers = new ArrayList<>();
        counter = new Counter();
    }

    public void readData(InputStream is){
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        numbers = br.lines()
                .filter(line -> !line.isEmpty())
                .map(line -> line.replaceAll("\\s+",""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    public void conduct(){
        numbers.stream()
                .map(this::getFirstDigit)
                .forEach(counter::countDigit);
    }
    private int getFirstDigit(int number){
        return Integer.parseInt(String.valueOf(number).substring(0,1));
    }

    @Override
    public String toString() {
        return counter.toString();
    }
}

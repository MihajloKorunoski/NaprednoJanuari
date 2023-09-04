package mk.ukim.finki.napredno.exercises.prvkolokvium.mobileoperator;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MobileOperator {

    List<SalesRep> salesReps;

    public void readSalesRepData(InputStream in) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

        salesReps = bufferedReader.lines()
                .map(line -> {
                    try {
                        return SalesRep.createSalesRep(line);
                    } catch (InvalidException e) {
                        System.out.println(e.getMessage());
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        bufferedReader.close();
    }

    public void printSalesReport(PrintStream out) {
        PrintWriter pw = new PrintWriter(out);

        salesReps.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(pw::println);

        pw.flush();
    }
}

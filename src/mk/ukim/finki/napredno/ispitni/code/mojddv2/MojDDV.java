package mk.ukim.finki.napredno.ispitni.code.mojddv2;

import java.io.*;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class MojDDV {
    List<Record> recordList;

    public MojDDV() {
        recordList = new ArrayList<>();
    }

    void readRecords(InputStream inputStream) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));

        recordList = bf.lines().map(i -> {
                    try {
                        return Record.createInstance(i);
                    } catch (AmountNotAllowedException e) {
                        System.out.println(e.getMessage());
                        return null;
                    }
                }).filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    void printTaxReturns(OutputStream outputStream) {
        PrintWriter pw = new PrintWriter(outputStream);
        recordList.forEach(pw::println);
        pw.flush();
    }

    public void printStatistics(OutputStream outputStream) {
        PrintWriter pw = new PrintWriter(outputStream);
        DoubleSummaryStatistics statistics = recordList.stream().mapToDouble(Record::getTaxReturn).summaryStatistics();

        pw.println(String.format("min:\t%-5.3f", statistics.getMin()));
        pw.println(String.format("max:\t%-5.3f", statistics.getMax()));
        pw.println(String.format("sum:\t%-5.3f", statistics.getSum()));
        pw.println(String.format("count:\t%-5d", statistics.getCount()));
        pw.println(String.format("avg:\t%-5.3f", statistics.getAverage()));

        pw.flush();
    }
}

package mk.ukim.finki.napredno.ispitni.code.mojddv1;

import java.io.*;
import java.util.ArrayList;
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
}

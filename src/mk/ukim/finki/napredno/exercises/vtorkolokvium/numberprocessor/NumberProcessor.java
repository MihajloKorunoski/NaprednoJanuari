package mk.ukim.finki.napredno.exercises.vtorkolokvium.numberprocessor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class NumberProcessor {
    List<Row> rowList;

    public NumberProcessor() {
        rowList = new ArrayList<>();
    }

    public void readRows(InputStream in) {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        rowList = br.lines()
                .map(Row::new)
                .collect(Collectors.toList());
    }

    public void printMaxFromRows(OutputStream out) {

        PrintWriter pw = new PrintWriter(out);

        rowList.stream()
                .filter(Row::condition)
                .map(Row::max)
                .forEach(pw::println);
        pw.flush();
        pw.close();
    }
}

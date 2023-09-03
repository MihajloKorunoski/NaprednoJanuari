package mk.ukim.finki.napredno.ispitni.ispitni.iknowonlinepayments;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class OnlinePayments {
    List<Item> itemList;

    public OnlinePayments() {
        itemList = new ArrayList<>();
    }

    public void readItems(InputStream inputStream) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(";");
                itemList.add(new Item(parts[0], parts[1], Integer.parseInt(parts[2])));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printStudentReport(String index, OutputStream outputStream) {
        PrintWriter pw = new PrintWriter(outputStream);

        List<Item> studentItems = itemList.stream()
                .filter(item -> item.getStudentIndex().equals(index))
                .sorted(Comparator.comparing(Item::getPrice).reversed())
                .collect(Collectors.toList());

        if (studentItems.isEmpty()) {
            pw.println("Student " + index + " not found!");
        } else {
            int netSum = studentItems.stream().mapToInt(Item::getPrice).sum();
            double provision = Math.round(netSum * 0.0114);

            provision = Math.min(300, Math.max(3, provision));

            pw.println(String.format("Student: %s Net: %d Fee: %.0f Total %.0f", index, netSum, provision, netSum +provision));
            pw.println("Items:");

            AtomicInteger counter = new AtomicInteger(1);
            studentItems.forEach(item -> pw.println(String.format("%d. %s %d",counter.getAndIncrement(),
                    item.getItemName(),
                    item.getPrice())));
        }
        pw.flush();
    }
}

package mk.ukim.finki.napredno.ispitni.prvkolokvium.postoffice;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class PostOffice {
    String name;
    String city;
    List<Package> packageList;

    public PostOffice(String name, String city) {
        this.name = name;
        this.city = city;
        packageList = new ArrayList<>();
    }

    public void loadPackages(Reader reader) throws InvalidPackageException, IOException {
        try (BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    break; // Exit the loop if an empty line is encountered
                }
                packageList.add(PackageFactory.createPackage(line));
            }
        }
    }

    public boolean addPackage(Package p) {
        return packageList.add(p);
    }


    public Package mostExpensive() {
        return packageList.stream()
                .max(Comparator.comparingDouble(Package::price))
                .orElse(null);
    }

    public void printPackages(OutputStream out) {
        PrintWriter pw = new PrintWriter(out);
        packageList.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(pw::println);
        pw.flush();
    }

}

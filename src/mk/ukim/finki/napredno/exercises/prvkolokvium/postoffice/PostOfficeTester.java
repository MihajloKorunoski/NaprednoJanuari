package mk.ukim.finki.napredno.exercises.prvkolokvium.postoffice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PostOfficeTester {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            PostOffice office = new PostOffice("Poshta", "Skopje");

            // Load packages
            office.loadPackages(br);

            // Print all packages
            System.out.println("======Packages======");
            office.printPackages(System.out);
            System.out.println();

            // Add a new local package
            Package localPackage = new LocalPackage("John", "Main St.", 123, 10, false);
            office.addPackage(localPackage);

            // Add a new international package
            Package internationalPackage = new InternationalPackage("Jane", "Park Ave.", 456, 20, "Europe");
            office.addPackage(internationalPackage);

            // Add a new group package
            GroupPackage groupPackage = new GroupPackage("Group", "Address", 789);
            groupPackage.addPackage(localPackage);
            groupPackage.addPackage(internationalPackage);
            office.addPackage(groupPackage);

            // Print all packages after adding the group package
            System.out.println("======Updated Packages======");
            office.printPackages(System.out);
            System.out.println();

            // Find the most expensive package
            System.out.println("======Most Expensive Package======");
            Package mostExpensive = office.mostExpensive();
            System.out.println(mostExpensive);
        } catch (IOException e) {
            System.out.println("An error occurred while reading input: " + e.getMessage());
        } catch (InvalidPackageException e) {
            System.out.println("Invalid package: " + e.getMessage());
        }
    }

}
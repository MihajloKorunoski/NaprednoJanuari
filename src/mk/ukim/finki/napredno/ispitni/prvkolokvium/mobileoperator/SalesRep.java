package mk.ukim.finki.napredno.ispitni.prvkolokvium.mobileoperator;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class SalesRep implements Comparable<SalesRep> {
    String id;
    List<Customer> customers;


    public SalesRep(String id, List<Customer> customers) {
        this.id = id;
        this.customers = customers;
    }

    public static SalesRep createSalesRep(String line) throws InvalidException {
        String[] parts = line.split("\\s+");
        String id = parts[0];
        if (!IdValidator.isValid(id, 3)) {
            throw new InvalidException(String.format("%s is not a valid sales rep ID", id));
        }
        List<Customer> customers = new ArrayList<>();

        for (int i = 1; i < parts.length; i += 5) {
            String customerId = parts[i];
            String type = parts[i + 1];
            double minutes = Double.parseDouble(parts[i + 2]);
            int sms = Integer.parseInt(parts[i + 3]);
            double gbs = Double.parseDouble(parts[i + 4]);
            try{
                if (type.equals("M")) {
                    customers.add(new MCustomer(customerId, minutes, sms, gbs));
                } else
                    customers.add(new SCustomer(customerId, minutes, sms, gbs));
            } catch (InvalidException e){
                System.out.println(e.getMessage());
            }


        }
        return new SalesRep(id, customers);
    }

    private double totalCommission() {
        return customers.stream()
                .mapToDouble(Customer::commission)
                .sum();
    }

    @Override
    public String toString() {
        DoubleSummaryStatistics doubleSummaryStatistics = customers.stream()
                .mapToDouble(Customer::totalPrice)
                .summaryStatistics();

        return String.format("%s Count: %d Min: %.2f Average: %.2f Max: %.2f Commission: %.2f",
                id,
                doubleSummaryStatistics.getCount(),
                doubleSummaryStatistics.getMin(),
                doubleSummaryStatistics.getAverage(),
                doubleSummaryStatistics.getMax(),
                totalCommission());
    }

    @Override
    public int compareTo(SalesRep o) {
        return Double.compare(totalCommission(), o.totalCommission());
    }
}



















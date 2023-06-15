package mk.ukim.finki.napredno.ispitni.prvkolokvium.mobileoperator;

import java.io.IOException;

public class MobileOperatorTest {
    public static void main(String[] args) {
        MobileOperator mobileOperator = new MobileOperator();
        System.out.println("---- READING OF THE SALES REPORTS ----");
        try {
            mobileOperator.readSalesRepData(System.in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("---- PRINTING FINAL REPORTS FOR SALES REPRESENTATIVES ----");
        mobileOperator.printSalesReport(System.out);
    }
}

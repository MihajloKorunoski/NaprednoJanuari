package mk.ukim.finki.napredno.exercises.prvkolokvium.mobileoperator;

public class SCustomer extends Customer {


    static double BASE_PRICE_S = 500.0;

    static double FREE_MINUTES_S = 100;
    static int FREE_SMS_S = 50;
    static double FREE_GB_INTERNET_S = 5.0;

    static double PRICE_PER_MINUTES = 5.0;
    static double PRICE_PER_SMS = 6.0;
    static double PRICE_PER_GB = 25.0;

    static double COMMISSION_RATE = 0.07;

    public SCustomer(String id, double minutes, int messages, double gbs) throws InvalidException {
        super(id, minutes, messages, gbs);
    }

    @Override
    double totalPrice() {
        double total = BASE_PRICE_S;
        total += PRICE_PER_MINUTES * Math.max(0, minutes - FREE_MINUTES_S);
        total += PRICE_PER_SMS * Math.max(0, messages - FREE_SMS_S);
        total += PRICE_PER_GB * Math.max(0, gbs - FREE_GB_INTERNET_S);
        return total;
    }

    @Override
    double commission() {
        return totalPrice() * COMMISSION_RATE;
    }
}

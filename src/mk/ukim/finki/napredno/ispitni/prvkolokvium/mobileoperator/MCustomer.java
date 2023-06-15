package mk.ukim.finki.napredno.ispitni.prvkolokvium.mobileoperator;

public class MCustomer extends Customer {


    static double BASE_PRICE_M = 750.0;

    static double FREE_MINUTES_M = 150;
    static int FREE_SMS_M = 60;
    static double FREE_GB_INTERNET_M = 10.0;

    static double PRICE_PER_MINUTES = 4.0;
    static double PRICE_PER_SMS = 4.0;
    static double PRICE_PER_GB = 20.0;

    static double COMMISSION_RATE = 0.04;

    public MCustomer(String id, double minutes, int messages, double gbs) throws InvalidException {
        super(id, minutes, messages, gbs);
    }

    @Override
    double totalPrice() {
        double total = BASE_PRICE_M;
        total += PRICE_PER_MINUTES * Math.max(0, minutes - FREE_MINUTES_M);
        total += PRICE_PER_SMS * Math.max(0, messages - FREE_SMS_M);
        total += PRICE_PER_GB * Math.max(0, gbs - FREE_GB_INTERNET_M);
        return total;
    }

    @Override
    double commission() {
        return totalPrice() * COMMISSION_RATE;
    }
}


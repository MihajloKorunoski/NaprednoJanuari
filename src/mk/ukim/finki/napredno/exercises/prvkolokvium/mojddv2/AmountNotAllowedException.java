package mk.ukim.finki.napredno.exercises.prvkolokvium.mojddv2;

class AmountNotAllowedException extends Exception{
    public AmountNotAllowedException(int sum) {
        super(String.format("Receipt with amount %d is not allowed to be scanned", sum));
    }
}

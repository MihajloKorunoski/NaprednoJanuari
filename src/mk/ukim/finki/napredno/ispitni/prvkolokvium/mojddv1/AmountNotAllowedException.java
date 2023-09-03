package mk.ukim.finki.napredno.ispitni.prvkolokvium.mojddv1;

class AmountNotAllowedException extends Exception{
    public AmountNotAllowedException(int sum) {
        super(String.format("Receipt with amount %d is not allowed to be scanned", sum));
    }
}

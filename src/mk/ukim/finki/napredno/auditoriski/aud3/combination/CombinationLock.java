package mk.ukim.finki.napredno.auditoriski.aud3.combination;

public class CombinationLock {
    private int combination;
    private boolean isOpen;
    private static int DEFAULT_COMBINATION = 100;

    public CombinationLock(int combination) {
        if (isValidCombination(combination))
            this.combination = combination;
        else
            this.combination = 100;
    }

    private boolean isValidCombination(int combination) {
        return combination >= 100 && combination <= 999;
    }

    public boolean open(int combination) {
        isOpen = (this.combination == combination);
        return isOpen;
    }

    public boolean changeCombination(int oldCombination, int newCombination) {
        if (open(oldCombination) && isValidCombination(newCombination)) {
            combination = newCombination;
            return true;
        }
        return false;
    }

    public void lock() {
        isOpen = false;
    }
}

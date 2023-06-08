package mk.ukim.finki.napredno.auditoriski.aud3.combination;

public class CombinationLockTest {
    public static void main(String[] args) {
        // Test 1: Create a combination lock with a valid combination
        CombinationLock lock1 = new CombinationLock(345);
        System.out.println("Combination lock 1 created with combination 345.");

        // Test 2: Try to open the lock with the correct combination
        boolean isOpen = lock1.open(345);
        System.out.println("Lock 1 opened successfully: " + isOpen);

        // Test 3: Try to open the lock with an incorrect combination
        isOpen = lock1.open(123);
        System.out.println("Lock 1 opened successfully: " + isOpen);

        // Test 4: Change the combination of the lock
        boolean isCombinationChanged = lock1.changeCombination(345, 789);
        System.out.println("Combination of lock 1 changed successfully: " + isCombinationChanged);

        // Test 5: Try to change the combination with an incorrect old combination
        isCombinationChanged = lock1.changeCombination(111, 222);
        System.out.println("Combination of lock 1 changed successfully: " + isCombinationChanged);

        // Test 6: Try to change the combination with an invalid new combination
        isCombinationChanged = lock1.changeCombination(789, 50);
        System.out.println("Combination of lock 1 changed successfully: " + isCombinationChanged);

        // Test 7: Lock the lock
        lock1.lock();
        System.out.println("Lock 1 is locked.");

        // Test 8: Create a combination lock with an invalid combination
        CombinationLock lock2 = new CombinationLock(50);
        System.out.println("Combination lock 2 created with combination 50.");

        // Test 9: Try to open the lock with the correct combination
        isOpen = lock2.open(50);
        System.out.println("Lock 2 opened successfully: " + isOpen);

        // Test 10: Try to change the combination with an invalid new combination
        isCombinationChanged = lock2.changeCombination(50, 1000);
        System.out.println("Combination of lock 2 changed successfully: " + isCombinationChanged);
    }
}

package mk.ukim.finki.napredno.exercises.vtorkolokvium.phonebook;

class DuplicateNumberException extends Exception{
    public DuplicateNumberException(String number) {
        super(String.format("Duplicate number: %s",number));
    }
}

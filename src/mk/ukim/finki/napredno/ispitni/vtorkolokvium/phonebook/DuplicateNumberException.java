package mk.ukim.finki.napredno.ispitni.vtorkolokvium.phonebook;

class DuplicateNumberException extends Exception{
    public DuplicateNumberException(String number) {
        super(String.format("Duplicate number: %s",number));
    }
}

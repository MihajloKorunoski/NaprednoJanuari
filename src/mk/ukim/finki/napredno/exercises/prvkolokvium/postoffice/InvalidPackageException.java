package mk.ukim.finki.napredno.exercises.prvkolokvium.postoffice;

public class InvalidPackageException extends Exception{
    public InvalidPackageException() {
    }

    public InvalidPackageException(String message) {
        super(message);
    }
}

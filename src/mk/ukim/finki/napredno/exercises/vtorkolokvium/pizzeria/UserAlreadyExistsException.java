package mk.ukim.finki.napredno.exercises.vtorkolokvium.pizzeria;

class UserAlreadyExistsException extends Exception{
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}

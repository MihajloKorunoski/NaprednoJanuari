package mk.ukim.finki.napredno.ispitni.vtorkolokvium.pizzeria;

class UserAlreadyExistsException extends Exception{
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}

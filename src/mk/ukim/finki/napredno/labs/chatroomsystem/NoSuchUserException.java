package mk.ukim.finki.napredno.labs.chatroomsystem;

class NoSuchUserException extends Exception{
    public NoSuchUserException(String userName) {
        super("No such user: " + userName);
    }
}

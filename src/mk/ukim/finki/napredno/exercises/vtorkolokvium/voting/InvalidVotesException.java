package mk.ukim.finki.napredno.exercises.vtorkolokvium.voting;

class InvalidVotesException extends Exception {

    public InvalidVotesException() {
        super("Invalid votes: The provided vote count is not valid.");
    }
}
package mk.ukim.finki.napredno.labs.chatroomsystem;

class NoSuchRoomException extends Exception {
    public NoSuchRoomException(String roomName) {
        super("No such room: " + roomName);
    }
}

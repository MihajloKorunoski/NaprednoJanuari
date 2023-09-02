package mk.ukim.finki.napredno.labs.chatroomsystem;

import java.util.TreeSet;

class ChatRoom {

    private String name;
    private TreeSet<String> users;

    public ChatRoom(String name) {
        this.name = name;
        users = new TreeSet<>();
    }

    public void addUser(String username) {
        users.add(username);
    }

    public void removeUser(String username) {
        users.remove(username);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("\n");
        if (users.isEmpty())
            sb.append("EMPTY\n");
        else
            for (String user : users)
                sb.append(user).append("\n");
        sb.append("\n");
        return sb.toString();
    }

    public boolean hasUser(String username) {
        return users.contains(username);
    }

    public int numUsers() {
        return users.size();
    }
}

package mk.ukim.finki.napredno.labs.chatroomsystem;

import java.util.*;

class ChatSystem {

    TreeMap<String, ChatRoom> rooms;
    TreeSet<String> users;

    public ChatSystem() {
        rooms = new TreeMap<>();
        users = new TreeSet<>();
    }

    public void addRoom(String roomName) {
        rooms.put(roomName, new ChatRoom(roomName));
    }

    public void removeRoom(String roomName) {
        rooms.remove(roomName);
    }

    public ChatRoom getRoom(String roomName) throws NoSuchRoomException {
        if (!rooms.containsKey(roomName))
            throw new NoSuchRoomException(roomName);
        return rooms.get(roomName);
    }

    public void register(String userName) {
        users.add(userName);
        Optional<Map.Entry<String, ChatRoom>> roomEntry = rooms.entrySet()
                .stream().min(Comparator.comparing(e -> e.getValue().numUsers()));
        if (roomEntry.isPresent())
            roomEntry.get().getValue().addUser(userName);
    }

    public void registerAndJoin(String userName, String roomName) throws NoSuchRoomException {
        users.add(userName);
        if (!rooms.containsKey(roomName))
            throw new NoSuchRoomException(roomName);
        rooms.get(roomName).addUser(userName);
    }

    public void joinRoom(String userName, String roomName) throws NoSuchRoomException, NoSuchUserException {
        if (!rooms.containsKey(roomName))
            throw new NoSuchRoomException(roomName);
        if (!users.contains(userName))
            throw new NoSuchUserException(userName);
        rooms.get(roomName).addUser(userName);
    }

    public void leaveRoom(String userName, String roomName) throws NoSuchRoomException, NoSuchUserException {
        if (!rooms.containsKey(roomName))
            throw new NoSuchRoomException(roomName);
        if (!users.contains(userName))
            throw new NoSuchUserException(userName);
        rooms.get(roomName).removeUser(userName);
    }

    public void followFriend(String userName, String friend_username) throws NoSuchUserException {
        if (!users.contains(userName))
            throw new NoSuchUserException(userName);
        if (!users.contains(friend_username))
            throw new NoSuchUserException(friend_username);

        for (Map.Entry<String, ChatRoom> roomEntry : rooms.entrySet())
            if(roomEntry.getValue().hasUser(friend_username))
                roomEntry.getValue().addUser(userName);
    }
}

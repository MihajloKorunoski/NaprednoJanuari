package mk.ukim.finki.napredno.ispitni.vtorkolokvium.pizzeria;

class User {
    String email;
    String name;
    String phoneNumber;
    int id;
    static int ID_COUNTER = 1;

    public User(String email, String name, String phoneNumber, int id) {
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }
}

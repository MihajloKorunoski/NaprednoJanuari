package mk.ukim.finki.napredno.exercises.vtorkolokvium.pizzeria;

class User {
    private String email;
    private String name;
    private String phoneNumber;
    private int id;
    private static int ID_COUNTER = 1;

    public User(String email, String name, String phoneNumber) {
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        id = ID_COUNTER++;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getId() {
        return id;
    }
}

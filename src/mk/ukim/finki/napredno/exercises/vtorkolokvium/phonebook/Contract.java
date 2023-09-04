package mk.ukim.finki.napredno.exercises.vtorkolokvium.phonebook;


class Contract implements Comparable<Contract> {
    String name;
    String number;

    public Contract(String name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("%s %s", name, number);
    }

    @Override
    public int compareTo(Contract secondContact) {
        if (name.equals(secondContact.name))
            return number.compareTo(secondContact.number);
        return name.compareTo(secondContact.name);
    }
}

package mk.ukim.finki.napredno.labs.contacts;

abstract class Contact implements Comparable<Contact> {
    protected String date;

    public Contact(String date) {
        this.date = date;
    }

    public boolean isNewerThan(Contact c) {
        return this.date.compareTo(c.date) > 0;
    }

    public abstract String quoted();

    public abstract String getType();

    @Override
    public int compareTo(Contact o) {
        return o.date.compareTo(this.date);
    }
}

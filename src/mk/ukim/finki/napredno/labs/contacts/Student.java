package mk.ukim.finki.napredno.labs.contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

class Student {
    private String firstName;
    private String lastname;
    private String city;
    private int age;
    private long index;

    private List<Contact> contacts;

    public Student(String firstName, String lastname, String city, int age, long index) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.city = city;
        this.age = age;
        this.index = index;
        contacts = new ArrayList<>();
    }

    public String getCity() {
        return city;
    }

    public long getIndex() {
        return index;
    }

    public int getContactsSize() {
        return contacts.size();
    }

    public String getFullName() {
        return firstName + " " + lastname;
    }

    public void addEmailContact(String date, String email) {
        contacts.add(new EmailContact(date, email));
    }

    public void addPhoneContact(String date, String phone) {
        contacts.add(new PhoneContact(date, phone));
    }

    public List<Contact> getFiltered(String type) {
        return contacts.stream()
                .filter(each -> each.getType().equals(type))
                .collect(Collectors.toList());
    }

    public List<Contact> getEmailContacts() {
        return getFiltered("Email");
    }

    public List<Contact> getPhoneContacts() {
        return getFiltered("Phone");
    }

    public Contact getLatestContact() {
        return contacts.stream()
                .sorted()
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");

        String phonesString = getPhoneContacts().stream()
                .map(Contact::quoted)
                .collect(Collectors.joining(", ", "[", "]"));

        String emailsString = getEmailContacts().stream()
                .map(Contact::quoted)
                .collect(Collectors.joining(", ", "[", "]"));

        joiner.add(keyValue("ime", firstName))
                .add(keyValue("prezime", lastname))
                .add(keyValueNoQuotes("vozrast", String.valueOf(age)))
                .add(keyValue("grad", city))
                .add(keyValueNoQuotes("indeks", String.valueOf(index)))
                .add(keyValueNoQuotes("telefonskiKontakti", phonesString))
                .add(keyValueNoQuotes("emailKontakti", emailsString));
        return joiner.toString();
    }

    public static String keyValue(String key, String value) {
        return String.format("\"%s\":\"%s\"", key, value);
    }

    public static String keyValueNoQuotes(String key, String value) {
        return String.format("\"%s\":%s", key, value);
    }
}

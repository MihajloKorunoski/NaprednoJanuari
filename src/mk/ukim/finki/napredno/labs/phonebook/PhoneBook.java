package mk.ukim.finki.napredno.labs.phonebook;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class PhoneBook {

    private final static int MAX_SIZE = 250;
    private List<Contact> contactList;

    public PhoneBook() {
        contactList = new ArrayList<>();
    }

    public static boolean saveAsTextFile(PhoneBook phonebook, String textFile) {
        try (PrintWriter out = new PrintWriter(new File(textFile))) {
            out.println(phonebook.toString());
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public static PhoneBook loadFromTextFile(String textFile) throws IOException, InvalidFormatException {
        List<String> lines = Files.readAllLines(Paths.get(textFile), StandardCharsets.UTF_8);

        PhoneBook res = new PhoneBook();

        StringBuilder sb = new StringBuilder();

        for (String line : lines) {
            if (line.isEmpty()) {
                if (sb.length() > 0) {
                    try {
                        res.addContact(Contact.valueOf(sb.toString()));
                    } catch (InvalidNameException | MaximumSizeExceddedException e) {
                        throw new InvalidFormatException();
                    }
                    sb.setLength(0);
                }
            } else {
                sb.append(line).append('\n');
            }
        }
        if (sb.length() > 0)
            try {
                res.addContact(Contact.valueOf(sb.toString()));
            } catch (InvalidNameException | MaximumSizeExceddedException e) {
                throw new InvalidFormatException();
            }
        return res;

    }

    public void addContact(Contact contact) throws InvalidNameException, MaximumSizeExceddedException {
        if (getContactForName(contact.getName()) != null)
            throw new InvalidNameException(contact.getName(), InvalidNameException.Reason.NOT_UNIQUE);
        if (contactList.size() >= MAX_SIZE)
            throw new MaximumSizeExceddedException(MAX_SIZE);
        contactList.add(contact);
    }

    public Contact getContactForName(String name) {
        return contactList.stream()
                .filter(contact -> contact.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public boolean removeContact(String name) {
        Contact toRemove = getContactForName(name);
        if (toRemove != null)
            return contactList.remove(toRemove);
        return false;
    }

    public int numberOfContacts() {
        return contactList.size();
    }


    public List<Contact> getContacts() {
        return contactList.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Contact> getContactsForNumber(String s) {
        return contactList.stream()
                .filter(contact -> contact.hasPhoneNumberThatStartsWith(s))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return contactList.stream()
                .map(Contact::toString)
                .sorted()
                .collect(Collectors.joining("\n")) + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBook phoneBook = (PhoneBook) o;
        return Objects.equals(contactList, phoneBook.contactList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactList);
    }
}

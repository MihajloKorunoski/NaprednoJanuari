package mk.ukim.finki.napredno.ispitni.vtorkolokvium.phonebook;

import java.util.*;

class PhoneBook {

    private Set<String> uniquePhoneNumbers;
    private Map<String, Set<Contract>> contactsbyname;
    private TreeMap<String, Set<Contract>> contactByNumber;

    public PhoneBook() {
        uniquePhoneNumbers = new HashSet<>();
        contactsbyname = new HashMap<>();
        contactByNumber = new TreeMap<>();
    }

    public void addContact(String name, String number) throws DuplicateNumberException {
        Contract contact = new Contract(name, number);
        if (uniquePhoneNumbers.contains(number))
            throw new DuplicateNumberException(number);
        else
            uniquePhoneNumbers.add(number);

        contactsbyname.putIfAbsent(name, new TreeSet<>());
        contactsbyname.get(name).add(contact);
        contactByNumber.computeIfAbsent(number, k -> new TreeSet<>()).add(contact);
    }

    public void contactsByNumber(String number) {
        if (number.length() < 3) {
            System.out.println("Invalid number length");
            return;
        }

        List<Contract> matchingContacts = new ArrayList<>();

        for (String contactNumber : contactByNumber.keySet()) {
            if (contactNumber.contains(number)) {
                Set<Contract> contacts = contactByNumber.get(contactNumber);
                matchingContacts.addAll(contacts);
            }
        }

        if (matchingContacts.isEmpty()) {
            System.out.println("No contacts found");
            return;
        }

        matchingContacts.sort(Contract::compareTo);
        matchingContacts.forEach(System.out::println);
    }

    public void contactsByName(String name) {
        if (!contactsbyname.containsKey(name))
            System.out.println("NOT FOUND");
        else {
            Set<Contract> contracts = contactsbyname.get(name);
            contracts.forEach(System.out::println);
        }
    }
}

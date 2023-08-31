package mk.ukim.finki.napredno.labs.phonebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class Contact implements Comparable<Contact>{

    final static int MIN_NAME_LENGTH = 4;
    final static int MAX_NAME_LENGTH = 10;
    final static int MAX_SIZE = 5;
    private String name;
    private List<String> numbers;

    public Contact(String name, String... phonenumber)
            throws InvalidNameException, InvalidNumberException, MaximumSizeExceddedException {
        validateName(name);
        this.name = name;

        numbers = new ArrayList<>();

        for (String number : phonenumber) {
            addNumber(number);
        }
    }

    public void validateName(String name) throws InvalidNameException {
        if (name.length() <= MIN_NAME_LENGTH || name.length() >= MAX_NAME_LENGTH)
            throw new InvalidNameException(name, InvalidNameException.Reason.INVALID_SIZE);
        for (char c : name.toCharArray()) {
            if (!Character.isLetterOrDigit(c))
                throw new InvalidNameException(name, InvalidNameException.Reason.INVALID_CHARACTER);
        }
    }

    public String getName() {
        return name;
    }

    public List<String> getNumbers() {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public void addNumber(String number) throws InvalidNumberException, MaximumSizeExceddedException {
        if (!isValidNumber(number)) {
            throw new InvalidNumberException(number);
        }
        if (numbers.size() >= MAX_SIZE) {
            throw new MaximumSizeExceddedException(MAX_SIZE);
        }

        numbers.add(number);
    }

    private static boolean isValidNumber(String number) {
        return number != null && number.matches("07[0-2,5-8][0-9]{6}");
    }

    @Override
    public String toString() {
        String numbersString = String.join("\n", getNumbers());
        return String.format("%s\n%d\n%s\n", name, numbers.size(), numbersString);
    }

    public static Contact valueOf(String s) throws  InvalidFormatException {
        String[] lines = s.split("\n");

        if (lines.length < 2)
            throw new InvalidFormatException();

        try {
            return new Contact(lines[0], Arrays.copyOfRange(lines, 2, lines.length));
        } catch (InvalidNameException | InvalidNumberException | MaximumSizeExceddedException e) {
            throw new InvalidFormatException();
        }
    }

    @Override
    public int compareTo(Contact o) {
        return name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) && Objects.equals(numbers, contact.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numbers);
    }

    public boolean hasPhoneNumberThatStartsWith(String number_start){
        return numbers.stream()
                .anyMatch(number -> number.startsWith(number_start));
    }
}

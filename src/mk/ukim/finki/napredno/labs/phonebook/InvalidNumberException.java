package mk.ukim.finki.napredno.labs.phonebook;

class InvalidNumberException extends Exception{

    String number;
    public InvalidNumberException(String number) {
        this.number = number;
    }

    public String getNumber(){
        return number;
    }
}

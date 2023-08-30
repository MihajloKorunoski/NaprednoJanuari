package mk.ukim.finki.napredno.labs.contacts;

class EmailContact extends Contact{
    private String email;

    public EmailContact(String date, String email) {
        super(date);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String quoted() {
        return String.format("\"%s\"", email);
    }

    @Override
    public String getType() {
        return "Email";
    }
}

package mk.ukim.finki.napredno.labs.phonebook;

class MaximumSizeExceddedException extends Exception{

    int max_size;

    public MaximumSizeExceddedException(int max_size) {
        this.max_size = max_size;
    }

    public int getMax_size() {
        return max_size;
    }
}

package mk.ukim.finki.napredno.labs.mp3player;

class Song {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Song{title=" + title + ", artist=" + artist + "}";
    }
}

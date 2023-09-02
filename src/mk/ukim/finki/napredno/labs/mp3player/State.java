package mk.ukim.finki.napredno.labs.mp3player;

interface State {
    void play();
    void stop();
    void fwd();
    void rew();
}

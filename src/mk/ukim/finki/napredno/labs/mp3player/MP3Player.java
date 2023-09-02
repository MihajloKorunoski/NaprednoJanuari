package mk.ukim.finki.napredno.labs.mp3player;

import java.util.List;

class MP3Player {
    private List<Song> songs;
    int currentSongIndex = 0;
    private State playingsState;
    private State pausedState;
    private State stoppedState;
    private State currentState;

    public MP3Player(List<Song> songs) {
        this.songs = songs;

        playingsState = new PlayingState(this);
        pausedState = new PausedState(this);
        stoppedState = new StoppedState(this);

        currentState = stoppedState;
    }

    public void pressPlay() {
        currentState.play();
    }

    public void printCurrentSong() {
        Song printSong = songs.get(currentSongIndex);
        System.out.println(printSong);
    }

    public void pressFWD() {
        currentState.fwd();
    }

    public void pressStop() {
        currentState.stop();
    }

    public void pressREW() {
        currentState.rew();
    }

    public void moveToNextSong(){
        currentSongIndex = (currentSongIndex + 1) % songs.size();
    }
    public void moveToPrevSong(){
        currentSongIndex =(currentSongIndex - 1 + songs.size()) % songs.size();
    }

    public State getPlayingsState() {
        return playingsState;
    }

    public State getPausedState() {
        return pausedState;
    }

    public State getStoppedState() {
        return stoppedState;
    }

    public void setState(State state){
        currentState = state;
    }

    public void resetSongs(){
        currentSongIndex = 0;
    }

    @Override
    public String toString() {
        return "MP3Player{currentSong = " + currentSongIndex + ", songList = " + songs + "}";
    }
}

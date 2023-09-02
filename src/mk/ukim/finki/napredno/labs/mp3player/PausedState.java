package mk.ukim.finki.napredno.labs.mp3player;

class PausedState implements State{

    private MP3Player player;

    public PausedState(MP3Player mp3Player) {
        player = mp3Player;
    }

    @Override
    public void play() {
        System.out.println("Song "+ player.currentSongIndex + " is playing");
        player.setState(player.getPlayingsState());
    }

    @Override
    public void stop() {
        System.out.println("Songs are stopped");
        player.resetSongs();
        player.setState(player.getStoppedState());
    }

    @Override
    public void fwd() {
        player.moveToNextSong();
        System.out.println("Forward...");
    }

    @Override
    public void rew() {
        player.moveToPrevSong();
        System.out.println("Reward...");
    }
}

package mk.ukim.finki.napredno.labs.mp3player;

class StoppedState implements State{

    private MP3Player player;
    public StoppedState(MP3Player mp3Player) {
        player = mp3Player;
    }

    @Override
    public void play() {
        System.out.println("Song "+ player.currentSongIndex + " is playing");
        player.setState(player.getPlayingsState());
    }

    @Override
    public void stop() {
        System.out.println("Songs are already stopped");
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

package mk.ukim.finki.napredno.labs.mp3player;

class PlayingState implements State{
    private MP3Player player;
    public PlayingState(MP3Player mp3Player) {
        player = mp3Player;
    }

    @Override
    public void play() {
        System.out.println("Song is already playing");
    }

    @Override
    public void stop() {
        System.out.println("Song "+ player.currentSongIndex + " is paused");
        player.setState(player.getPausedState());
    }

    @Override
    public void fwd() {
        player.setState(player.getPausedState());
        player.moveToNextSong();
        System.out.println("Forward...");
    }

    @Override
    public void rew() {
        player.setState(player.getPausedState());
        player.moveToPrevSong();
        System.out.println("Reward...");
    }
}

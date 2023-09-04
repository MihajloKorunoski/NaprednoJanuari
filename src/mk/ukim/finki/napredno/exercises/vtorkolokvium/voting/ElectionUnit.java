package mk.ukim.finki.napredno.exercises.vtorkolokvium.voting;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class ElectionUnit {
    private int unit;
    private Map<String, Integer> registeredVotesByPoll;
    private List<Subscriber> subscribers;

    public int getUnit() {
        return unit;
    }

    public ElectionUnit(int unit, Map<String, Integer> registeredVotesByPoll) {
        this.unit = unit;
        this.registeredVotesByPoll = registeredVotesByPoll;
        subscribers = new ArrayList<>();
    }

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    void addVotes(String pollId, String party, int votes) {
        subscribers.forEach(subscriber -> subscriber.updateVotes(
                this.unit,
                pollId,
                party,
                votes,
                registeredVotesByPoll.get(pollId),
                registeredVotesByPoll.values().stream().mapToInt(i -> i).sum()
        ));
    }
}

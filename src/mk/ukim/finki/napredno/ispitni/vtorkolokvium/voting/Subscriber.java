package mk.ukim.finki.napredno.ispitni.vtorkolokvium.voting;

interface Subscriber {
    void updateVotes(int unit, String pollId, String party, int votes, int totalVotersPerPoll, int totalVotersPerUnit);
}

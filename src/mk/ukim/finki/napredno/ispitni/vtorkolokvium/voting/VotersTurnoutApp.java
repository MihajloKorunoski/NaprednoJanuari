package mk.ukim.finki.napredno.ispitni.vtorkolokvium.voting;

import java.util.HashMap;
import java.util.Map;

class VotersTurnoutApp implements Subscriber {

    Map<Integer, Integer> castedVotes;
    Map<Integer, Integer> registeredVoters;

    public VotersTurnoutApp() {
        castedVotes = new HashMap<>();
        registeredVoters = new HashMap<>();
    }

    public void printStatistics() {
        System.out.printf("%10s %7s %7s %7s\n", "Unit:", "Casted:", "Voters:", "Turnout:");
        for(int unit: castedVotes.keySet()){
            System.out.printf("%10d %7d %7d %7.2f%%%n", unit,
                    castedVotes.get(unit),
                    registeredVoters.get(unit),
                    castedVotes.get(unit) * 100.0 / registeredVoters.get(unit));
        }
    }

    @Override
    public void updateVotes(int unit, String pollId, String party, int votes, int totalVotersPerPoll, int totalVotersPerUnit) {
        registeredVoters.put(unit, totalVotersPerUnit);

        castedVotes.putIfAbsent(unit, 0);

        castedVotes.put(unit, castedVotes.get(unit) + votes);

    }
}

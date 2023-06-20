package mk.ukim.finki.napredno.ispitni.vtorkolokvium.voting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class VotesController {

    List<String> parties;
    Map<String, Integer> unitPerPoll;
    Map<Integer, ElectionUnit> electionUnitMap;

    public VotesController(List<String> parties, Map<String, Integer> unitPerPoll) {
        this.parties = parties;
        this.unitPerPoll = unitPerPoll;
        electionUnitMap = new HashMap<>();
    }

    public void addElectionUnit(ElectionUnit electionUnit) {
        electionUnitMap.put(electionUnit.getUnit(), electionUnit);
    }

    public void addVotes(String pollId, String party, int votes) throws InvalidVotesException {
        if (!parties.contains(party))
            throw new InvalidVotesException();

        int unitNumber = unitPerPoll.get(pollId);
        ElectionUnit electionUnit = electionUnitMap.get(unitNumber);
        electionUnit.addVotes(pollId, party, votes);
    }
}

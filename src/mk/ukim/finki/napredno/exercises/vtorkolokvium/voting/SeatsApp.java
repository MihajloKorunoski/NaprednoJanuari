package mk.ukim.finki.napredno.exercises.vtorkolokvium.voting;

import java.util.*;


class SeatsApp implements Subscriber {

    private Map<Integer, Map<String, Integer>> unitPartyVotes;
    private Map<Integer, Integer> unitTotalVotes;

    public SeatsApp() {
        unitPartyVotes = new HashMap<>();
        unitTotalVotes = new HashMap<>();
    }


    @Override
    public void updateVotes(int unit, String pollId, String party, int votes, int totalVotersPerPoll, int totalVotersPerUnit) {
        Map<String, Integer> partyVotes = unitPartyVotes.getOrDefault(unit, new HashMap<>());
        partyVotes.put(party, partyVotes.getOrDefault(party, 0) + votes);
        unitPartyVotes.put(unit, partyVotes);
        // pravi unit i za sekoj unit partija i glasovi

        int totalVotes = unitTotalVotes.getOrDefault(unit, 0);
        totalVotes += votes;
        unitTotalVotes.put(unit, totalVotes);
    }

    void printStatistics() {
        System.out.printf("%10s %10s %13s %10s %13s\n", "Party", "Votes", "%Votes", "Seats", "%Seats");

        Map<String, Integer> combinedPartyVotes = new HashMap<>();
        int totalSeats = unitTotalVotes.size() * 20;
        int totalVotes = 0;

        for (Map<String, Integer> partyVotes : unitPartyVotes.values()) {
            for (Map.Entry<String, Integer> entry : partyVotes.entrySet()) {
                String party = entry.getKey();
                int votes = entry.getValue();
                combinedPartyVotes.put(party, combinedPartyVotes.getOrDefault(party, 0) + votes);
                totalVotes += votes;
            }
        }

        List<Map.Entry<String, Integer>> sortedPartyVotes = new ArrayList<>(combinedPartyVotes.entrySet());
        sortedPartyVotes.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        int remainingSeats = totalSeats;
        Map<String, Integer> partySeats = new HashMap<>();


        for (Map.Entry<String, Integer> entry : sortedPartyVotes) {
            String party = entry.getKey();
            int votes = entry.getValue();
            int seats = votes / (totalVotes / totalSeats);
            partySeats.put(party, seats);
            remainingSeats -= seats;
        }

        if (remainingSeats > 0) {
            String partyWithMostVotes = sortedPartyVotes.get(0).getKey();
            partySeats.put(partyWithMostVotes, partySeats.getOrDefault(partyWithMostVotes, 0) + remainingSeats);
        }
        for (Map.Entry<String, Integer> entry : sortedPartyVotes) {
            String party = entry.getKey();
            int votes = entry.getValue();
            int seats = partySeats.getOrDefault(party, 0);
            double votePercentage = (votes * 100.0) / totalVotes;
            double seatPercentage = (seats * 100.0) / totalSeats;

            System.out.printf("%10s %10d %12.2f%% %10d %12.2f%%\n", party, votes, votePercentage, seats, seatPercentage);
        }
    }
}

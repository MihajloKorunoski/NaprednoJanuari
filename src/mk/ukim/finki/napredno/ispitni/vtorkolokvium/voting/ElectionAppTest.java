package mk.ukim.finki.napredno.ispitni.vtorkolokvium.voting;

import java.util.*;
import java.util.stream.Collectors;

public class ElectionAppTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> parties = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());
        Map<String, Integer> unitPerPoll = new HashMap<>();
        Map<Integer, ElectionUnit> electionUnitMap = new TreeMap<>();

        int totalUnits = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < totalUnits; i++) {
            Map<String, Integer> votersPerPoll = new HashMap<>();
            String line = sc.nextLine();
            String[] parts = line.split("\\s+");
            Integer unit = Integer.parseInt(parts[0]);
            for (int j = 1; j < parts.length; j += 2) {
                String pollId = parts[j];
                int voters = Integer.parseInt(parts[j + 1]);
                unitPerPoll.putIfAbsent(pollId, unit);
                votersPerPoll.put(pollId, voters);
            }

            electionUnitMap.putIfAbsent(unit, new ElectionUnit(unit, votersPerPoll));
        }
        VotesController controller = new VotesController(parties, unitPerPoll);

        electionUnitMap.values().forEach(controller::addElectionUnit);

        VotersTurnoutApp votersTurnoutApp = new VotersTurnoutApp();
        SeatsApp seatsApp = new SeatsApp();


        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split("\\s+");
            String testCase = parts[0];

            if (testCase.equals("subscribe")) { //Example: subscribe votersTurnoutApp 1
                int unit = Integer.parseInt(parts[1]);
                String app = parts[2];
                if (app.equals("votersTurnoutApp")) {
                    electionUnitMap.get(unit).subscribe(votersTurnoutApp);
                } else {
                    electionUnitMap.get(unit).subscribe(seatsApp);
                }
            } else if (testCase.equals("unsubscribe")) { //Example: unsubscribe votersTurnoutApp 1
                int unit = Integer.parseInt(parts[1]);
                String app = parts[2];
                if (app.equals("votersTurnoutApp")) {
                    electionUnitMap.get(unit).unsubscribe(votersTurnoutApp);
                } else {
                    electionUnitMap.get(unit).unsubscribe(seatsApp);
                }
            } else if (testCase.equals("addVotes")) { // Example: addVotes 1234 A 1000
                String pollId = parts[1];
                String party = parts[2];
                int votes = Integer.parseInt(parts[3]);
                try {
                    controller.addVotes(pollId, party, votes);
                } catch (InvalidVotesException e) {
                    e.printStackTrace();
                }
            } else if (testCase.equals("printStatistics")) {
                String app = parts[1];
                if (app.equals("votersTurnoutApp")) {
                    System.out.println("PRINTING STATISTICS FROM VOTERS TURNOUT APPLICATION");
                    votersTurnoutApp.printStatistics();
                } else {
                    System.out.println("PRINTING STATISTICS FROM SEATS APPLICATION");
                    seatsApp.printStatistics();
                }
            }
        }
    }
}
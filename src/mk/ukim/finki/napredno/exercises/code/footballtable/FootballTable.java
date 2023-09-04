package mk.ukim.finki.napredno.exercises.code.footballtable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class FootballTable {
    Map<String, Team> teams;

    public FootballTable() {
        teams = new HashMap<>();
    }

    public void addGame(String homeTeam, String awayTeam, int homeGoals, int awayGoals) {
        teams.putIfAbsent(homeTeam, new Team(homeTeam));
        teams.putIfAbsent(awayTeam, new Team(awayTeam));
        teams.get(homeTeam).addGame(homeGoals, awayGoals);
        teams.get(awayTeam).addGame(awayGoals, homeGoals);
    }

    public void printTable() {
        List<Team> sortedTeams = teams.values().stream().sorted().collect(Collectors.toList());
        IntStream.range(0, sortedTeams.size()).forEach(i -> {
            Team team = sortedTeams.get(i);
            System.out.printf("%2d. %-15s%5d%5d%5d%5d%5d\n", i + 1,
                    team.getName(),
                    team.getPlayed(),
                    team.getWon(),
                    team.getDraw(),
                    team.getLost(),
                    team.point());
        });
    }
}

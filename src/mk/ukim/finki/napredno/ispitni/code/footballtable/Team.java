package mk.ukim.finki.napredno.ispitni.code.footballtable;

class Team implements Comparable<Team>{
    private String name;
    private int played;
    private int won;
    private int draw;
    private int lost;
    private int goalsScored;
    private int goalsConceded;

    public Team(String name) {
        this.name = name;
    }

    public void addGame(int goalsScored, int goalsConceded) {
        this.played++;
        this.goalsScored += goalsScored;
        this.goalsConceded += goalsConceded;

        if(goalsScored > goalsConceded){
            this.won++;
        } else if (goalsScored == goalsConceded){
            this.draw++;
        } else {
            this.lost++;
        }
    }

    public int point(){
        return this.won * 3 + this.draw;
    }
    public int goalDifference(){
        return this.goalsScored - this.goalsConceded;
    }


    @Override
    public int compareTo(Team o) {
        if(this.point() != o.point())
            return o.point() - this.point();
        else if (this.goalDifference() != o.goalDifference())
            return o.goalDifference() - this.goalDifference();
        else
            return this.name.compareTo(o.name);
    }

    public String getName() {
        return name;
    }

    public int getPlayed() {
        return played;
    }

    public int getWon() {
        return won;
    }

    public int getDraw() {
        return draw;
    }

    public int getLost() {
        return lost;
    }
}

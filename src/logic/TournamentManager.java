package logic;

import pbjam.beans.Tournament;

import java.util.ArrayList;
import java.util.List;

public class TournamentManager {
    private final List<Tournament> tournaments = new ArrayList<>();

    public void addTournament(Tournament tournament) {
        tournaments.add(tournament);
    }

    public void viewTournaments() {
        System.out.println("Upcoming Tournaments:");
        for (Tournament t : tournaments) {
            System.out.println(t);
        }
    }
}

package logic;

import pbjam.beans.Match;
import pbjam.beans.Player;
import pbjam.beans.Tournament;

import java.util.ArrayList;
import java.util.List;

public class ProfileManager {

    public void viewProfile(Player player) {
        System.out.println(player); // relies on Player.toString()
    }

    public void editPhoneNumber(Player player, String newNumber) {
        player.setPhoneNumber(newNumber);
        System.out.println("Phone number updated.");
    }

    public void editLocation(Player player, String newLocation) {
        player.setLocation(newLocation);
        System.out.println("Location updated.");
    }

    public void viewMatchHist(Player player) {
        List<Match> matchHistory = player.getMatchHistory();
        if (matchHistory == null || matchHistory.isEmpty()) {
            System.out.println("No match history available.");
        } else {
            System.out.println("Match History:");
            for (Match match : matchHistory) {
                System.out.println(match);
            }
        }
    }

    public void addFriend(Player player, Player friend) {
        if (friend == null || player.equals(friend)) {
            System.out.println("Invalid friend.");
            return;
        }

        List<Player> friends = player.getFriends();
        if (friends.contains(friend)) {
            System.out.println(friend.getName() + " is already your friend.");
        } else {
            friends.add(friend);
            System.out.println(friend.getName() + " has been added to your friends list.");
        }
    }

    public List<Player> findMatch(Player player, List<Player> allPlayers) {
        List<Player> potentialMatches = new ArrayList<>();
        for (Player other : allPlayers) {
            if (!player.equals(other) && Math.abs(player.getDuprSingles() - other.getDuprSingles()) <= 0.5) {
                potentialMatches.add(other);
            }
        }
        return potentialMatches;
    }

    public void viewTournaments(Player player) {
        List<Tournament> tournaments = player.getTournaments();
        if (tournaments == null || tournaments.isEmpty()) {
            System.out.println("No tournaments available.");
        } else {
            System.out.println("Tournaments:");
            for (Tournament tournament : tournaments) {
                System.out.println(tournament);
            }
        }
    }
}

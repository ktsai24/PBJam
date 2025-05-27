package logic;

import pbjam.beans.Match;
import pbjam.beans.Match.MatchType;
import pbjam.beans.Player;

import java.util.List;

public class MatchManager {

    public void scheduleMatch(Player host, MatchType type, List<Player> players, String date, String location, String result) {
        int required = (type == MatchType.SINGLES) ? 2 : 4;

        if (players.size() != required) {
            throw new IllegalArgumentException("A " + type + " match requires exactly " + required + " players.");
        }

        Match match = new Match(type, players, date, location, result);
        host.getMatchHistory().add(match);
        System.out.println("Match scheduled:\n" + match);
    }

    public void viewMatchHistory(Player player) {
        List<Match> history = player.getMatchHistory();
        if (history.isEmpty()) {
            System.out.println("No match history found.");
        } else {
            System.out.println("Match History:");
            for (Match m : history) {
                System.out.println(m);
            }
        }
    }
}

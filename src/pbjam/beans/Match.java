package pbjam.beans;

import java.io.Serializable;
import java.util.List;

public class Match implements Serializable {
    private static final long serialVersionUID = 1L;
    public enum MatchType { SINGLES, DOUBLES }

    private final MatchType type;
    private final List<Player> players;
    private final String date;
    private final String location;
    private final String result;

    public Match(MatchType type, List<Player> players, String date, String location, String result) {
        if ((type == MatchType.SINGLES && players.size() != 2) ||
            (type == MatchType.DOUBLES && players.size() != 4)) {
            throw new IllegalArgumentException("Invalid number of players for " + type);
        }
        this.type = type;
        this.players = players;
        this.date = date;
        this.location = location;
        this.result = result;
    }


    public MatchType getType() {
        return type;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(type).append(" Match on ").append(date)
          .append(" at ").append(location).append("\nPlayers: ");
        for (Player p : players) {
            sb.append(p.getName()).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append("\nResult: ").append(result);
        return sb.toString();
    }
    
}

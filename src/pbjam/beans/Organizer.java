
import java.util.ArrayList;
import java.util.List;

import abstracts.Person;
import pbjam.beans.Match.MatchType;
import pbjam.beans.Match;

public class Organizer extends Person {
    private List<Group> groups = new ArrayList<>();
    private List<Match> matches = new ArrayList<>();

    public Organizer(String name, String email) {
        super(name, email);
    }

    public void createGroup(String groupName) {
        Group group = new Group(groupName);
        groups.add(group);
        System.out.println("Group '" + groupName + "' created.");
    }

    public void scheduleMatch(MatchType type, List<Player> players, String date, String location, String result) {
        Match match = new Match(type, players, date, location, result);
        matches.add(match);
        System.out.println("Scheduled: " + match);
    }

    public List<Group> getGroups() {
        return groups;
    }

    public List<Match> getMatches() {
        return matches;
    }

    @Override
    public void viewProfile() {
        System.out.println("Organizer: " + name + "\nEmail: " + email);
    }

    @Override
    public void editProfile() {
        // Logic to edit name/email if needed
    }

    @Override
    public String getDetails() {
        return "Organizer Name: " + name + ", Email: " + email;
    }
}
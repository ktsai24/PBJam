package logic;

import pbjam.beans.*;
import pbjam.beans.Match.MatchType;
import exceptions.InvalidMatchException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class PBJamFacade {
    private final Player player;

    private final FriendManager friendManager;
    private final ProfileManager profileManager;
    private final MatchManager matchManager;
    private final GroupManager groupManager;
    private final TournamentManager tournamentManager;

    public PBJamFacade(Player player) {
        this.player = player;
        this.friendManager = new FriendManager(player);
        this.profileManager = new ProfileManager();
        this.matchManager = new MatchManager();
        this.groupManager = new GroupManager();
        this.tournamentManager = new TournamentManager();
    }

    //Profile
    public void viewProfile() {
        profileManager.viewProfile(player);
    }

    public void editPhone(String newPhone) {
        profileManager.editPhoneNumber(player, newPhone);
    }

    public void editLocation(String newLoc) {
        profileManager.editLocation(player, newLoc);
    }

    // Friends
    public void addFriend(Player friend) {
        friendManager.addFriend(friend);
    }

    public void viewFriends() {
        friendManager.viewFriends();
    }

    //Match
    public void recordMatch(Match.MatchType type, List<Player> players, String date, String location, String result) {
        int expected = (type == Match.MatchType.SINGLES) ? 2 : 4;

        if (players.size() != expected) {
            throw new InvalidMatchException("A " + type + " match must have " + expected + " players.");
        }

        Match match = new Match(type, players, date, location, result);
        player.getMatchHistory().add(match);
    }

    public void viewMatchHistory() {
        matchManager.viewMatchHistory(player);
    }

    //Groups
    public void createGroup(String name) {
        Group group = new Group(name);
        group.addPlayer(player);
        groupManager.addGroup(group);
    }

    public void postGroupMessage(Group group, String msg) {
        group.postMessage(player.getName() + ": " + msg);
    }

    public void scheduleGroupMeetup(Group group, String date, String location) {
        String message = "Meetup scheduled on " + date + " at " + location;
        group.postMessage(message);
    }

    public List<Group> getGroups() {
        return groupManager.getGroups();
    }

    public void createTournament(String name, String date, String location) {
        Tournament t = new Tournament(name, date, location);
        player.getTournaments().add(t);
        tournamentManager.addTournament(t);
    }

    public void viewTournaments() {
        profileManager.viewTournaments(player);
    }
    
    public void savePlayerData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/player_data.ser"))) {
            out.writeObject(player);
            System.out.println("Player data saved.");
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    public Player loadPlayerData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("data/player_data.ser"))) {
        	System.out.println("Successfully loaded player data.");
            return (Player) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No saved player data found.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Data load error: " + e.getMessage());
        }
        return null;
    }
}

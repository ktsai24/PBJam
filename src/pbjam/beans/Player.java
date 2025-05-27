package pbjam.beans;

import abstracts.Person;
import enums.Sex;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player extends Person implements Serializable{
	private static final long serialVersionUID = 1L;
    private String location;
    private String phoneNumber;
    private Sex sex;
    private boolean duprLinked;
    private double duprSingles;
    private double duprDoubles;

    private final List<Player> friends = new ArrayList<>();
    private final List<Match> matchHistory = new ArrayList<>();
    private final List<Tournament> tournaments = new ArrayList<>();

    // Default constructor for menu use
    public Player() {
        super("", "");
    }

    public Player(String name, String email, String location, String phoneNumber, Sex sex, double duprSingles, double duprDoubles) {
        super(name, email);
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.duprDoubles = duprDoubles;
        this.duprSingles = duprSingles;
    }

    // Getters and setters
    public Sex getSex() {
        return sex;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isDuprLinked() {
        return duprLinked;
    }

    public void setDuprLinked(boolean duprLinked) {
        this.duprLinked = duprLinked;
    }

    public double getDuprSingles() {
        return duprSingles;
    }

    public void setDuprSingles(double duprSingles) {
        this.duprSingles = duprSingles;
    }

    public double getDuprDoubles() {
        return duprDoubles;
    }

    public void setDuprDoubles(double duprDoubles) {
        this.duprDoubles = duprDoubles;
    }

    public List<Player> getFriends() {
        return friends;
    }

    public List<Match> getMatchHistory() {
        return matchHistory;
    }

    public List<Tournament> getTournaments() {
        return tournaments;
    }

    // Stub methods (optional override logic)
    @Override
    public void viewProfile() {
        System.out.println(getDetails());
    }

    @Override
    public void editProfile() {
        // Placeholder for editable profile fields
    }

    @Override
    public String getDetails() {
        return "Player Name: " + getName() +
               "\nLocation: " + location +
               "\nPhone: " + phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + getName() +
               "\nLocation: " + location +
               "\nPhone: " + phoneNumber +
               "\nDUPR Linked: " + duprLinked +
               "\nSingles DUPR: " + duprSingles +
               "\nDoubles DUPR: " + duprDoubles;
    }
}

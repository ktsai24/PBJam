package menu;

import enums.Sex;
import logic.PBJamFacade;
import pbjam.beans.Group;
import pbjam.beans.Match;
import pbjam.beans.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuHandler {
    private final Player player;
    private final PBJamFacade facade;

    public MenuHandler(Player player) {
        this.player = player;
        this.facade = new PBJamFacade(player);
    }

    public void displayMenu() {
        Scanner sc = new Scanner(System.in);
        int option = -1;

        do {
        	System.out.println("Successfully loaded player data.");
            System.out.println("\nWelcome to your PBJam!");
            System.out.println(player.getName());
            System.out.println("Location: " + player.getLocation());
            System.out.println("Doubles Dupr: " + player.getDuprDoubles() + "  Singles Dupr: " + player.getDuprSingles());

            System.out.println("\nMenu:");
            System.out.println("1. View Profile");
            System.out.println("2. View Friends");
            System.out.println("3. Add Friend");
            System.out.println("4. View Tournaments");
            System.out.println("5. Record Match");
            System.out.println("6. Create Group");
            System.out.println("7. Post Group Message");
            System.out.println("8. Create Tournament (Organizer Only)");
            System.out.println("9. Schedule Group Meetup");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            if (sc.hasNextInt()) {
                option = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Invalid input.");
                sc.nextLine();
                continue;
            }

            switch (option) {
                case 1 -> facade.viewProfile();
                case 2 -> facade.viewFriends();
                case 3 -> {
                    System.out.print("Enter friend's name: ");
                    String name = sc.nextLine();
                    Player friend = new Player(name, "friend@email.com", "Friendtown", "555-0000", Sex.FEMALE, 3.5, 3.5);
                    facade.addFriend(friend);
                }
                case 4 -> facade.viewTournaments();
                case 5 -> {
                    System.out.println("\n--- Record Match ---");
                    System.out.print("Match Type (SINGLES/DOUBLES): ");
                    String typeInput = sc.nextLine().toUpperCase();

                    try {
                        Match.MatchType type = Match.MatchType.valueOf(typeInput);
                        List<Player> players = new ArrayList<>();
                        players.add(player);

                        int needed = (type == Match.MatchType.SINGLES) ? 1 : 3;
                        for (int i = 0; i < needed; i++) {
                            System.out.print("Enter player " + (i + 2) + " name: ");
                            String pname = sc.nextLine();
                            players.add(new Player(pname, "email", "Loc", "000", Sex.MALE, 3.0, 3.0));
                        }

                        System.out.print("Date (e.g. 2025-06-01): ");
                        String date = sc.nextLine();
                        System.out.print("Location: ");
                        String loc = sc.nextLine();
                        System.out.print("Enter match result: ");
                        String result = sc.nextLine();

                        facade.recordMatch(type, players, date, loc, result);
                    } catch (Exception e) {
                        System.out.println("Error recording match: " + e.getMessage());
                    }
                }
                case 6 -> {
                    System.out.print("Enter new group name: ");
                    String groupName = sc.nextLine();
                    facade.createGroup(groupName);
                }
                case 7 -> {
                    List<Group> groups = facade.getGroups();
                    if (groups.isEmpty()) {
                        System.out.println("No groups available.");
                        break;
                    }
                    System.out.println("Available Groups:");
                    for (int i = 0; i < groups.size(); i++) {
                        System.out.println((i + 1) + ". " + groups.get(i).getName());
                    }
                    System.out.print("Select group number: ");
                    int gnum = Integer.parseInt(sc.nextLine()) - 1;
                    System.out.print("Enter message: ");
                    String msg = sc.nextLine();
                    facade.postGroupMessage(groups.get(gnum), msg);
                }
                case 8 -> {
                    System.out.print("Tournament name: ");
                    String tName = sc.nextLine();
                    System.out.print("Date: ");
                    String tDate = sc.nextLine();
                    System.out.print("Location: ");
                    String tLoc = sc.nextLine();
                    facade.createTournament(tName, tDate, tLoc);
                }
                case 9 -> {
                    List<Group> groups = facade.getGroups();
                    if (groups.isEmpty()) {
                        System.out.println("No groups to schedule meetups for.");
                        break;
                    }
                    System.out.println("Select a group to schedule a meetup:");
                    for (int i = 0; i < groups.size(); i++) {
                        System.out.println((i + 1) + ". " + groups.get(i).getName());
                    }
                    System.out.print("Enter group number: ");
                    int gIndex = Integer.parseInt(sc.nextLine()) - 1;
                    Group selectedGroup = groups.get(gIndex);
                    System.out.print("Enter meetup date: ");
                    String date = sc.nextLine();
                    System.out.print("Enter meetup location: ");
                    String location = sc.nextLine();
                    facade.scheduleGroupMeetup(selectedGroup, date, location);
                }
                case 0 -> {
                    facade.savePlayerData();
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option.");
            }

            System.out.print("\nPress Enter to return to the menu...");
            sc.nextLine();
        } while (option != 0);
    }
}

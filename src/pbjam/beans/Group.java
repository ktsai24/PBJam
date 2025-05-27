package pbjam.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Group implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String name;
    private final List<Player> members = new ArrayList<>();
    private final List<String> messages = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public void addPlayer(Player player) {
        if (!members.contains(player)) {
            members.add(player);
        }
    }

    public List<Player> getMembers() {
        return members;
    }

    public String getName() {
        return name;
    }

    // ✅ Add this method to enable message posting
    public void postMessage(String message) {
        messages.add(message);
    }

    public List<String> getMessages() {
        return messages;
    }

    public void viewMessages() {
        if (messages.isEmpty()) {
            System.out.println("No messages yet.");
        } else {
            System.out.println("Messages in " + name + ":");
            for (String m : messages) {
                System.out.println("- " + m);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Group: " + name + "\nMembers:\n");
        for (Player p : members) {
            sb.append("- ").append(p.getName()).append("\n");
        }
        return sb.toString();
    }
}

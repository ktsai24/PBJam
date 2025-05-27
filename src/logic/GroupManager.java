package logic;

import pbjam.beans.Group;
import java.util.ArrayList;
import java.util.List;

public class GroupManager {
    private final List<Group> groups = new ArrayList<>();

    public void addGroup(Group group) {
        groups.add(group);
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void listGroups() {
        if (groups.isEmpty()) {
            System.out.println("No groups available.");
        } else {
            System.out.println("Groups:");
            for (int i = 0; i < groups.size(); i++) {
                System.out.println((i + 1) + ". " + groups.get(i).getName());
            }
        }
    }
}

package logic;

import pbjam.beans.Player;
import java.util.ArrayList;
import java.util.List;

public class FriendManager {
    private final Player user;

    public FriendManager(Player user) {
        this.user = user;
    }

    public void addFriend(Player friend) {
        user.getFriends().add(friend);
        System.out.println(friend.getName() + " added as a friend!");
    }

    public void viewFriends() {
        System.out.println("Friends List:");
        for (Player friend : user.getFriends()) {
            System.out.println("- " + friend.getName());
        }
    }
}

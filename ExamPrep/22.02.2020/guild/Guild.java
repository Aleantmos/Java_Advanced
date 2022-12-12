package guild;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (roster.size() < capacity) {
            roster.add(player);
        }
    }

    public Player getPlayer(String name) {
        Player findPlayer = null;
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                findPlayer = player;
                break;
            }
        }
        return findPlayer;
    }

    public boolean removePlayer(String name) {
        boolean isRemoved = false;
        Player playerToRemove = getPlayer(name);
        if (playerToRemove != null) {
            roster.remove(playerToRemove);
            isRemoved = true;
        }
        return isRemoved;
    }

    public void promotePlayer(String name) {
        Player playerToPromote = getPlayer(name);
        if (playerToPromote != null && !playerToPromote.getRank().equals("Member")) {
            playerToPromote.setRank("Member");
        }
    }

    public void demotePlayer(String name) {
        Player playerToDemote = getPlayer(name);
        if (playerToDemote != null && !playerToDemote.getRank().equals("Trial")) {
            playerToDemote.setRank("Trial");
        }
    }

    public Player[] kickPlayersByClass(String clazz) {

        List<Player> removedPlayers = roster.stream()
                .filter(player -> player.getClazz().equals(clazz))
                .collect(Collectors.toList());
        roster.removeAll(removedPlayers);
        return removedPlayers.toArray(Player[]::new);
    }

    public int count() {
        return roster.size();
    }

    public String report() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Players in the guild: %s:", this.name)).append(System.lineSeparator());
        roster.forEach(result::append);

        return result.toString();
    }
}

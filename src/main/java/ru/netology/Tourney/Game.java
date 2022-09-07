package ru.netology.Tourney;

import java.util.ArrayList;

public class Game {
    protected ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String name1, String name2) {
        Player player1 = findByName(name1);
        Player player2 = findByName(name2);
        if (findByName(name1) == null) {
            throw new NotRegisteredException(
                    "Игрок " + name1 + " не зарегистрирован и не может участвовать"
            );
        }
        if (findByName(name2) == null) {
            throw new NotRegisteredException(
                    "Игрок " + name2 + " не зарегистрирован и не может участвовать"
            );
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }

    }
}




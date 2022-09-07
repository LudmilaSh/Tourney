package ru.netology.Tourney;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Ivan", 10);
    Player player2 = new Player(2, "Viktor", 20);
    Player player3 = new Player(3, "Renat", 30);
    Player player4 = new Player(4, "Denis", 30);

    @Test
    public void shouldFindByName() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertEquals(player1, game.findByName("Ivan"));
    }

    @Test
    public void shouldFindNoName() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertEquals(null , game.findByName("Vika"));
    }

    @Test
    public void shouldNotFindPlayer1UnRegistered() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Vika", "Ivan");
                });

    }

    @Test
    public void shouldNotFindPlayer2UnRegistered() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Renat", "Lusya");
        });

    }

    @Test
    public void shouldFindResultIfPlayer1Stronger() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertEquals(1 , game.round("Viktor", "Ivan"));
    }

    @Test
    public void shouldFindResultIfPlayer2Stronger() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertEquals(2 , game.round("Viktor", "Renat"));
    }

    @Test
    public void shouldFindResultIfPlayersEqual() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertEquals(0 , game.round("Denis", "Renat"));
    }
}

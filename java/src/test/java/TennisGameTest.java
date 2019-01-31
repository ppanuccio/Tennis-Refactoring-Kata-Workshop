import org.assertj.core.api.Assertions;
import org.junit.*;
import tennis.game.Player;

import static org.assertj.core.api.Assertions.assertThat;

public class TennisGameTest
{
  Player player1=new Player("player1");
  Player player2=new Player("player2");
  TennisGame game;

  @Before
  public void setUp(){
    game=new TennisGame(player1.getName(),player2.getName());
  }

  @Test
  public void should_add_point_to_a_player(){
    assertThat(game.getScore()).isEqualTo("Love-All");

    game.wonPoint(player1.getName());

    assertThat(game.getScore()).isEqualTo("Fifteen-Love");

    game.wonPoint(player2.getName());

    assertThat(game.getScore()).isEqualTo("Fifteen-All");

    game.wonPoint(player1.getName());

    assertThat(game.getScore()).isEqualTo("Thirty-Fifteen");
  }

  @Test
  public void should_set_won_to_a_player1(){
    game.wonPoint(player1.getName());
    game.wonPoint(player1.getName());
    game.wonPoint(player1.getName());

    assertThat(game.getScore()).isEqualTo("Forty-Love");

    game.wonPoint(player1.getName());

    assertThat(game.getScore()).isEqualTo("Win for player1");
  }

  @Test
  public void should_set_won_to_a_player2(){
    game.wonPoint(player2.getName());
    game.wonPoint(player2.getName());
    game.wonPoint(player2.getName());

    assertThat(game.getScore()).isEqualTo("Love-Forty");

    game.wonPoint(player1.getName());

    assertThat(game.getScore()).isEqualTo("Fifteen-Forty");
    game.wonPoint(player2.getName());

    assertThat(game.getScore()).isEqualTo("Win for player2");

    game.wonPoint(player2.getName());

    assertThat(game.getScore()).isEqualTo("Win for player2");
  }

  @Test
  public void should_set_advantage_to_a_player1(){
    game.wonPoint(player2.getName());
    game.wonPoint(player2.getName());
    game.wonPoint(player2.getName());

    assertThat(game.getScore()).isEqualTo("Love-Forty");

    game.wonPoint(player1.getName());

    assertThat(game.getScore()).isEqualTo("Fifteen-Forty");
    game.wonPoint(player1.getName());
    game.wonPoint(player1.getName());
    game.wonPoint(player1.getName());

    assertThat(game.getScore()).isEqualTo("Advantage player1");

    game.wonPoint(player2.getName());

    assertThat(game.getScore()).isEqualTo("Win for player2");
  }


}

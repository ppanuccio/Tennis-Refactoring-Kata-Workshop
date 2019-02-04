import tennis.game.*;

public class TennisGame {

    private Score score;

    public TennisGame() {
        score=new Score();
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            score.addPointToPlayerOne();
        } else {
            score.addPointToPlayerTwo();
        }
    }

    public String getScore() {
        return this.score.getScore();
    }
}

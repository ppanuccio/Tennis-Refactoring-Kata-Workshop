package tennis.game;

public class Score
{
  private int scorePlayerOne;
  private int scorePlayerTwo;
  private String score;

  public Score(){
    scorePlayerOne=0;
    scorePlayerTwo=0;
    score="Love-All";
  }

  public void addPointToPlayerOne(){
    scorePlayerOne++;
    calculateScore();
  }

  public void addPointToPlayerTwo(){
    scorePlayerTwo++;
    calculateScore();
  }

  public String getScore(){
    return score;
  }

  private String calculateScore()
  {
    if (isTied())
    {
      return getTiedScore();
    }
    else if (atLeastOnePlayerHasScoredMoreThanFourPoints())
    {
      return getMoreThanFourPointsScore();
    }
    else
    {
      return getIntermediateScore();
    }
  }

  private String getIntermediateScore()
  {
    score="";
    int tempScore;
    for (int i = 1; i<3; i++)
    {
      if (i==1) {
        tempScore = scorePlayerOne;
      } else { score+="-"; tempScore = scorePlayerTwo;}
      switch(tempScore)
      {
        case 0:
          score+="Love";
          break;
        case 1:
          score+="Fifteen";
          break;
        case 2:
          score+="Thirty";
          break;
        case 3:
          score+="Forty";
          break;
      }
    }
    return score;
  }

  private String getMoreThanFourPointsScore()
  {
    int minusResult = scorePlayerOne-scorePlayerTwo;
    if (minusResult==1) {
      score ="Advantage player1";
    } else if (minusResult ==-1) {
      score ="Advantage player2";
    } else if (minusResult>=2) {
      score = "Win for player1";
    } else {
      score ="Win for player2";
    }
    return score;
  }

  private String getTiedScore()
  {
    switch (scorePlayerOne)
    {
      case 0:
        score = "Love-All";
        break;
      case 1:
        score = "Fifteen-All";
        break;
      case 2:
        score = "Thirty-All";
        break;
      default:
        score = "Deuce";
        break;

    }
    return score;
  }

  private boolean atLeastOnePlayerHasScoredMoreThanFourPoints()
  {
    return scorePlayerOne>=4 || scorePlayerTwo>=4;
  }

  private boolean isTied()
  {
    return scorePlayerOne == scorePlayerTwo;
  }

}

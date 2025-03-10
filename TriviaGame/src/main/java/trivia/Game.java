package trivia;

import java.util.ArrayList;
import java.util.List;

public class Game implements IGame {
   public final static int position = 12;
   private final List<Player> players = new ArrayList<>();
   private final QuestionDeck questionDeck = new QuestionDeck();
   private int currentPlayerIndex = 0;

   public boolean add(String playerName) {
      players.add(new Player(playerName));
      System.out.println(playerName + " was added");
      System.out.println("They are player number " + players.size());
      return true;
   }

   public void roll(int roll) {
      Player currentPlayer = players.get(currentPlayerIndex);

      System.out.println(currentPlayer.getName() + " is the current player");
      System.out.println("They have rolled a " + roll);

      if (currentPlayer.isInPenaltyBox()) {
         boolean outOfPenaltyBox = roll % 2 != 0;
         if (outOfPenaltyBox) {
            System.out.println(currentPlayer.getName() + " is getting out of the penalty box");
            currentPlayer.getOutOfPenaltyBox();
            currentPlayer.move(roll);
            System.out.println(currentPlayer.getName() + "'s new location is " + currentPlayer.getPosition());
            askQuestion();
         } else {
            System.out.println(currentPlayer.getName() + " is not getting out of the penalty box");
         }
      } else {
         currentPlayer.move(roll);
         System.out.println(currentPlayer.getName() + "'s new location is " + currentPlayer.getPosition());
         askQuestion();
      }
   }

   private void askQuestion() {
      Player currentPlayer = players.get(currentPlayerIndex);
      String category = questionDeck.getCategoryForPosition(currentPlayer.getPosition() - 1);
      System.out.println("The category is " + category);
      System.out.println(questionDeck.drawQuestion(category));
   }

   public boolean handleCorrectAnswer() {
      Player currentPlayer = players.get(currentPlayerIndex);
      if (!currentPlayer.isInPenaltyBox()) {
         System.out.println("Answer was correct!!!!");
         currentPlayer.addCoin();
         System.out.println(currentPlayer.getName() + " now has " + currentPlayer.getCoins() + " Gold Coins.");
         boolean isNotWinner = currentPlayer.getCoins() < 6;
         nextPlayer();
         return isNotWinner;
      } else {
         nextPlayer();
         return true;
      }
   }

   public boolean handleWrongAnswer() {
      Player currentPlayer = players.get(currentPlayerIndex);
      System.out.println("Question was incorrectly answered");
      System.out.println(currentPlayer.getName() + " was sent to the penalty box");
      currentPlayer.goToPenaltyBox();
      nextPlayer();
      return true;
   }

   private void nextPlayer() {
      currentPlayerIndex++;
      if (currentPlayerIndex >= players.size()) {
         currentPlayerIndex = 0;
      }
   }
}

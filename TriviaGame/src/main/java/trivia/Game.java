package trivia;

import java.util.*;

public class Game implements IGame {
   private static final int MAX_PLAYERS = 6;
   private static final int WINNING_SCORE = 6;
   private static final int BOARD_SIZE = 12;

   private final List<Player> players = new ArrayList<>();
   private final Map<String, Queue<String>> questions = new HashMap<>();
   private final String[] categories = {"Pop", "Science", "Sports", "Rock"};

   private int currentPlayerIndex = 0;
   private boolean isGettingOutOfPenaltyBox;

   public Game() {
      questions.put("Pop", new LinkedList<>());
      questions.put("Science", new LinkedList<>());
      questions.put("Sports", new LinkedList<>());
      questions.put("Rock", new LinkedList<>());

      for (int i = 0; i < 50; i++) {
         questions.get("Pop").add("Pop Question " + i);
         questions.get("Science").add("Science Question " + i);
         questions.get("Sports").add("Sports Question " + i);
         questions.get("Rock").add("Rock Question " + i);
      }
   }

   public boolean add(String playerName) {
      if (players.size() >= MAX_PLAYERS) {
         return false;
      }

      players.add(new Player(playerName));
      System.out.println(playerName + " was added");
      System.out.println("They are player number " + players.size());
      return true;
   }

   public boolean isPlayable() {
      return players.size() >= 2;
   }

   public void roll(int roll) {
      Player currentPlayer = players.get(currentPlayerIndex);
      System.out.println(currentPlayer.getName() + " is the current player");
      System.out.println("They have rolled a " + roll);

      if (currentPlayer.isInPenaltyBox()) {
         if (roll % 2 != 0) {
            isGettingOutOfPenaltyBox = true;
            System.out.println(currentPlayer.getName() + " is getting out of the penalty box");
            movePlayer(currentPlayer, roll);
            askQuestion();
         } else {
            System.out.println(currentPlayer.getName() + " is not getting out of the penalty box");
            isGettingOutOfPenaltyBox = false;
         }
      } else {
         movePlayer(currentPlayer, roll);
         askQuestion();
      }
   }

   private void movePlayer(Player player, int roll) {
      player.move(roll, BOARD_SIZE);
      System.out.println(player.getName() + "'s new location is " + player.getPosition());
      System.out.println("The category is " + currentCategory(player.getPosition()));
   }

   private void askQuestion() {
      String category = currentCategory(players.get(currentPlayerIndex).getPosition());
      System.out.println(questions.get(category).poll());
   }

   private String currentCategory(int position) {
      return categories[position % categories.length];
   }

   public boolean handleCorrectAnswer() {
      Player currentPlayer = players.get(currentPlayerIndex);

      if (currentPlayer.isInPenaltyBox() && !isGettingOutOfPenaltyBox) {
         nextPlayer();
         return true;
      }

      System.out.println("Answer was corrent!!!!");
      currentPlayer.incrementScore();
      System.out.println(currentPlayer.getName() + " now has " + currentPlayer.getScore() + " Gold Coins.");

      boolean winner = !currentPlayer.hasWon(WINNING_SCORE);
      nextPlayer();
      return winner;
   }

   public boolean wrongAnswer() {
      Player currentPlayer = players.get(currentPlayerIndex);
      System.out.println("Question was incorrectly answered");
      System.out.println(currentPlayer.getName() + " was sent to the penalty box");
      currentPlayer.setInPenaltyBox(true);

      nextPlayer();
      return true;
   }

   private void nextPlayer() {
      currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
   }


}

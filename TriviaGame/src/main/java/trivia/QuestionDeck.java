package trivia;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class QuestionDeck {
    private final Map<String, LinkedList<String>> questionMap = new HashMap<>();
    private static final String[] CATEGORIES = {"Pop", "Science", "Sports", "Rock"};

    public QuestionDeck() {
        for (String category : CATEGORIES) {
            questionMap.put(category, new LinkedList<>());
            for (int i = 0; i < 50; i++) {
                questionMap.get(category).add(category + " Question " + i);
            }
        }
    }

    public String drawQuestion(String category) {
        return questionMap.getOrDefault(category, new LinkedList<>()).isEmpty() ?
                "No more questions." : questionMap.get(category).removeFirst();
    }

    public String getCategoryForPosition(int position) {
        switch (position % 12) {  // Ajuster modulo 12 pour suivre GameOld
            case 0: case 4: case 8: return "Pop";
            case 1: case 5: case 9: return "Science";
            case 2: case 6: case 10: return "Sports";
            default: return "Rock";
        }
    }
}

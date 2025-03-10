package trivia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trivia.QuestionDeck;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TestAfterRefactoringQuestionDeck {
    private QuestionDeck questionDeck;

    @BeforeEach
    void setUp() {
        questionDeck = new QuestionDeck();
    }

    @Test
    void testDrawQuestion() {
        String question = questionDeck.drawQuestion("Science");
        assertNotNull(question);
    }

    @Test
    void testCategoryForPosition() {
        assertEquals("Science", questionDeck.getCategoryForPosition(1));
        assertEquals("Sports", questionDeck.getCategoryForPosition(2));
    }

    @Test
    void drawQuestionFromEmptyCategory() {
        for (int i = 0; i < 50; i++) {
            questionDeck.drawQuestion("Pop");
        }
        assertEquals("No more questions.", questionDeck.drawQuestion("Pop"));
    }
}


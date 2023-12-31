import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Quiz {
    private final Question[] questions;
    private final Scanner in = new Scanner(System.in);
    private int score = 0;

    public Quiz(Question[] questions) {
        this.questions = questions;
    }

    public void start() {
        Collections.shuffle(Arrays.asList(questions));
        var questionNumber = 1;
        for (var q : questions) {
            System.out.printf("%d. %s\n", questionNumber++, q.question());
            for (var a : q.answers().entrySet()) {
                System.out.printf("%s) %s\n", a.getKey(), a.getValue());
            }

            Question.Answer userChoice;
            while (true) {
                try {
                    userChoice = Question.Answer.valueOf(in.next().toUpperCase());
                    break;
                } catch (RuntimeException e) {
                    System.err.printf("Valid options are: %s (case-insensitive)\n", Arrays.toString(Question.Answer.values()));
                }
            }

            if (userChoice.equals(q.correctAnswer())) {
                score++;
            }
        }
        System.out.printf("Score: %d/%d\n", score, questions.length);
    }
}

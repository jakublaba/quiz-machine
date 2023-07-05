import java.util.Arrays;
import java.util.Scanner;

public class Quiz {
    private final Question[] questions;
    private final Scanner in = new Scanner(System.in);
    private int score = 0;

    public Quiz(Question[] questions) {
        this.questions = questions;
    }

    public void start() {
        for (var q : questions) {
            System.out.printf("%d. %s\n", q.number(), q.question());
            for (var a : q.answers().entrySet()) {
                System.out.printf("%s) %s\n", a.getKey(), a.getValue());
            }

            Question.Answer userChoice;
            do {
                try {
                    userChoice = Question.Answer.valueOf(in.next().toUpperCase());
                    break;
                } catch (RuntimeException e) {
                    System.err.printf("Valid options are: %s (case-insensitive)\n", Arrays.toString(Question.Answer.values()));
                }
            } while (true);

            if (userChoice.equals(q.correctAnswer())) {
                score++;
            }
        }
        System.out.printf("Score: %d/%d\n", score, questions.length);
    }
}

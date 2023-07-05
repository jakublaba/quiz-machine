import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Main {
    private static final String JAVA_QUIZ = "java_quiz.json";

    public static void main(String[] args) {
        var objMapper = new ObjectMapper();

        try (var inputStream = Main.class.getClassLoader().getResourceAsStream(JAVA_QUIZ)) {
            var questions = objMapper.readValue(inputStream, Question[].class);
            var quiz = new Quiz(questions);
            quiz.start();
        } catch (IOException e) {
            throw new RuntimeException("An exception occurred while loading quiz questions", e);
        }
    }
}

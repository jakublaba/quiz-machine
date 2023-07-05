import java.util.Map;

public record Question(
        String question,
        Map<Answer, String> answers,
        Answer correctAnswer
) {
    public enum Answer {
        A, B, C, D,
    }
}

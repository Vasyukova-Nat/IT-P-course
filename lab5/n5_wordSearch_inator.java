package lab5;

import java.util.regex.*;

public class n5_wordSearch_inator {
    public static void main(String[] args) {
        String text = "My Car iS very angRy";
        // String text = null;
        String X = "c"; // символ который ищем

        try {
            Pattern pattern = Pattern.compile("\\b" + X + "[a-zA-Z]*\\b");
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                System.out.println(matcher.group());
            }

        } catch (NullPointerException e) {
            System.err.println("Error: Введен пустой текст ");
        } catch (PatternSyntaxException e) {
            System.err.println("Error: Некорректный regex - " + e.getDescription());
        } catch (Exception e) {
            System.err.println("Error: Какое-то исключение - " + e.getMessage());
        }
    }
}

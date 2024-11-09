package lab5;

import java.util.regex.*;

public class n3_largeLetters_inator {
    public static void main(String[] args) {
        String text = "МоЙ Кот оченЬ сердИТый А";
        // String text = null;

        try {
            Pattern pattern = Pattern.compile("([a-zа-яё])([A-ZА-ЯЁ])");
            Matcher matcher = pattern.matcher(text);

            String o = matcher.replaceAll("!$1$2!");
            System.out.println(o);

        } catch (NullPointerException e) {
            System.err.println("Error: Введен пустой текст ");
        } catch (PatternSyntaxException e) {
            System.err.println("Error: Некорректный regex - " + e.getDescription());
        } catch (Exception e) {
            System.err.println("Error: Какое-то исключение - " + e.getMessage());
        }
    }
}

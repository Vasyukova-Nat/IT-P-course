package lab5;

import java.util.regex.*;

public class n1_NumberFinder {
    public static void main(String[] args) {
        String text = "The price of the product is $19.99";
        // String text = null;

        try {
            // Pattern pattern = Pattern.compile("\\d+\\.\\d+" );
            // Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
            Pattern pattern = Pattern.compile("\\d+([.,]\\d+)?"); // итоговый вариант
            // Pattern pattern = Pattern.compile("[");

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

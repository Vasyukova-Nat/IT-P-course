package lab5;

import java.util.regex.*;

public class n2_password_inator {
    public static void main(String[] args) {
        String password = "3Fgsfwfq";
        // String password = null;

        try {
            Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$");
            // Pattern pattern = Pattern.compile("[");

            Matcher matcher = pattern.matcher(password);

            if (matcher.matches()) {
                System.out.println("Пароль корректен! ^.^");
            } else {
                System.out.println("Пароль некорректен");
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

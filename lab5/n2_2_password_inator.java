package lab5;

import java.util.regex.*;

public class n2_2_password_inator {
    public static void main(String[] args) {
        String password = "3Fgfq";

        if (password == null || password.isEmpty()) {
            System.out.println("Пароль не может быть пустым!");
            return;
        }

        Pattern lengthPattern = Pattern.compile(".{8,16}");
        Pattern uppercasePattern = Pattern.compile("[A-Z]");
        Pattern digitPattern = Pattern.compile("\\d");

        Matcher lengthMatcher = lengthPattern.matcher(password);
        Matcher uppercaseMatcher = uppercasePattern.matcher(password);
        Matcher digitMatcher = digitPattern.matcher(password);

        StringBuilder errorMessage = new StringBuilder();

        if (!lengthMatcher.find()) {
            errorMessage.append("Длина пароля должна быть от 8 до 16 символов.\n");
        }
        if (!uppercaseMatcher.find()) {
            errorMessage.append("должен содержать хотя бы одну заглавную букву.\n");
        }
        if (!digitMatcher.find()) {
            errorMessage.append("должен содержать хотя бы одну цифру.\n");
        }

        if (errorMessage.length() > 0) {
            System.out.println("Пароль некорректен:\n" + errorMessage);
        } else {
            System.out.println("Пароль корректен! ^.^");
        }
    }
}

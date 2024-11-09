package lab5;

import java.util.regex.*;

public class n4_IP {
    public static void main(String[] args) {
        // String IP = "0.0.0.0";
        String IP = "255.255.255.255";
        // String IP = "10.20.30.40";
        // String IP = "111.234.123.01";
        // String IP = null;

        // ^(25[0-5]|2[0-4][0-9]|[0-9]{1,2}|1[0-9]{2})$
        // ^(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[0-9][0-9]|[0-9])$
        String regex = "^((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[0-9][0-9]|[0-9])(\\.|$)){4}$";

        try {
            Pattern pattern = Pattern.compile(regex);

            Matcher matcher = pattern.matcher(IP);
            if (matcher.matches()) {
                System.out.println("IP корректен! ^.^");
            } else {
                System.out.println("IP некорректен");
            }
        } catch (NullPointerException e) {
            System.err.println("Error: Введен пустой текст");
        } catch (PatternSyntaxException e) {
            System.err.println("Error: Некорректный regex - " + e.getDescription());
        } catch (Exception e) {
            System.err.println("Error: Какое-то исключение - " + e.getMessage());
        }
    }
}

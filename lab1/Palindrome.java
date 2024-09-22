// Программа может работать как с заглавными, так и со строчными буквами!
public class Palindrome {
    public static void main(String[] args) { // args - параметр который можно указать при запуске через cmd.
                                             // Например java Palindrome.java Amogusugoma 828 rar
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if (isPalindrome(s)) {
                System.out.println(s + " - yes");
            } else {
                System.out.println(s + " - no");
            }
        }
    }

    public static String reverseString(String s) {
        String reversed = "";
        for (int i = s.length() - 1; i >= 0; i--) { // с индекса последнего символа (s.length() - 1)
                                                    // до индекса первого (0)
            reversed += s.charAt(i); // получение символа строки, находящегося на позиции i.
        }
        return reversed;
    }

    public static boolean isPalindrome(String s) {
        String reversed = reverseString(s);
        s = s.toLowerCase(); // .toLowerCase() - перевести всю строку в нижний регистр
        reversed = reversed.toLowerCase(); // или toUpperCase()
        return s.equals(reversed); // .equals() сравнивает строки
    }
}

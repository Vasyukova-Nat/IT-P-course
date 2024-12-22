package tasks;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AllTasks6 {
    public static void main(String[] args) {
        System.out.println("Task 1");
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));

        System.out.println("\n" + "Task 2");
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2"));
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2", Arrays.asList("b")));
        System.out.println(stripUrlParams("https://edabit.com", Arrays.asList("b")));

        System.out.println("\n" + "Task 3");
        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println(nicoCipher("edabitisamazing", "matt"));
        System.out.println(nicoCipher("iloveher", "612345"));

        System.out.println("\n" + "Task 4");
        System.out.println((twoProduct(new int[] { 1, 2, 3, 9, 4, 5, 15, 3 }, 45)));
        System.out.println((twoProduct(new int[] { 1, 2, 3, 9, 4, 15, 3, 5 }, 45)));
        System.out.println((twoProduct(new int[] { 1, 2, -1, 4, 5, 6, 10, 7 }, 20)));
        System.out.println((twoProduct(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 10)));
        System.out.println((twoProduct(new int[] { 100, 12, 4, 1, 2 }, 15)));

        System.out.println("\n" + "Task 5");
        System.out.println(Arrays.toString(isExact(6)));
        System.out.println(Arrays.toString(isExact(24)));
        System.out.println(Arrays.toString(isExact(125)));
        System.out.println(Arrays.toString(isExact(720)));
        System.out.println(Arrays.toString(isExact(1024)));
        System.out.println(Arrays.toString(isExact(40320)));

        System.out.println("\n" + "Task 6");
        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("1.(1)"));
        System.out.println(fractions("3.(142857)"));
        System.out.println(fractions("0.19(2367)"));
        System.out.println(fractions("0.1097(3)"));

        System.out.println("\n" + "Task 7");
        System.out.println(pilishString("33314444"));
        System.out.println(pilishString("TOP"));
        System.out.println(pilishString("X"));
        System.out.println(pilishString(""));

        System.out.println("\n" + "Task 8");
        System.out.println(formula("6 * 4 = 24"));
        System.out.println(formula("18 / 17 = 2"));
        System.out.println(formula("16 * 10 = 160 = 14 + 120"));

        System.out.println("\n" + "Task 9");
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedcba"));

        System.out.println("\n" + "Task 10");
        System.out.println(palindromeDescendant(11211230));
        System.out.println(palindromeDescendant(13001120));
        System.out.println(palindromeDescendant(23336014));
        System.out.println(palindromeDescendant(11));
    }

    // Task 1
    public static String hiddenAnagram(String s, String target) {
        String cleanedS = s.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String cleanedTarget = target.replaceAll("[^a-zA-Z]", "").toLowerCase();

        Map<Character, Integer> targetCount = new HashMap<>();
        for (char c : cleanedTarget.toCharArray()) {
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }

        int targetLength = cleanedTarget.length();

        for (int i = 0; i <= cleanedS.length() - targetLength; i++) {
            String substring = cleanedS.substring(i, i + targetLength);
            if (isAnagram(substring, targetCount)) {
                return substring;
            }
        }

        return "noutfond";
    }

    private static boolean isAnagram(String substring, Map<Character, Integer> targetCount) {
        Map<Character, Integer> substringCount = new HashMap<>();
        for (char c : substring.toCharArray()) {
            substringCount.put(c, substringCount.getOrDefault(c, 0) + 1);
        }
        return substringCount.equals(targetCount);
    }

    // Task 2
    public static String stripUrlParams(String url) {
        return stripUrlParams(url, new ArrayList<>());
    }

    public static String stripUrlParams(String url, List<String> paramsToRemove) {
        if (url.length() < 1) {
            return "";
        }

        String[] parts = url.split("\\?"); // разделяем URL на базовую часть и параметры
        String baseUrl = parts[0];
        Map<String, String> paramMap = new LinkedHashMap<>();

        if (parts.length > 1) { // если есть пар-ры
            String[] params = parts[1].split("&");
            for (String param : params) {
                String[] keyValue = param.split("=");
                String key = keyValue[0];
                String value = keyValue.length > 1 ? keyValue[1] : "";

                // если параметр не в списке для удаления, добавляем его в карту
                if (!paramsToRemove.contains(key)) {
                    paramMap.put(key, value);
                }
            }
        }

        List<String> sortedKeys = new ArrayList<>(paramMap.keySet()); // удаляем дубликаты параметров. Оставляем только
                                                                      // последний
        Collections.sort(sortedKeys);

        StringBuilder result = new StringBuilder(baseUrl); // это будет результирующий URL
        if (!sortedKeys.isEmpty()) {
            result.append("?");
            for (String key : sortedKeys) {
                result.append(key).append("=").append(paramMap.get(key)).append("&");
            }
            result.setLength(result.length() - 1); // удаляем последний '&'
        }
        return result.toString();
    }

    // Task 3
    public static String nicoCipher(String message, String key) {
        int keyLength = key.length();

        Integer[] keyOrder = getKeyOrder(key);

        int padding = keyLength - (message.length() % keyLength);
        if (padding != keyLength) {
            message += " ".repeat(padding);
        }

        int rows = message.length() / keyLength;
        char[][] grid = new char[rows][keyLength];
        for (int i = 0; i < message.length(); i++) {
            grid[i / keyLength][i % keyLength] = message.charAt(i);
        }

        char[][] sortedGrid = new char[rows][keyLength];
        for (int i = 0; i < keyLength; i++) {
            int targetColumn = keyOrder[i];
            for (int j = 0; j < rows; j++) {
                sortedGrid[j][i] = grid[j][targetColumn];
            }
        }

        StringBuilder result = new StringBuilder();
        for (char[] row : sortedGrid) {
            for (char c : row) {
                result.append(c);
            }
        }

        return result.toString();
    }

    private static Integer[] getKeyOrder(String key) {
        Character[] keyChars = key.chars()
                .mapToObj(c -> (char) c)
                .toArray(Character[]::new);

        Character[] sortedKeyChars = keyChars.clone();
        Arrays.sort(sortedKeyChars);

        Map<Character, Queue<Integer>> charIndexMap = new HashMap<>();
        for (int i = 0; i < keyChars.length; i++) {
            charIndexMap.putIfAbsent(keyChars[i], new LinkedList<>());
            charIndexMap.get(keyChars[i]).add(i);
        }

        Integer[] keyOrder = new Integer[key.length()];
        for (int i = 0; i < sortedKeyChars.length; i++) {
            keyOrder[i] = charIndexMap.get(sortedKeyChars[i]).poll();
        }

        return keyOrder;
    }

    // Task 4
    public static String twoProduct(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (n % arr[i] == 0) {
                int complement = n / arr[i];
                if (map.containsKey(complement) && map.get(complement) < i) {
                    return Arrays.toString(new int[] { complement, arr[i] });
                }
                map.put(arr[i], i);
            }
        }
        return Arrays.toString(new int[] {});
    }

    // Task 5
    public static int[] isExact(int number) {
        return isExactHelper(number, 1, 1);
    }

    private static int[] isExactHelper(int target, int n, int factorial) {
        if (factorial == target) {
            return new int[] { target, n };
        } else if (factorial > target) {
            return new int[] {};
        } else {
            return isExactHelper(target, n + 1, factorial * (n + 1));
        }
    }

    // Task 6
    public static String fractions(String decimal) {
        String regex = "(\\d*)\\.(\\d*)\\((\\d+)\\)"; // регех
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(decimal);

        if (matcher.matches()) {
            String integerPart = matcher.group(1);
            String nonRepeatingPart = matcher.group(2);
            String repeatingPart = matcher.group(3);

            long integer = integerPart.isEmpty() ? 0 : Long.parseLong(integerPart);
            long nonRepeatingLength = nonRepeatingPart.length();
            long repeatingLength = repeatingPart.length();

            long numerator = 0;
            long denominator = 1;

            if (nonRepeatingLength > 0) {
                numerator = Long.parseLong(nonRepeatingPart + repeatingPart) - Long.parseLong(nonRepeatingPart);
                denominator = (long) Math.pow(10, nonRepeatingLength) * (long) (Math.pow(10, repeatingLength) - 1);
            } else {
                numerator = Long.parseLong(repeatingPart);
                denominator = (long) (Math.pow(10, repeatingLength) - 1);
            }

            numerator += integer * denominator;

            long gcd = gcd(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;

            return numerator + "/" + denominator;
        }

        return "Invalid input";
    }

    // Метод для нахождения НОД
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Task 7
    public static String pilishString(String txt) {
        // Первая часть числа Пи: 3.14159265358979
        int[] piDigits = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9 };

        // Если строка пустая, возвращаем пустую строку
        if (txt == null || txt.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int i = 0;

        for (int length : piDigits) {
            if (i >= txt.length()) {
                break;
            }
            if (i + length > txt.length()) {
                String word = txt.substring(i);
                word += repeatLastChar(txt.charAt(txt.length() - 1), length - word.length());
                result.append(word);
                break;
            } else {
                result.append(txt, i, i + length);
                i += length;
            }
            if (i < txt.length() && result.length() < txt.length() + piDigits.length) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    private static String repeatLastChar(char lastChar, int times) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(lastChar).repeat(Math.max(0, times)));
        return sb.toString();
    }

    // Task 8
    public static boolean formula(String str) {
        // Удаляем пробелы из строки
        str = str.replaceAll("\\s+", "");

        // Разделяем строку на части по знаку равенства
        String[] parts = str.split("=");

        // Если количество частей больше 2, формула неправильная
        if (parts.length != 2) {
            return false;
        }

        // Проверяем каждую часть на правильность
        String leftSide = parts[0];
        String rightSide = parts[1];

        // Вычисляем значение левой части
        double leftValue = evaluateExpression(leftSide);
        // Вычисляем значение правой части
        double rightValue = evaluateExpression(rightSide);

        // Сравниваем значения
        return leftValue == rightValue;
    }

    private static double evaluateExpression(String expression) {
        // Здесь можно использовать простую реализацию для вычисления выражений
        // Например, поддержка только операций +, -, *, /
        String[] tokens = expression.split("(?=[-+*/])|(?<=[-+*/])");
        double result = 0;
        double currentNumber = 0;
        String currentOperation = "+";

        for (String token : tokens) {
            token = token.trim();
            if (token.isEmpty())
                continue;

            if (token.matches("-?\\d+(\\.\\d+)?")) { // Если это число
                currentNumber = Double.parseDouble(token);
                switch (currentOperation) {
                    case "+":
                        result += currentNumber;
                        break;
                    case "-":
                        result -= currentNumber;
                        break;
                    case "*":
                        result *= currentNumber;
                        break;
                    case "/":
                        if (currentNumber != 0) {
                            result /= currentNumber;
                        } else {
                            throw new ArithmeticException("Division by zero");
                        }
                        break;
                }
            } else { // Если это операция
                currentOperation = token;
            }
        }

        return result;
    }

    // Task 9
    public static String isValid(String s) {
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        Map<Integer, Integer> frequencyCount = new HashMap<>();
        for (int freq : charFrequency.values()) {
            frequencyCount.put(freq, frequencyCount.getOrDefault(freq, 0) + 1);
        }

        if (frequencyCount.size() == 1) {
            return "YES";
        }

        if (frequencyCount.size() > 2) {
            return "NO";
        }

        int freq1 = -1;
        int freq2 = -1;
        int count1 = 0;
        int count2 = 0;

        for (var entry : frequencyCount.entrySet()) {
            if (freq1 == -1) {
                freq1 = entry.getKey();
                count1 = entry.getValue();
            } else {
                freq2 = entry.getKey();
                count2 = entry.getValue();
            }
        }

        if ((freq1 == 1 && count1 == 1) || (freq2 == 1 && count2 == 1)) {
            return "YES";
        }

        if ((Math.abs(freq1 - freq2) == 1) && ((freq1 > freq2 && count1 == 1) || (freq2 > freq1 && count2 == 1))) {
            return "YES";
        }

        return "NO";
    }

    // Task 10
    public static boolean palindromeDescendant(long number) {
        String num = String.valueOf(number);

        while (num.length() >= 2) {
            if (isPalindrome(num)) {
                return true;
            }
            if (num.length() < 2) {
                break;
            }
            num = getDescendant(num);
        }
        return false;
    }

    // является ли строка палиндромом
    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static String getDescendant(String num) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < num.length(); i += 2) {
            int digit1 = Character.getNumericValue(num.charAt(i));
            int digit2 = Character.getNumericValue(num.charAt(i + 1));
            result.append(digit1 + digit2);
        }

        return result.toString();
    }
}

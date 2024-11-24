package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllTasks5 {
    public static void main(String[] args) {
        System.out.println("Task 1");
        String s1 = "FFFF";
        String s2 = "ABCD";
        System.out.println(sameLetterPattern(s1, s2));

        System.out.println("\n" + "Task 2");
        System.out.println(memeSum(26, 39));

        System.out.println("\n" + "Task 3");
        System.out.println(digitsCount(0, 1289396387328L));
        System.out.println(digitsCount2(1289396387328L));

        System.out.println("\n" + "Task 4");
        System.out.println(totalPoints(new String[] { "cat", "create", "sat" }, "caster"));
        System.out.println(totalPoints(new String[] { "trance", "recant" }, "recant"));
        System.out.println(totalPoints(new String[] { "dote",
                "dotes", "toes", "set", "dot", "dots", "sted" }, "tossed"));

        System.out.println("\n" + "Task 5");
        System.out.println(longestRun(new int[] { 1, 2, 3, 5, 6, 7, 8, 9 }));
        System.out.println(longestRun(new int[] { 1, 2, 3, 10, 11, 15 }));
        System.out.println(longestRun(new int[] { 5, 4, 2, 1 }));
        System.out.println(longestRun(new int[] { 3, 5, 7, 10, 15 }));

        System.out.println("\n" + "Task 6");
        // String[] m4 = { "53%", "79%" };
        // String[] m4 = { "10%" };
        String[] m4 = { "95%", "83%", "90%", "87%", "88%", "93%" };
        System.out.println(takeDownAverage(m4));

        System.out.println("\n" + "Task 7");
        System.out.println(canMove("Rook", "A8", "H8"));
        System.out.println(canMove("Bishop", "A7", "G1"));
        System.out.println(canMove("Queen", "C4", "D6"));

        System.out.println("\n" + "Task 8");
        System.out.println(maxPossible(9328, 456));
        System.out.println(maxPossible(523, 76));
        System.out.println(maxPossible(9132, 5564));
        System.out.println(maxPossible(8732, 91255));

        System.out.println("\n" + "Task 9");
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));

        System.out.println("\n" + "Task 10");
        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(689));
        System.out.println(isNew(509));
    }

    public static List<Integer> positions(String s, char a) { // вспомогательный метод для Task1
        List<Integer> symbols = new ArrayList<>();
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == a) {
                symbols.add(i);
            }
        return symbols;
    }

    public static boolean sameLetterPattern(String s1, String s2) { // Task1
        boolean flag = true;
        for (int i = 0; i < s1.length(); i++) {
            List<Integer> l1 = positions(s1, s1.charAt(i));
            List<Integer> l2 = positions(s2, s2.charAt(i));
            if (!l1.equals(l2)) {
                flag = false;
            }
        }
        return flag;
    }

    public static String memeSum(int a, int b) { // Task 2
        // просьба ставить более длинное число в переменную a12
        String o = "";

        String as = String.valueOf(a);
        String bs = String.valueOf(b);

        List<Integer> al = new ArrayList<>();
        List<Integer> bl = new ArrayList<>();
        if (as.length() >= bs.length()) {
            while (a != 0) {
                al.add(0, a % 10); // добавляем цифры в начало списка
                a /= 10;
            }

            while (b != 0) {
                bl.add(0, b % 10); // добавляем цифры в начало списка
                b /= 10;
            }
            for (int i = 0; i < as.length() - bs.length(); i++) {
                bl.add(0, 0); // добавляем ноль в начало списка
            }
        }

        for (int i = 0; i < al.size(); i++) {
            o += (al.get(i) + bl.get(i));
        }

        return o;
    }

    public static int digitsCount(int o, long a) { // Task 3 усложненная версия
        if (a < 10)
            return o + 1;
        o += 1;
        return digitsCount(o, a / 10);
    }

    public static int digitsCount2(long a) { // Task 3 упрощенная версия
        if (a < 10)
            return 1;
        return 1 + digitsCount2(a / 10);
    }

    public static int totalPoints(String[] m, String decrypted) { // Task 4
        int o = 0;
        ArrayList<Character> ansChars = new ArrayList<Character>();

        for (int i = 0; i < decrypted.length(); i++) {
            ansChars.add(decrypted.charAt(i));
        }

        for (String i : m) {
            ArrayList<Character> mChars = new ArrayList<Character>();
            for (char j : i.toCharArray())
                mChars.add(j);
            for (char j : ansChars)
                mChars.remove((Character) j);
            if (!mChars.isEmpty()) {
                continue;
            }

            if (i.length() == 3) {
                o += 1;
                break;
            } else if (i.length() == 4) {
                o += 2;
                break;
            } else if (i.length() == 5) {
                o += 3;
                break;
            } else if (i.length() == 6) {
                o += 54;
                break;
            }
        }

        return o;
    }

    public static int longestRun(int[] m) { // Task 5
        List<Integer> maxk = new ArrayList<>();
        int k = 1;

        for (int i = 1; i < m.length; i++) { // если увеличивается
            if (m[i] == m[i - 1] + 1) {
                k += 1;
            } else {
                maxk.add(k);
                k = 1;
            }
            if (i == m.length - 1) {
                maxk.add(k);
            }
        }
        for (int i = 1; i < m.length; i++) { // если уменьшается
            if (m[i] == m[i - 1] - 1) {
                k += 1;
            } else {
                maxk.add(k);
                k = 1;
            }
            if (i == m.length - 1) {
                maxk.add(k);
            }
        }

        return Collections.max(maxk);
    }

    public static String takeDownAverage(String[] m) { // Task 6
        double k = m.length;
        double summ = 0;
        for (String elem : m) {
            int num = Integer.parseInt(elem.replaceAll("\\D", ""));
            summ += num;
        }
        double perc = summ / k;
        double x = (perc - 5) * (k + 1) - summ;

        return Math.floor(x) + "%";
    }

    public static boolean canMove(String piece, String currentPos, String targetPos) { // Task 7
        int currentX = currentPos.charAt(0) - 'A'; // считаем числовые коды букв. Например 'A'-'A'=0
        int currentY = currentPos.charAt(1) - '1';
        int targetX = targetPos.charAt(0) - 'A';
        int targetY = targetPos.charAt(1) - '1';

        switch (piece) {
            case "Pawn":
                // Пешка может двигаться на одну клетку вперед (вверх по доске)
                return currentX == targetX && targetY == currentY + 1;
            case "Knight":
                // Конь может двигаться буквой "Г"
                return (Math.abs(currentX - targetX) == 2 && Math.abs(currentY - targetY) == 1) ||
                        (Math.abs(currentX - targetX) == 1 && Math.abs(currentY - targetY) == 2);
            case "Bishop":
                // Слон может двигаться по диагонали
                return Math.abs(currentX - targetX) == Math.abs(currentY - targetY);
            case "Rook":
                // Ладья может двигаться по вертикали или горизонтали
                return currentX == targetX || currentY == targetY;
            case "Queen":
                // Ферзь может двигаться как слон или ладья
                return Math.abs(currentX - targetX) == Math.abs(currentY - targetY) ||
                        currentX == targetX || currentY == targetY;
            case "King":
                // Король может двигаться на одну клетку в любом направлении
                return Math.abs(currentX - targetX) <= 1 && Math.abs(currentY - targetY) <= 1;
            default:
                return false; // Неверное имя фигуры
        }
    }

    // public static int maxPossible(int a, int b) {
    // String aStr = Integer.toString(a);
    // String bStr = Integer.toString(b);
    // String cStr = aStr + bStr;
    // Set<Character> uniqueDigits = new HashSet<>();
    // for (char c : cStr.toCharArray()) {
    // uniqueDigits.add(c);
    // }

    // List<Character> sortedList = new ArrayList<>(uniqueDigits);
    // Collections.sort(sortedList, Comparator.reverseOrder()); // сортируем по
    // убыванию

    // String res = "";
    // for (int i = 0; i < aStr.length() && i < sortedList.size(); i++) {
    // res += sortedList.get(i);
    // }

    // return 0;
    // }

    public static int maxPossible(int num1, int num2) { // Task 8
        char[] digits1 = String.valueOf(num1).toCharArray(); // Преобразуем в массивы символов
        char[] digits2 = String.valueOf(num2).toCharArray();

        Arrays.sort(digits2); // для цифр второго числа

        StringBuilder sb = new StringBuilder();
        int index = digits2.length - 1; // Индекс для массива цифр второго числа

        for (int i = 0; i < digits1.length; i++) {
            // Если есть еще цифры во втором числе и текущая цифра первого числа меньше
            // чем текущая цифра второго числа, заменяем
            if (index >= 0 && digits1[i] < digits2[index]) {
                sb.append(digits2[index]);
                index -= 1; // Переходим к следующей цифре второго числа
            } else {
                sb.append(digits1[i]); // Оставляем цифру первого числа
            }
        }

        return Integer.parseInt(sb.toString());
    }

    public static String timeDifference(String cityA, String timeA, String cityB) { // Task 9
        String[] months = { "", "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December", "January" };
        int[] daysInMonths = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        HashMap<String, Double> gmt = new HashMap<String, Double>();
        gmt.put("Los Angeles", -8.0);
        gmt.put("New York", -5.0);
        gmt.put("Caracas", -4.5);
        gmt.put("Buenos Aires", -3.0);
        gmt.put("London", 0.0);
        gmt.put("Rome", 1.0);
        gmt.put("Moscow", 3.0);
        gmt.put("Tehran", 3.5);
        gmt.put("New Delhi", 5.5);
        gmt.put("Beijing", 8.0);
        gmt.put("Canberra", 10.0);

        // "April 1, 2011 23:23"
        timeA = timeA.replaceAll(",", "");
        String[] split = timeA.split("\\s+");
        String inMonth = split[0];
        String inDay = split[1];
        String inYear = split[2];
        String inTime1 = split[3];
        int inHours = Integer.parseInt(inTime1.substring(0, 2));
        int inMinutes = Integer.parseInt(inTime1.substring(3, 5));
        int indexInMonth = 0;
        for (int i = 0; i < months.length; i++) {
            if (inMonth.equals(months[i])) {
                indexInMonth = i;
            }
        }
        int daysInMonth = daysInMonths[indexInMonth];

        double gmtA = gmt.get(cityA);
        double gmtB = gmt.get(cityB);
        double diff = gmtB - gmtA;
        double diffMinutes = (diff % 1) * 60;
        double diffHours = diff - (diff % 1);
        String outTime = "";
        double outMinutes = inMinutes + diffMinutes;
        double outHours = inHours + diffHours;

        int outYear = Integer.parseInt(inYear);
        int outDay = Integer.parseInt(inDay);
        if (outMinutes > 60) {
            outHours += 1;
        }
        if (outHours > 23) {
            outHours = outHours - 24;
            outDay += 1;
        }
        if (outDay > daysInMonth) {
            outDay -= daysInMonth;
            indexInMonth += 1;
        }
        if (indexInMonth > 12) {
            indexInMonth -= 12;
            outYear += 1;
        }

        if (outHours < 10 && outMinutes < 10) {
            outTime = "0" + (int) outHours + ":0" + (int) outMinutes;
        } else if (outHours < 10) {
            outTime = "0" + (int) outHours + ":" + (int) outMinutes;
        } else if (outMinutes < 10) {
            outTime = (int) outHours + ":0" + (int) outMinutes;
        } else {
            outTime = (int) outHours + ":" + (int) outMinutes;
        }

        return outYear + "-" + indexInMonth + "-" + outDay + " " + outTime;
    }

    public static boolean isNew(int number) { // Task 10
        char[] digits = String.valueOf(number).toCharArray();
        Arrays.sort(digits);

        for (int i = 0; i < number; i++) { // Проверяем все меньшие числа
            char[] smallerDigits = String.valueOf(i).toCharArray();
            Arrays.sort(smallerDigits);

            if (Arrays.equals(digits, smallerDigits)) { // если равны - это перестановка
                return false; // не новое число
            }
        }

        return true;
    }
}

package tasks;

import java.util.ArrayList;
import java.util.List;

public class a {
    public static void main(String[] args) {
        System.out.println(bruteForce(2, 6));
    }

    public static List<String> bruteForce(int n, int k) {
        List<String> result = new ArrayList<>();
        generateCombinations("", n, k, result); // Вызываем вспомогательный метод для генерации комбинаций
        return result;
    }

    // Вспомогательный метод для рекурсивной генерации комбинаций
    private static void generateCombinations(String prefix, int n, int k, List<String> result) {
        // Если длина префикса равна n, добавляем его в результат
        if (prefix.length() == n) {
            result.add(prefix); // Добавляем текущую комбинацию в список результатов
            return; // Завершаем выполнение метода
        }

        // Генерируем символы от 0 до k-1
        for (int i = 0; i < k; i++) { // Проходим по всем возможным символам
            // Проверяем, что символ не повторяется в текущем префиксе
            if (!prefix.contains(String.valueOf(i))) {
                // Рекурсивно вызываем метод, добавляя текущий символ к префиксу
                generateCombinations(prefix + i, n, k, result);
            }
        }
    }
}

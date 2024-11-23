package lab6;

import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.util.*;

public class n1_top10 {
    public static void main(String[] args) {
        Map<String, Integer> wordCountMap = new HashMap<>(); // создаем пустую хэш-карту

        try {
            FileReader fileReader = new FileReader("C:\\Users\\lucky\\Desktop\\ITIP\\lab6\\input.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) { // Используется метод readLine() для чтения построчно.
                                                                 // Если больше строк нет, возвращается null
                String[] words = line.split("\\s+"); // разбиваем строку на слова по пробелам
                for (String word : words) {
                    word = word.replaceAll("[.,]", "").toLowerCase(); // удаляем . и ,

                    if (!word.isEmpty()) {
                        wordCountMap.putIfAbsent(word, 0); // Если слово еще не встречалось, добавляем его с нулевым
                                                           // количеством
                        wordCountMap.computeIfPresent(word, (k, v) -> v + 1); // Если слово уже есть, увеличиваем
                                                                              // счетчик
                    }
                }
            }
            bufferedReader.close();

            // Сортируем список по убыванию количества повторений
            List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCountMap.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue()); // Сравниваем по значениям (по убыванию)
                }
            });

            int count = Math.min(10, list.size());
            for (int i = 0; i < count; i++) {
                System.out.println(i + 1 + ". " + list.get(i).getKey() + " - " + list.get(i).getValue() + " pieces");
            }

        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден / Отказано в доступе");
        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом");
        }
    }
}

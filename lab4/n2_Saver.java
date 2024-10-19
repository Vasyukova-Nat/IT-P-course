package lab4;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class n2_Saver {
    public static void main(String[] args) {
        // File file = new File("n2_meow.txt");

        try {
            // Файл для чтения
            FileReader fileReader = new FileReader("C:\\Users\\lucky\\Desktop\\ITIP\\lab4\\n2_meow.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) { // Используется метод readLine() для чтения построчно.
                                                                 // Если больше строк нет, возвращается null
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Файл для чтения не найден.");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла");
            // e.printStackTrace(); // выведет путь, пройденный программой до ошибки
        }
    }
}

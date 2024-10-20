
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class n2_Saver {
    public static void main(String[] args) {
        try {
            // Файл для чтения
            FileReader fileReader = new FileReader("C:\\Users\\lucky\\Desktop\\ITIP\\lab4\\n2_meow.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            // Файл для сохранения
            // FileWriter fileWriter = new
            // FileWriter("C:\\Users\\lucky\\Desktop\\ITIP\\lab4\\new_file.txt");
            FileWriter fileWriter = new FileWriter("C:\\Users\\lucky\\Desktop\\Защищенная директория\\new.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Цикл перебора и сохранения строк файла
            while ((line = bufferedReader.readLine()) != null) { // Используется метод readLine() для чтения построчно.
                                                                 // Если больше строк нет, возвращается null
                bufferedWriter.write(line + "\n");
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Файл не найден / Отказано в доступе");
            // ex.printStackTrace(); // выведет путь, пройденный программой до ошибки
        } catch (SecurityException e) {
            System.err.println("Ошибка доступа/безопасности");
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом");
        }
    }
}

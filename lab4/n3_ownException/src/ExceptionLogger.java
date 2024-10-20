import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class ExceptionLogger {

    private String logFilePath = "C:\\Users\\lucky\\Desktop\\ITIP\\lab4\\n3_ownException\\logs\\ex.txt";
    // public ExceptionLogger(String logFilePath) { //альтернатива
    // this.logFilePath = logFilePath;
    // }

    public void logException(Exception e) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(logFilePath, true))) {
            writer.println("\n" + LocalDateTime.now() + " - Exception: " + e.getMessage());
            e.printStackTrace(writer);
        } catch (IOException ioException) {
            System.err.println("Ошибка работы с файлом для сохранения логов");
            // ioException.printStackTrace();
        }
    }
}
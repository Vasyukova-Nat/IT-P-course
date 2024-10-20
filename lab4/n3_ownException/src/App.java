
public class App {
    public static void main(String[] args) throws Exception {
        ExceptionLogger logger = new ExceptionLogger(); // если в класс ExceptionLogger добавить конструктор, то здесь в
                                                        // скобках можно будет вписать местоположение как аргумент
        EmailValidator validator = new EmailValidator();
        String email = "murzocats.ru";

        try {
            validator.validateEmail(email);
            System.out.println("Email корректен!");
        } catch (CustomEmailFormatException e) {
            System.err.println("Ошибка: " + e.getMessage());
            logger.logException(e); // записываем в файл дату и printStackTrace
        }
    }
}

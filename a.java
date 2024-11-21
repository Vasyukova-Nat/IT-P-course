// Определение интерфейса
interface Animal {
    void makeSound(); // метод без реализации
}

// Класс Cat реализует интерфейс Animal
class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Мяу!");
    }
}

// Основной класс
public class a {
    public static void main(String[] args) {
        Animal cat = new Cat(); // создаем объект класса Cat

        cat.makeSound(); // вывод: Мяу!
    }
}
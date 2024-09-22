abstract class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) { // Конструктор инициализации
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Ниже геттеры и сеттеры: Методы доступа предоставляют возможность получить
    // (get) или установить (set) значение полей класса. Это позволяет другим
    // объектам и методам получать и изменять данные внутри экземпляров класса Book.
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public abstract void displayInfo();

}
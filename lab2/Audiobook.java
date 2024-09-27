class Audiobook extends Book {
    private double duration; // в часах
    private String narrator; // рассказчик
    private static int instanceCount = 0; // Счетчик экземпляров

    public Audiobook(String title, String author, int year, double duration, String narrator) {
        super(title, author, year);
        this.duration = duration;
        this.narrator = narrator;
        instanceCount++; // Увеличиваем счетчик при создании экземпляра
    }

    public Audiobook() { // Конструктор по умолчанию.
        this("--unidentified book--", "--unknown author--", 0000, -500, "--wind--");
        instanceCount++;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getNarrator() {
        return narrator;
    }

    public void setNarrator(String narrator) {
        this.narrator = narrator;
    }

    public static int getInstanceCount() {
        return instanceCount;
    }

    @Override // Реализация абстрактного метода
    public void displayInfo() { // здесь можно void заменить на String, а вывод на return
        System.out.println("Audiobook: " + getTitle() + ", Author: " + getAuthor() +
                ", Year: " + getYear() + ", Duration: " + duration + " hours" +
                ", Narrator: " + narrator);
    }
}
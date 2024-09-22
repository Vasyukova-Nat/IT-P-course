class Film extends Book {
    private double duration; // в минутах
    private String director;
    private String genre;

    public Film(String title, String author, int year, double duration, String director, String genre) {
        super(title, author, year);
        this.duration = duration;
        this.director = director;
        this.genre = genre;
    }

    public Film() { // Конструктор по умолчанию.
        this("--unidentified book--", "--unknown author--", 0000, -500, "--wind--", "--something ironic--");
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override // Реализация абстрактного метода
    public void displayInfo() {
        System.out.println("Film: " + getTitle() + ", Author: " + getAuthor() +
                ", Year: " + getYear() + ", Duration: " + duration + " minutes" +
                ", Director: " + director + ", Genre: " + genre);
    }
}
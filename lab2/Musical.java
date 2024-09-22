class Musical extends Book {
    private double duration; // в минутах
    private String composer;
    private int numberOfSongs;

    public Musical(String title, String author, int year, double duration, String composer, int numberOfSongs) {
        super(title, author, year);
        this.duration = duration;
        this.composer = composer;
        this.numberOfSongs = numberOfSongs;
    }

    public Musical() { // Конструктор по умолчанию.
        this("--unidentified book--", "--unknown author--", 0000, -500, "--wind--", 0);
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    public void setNumberOfSongs(int numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }

    @Override
    public void displayInfo() {
        System.out.println("Musical: " + getTitle() + ", Author: " + getAuthor() +
                ", Year: " + getYear() + ", Duration: " + duration + " minutes" +
                ", Composer: " + composer +
                ", Songs: " + numberOfSongs);
    }
}
// import examples.Point3d;

public class General {
    public static void main(String[] args) {
        Audiobook audiobook1 = new Audiobook("1984", "George Orwell", 1949, 11.5, "Елена Ландэ");
        Audiobook audiobook2 = new Audiobook("Большие кошки", "Natalia Vasyukova", 2023, 24, "Wise Cat");
        Audiobook audiobook3 = new Audiobook();
        Book film1 = new Film("Кошачьи войны", "Serik", 2022, 248, "Daria Manulova", "comedy");
        Book film2 = new Film();
        Book musical1 = new Musical("Легенда об Авокадо", "Райан Гослинг", 2005, 160, "Кристиан Бейл", 5);

        audiobook1.displayInfo();
        audiobook2.displayInfo();
        audiobook3.displayInfo();
        film1.displayInfo();
        musical1.displayInfo();
        film2.displayInfo();

        System.out.println("Всего аудиокниг: " + Audiobook.getInstanceCount()); // Счетчик экземпляров

        // Point3d myFirst3DPoint = new Point3d(5, 8, 2);
        // System.out.println("YYYY" + myFirst3DPoint.getX());

    }
}
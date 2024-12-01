package lab7;

public class n1_1_Main {
    public static void main(String[] args) {
        int[] m = { 1, 2, 3, 4, 5, 6, 7 };

        n1_1_arraySum thread1 = new n1_1_arraySum(m, 0, m.length / 2);
        n1_1_arraySum thread2 = new n1_1_arraySum(m, m.length / 2, m.length);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.err.println("Ошибка InterruptedException");
        }

        int totalSum = thread1.getSum() + thread2.getSum();
        System.out.println("Итоговая сумма: " + totalSum);
    }
}

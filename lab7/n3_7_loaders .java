// Вариант 7
package lab7;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class n3_7_loaders {
    private static int capacity = 0;

    // объект блокировки и условие для синхронизации потоков
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();

    // Класс для каждого потока
    public static class Loader implements Runnable {
        @Override
        public void run() {
            Random random = new Random();

            while (true) {
                try {
                    lock.lock(); // Блокируем доступ к общим ресурсам

                    if (n3_7_Main.products.isEmpty()) { // Проверяем, есть ли еще продукты
                        break;
                    }

                    // Выбираем случайный продукт
                    // int index = random.nextInt(n3_7_Main.products.size());
                    // int product = n3_7_Main.products.remove(index);

                    List<String> keys = new ArrayList<>(n3_7_Main.products.keySet());
                    int index = random.nextInt(keys.size());
                    String productKey = keys.get(index);
                    int product = n3_7_Main.products.get(productKey);

                    System.out.println(Thread.currentThread().getName() + ": взял продукт с весом " + product);

                    if (capacity + product < 150) { // прибавляем продукт к грузоподъемности
                        capacity += product;
                        System.out
                                .println(Thread.currentThread().getName() + ": добавил продукт " + " с весом " + product
                                        + ", текущая грузоподъемность: " + capacity);
                        n3_7_Main.products.remove(productKey);
                        n3_7_Main.loaded.put(productKey, product);
                    } else {
                        // n3_7_Main.products.add(index, product); // Если превышен лимит, возвращаем
                        // продукт обратно в список

                        System.out.println(Thread.currentThread().getName() + ": остановился");
                        break;
                    }

                    System.out.println("На складе " + n3_7_Main.products);
                    System.out.println("В тележке " + n3_7_Main.loaded);
                    condition.signalAll(); // условие пробуждения остальных потоков

                    Thread.sleep(random.nextInt(2000)); // задержка
                } catch (InterruptedException e) {
                    System.err.println("Ошибка InterruptedException");
                } finally {
                    lock.unlock(); // Освобождаем блокировку
                }
            }

            // Пробуждение остальных потоков после остановки текущего
            lock.lock();
            try {
                condition.signalAll();
            } finally {
                lock.unlock();
            }

        }
    }

    public static class Unloader implements Runnable {
        @Override
        public void run() {
            Random random = new Random();

            while (true) {
                try {
                    lock.lock(); // Блокируем доступ к общим ресурсам

                    if (n3_7_Main.loaded.isEmpty()) { // Проверяем, есть ли еще продукты
                        break;
                    }

                    // Выбираем случайный продукт
                    // int index = random.nextInt(n3_7_Main.products.size());
                    // int product = n3_7_Main.products.remove(index);

                    List<String> keys = new ArrayList<>(n3_7_Main.loaded.keySet());
                    int index = random.nextInt(keys.size());
                    String productKey = keys.get(index);
                    int product = n3_7_Main.loaded.get(productKey);

                    System.out.println(Thread.currentThread().getName() + ": взял продукт с весом " + product);

                    if (capacity - product < 150) { // прибавляем продукт к грузоподъемности
                        capacity -= product;
                        System.out
                                .println(Thread.currentThread().getName() + ": разгрузил продукт " + " с весом "
                                        + product
                                        + ", текущая грузоподъемность: " + capacity);
                        n3_7_Main.loaded.remove(productKey);
                        // n3_7_Main.loaded.put(productKey, product);
                    } else {
                        // n3_7_Main.products.add(index, product); // Если превышен лимит, возвращаем
                        // продукт обратно в список

                        System.out.println(Thread.currentThread().getName() + ": остановился");
                        break;
                    }

                    System.out.println("На складе " + n3_7_Main.products);
                    System.out.println("В тележке " + n3_7_Main.loaded);
                    condition.signalAll(); // условие пробуждения остальных потоков

                    Thread.sleep(random.nextInt(2000)); // задержка
                } catch (InterruptedException e) {
                    System.err.println("Ошибка InterruptedException");
                } finally {
                    lock.unlock(); // Освобождаем блокировку
                }
            }

            // Пробуждение остальных потоков после остановки текущего
            lock.lock();
            try {
                condition.signalAll();
            } finally {
                lock.unlock();
            }

        }
    }
}

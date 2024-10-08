// java Primes.java
public class Primes { // объявляем класс Primes
    public static void main(String[] args) { // void - метод не возвращает никакого значения.
                                             // String[] - метод принимает массив строк.
        for (int i = 2; i < 100 + 1; i++) { // цикл создает перем-ю i==2 и будет выполняться, пока i<100. i++ — после
                                            // каждой итерации значение i будет увеличиваться на 1.
            if (isPrime(i)) { // вызываем метод isPrime(i), чтобы проверить, является ли это число i простым
                System.out.println(i); // если i простое, то оно выводится на экран
            }
        }
    }

    public static boolean isPrime(int n) { // Определяем метод isPrime, он принимает целое n
                                           // и возвращает boolean (true/false) и говорит является ли n простым
        if (n < 2) // синтаксис "меньше либо равно" - (n <= 2)
            return false; // простые числа начинаются с 2
        for (int i = 2; i < n; i++) { // (ЛИБО i <= Math.sqrt(n)); цикл перебирает числа от 2 до квадратного корня из
                                      // n
            if (n % i == 0) {
                return false; // если n делится хотя бы на одно из этих i, то оно не простое (составное)
            }
        }
        return true; // если не нашелся ни один делитель, то число простое
    }
}
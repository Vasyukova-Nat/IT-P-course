package lab4;

public class n1_Array {
    public static void main(String[] args) {
        Object[] arr = { 1, 2, 3, 4, 9 };
        // arr = null; // обнуление массива
        try {
            System.out.println(calculateAverage(arr));
        } catch (ClassCastException e) { // можно писать сразу 2 исключения: NumberFormatException | ClassCastException
            System.out.println("Ошибка. Введено не число. Измените входные данные и попробуйте еще раз.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка. Выход за границы массива.");
        } catch (NullPointerException e) {
            System.out.println("Ошибка. На вход поступил пустой массив");
        }

    }

    public static double calculateAverage(Object[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) { // здесь может возникнуть исключение выхода за границы
            sum += (int) arr[i]; // здесь может возникнуть исключение ClassCastException
        }
        return (sum / arr.length);
    }
}

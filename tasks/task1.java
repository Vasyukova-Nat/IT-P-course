// Gallon_Convert
// 1 галлон = от 3.785 до 4.55 литра

package tasks;

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) { // убрать String[] args нельзя, т.к. это стандартная сигнатура для метода
                                             // main
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите кол-во чисел: ");
        int k = scanner.nextInt();

        for (int i = 0; i < k; i++) {
            System.out.print("Введите число галлонов: ");
            int a = scanner.nextInt();
            System.out.println("В переводе в литры оно будет равно " + a * (3.785));
        }

        scanner.close();
    }
}

package tasks;

import java.util.ArrayList;
import java.util.List;

public class b {

    public static void main(String[] args) {
        int[][] labyrinth1 = {
                { 1, 3, 1 },
                { 1, -1, 1 },
                { 4, 2, 1 }
        };

        int[][] labyrinth2 = {
                { 2, -7, 3 },
                { -4, -1, 8 },
                { 4, 5, 9 }
        };

        System.out.println(labirint(labyrinth1));
        System.out.println(labirint(labyrinth2));
    }

    public static List<String> labirint(int[][] matrix) {
        int n = matrix.length;
        List<String> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int minCost = findPath(matrix, n - 1, n - 1, path, 0);

        if (minCost == Integer.MAX_VALUE) {
            result.add("Прохода нет");
        } else {
            StringBuilder pathString = new StringBuilder();
            for (int i = path.size() - 1; i >= 0; i--) {
                pathString.append(path.get(i));
                if (i != 0) {
                    pathString.append("-");
                }
            }
            result.add(pathString.toString());
            result.add(String.valueOf(minCost));
        }
        return result;
    }

    private static int findPath(int[][] matrix, int x, int y, List<Integer> path, int currentCost) {
        // Проверка выхода за границы и на стенки
        if (x < 0 || y < 0 || matrix[x][y] < 0) {
            return Integer.MAX_VALUE;
        }

        // Если достигли верхнего левого угла
        if (x == 0 && y == 0) {
            path.add(matrix[x][y]);
            return currentCost + matrix[x][y];
        }

        // Добавляем текущую стоимость в путь
        path.add(matrix[x][y]);
        currentCost += matrix[x][y];

        // Рекурсивно ищем путь вверх и влево
        int costUp = findPath(matrix, x - 1, y, path, currentCost);
        int costLeft = findPath(matrix, x, y - 1, path, currentCost);

        // Убираем текущую ячейку из пути
        path.remove(path.size() - 1);

        // Возвращаем минимальную стоимость
        return Math.min(costUp, costLeft);
    }
}
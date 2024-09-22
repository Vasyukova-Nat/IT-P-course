package examples;

public class Point2d {
    private double xCoord; // координата X
    private double yCoord; // координата Y

    protected Point2d(double x, double y) { // Конструктор инициализации
        xCoord = x;
        yCoord = y;
    }

    protected Point2d() { // Конструктор по умолчанию.
        this(0, 0);
    }

    protected double getX() { // Возвращение координаты X
        return xCoord;
    }

    protected double getY() { // Возвращение координаты Y
        return yCoord;
    }

    protected void setX(double val) { // Установка значения координаты X.
        xCoord = val;
    }

    protected void setY(double val) { // Установка значения координаты Y.
        yCoord = val;
    }

    public static void main(String[] args) {
        // Point2d myPoint = new Point2d(); // создает точку (0,0)
        Point2d myOtherPoint = new Point2d(5, 3); // создает точку (5,3)
        double xValue = myOtherPoint.getX();
        System.out.println("X-координата: " + xValue);
    }

}
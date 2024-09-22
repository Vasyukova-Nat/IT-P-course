public class Point3d extends Point2d {
    private double zCoord; // координата Z

    public Point3d(double x, double y, double z) { // Конструктор инициализации
        super(x, y);
        zCoord = z;
    }

    public Point3d() { // Конструктор по умолчанию.
        this(0, 0, 0);
    }

    public double getZ() { // Возвращение координаты Z **/
        return zCoord;
    }

    public void setZ(double val) { // Установка значения координаты Z.
        zCoord = val;
    }

    public static void main(String[] args) {
        Point3d myFirst3DPoint = new Point3d(5, 3, 2);
        Point3d mySecond3DPoint = new Point3d(1, 2.0, 3);
        System.out.println(myFirst3DPoint.getX() + " " + mySecond3DPoint.getX());
    }
}
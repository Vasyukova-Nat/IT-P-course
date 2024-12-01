package lab7;

public class n1_1_arraySum extends Thread {
    private final int[] array;
    private final int start;
    private final int end;
    private int sum;

    public n1_1_arraySum(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
    }

    public int getSum() {
        return sum;
    }
}

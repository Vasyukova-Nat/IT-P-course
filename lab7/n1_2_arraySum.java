package lab7;

import java.util.concurrent.Callable;

public class n1_2_arraySum implements Callable<Integer> {
    private final int[] array;
    private final int start;
    private final int end;

    public n1_2_arraySum(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }
}

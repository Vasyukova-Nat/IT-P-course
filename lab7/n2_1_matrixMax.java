package lab7;

class n2_1_matrixMax extends Thread {
    private int[] row;
    private int maxElement;

    public n2_1_matrixMax(int[] row) {
        this.row = row;
    }

    @Override
    public void run() {
        maxElement = findMax(row);
    }

    private int findMax(int[] row) {
        int max = Integer.MIN_VALUE;
        for (int num : row) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public int getMaxElement() {
        return maxElement;
    }
}

import java.util.*;
class LambdaSkeleton {
    // Lets double all of the numbers in an array
    public static void main(String[] args) {
        int[] sample = new int[]{0, 3, 2, 4, 1, 5, 7, 6};
        System.out.println(Arrays.toString(sample));

        IntChange operation = new IntDoubler();
        for (int i = 0; i < sample.length; i++) {
            sample[i] = operation.change(sample[i]);
        }
        System.out.println(Arrays.toString(sample));
    }
}

interface IntChange {
    public int change(int in);
}
class IntDoubler implements IntChange {
    public int change(int in) {
        return in * 2;
    }
}

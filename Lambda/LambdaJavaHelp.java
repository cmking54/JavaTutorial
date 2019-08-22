import java.util.*;
import java.util.function.*;
class LambdaJavaHelp {
    // Lets double all of the numbers in an array
    public static void main(String[] args) {
        int[] sample = new int[]{0, 3, 2, 4, 1, 5, 7, 6};
        System.out.println(Arrays.toString(sample));
        Function<Integer, Integer> operation = n -> n * 2;
        for (int i = 0; i < sample.length; i++) {
            sample[i] = operation.apply(sample[i]);
        }
        // Arrays.stream(sample).forEach(n -> return n * 2);
        System.out.println(Arrays.toString(sample));
    }
}

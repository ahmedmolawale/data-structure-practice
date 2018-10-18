package ng.shoppi;

import java.util.Arrays;

public class ThreeSum {

    public static void findThreeSum(int data[]) {

        if (data.length < 3)
            throw new IllegalArgumentException("Invalid input.");

        Arrays.sort(data);
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length; j++) {
                int a = data[i];
                int b = data[j];
                if (a != b) {
                    int search = -a - b;
                    if (search != a && search != b) {
                        int index = Arrays.binarySearch(data, search);
                        if (!(index < 0)) {
                            System.out.println(a + " " + b + " " + search);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        findThreeSum(new int[]{-1, 0, -2});
    }
}

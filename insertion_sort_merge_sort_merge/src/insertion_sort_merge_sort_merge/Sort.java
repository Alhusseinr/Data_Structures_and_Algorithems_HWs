package insertion_sort_merge_sort_merge;

import java.util.*;

public class Sort {

    public static int[] insertion_sort(int[] array) {
        for (int j = 1; j < array.length; j++) {
            int key = array[j];
            int i = j - 1;

            while (i >= 0 && array[i] > key) {
                array[i + 1] = array[i];
                i = i - 1;
            }
            array[i + 1] = key;
        }
        return array;
    }

    public static int[] merge_sort(int[] array, int p, int r) {
        if (p < r) {

            int mid = (p + r) / 2;

            merge_sort(array, p, mid);

            merge_sort(array, mid + 1, r);

            merge(array, p, mid, r);

        }
        return array;
    }

    public static int[] merge(int[] array, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];

        for (int i = 1; i < n1; i++) {
            left[i] = array[p + i - 1];

            left[n1] = Integer.MAX_VALUE;
            right[n2] = Integer.MAX_VALUE;

            i = 0;
            int j = 0;

            for (int k = p; k <= r; k++) {
                if (left[i] <= right[j]) {
                    array[k] = left[i];
                    i = i + 1;
                } else {
                    array[k] = right[j];
                    j = j + 1;
                }
            }
        }
        return array;
    }

    public static int[] generate_random_array(int n, int k) {
        List<Integer> list;
        int[] array;
        Random rnd;
        rnd = new Random(System.currentTimeMillis());
        list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            list.add(new Integer(rnd.nextInt(k + 1)));
        }
        Collections.shuffle(list, rnd);
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = list.get(i).intValue();
        }
        return array;
    }/* * n: the size of the output array
     */
    public static int[] generate_random_array(int n) {
        List<Integer> list;
        int[] array;
        list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list, new Random(System.currentTimeMillis()));
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = list.get(i).intValue();
        }
        return array;
    }/* * Input: an integer array * Output: true if the array is acsendingly sorted, otherwise return false */
    public static boolean check_sorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }

    public static void print_array(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Insertion sort starts ------------------");
        for (int n = 100000; n <= 1000000; n = n + 100000) {
            int[] array = Sort.generate_random_array(n);
            //Sort.print_array(array);
            long t1 = System.currentTimeMillis();
            array = Sort.merge_sort(array, 0, n - 1);
            long t2 = System.currentTimeMillis();
            long t = t2 - t1;
            //Sort.print_array(array);
            boolean flag = Sort.check_sorted(array);
            System.out.println(n + "," + t + "," + flag);
        }
        System.out.println("Merge sort ends ------------------");
    }

}

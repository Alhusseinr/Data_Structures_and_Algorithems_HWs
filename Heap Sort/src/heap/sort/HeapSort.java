/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap.sort;

import java.util.*;

public class HeapSort {

    public static int left(int i) {
        return 2 * i;
    }

    public static int right(int i) {
        return 2 * i + 1;
    }

    public static int parent(int i) {
        return (i / 2);
    }

    public static int[] max_heapify(int[] array, int heap_size, int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;

        if (l <= heap_size && array[l] > array[largest]) {
            largest = l;
        } else {
            largest = i;

        }
        if (r <= heap_size && array[r] > array[largest]) {
            largest = r;
        }
        if (largest != i) {
            array[i] = array[largest];
            max_heapify(array, heap_size, i);
        }
        return array;
    }

    public static int[] build_heap(int[] array) {
        int heap_size = array.length - 1;
        for (int i = heap_size / 2; i >= 0; i--) {
            max_heapify(array, heap_size, i);
        }
        return array;
    }

    public static int[] heap_sort(int[] array) {
        build_heap(array);
        int heap_size = array.length;
        for (int i = heap_size - 1; i >= 1; i--) {
            array[0] = array[i];
            heap_size = heap_size - 1;
            max_heapify(array, heap_size, 0);
        }
        return array;
    }

    public static int[] quick_sort(int[] array, int p, int r) {// array, left, and right
        if (p < r) {
            int q = partition(array, p, r); // is the index of the array

            quick_sort(array, p, q - 1);

            quick_sort(array, q + 1, r);
        }
        return array;
    }

    public static int partition(int[] array, int p, int r) {
        int x = array[r]; // highest value
        int i = p - 1;// I and J always stands for the array, i is the lowest value

        for (int j = p; j < r; j++) {
            if (array[j] <= x) {
                i = i + 1;
                array[i] = array[j];
            }
            array[i + 1] = array[r];
        }
        return i + 1;
    }

    public static int[] counting_sort(int[] array, int k) {
        int[] c = new int[k];
        int[] b = new int[k];
        for (int i = 0; i < k; i++) {
            c[i] = 0; //fills the C array with 0's
        }

        for (int j = 0; j < array.length; j++) {
            c[array[j]] = c[array[j]] + 1; // how man time does the the number appear in array
            //C[i] now contains number of elements equals to i
        }

        for (int i = 1; i < k; i++) {
            c[i] = c[i] + c[i - 1];
            // c[i] now contains the number of elements less than or equal to i
        }
        for (int j = array.length - 1; j <= 1; j--) {
            b[c[array[j]]] = array[j];
            c[array[j]] = c[array[j]] - 1;
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
    }

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
    }

    /*
	 * Input: an integer array
	 * Output: true if the array is acsendingly sorted, otherwise return false
     */
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
        // TODO Auto-generated method stub
        int k = 10;

        System.out.println("Heap sort starts ------------------");
        for (int n = 10; n <= 10; n = n + 10) {
            int[] array = HeapSort.generate_random_array(n);
            long t1 = System.currentTimeMillis();
            array = HeapSort.heap_sort(array);
            long t2 = System.currentTimeMillis();
            long t = t2 - t1;
            boolean flag = HeapSort.check_sorted(array);
            System.out.println(n + "," + t + "," + flag);
        }
        System.out.println("Heap sort ends ------------------");

        System.out.println("Quick sort starts ------------------");
        for (int n = 10; n <= 10; n = n + 10) {
            int[] array = HeapSort.generate_random_array(n);
            long t1 = System.currentTimeMillis();
            array = HeapSort.quick_sort(array, 0, n - 1);
            long t2 = System.currentTimeMillis();
            long t = t2 - t1;
            boolean flag = HeapSort.check_sorted(array);
            System.out.println(n + "," + t + "," + flag);
        }
        System.out.println("Quick sort ends ------------------");

        System.out.println("Counting sort starts ------------------");
        for (int n = 10; n <= 10; n = n + 10) {
            int[] array = HeapSort.generate_random_array(n, k - 1);
            long t1 = System.currentTimeMillis();
            array = HeapSort.counting_sort(array, k);
            long t2 = System.currentTimeMillis();
            long t = t2 - t1;
            boolean flag = HeapSort.check_sorted(array);
            System.out.println(n + "," + t + "," + flag);
        }
        System.out.println("Heap sort ends ------------------");
    }

}

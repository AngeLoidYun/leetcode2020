package me.angeloid.test;

import java.util.Arrays;
import java.util.Comparator;

import static com.sun.xml.internal.xsom.impl.UName.comparator;

/**
 * @author AngeloidYun
 * @date 2020/8/19
 */
public class SortUtils {

    /**
     * 插入法堆排序
     *
     * @param arr
     */
    public static void heapSort(int[] arr, Comparator<Integer> comparator) {

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length, comparator);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i, comparator);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void adjustHeap(int[] arr, int parent, int length, Comparator<Integer> comparator) {
        if (parent > length / 2 - 1) {
            return;
        }
        int temp = arr[parent];//记录父节点的值
        int i = 2 * parent + 1;
        if (i + 1 < length && comparator.compare(arr[i], arr[i + 1]) < 0) {
            i++;
        }
        if (comparator.compare(arr[i], arr[parent]) > 0) {
            arr[parent] = arr[i];
            arr[i] = temp;
            adjustHeap(arr, i, length, comparator);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,5,3,2,7,4,9,6,8};
        heapSort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return (x < y) ? 1 : ((x == y) ? 0 : -1);
            }
        });
        System.out.println(Arrays.toString(arr));
    }


}

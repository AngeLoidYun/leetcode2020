package me.angeloid.leetcode;

import java.util.Arrays;

/**
 * @author AngeloidYun
 * @date 2020-03-31
 */
public class Solution912 {
    public int[] sortArray(int[] nums) {
        //冒泡排序
//        return bubbleSort(nums);

        //选择排序
//        return selectSort(nums);


        //插入排序
        return insertSort(nums);
    }

    /**
     * 冒泡排序
     *
     * @param nums
     * @return
     */
    public int[] bubbleSort(int[] nums) {
        bubbleSort(nums, nums.length - 1);
        return nums;
    }

    /**
     * 选择排序
     *
     * @param nums
     * @return
     */
    public int[] selectSort(int[] nums) {
        selectSort(nums, 0);
        return nums;
    }

    public int[] insertSort(int[] nums) {
        insertSort(nums, 1);
        return nums;
    }

    public int[] heapSort(int[] nums) {
        return nums;
    }

    //----------------------------assistance methods------------
    private void bubbleSort(int[] nums, int index) {
        if (index == 0) {
            return;
        }
        int maxIndex = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i <= index; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        swap(nums, maxIndex, index);
        bubbleSort(nums, --index);
    }

    private void selectSort(int[] nums, int index) {
        if (index == nums.length - 1) {
            return;
        }
        int minIndex = index;
        int minValue = Integer.MAX_VALUE;
        for (int i = index; i < nums.length; i++) {
            if (nums[i] < minValue) {
                minIndex = i;
                minValue = nums[i];
            }
        }
        swap(nums, index, minIndex);
        selectSort(nums, ++index);
    }

    private void insertSort(int[] nums, int index) {
        if (index > nums.length - 1) {
            return;
        }
        int insertIndex = index;
        for (int i = 0; i < index; i++) {
            if (nums[i] >= nums[index]) {
                insertIndex = i;
                break;
            }
        }
        int temp = nums[index];
        for (int i = index; i > insertIndex; i--) {
            nums[i] = nums[i - 1];
        }
        nums[insertIndex] = temp;
        insertSort(nums, ++index);
    }


    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        Solution912 solution912 = new Solution912();
        solution912.sortArray(new int[]{-2, 3, -5});
    }
}

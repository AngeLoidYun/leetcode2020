package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020/7/31
 */
public class SolutionM0803 {
    public int findMagicIndex(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 有序整数数,因此可以二分法
     */
    public int findMagicIndex2(int[] nums) {

        return find(nums, 0, nums.length - 1 );
    }

    private int find(int[] nums, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (end - start) / 2 + start;
        int left = find(nums, start, mid - 1);
        if (left != -1) {
            return left;
        } else if (nums[mid] == mid) {
            return mid;
        }
        return find(nums, mid + 1, end);
    }

    public static void main(String[] args) {
        SolutionM0803 m0803 = new SolutionM0803();
        System.out.println(m0803.findMagicIndex2(new int[]{1, 1, 2, 3, 4}));
    }
}

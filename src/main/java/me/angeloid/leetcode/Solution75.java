package me.angeloid.leetcode;

public class Solution75 {
    /**
     * p0 p2表示下一个0和下一个2的位置
     *
     * 遍历数组，找到 0 填入p0，继续遍历p0下一个元素
     * 找到2填入p2，继续遍历当前元素
     * @param nums
     */
    public void sortColors(int[] nums) {
        int p0 = 0;
        while (p0 < nums.length && nums[p0] == 0) {
            p0++;
        }
        int p2 = nums.length - 1;
        while (p2 > 0 && nums[p2] == 2) {
            p2--;
        }
        if (p0 >= p2) {
            return;
        }
        int i = p0;
        while (i <= p2) {
            int temp;
            if (nums[i] == 0) {
                temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                p0++;
                while (p0 < nums.length && nums[p0] == 0) {
                    p0++;
                }
                i = p0;
            } else if (nums[i] == 2) {
                temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                p2--;
                while (p2 > 0 && nums[p2] == 2) {
                    p2--;
                }
            }else{
                i++;
            }
        }
    }

    public static void main(String[] args) {

        Solution75 solution75 = new Solution75();
        solution75.sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }
}

package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020-04-01
 */
public class Solution1013 {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int v : A
        ) {
            sum += v;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int partialSum = sum / 3;
        int base = 0;
        int partCount = 0;
        for (int v : A) {
            base += v;
            if (base == partialSum) {
                base = 0;
                partCount++;
            }
        }
        return partCount >= 3;
    }


    public static void main(String[] args) {
        Solution1013 solution1013 = new Solution1013();
        solution1013.canThreePartsEqualSum(new int[]{10, -10, 10, -10, 10, -10, 10, -10});
    }
}

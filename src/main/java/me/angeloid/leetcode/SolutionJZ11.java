package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020/7/22
 */
public class SolutionJZ11 {
    /**
     * planA 暴力 O(n)
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int res = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[i - 1]) {
                return numbers[i];
            }
        }
        return res;
    }

    /**
     * plan B  二分法
     * @param numbers
     * @return
     */
    public int minArray2(int[] numbers) {
        int res = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[i - 1]) {
                return numbers[i];
            }
        }
        return res;
    }

}

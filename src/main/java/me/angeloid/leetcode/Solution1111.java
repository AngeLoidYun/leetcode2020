package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020-04-01
 */
public class Solution1111 {
    /**
     * 思路：在遇到新一层的括号时，要尽量分给另一组
     *
     * @param seq
     * @return
     */
    public int[] maxDepthAfterSplit(String seq) {


        int[] result = new int[seq.length()];
        char[] seqArr = seq.toCharArray();
        int atDepth = 0;
        for (int i = 0; i < seqArr.length; i++) {

            if (seqArr[i] == '(') {
                atDepth++;
                result[i] = atDepth % 2;
            } else {
                result[i] = atDepth % 2;
                atDepth--;
            }
        }
        return result;
    }
}

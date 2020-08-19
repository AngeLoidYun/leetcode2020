package me.angeloid.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AngeloidYun
 * @date 2020/5/29
 */
public class Solution93 {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4) {
            return new ArrayList<>();
        }
        char[] arr = s.toCharArray();
        boolean can3 = s.charAt(0) == '1' || s.charAt(0) == '2';
        tryIt(arr, 0, 1, can3, new ArrayList<>());
        return res;
    }

    private void tryIt(char[] arr, int i, int j, boolean can3, ArrayList<String> list) {
        if (j - i > 2 && !can3) {
            return;
        }
        if (j - i > 3) {
            return;
        }
        ArrayList<String> clone = (ArrayList<String>) list.clone();
        if (j == arr.length && i != j) {
            String subS = new String(arr, i, j - i);
            if (subS.startsWith("0") && subS.length() > 1||(can3 && Integer.parseInt(subS) > 255)) {
                return;
            } else {
                clone.add(subS);
            }
            j++;
        }
        if (clone.size() > 4) {
            return;
        }
        if (j == arr.length + 1) {
            if (clone.size() == 4) {
                StringBuilder builder = new StringBuilder();
                for (String s : clone
                ) {

                    builder.append(s);
                    builder.append(".");
                }
                res.add(builder.deleteCharAt(builder.lastIndexOf(".")).toString());
            }
            return;
        }
        //继续看
        tryIt(arr, i, j + 1, can3, clone);
        String subS = new String(arr, i, j - i);
        if (subS.startsWith("0") && subS.length() > 1 || (can3 && Integer.parseInt(subS) > 255)) {
            return;
        } else {
            clone.add(subS);
        }
        if (arr[j] == '1' || arr[j] == '2') {
            tryIt(arr, j, j + 1, true, clone);
        } else {
            tryIt(arr, j, j + 1, false, clone);
        }
    }

    public static void main(String[] args) {
        Solution93 solution93 = new Solution93();
        System.out.println(solution93.restoreIpAddresses("010010"));
    }

}

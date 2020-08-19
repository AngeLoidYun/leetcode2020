package me.angeloid.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author AngeloidYun
 * @date 2020/5/27
 */
public class Solution71 {
    public String simplifyPath(String path) {
        LinkedList<String> pStack = new LinkedList<>();
        int is = 0, ie = 0;
        boolean canSolve = false;
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c != '/' && !canSolve) {
                //begin
                is = i;
                canSolve = true;
            }
            if (c == '/') {
                ie = i;
                if (ie > is && canSolve) {
                    String subP = path.substring(is, ie);
                    if (".".equals(subP)) {

                    } else if ("..".equals(subP)) {
                        if (!pStack.isEmpty()) {
                            pStack.pop();
                        }
                    } else {
                        pStack.push(subP);
                    }
                    canSolve = false;
                }
            }
            if (i == path.length() - 1 && c != '/') {
                String subP = path.substring(is, path.length());
                if (".".equals(subP)) {

                } else if ("..".equals(subP)) {
                    if (!pStack.isEmpty()) {
                        pStack.pop();
                    }
                } else {
                    pStack.push(subP);
                }
                canSolve = false;
            }
        }

        StringBuilder builder = new StringBuilder();
        builder.append("/");
        while (!pStack.isEmpty()) {
            builder.append(pStack.pollLast());
            if (pStack.size() > 0) {
                builder.append("/");
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution71 solution71 = new Solution71();

        System.out.println(solution71.simplifyPath("/../"));
        System.out.println(solution71.simplifyPath("/home/"));
        System.out.println(solution71.simplifyPath("/home//foo/"));
        System.out.println(solution71.simplifyPath("/a/./b/../../c/"));
        System.out.println(solution71.simplifyPath("/a/../../b/../c//.//"));
        System.out.println(solution71.simplifyPath("/a//b////c/d//././/.."));
    }
}

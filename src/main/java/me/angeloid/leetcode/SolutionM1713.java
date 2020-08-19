package me.angeloid.leetcode;

/**
 * @author AngeloidYun
 * @date 2020/7/9
 */
public class SolutionM1713 {
    public int respace(String[] dictionary, String sentence) {
        int[] dp = new int[sentence.length() + 1];
        dp[0] = 0;
        Trie root = new Trie();
        for (int i = 0; i < dictionary.length; i++) {
            root.insert(dictionary[i]);
        }
        for (int i = 1; i <= sentence.length(); i++) {
            dp[i] = dp[i - 1] + 1;
            Trie curPos = root;
            for (int j = i; j >= 1; j--) {
                int t = sentence.charAt(j - 1) - 'a';
                if (curPos.next[t] == null) {
                    break;
                } else if (curPos.next[t].isEnd) {
                    dp[i] = Math.min(dp[j - 1], dp[i]);
                }
                if (dp[i] == 0) {
                    break;
                }
                curPos = curPos.next[t];
            }
        }
        return dp[sentence.length()];
    }


    class Trie {
        private Trie[] next = new Trie[26];
        private boolean isEnd = false;

        public void insert(String s) {
            Trie curPos = this;
            for (int i = s.length() - 1; i >= 0; i--) {
                int t = s.charAt(i) - 'a';
                if (curPos.next[t] == null) {
                    curPos.next[t] = new Trie();
                }
                curPos = curPos.next[t];
            }
            curPos.isEnd = true;
        }
    }


    public static void main(String[] args) {

        SolutionM1713 solutionM1713 = new SolutionM1713();
        System.out.println(solutionM1713.respace(new String[]{"frrrbbrrbfrfqqbbbrb", "qr", "b", "rf", "qqbbbbfrqbrrqrffbrqqqbqqfqfrr", "r", "ffqq", "bffbqfqqbrrrf", "fq", "qfr", "fr", "rqrrbfbfq", "r", "f", "qbqbrbrbqfqbbbfbbbfbq", "bqqbbbqrbbrf", "f"
        }, "bqqffbqbbfqrfrrrbbrrbfrfqqbbbrbfqfffffrfqfqfffffrrfqfrrqbqfrbfrqqrfrbrbbqbqbqqfqrfbfrfr"));
    }
}

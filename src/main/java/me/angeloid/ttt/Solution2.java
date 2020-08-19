package me.angeloid.ttt;


import java.util.Scanner;

/**
 * @author AngeloidYun
 * @date 2020-03-11
 */
public class Solution2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int interval = scanner.nextInt();
        play(total, interval);
    }


    private static boolean same(int[] person, int l, int n) {
        for (int i = 0; i < l; i++) {
            if (person[i] == n) {
                return true;
            }
        }
        return false;
    }

    public static void play(int playerNum, int step) {
        int[] person = new int[playerNum];
        int counter = 1;
        while (true) {
            if (counter > playerNum * step) {
                break;
            }
            for (int i = 1; i <= playerNum; i++) {
                while (true) {
                    if (same(person, playerNum, i) == false) {
                        break;
                    } else {
                        i = i + 1;
                    }
                }
                if (i > playerNum) {
                    break;
                }
                if (counter % step == 0) {
                    System.out.print(i + " ");
                    person[counter / step - 1] = i;
                }
                counter += 1;
            }
        }
    }
}

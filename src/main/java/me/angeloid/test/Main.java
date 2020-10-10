package me.angeloid.test;


import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] arr = new int[count];
        int[] res = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                if (arr[j] > arr[i]) {
                    res[i] = j;
                    break;
                }
            }
        }
        for (int i = 0; i < count; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int input = scanner.nextInt();
            int n = scanner.nextInt();
            BigInteger res = new BigInteger("0");
            BigInteger cur = new BigInteger(String.valueOf(input));
            for (int i = 0; i < n; i++) {
                res = res.add(cur);
                input++;
                cur = new BigInteger(cur.toString() + input);
            }
            System.out.print(res.toString());
        }
    }

    public static void main(String[] args) {
        //双指针法
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            char[] arr = s.toCharArray();
            int i = 0;
            int j = 0;
            int letterCount = 0;
            int digitalCount = 0;
            int length = 0;
            while (i < arr.length && j < arr.length) {
                if (Character.isLetter(arr[j])) {
                    letterCount++;
                    while (letterCount >= 2 && i <= j) {
                        if (Character.isLetter(arr[i])) {
                            letterCount--;
                        }else{
                            digitalCount--;
                        }
                        i++;
                    }
                }else{
                    digitalCount++;
                }
                if (digitalCount>0&&letterCount>0){
                    if(j==i&&Character.isLetter(arr[i])){
                        length = Math.max(length,1);
                    }else{
                        length = Math.max(length,j-i+1);
                    }
                }
                j++;
            }
            System.out.print(length>0?length:-1);
        }
    }
}

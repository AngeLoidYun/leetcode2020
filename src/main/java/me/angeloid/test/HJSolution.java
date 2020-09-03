package me.angeloid.test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;

/**
 * @author AngeloidYun
 * @date 2020/8/28
 */
public class HJSolution {

    //    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int[] arr= new int[26];
//        String s = scanner.nextLine().toLowerCase();
//        String pattern = scanner.nextLine().toLowerCase();
//        for(char c:s.toCharArray()){
//            arr[c-'a']+=1;
//        }
//        System.out.println(arr[pattern.charAt(0)-'a']);
//    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String[] err = new String[8];
        int ptr = 0;
        while(sc.hasNext()){
            String s = sc.nextLine();
            String[] split = s.split(" ");
            String pre =split[0];
            if(pre.contains("\\")){
                pre = pre.substring(pre.lastIndexOf("\\")+1);
            }
            if(pre.length()>16){
                pre = pre.substring(pre.length()-16);
            }
            pre = pre+" "+split[1];
            err[ptr] = pre;
            ptr = (ptr+1)%8;
        }
        Map<String,Integer> map = new LinkedHashMap<>();
        for(String e :err){
            if(e!=null){
                if(map.get(e)!=null){
                    map.put(e,map.get(e)+1);
                }else{
                    map.put(e,1);
                }
            }
        }
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+" " + entry.getValue());
        }
}}
